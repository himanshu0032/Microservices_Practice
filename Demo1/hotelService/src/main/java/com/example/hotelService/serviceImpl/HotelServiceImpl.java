package com.example.hotelService.serviceImpl;

import com.example.hotelService.entities.Hotel;
import com.example.hotelService.exception.ResourceNotFoundException;
import com.example.hotelService.repository.HotelRepository;
import com.example.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomHotelIdString = UUID.randomUUID().toString();
        hotel.setId(randomHotelIdString);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {

        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String hotelId) {

        return hotelRepository.findById(hotelId).orElseThrow(
                ()-> new ResourceNotFoundException("hotel with given Id is not found on server!! :"+hotelId)
        );

    }
}
