package com.example.hotelmanagementsystem.Repository;

import com.example.hotelmanagementsystem.Domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
