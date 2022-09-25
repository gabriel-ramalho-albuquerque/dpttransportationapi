package com.transportation.DPTTransport.Location;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping(path = "top-zones")
    public List<Object> getTopZones(@RequestParam("order") String order){
        return locationService.getTopZones(order);
    }
}