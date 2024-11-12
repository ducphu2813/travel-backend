package com.travel.Booking.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("FLIGHT")
public interface FlightServiceInterface {

    @GetMapping("/internal/flight/health")
    public String health();
}
