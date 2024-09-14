package com.travel.Resort.Controller;

import com.travel.Resort.DTO.AddRoomDTO;
import com.travel.Resort.Model.ResortRoom;
import com.travel.Resort.Service.Interface.IResortRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resort-room")
public class ResortRoomController {

    private final IResortRoomService resortRoomService;

    public ResortRoomController(IResortRoomService resortRoomService) {
        this.resortRoomService = resortRoomService;
    }

    @GetMapping
    public List<ResortRoom> getAll() {
        return resortRoomService.getAllResortRooms();
    }

    @GetMapping("/{id}")
    public ResortRoom getById(@PathVariable String id) {
        return resortRoomService.getResortRoomById(id);
    }

    @PostMapping
    public List<ResortRoom> addMany(@RequestBody AddRoomDTO addRoomDTO) {
        return resortRoomService.createResortRooms(addRoomDTO);
    }

    @PutMapping("/{id}")
    public ResortRoom update(@PathVariable String id, @RequestBody ResortRoom resortRoom) {
        return resortRoomService.updateResortRoom(id, resortRoom);
    }

    @DeleteMapping("/{resortId}/{id}")
    public void delete(@PathVariable String id, @PathVariable String resortId) {
        resortRoomService.deleteResortRoom(id, resortId);
    }


}
