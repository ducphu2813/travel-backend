package com.travel.Resort.DTO;

import com.travel.Resort.Model.ResortRoom;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddRoomDTO {

    private String resortId;
    private List<ResortRoom> rooms;
}
