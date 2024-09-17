package com.travel.Tour.Controller;

import com.travel.Tour.DTO.AddScheduleDTO;
import com.travel.Tour.Model.Tour;
import com.travel.Tour.Service.Interface.ITourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourController {

    private final ITourService tourService;

    public TourController(ITourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getAll() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getById(@PathVariable String id) {
        return tourService.getTourById(id);
    }

    @PostMapping
    public Tour add(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @PutMapping("/{id}")
    public Tour update(@PathVariable String id, @RequestBody Tour tour) {
        return tourService.updateTour(id, tour);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        tourService.deleteTour(id);
    }

    //hàm thêm 1 or nhiều tour schedule cho 1 tour
    @PostMapping("/add-schedule")
    public Tour addSchedule(@RequestBody AddScheduleDTO addScheduleDTO) {
        return tourService.addTourSchedule(addScheduleDTO);
    }
}
