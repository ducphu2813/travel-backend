package com.travel.Flight.Controller.Internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/flight")
public class FlightInternalController {

    @GetMapping("/health")
    public String health() {
        return "Flight service is healthy";
    }
}
