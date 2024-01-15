package com.example.hotelmanagementsystem.Service;

import com.example.hotelmanagementsystem.Domain.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel getHotelById(long Id);
    List<Hotel> getAllHotels();
    Hotel updateHotelRecord(Hotel hotel);
    void deleteHotel(long Id);


}
