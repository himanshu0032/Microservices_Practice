package com.example.hotelService.service;

import com.example.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String id);
}
