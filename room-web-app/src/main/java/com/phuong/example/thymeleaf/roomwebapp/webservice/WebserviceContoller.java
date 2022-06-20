package com.phuong.example.thymeleaf.roomwebapp.webservice;

import com.phuong.example.thymeleaf.roomwebapp.business.ReservationService;
import com.phuong.example.thymeleaf.roomwebapp.business.RoomReservation;
import com.phuong.example.thymeleaf.roomwebapp.data.Guest;
import com.phuong.example.thymeleaf.roomwebapp.data.Room;
import com.phuong.example.thymeleaf.roomwebapp.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceContoller {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceContoller(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
        Date date = dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests(){
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest){
        this.reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }

    //test commit -> old-branch
}
