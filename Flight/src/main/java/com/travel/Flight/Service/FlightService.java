package com.travel.Flight.Service;

import com.travel.Flight.Exception.NotFoundException;
import com.travel.Flight.Model.Flight;
import com.travel.Flight.Repository.FlightRepository;
import com.travel.Flight.Service.Interface.IFlightService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightService implements IFlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight not found with id: " + id));
    }

    @Override
    @Transactional
    public Flight addFlight(Flight flight) {
        flight.setId(null);
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public Flight updateFlight(String id, Flight flight) {
        Flight oldFlight = flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight not found with id: " + id));
        flight.setId(id);
        return flightRepository.save(flight);

    }

    @Override
    @Transactional
    public void deleteFlight(String id) {
        Flight oldFlight = flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight not found with id: " + id));
        flightRepository.deleteById(id);
    }
}
