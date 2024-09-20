package com.travel.Tour.Service;

import com.travel.Tour.DTO.AddScheduleDTO;
import com.travel.Tour.Exception.NotFoundException;
import com.travel.Tour.Model.Tour;
import com.travel.Tour.Repository.TourRepository;
import com.travel.Tour.Service.Interface.ITourService;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class TourService implements ITourService {

    private final TourRepository tourRepository;
    private final MongoTemplate mongoTemplate;

    public TourService(TourRepository tourRepository,
                       MongoTemplate mongoTemplate) {
        this.tourRepository = tourRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(String id) {
        return tourRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Tour not found"));
    }

    @Override
    @Transactional
    public Tour createTour(Tour tour) {
        tour.setId(null);
        return tourRepository.save(tour);
    }

    @Override
    @Transactional
    public Tour updateTour(String id, Tour tour) {

        Tour tourToUpdate = tourRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Tour not found"));

        tour.setId(id);

        return tourRepository.save(tour);
    }

    @Override
    @Transactional
    public void deleteTour(String id) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Tour not found"));

        tourRepository.delete(tour);
    }

    //hàm thêm 1 hoặc nhiều tour schedule cho 1 tour(sử dụng AddScheduleDTO và MongoTemplate)
    @Override
    @Transactional
    public Tour addTourSchedule(AddScheduleDTO scheduleDTO) {
        //kiểm tra tour có tồn tại không
        Tour tour = tourRepository.findById(scheduleDTO.getTourId())
                .orElseThrow( () -> new NotFoundException("Tour not found"));

        Query query = new Query(Criteria.where("id").is(scheduleDTO.getTourId()));

        Update update = new Update().push("schedules").each(scheduleDTO.getSchedules().toArray());

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Tour.class);
    }

}
