package com.travel.Resort.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "resorts_rooms")
public class ResortRoom {

    @Id
    private String id;
    private String roomNumber;
    private String roomType;
    private Integer singleBeds;
    private Integer doubleBeds;
    private Integer maxAdults;
    private Integer maxChildren;
    private Integer size;
    private Integer floor;
    private String view;
    private boolean airConditioning;
    private boolean heating;
    private boolean tv;
    private boolean smokingPolicy;
    private Integer pricePerNight;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String status;
}
