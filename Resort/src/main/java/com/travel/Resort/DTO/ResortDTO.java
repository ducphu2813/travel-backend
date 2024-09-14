package com.travel.Resort.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.travel.Resort.Model.ResortRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResortDTO {

    private String name;
    private String description;
    private String address;
    private String city;
    private Integer numberOfPools;
    private boolean wifi;
    private boolean parking;
    private boolean smokingPolicy;
    private boolean elevator;
    private boolean breakfast;
    private boolean garden;
    private boolean gym;
    private boolean restaurant;
    private Integer mealPricePerNight;
    private Integer mealPricePerPerson;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String status;
    private List<ResortRoom> rooms;
}
