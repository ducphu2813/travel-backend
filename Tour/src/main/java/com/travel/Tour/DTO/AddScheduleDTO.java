package com.travel.Tour.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddScheduleDTO {

    private String tourId;
    private List<TourScheduleDTO> schedules;
}
