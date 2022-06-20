package com.phuong.example.thymeleaf.roomwebapp.web;

import com.phuong.example.thymeleaf.roomwebapp.business.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel-guests")
public class GuestController {
    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(Model model) {
        model.addAttribute("guests", reservationService.getHotelGuests());
        return "hotel-guests";
    }

    // commit 1
}
