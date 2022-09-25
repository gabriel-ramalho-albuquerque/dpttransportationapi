package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/trip")
@AllArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping(path = "list-yellow")
    public Page<Trip> getListYellow(Pageable pageable){
        return tripService.getListYellow(pageable);
    }
}
