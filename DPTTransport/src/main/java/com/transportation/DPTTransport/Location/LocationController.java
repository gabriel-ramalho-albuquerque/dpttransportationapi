package com.transportation.DPTTransport.Location;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping(path = "top-zones")
    public List<TopZoneDTO> getTopZones(@RequestParam("order") String order){
        return locationService.getTopZones(order);
    }

    @GetMapping(path = "zone-trips")
    public List<ZoneTripsDTO> getZoneTrips(@RequestParam("zone") Long zoneId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return locationService.getZoneTrips(zoneId, date);
    }
}