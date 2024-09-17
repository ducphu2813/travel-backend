package com.travel.Tour.Model;

import com.travel.Tour.DTO.TourScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tour")
public class Tour {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer duration;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private Integer maxParticipants;
    private String status;
    private List<TourScheduleDTO> schedules;

}
