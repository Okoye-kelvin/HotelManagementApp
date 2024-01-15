package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Domain.Hotel;
import com.example.hotelmanagementsystem.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/HotelHomepage")
    public String homePage(Model model) {
        try {
            List<Hotel> hotels = hotelService.getAllHotels();
            model.addAttribute("hotels", hotels);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Handle the exception if needed
        }
        return "home";
    }

    @GetMapping("/ShowHotelForm")
    public String showHotelForm(Model model){
        model.addAttribute("hotel",new Hotel());
        return "New_Hotel";

    }

    @PostMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel, RedirectAttributes redirectAttributes) {
        try {
            hotelService.saveHotel(hotel);
            redirectAttributes.addFlashAttribute("message", "Room Booked");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Error saving hotel");
            redirectAttributes.addFlashAttribute("color", "danger");
        }
        return "redirect:/HotelHomepage";
    }

    @GetMapping("/updateHotelRecord/{id}")
    public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
        try {
           Hotel hotel = hotelService.getHotelById(Id);
            model.addAttribute("hotel", hotel);
            model.addAttribute("pageTitle", "Edit Hotel Id:" + Id);
            return "updateHotelRecord";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/HotelHomepage";
        }
    }
    @PostMapping("/updateHotelRecord")
    public String updateHotelRecord(@ModelAttribute("hotel") Hotel hotel, RedirectAttributes redirectAttributes){
        try {
            hotelService.saveHotel(hotel);
            redirectAttributes.addFlashAttribute("message", "Hotel Record updated successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating hotel: " + e.getMessage());
        }
        return "redirect:/HotelHomepage";
    }
    @GetMapping("deleteHotel/{id}")
    public String deleteHotel(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            hotelService.deleteHotel(id);
            redirectAttributes.addFlashAttribute("message", "Room Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/HotelHomepage";
    }
}


