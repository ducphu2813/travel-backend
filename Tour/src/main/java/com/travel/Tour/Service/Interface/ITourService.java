package com.travel.Tour.Service.Interface;

import com.travel.Tour.DTO.AddScheduleDTO;
import com.travel.Tour.Model.Tour;

import java.util.List;

public interface ITourService {

    List<Tour> getAllTours();
    Tour getTourById(String id);
    Tour createTour(Tour tour);
    Tour updateTour(String id, Tour tour);
    void deleteTour(String id);

    //hàm thêm 1 or nhiều tour schedule cho 1 tour(sử dụng AddScheduleDTO)
    Tour addTourSchedule(AddScheduleDTO addTourScheduleDTO);
}
