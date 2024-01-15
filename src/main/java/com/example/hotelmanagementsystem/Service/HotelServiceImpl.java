package com.example.hotelmanagementsystem.Service;

import com.example.hotelmanagementsystem.Domain.Hotel;
import com.example.hotelmanagementsystem.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HotelServiceImpl implements HotelService {
@Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);

    }

    @Override
    public Hotel getHotelById(long Id) {
        Optional<Hotel> hotel = hotelRepository.findById(Id);
        Hotel emptyHotel = null;
        if (hotel.isPresent()) {
            emptyHotel = hotel.get();
            return emptyHotel;
        }
        else {
            throw new RuntimeException("Room not available");
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotelRecord(Hotel hotel) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotel.getId());
        if(optionalHotel.isPresent()) {
            Hotel updateHotel = new Hotel();
            updateHotel.setId(hotel.getId());
            updateHotel.setApplicantName(hotel.getApplicantName());
            updateHotel.setApplicantContact(hotel.getApplicantContact());
            updateHotel.setApplicantGender(hotel.getApplicantGender());
            updateHotel.setStayPurpose(hotel.getStayPurpose());
            updateHotel.setGuestNum(hotel.getGuestNum());
            updateHotel.setRoomName(hotel.getRoomName());
            updateHotel.setStay_Duration(hotel.getStay_Duration());
            hotelRepository.save(updateHotel);

            return updateHotel;
        }
        else{
            throw new RuntimeException("Room not available");
        }
    }


    @Override
    public void deleteHotel(long Id) {
    hotelRepository.deleteById(Id);
    }
}
