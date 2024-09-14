package com.travel.Resort.Service;

import com.travel.Resort.DTO.ResortDTO;
import com.travel.Resort.Exception.NotFoundException;
import com.travel.Resort.Model.Resort;
import com.travel.Resort.Model.ResortRoom;
import com.travel.Resort.Repository.ResortRepository;
import com.travel.Resort.Repository.ResortRoomRepository;
import com.travel.Resort.Service.Interface.IResortService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResortService implements IResortService {

    private final ResortRepository resortRepository;
    private final ResortRoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public ResortService(
            ResortRepository resortRepository,
            ResortRoomRepository roomRepository,
            ModelMapper modelMapper) {
        this.resortRepository = resortRepository;
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Resort> getAllResorts() {
        return resortRepository.findAll();
    }

    @Override
    public ResortDTO getResortById(String id) {
        Resort resort = resortRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resort not found with id: " + id));

        ResortDTO resortDTO = modelMapper.map(resort, ResortDTO.class);

        //lấy danh sách room của resort
        if( !(resort.getRoomIds() == null || resort.getRoomIds().isEmpty()) ) {
            List<ResortRoom> rooms = roomRepository.findAllById(resort.getRoomIds());
            resortDTO.setRooms(rooms);
        }
        else{
            resortDTO.setRooms(null);
        }

        return resortDTO;
    }

    @Override
    @Transactional
    public Resort createResort(Resort resort) {
        resort.setId(null);
        return resortRepository.save(resort);
    }

    @Override
    @Transactional
    public Resort updateResort(String id, Resort resort) {
        Resort oldResort = resortRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resort not found with id: " + id));

        resort.setId(id);
        return resortRepository.save(resort);
    }

    @Override
    @Transactional
    public void deleteResort(String id) {
        Resort resort = resortRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resort not found with id: " + id));

        resortRepository.delete(resort);
    }
}
