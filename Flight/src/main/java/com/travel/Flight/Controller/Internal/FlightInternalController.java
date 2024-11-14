package com.travel.Flight.Controller.Internal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/flight")
public class FlightInternalController {

    Environment environment;

    public FlightInternalController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/health")
    public String health() {
        //thử in ra instance của service này
        System.out.println("Instance: " + environment.getProperty("local.server.port"));
        return "Flight service is healthy";
    }
}
