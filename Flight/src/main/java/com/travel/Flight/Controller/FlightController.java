package com.travel.Flight.Controller;

import com.travel.Flight.Model.Flight;
import com.travel.Flight.Service.Interface.IFlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final IFlightService flightService;

    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable String id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight update(@PathVariable String id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        flightService.deleteFlight(id);
    }
}
