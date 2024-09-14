package com.travel.Flight.Service.Interface;

import com.travel.Flight.Model.Flight;

import java.util.List;

public interface IFlightService {

    List<Flight> getAllFlights();
    Flight getFlightById(String id);
    Flight addFlight(Flight flight);
    Flight updateFlight(String id, Flight flight);
    void deleteFlight(String id);

    //những hàm tìm kiếm cần thiết
    //tìm bằng airline

    //tìm bằng ngày khởi hành

    //tìm bằng city đi

    //tìm bằng city đến

    //tìm bằng 2 city đi và đến

    //tìm round trip bằng 2 city
}
