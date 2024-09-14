package com.travel.Resort.Service;

import com.travel.Resort.DTO.AddRoomDTO;
import com.travel.Resort.Exception.NotFoundException;
import com.travel.Resort.Model.Resort;
import com.travel.Resort.Model.ResortRoom;
import com.travel.Resort.Repository.ResortRepository;
import com.travel.Resort.Repository.ResortRoomRepository;
import com.travel.Resort.Service.Interface.IResortRoomService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResortRoomService implements IResortRoomService {

    private final ResortRoomRepository resortRoomRepository;
    private final ResortRepository resortRepository;
    private final MongoTemplate mongoTemplate;

    public ResortRoomService(
            ResortRoomRepository resortRoomRepository,
            ResortRepository resortRepository,
            MongoTemplate mongoTemplate) {
        this.resortRoomRepository = resortRoomRepository;
        this.resortRepository = resortRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<ResortRoom> getAllResortRooms() {
        return resortRoomRepository.findAll();
    }

    @Override
    public ResortRoom getResortRoomById(String id) {
        return resortRoomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ResortRoom not found with id: " + id));
    }

    //hàm thêm danh sách nhiều room và trả về danh sách id của các room đã thêm
    //sau đó thêm các id vào danh sách id của resort
    @Override
    @Transactional
    public List<ResortRoom> createResortRooms(AddRoomDTO addRoomDTO) {

        //kiểm tra xem resort có tồn tại không
        Resort resort = resortRepository.findById(addRoomDTO.getResortId())
                .orElseThrow(() -> new NotFoundException("Resort not found with id: " + addRoomDTO.getResortId()));

        //lưu danh sách room
        List<ResortRoom> rooms = resortRoomRepository.saveAll(addRoomDTO.getRooms());

        //lưu danh sách id của room vào danh sách id của resort
        resort.getRoomIds().addAll(rooms.stream().map(ResortRoom::getId).toList());

        //lưu lại resort
        resortRepository.save(resort);

        return rooms;
    }

    @Override
    @Transactional
    public ResortRoom updateResortRoom(String id, ResortRoom resortRoom) {
        ResortRoom oldResortRoom = resortRoomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ResortRoom not found with id: " + id));

        resortRoom.setId(id);

        return resortRoomRepository.save(resortRoom);
    }

    @Override
    @Transactional
    public void deleteResortRoom(String id, String resortId) {
        ResortRoom resortRoom = resortRoomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ResortRoom not found with id: " + id));

        //tìm resort theo id
        Resort resort = resortRepository.findById(resortId)
                .orElseThrow(() -> new NotFoundException("Resort not found with id: " + resortId));

        //kiểm tra room id có tồn tại trong danh sách id của resort không
        if (!resort.getRoomIds().contains(id)) {
            throw new NotFoundException("Room not found in Resort");
        }

        //xóa id của room khỏi danh sách id của resort
        Query query = new Query(Criteria.where("id").is(resortId));
        Update update = new Update().pull("roomIds", id);
        mongoTemplate.updateFirst(query, update, Resort.class);
        resortRoomRepository.delete(resortRoom);
    }
}
