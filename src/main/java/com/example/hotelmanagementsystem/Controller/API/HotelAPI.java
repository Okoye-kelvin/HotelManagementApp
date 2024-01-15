package com.example.hotelmanagementsystem.Controller.API;

import com.example.hotelmanagementsystem.Domain.Hotel;
import com.example.hotelmanagementsystem.Repository.HotelRepository;
import com.example.hotelmanagementsystem.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class HotelAPI {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelService hotelService;
    @RequestMapping("/hotel")
    @GetMapping("/hotel")
    public ResponseEntity<List<Hotel>> getAllHotel(){

        return ResponseEntity.ok().body(hotelService.getAllHotels());
    }
    @GetMapping
    public ResponseEntity<Hotel> getHotelById(@PathVariable long id){
        return ResponseEntity.ok().body(hotelService.getHotelById(id));
    }
    @PostMapping("/hotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok().body(hotelService.saveHotel(hotel));
    }
    @PutMapping("/hotel/{id}")
    public ResponseEntity<Hotel> updateHotelRecord(@PathVariable long Id, @RequestBody Hotel hotel){
        return ResponseEntity.ok().body(hotelService.updateHotelRecord(hotel));
    }
    @DeleteMapping("/hotel/{id}")
    public HttpStatus deleteHotel(@PathVariable long id ){
        hotelService.deleteHotel(id);
        return HttpStatus.OK;
    }



}