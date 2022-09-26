package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/trip")
@AllArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping(path = "list-yellow")
    public Page<Trip> getListYellow(@RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "pickupDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate,
                                    @RequestParam(name = "dropoffDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dropoffDate,
                                    Pageable pageable){
        return tripService.getListYellow(id, pickupDate, dropoffDate, pageable);
    }
}
