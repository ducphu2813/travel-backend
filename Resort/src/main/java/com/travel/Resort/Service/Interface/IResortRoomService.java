package com.travel.Resort.Service.Interface;

import com.travel.Resort.DTO.AddRoomDTO;
import com.travel.Resort.Model.ResortRoom;

import java.util.List;

public interface IResortRoomService {

    List<ResortRoom> getAllResortRooms();
    ResortRoom getResortRoomById(String id);
    ResortRoom updateResortRoom(String id, ResortRoom resortRoom);
    void deleteResortRoom(String id, String resortId);

    //hàm thêm danh sách nhiều room
    List<ResortRoom> createResortRooms(AddRoomDTO addRoomDTO);
}
