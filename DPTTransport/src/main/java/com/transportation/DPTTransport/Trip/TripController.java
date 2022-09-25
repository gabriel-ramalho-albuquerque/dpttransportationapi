package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trip")
@AllArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping(path = "list-yellow")
    public List<Object> getListYellow(){
        return null;
    }
}
