package com.travel.Resort.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Document(collection = "resorts")
public class Resort {

    @Id
    private String id;
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
    private List<String> roomIds;
}
