package com.transportation.DPTTransport.Location;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<TopZone> getTopZones(String order){
        if (order.equals("pickups")) {
            return locationRepository.getTopZonesByPickUps(PageRequest.of(0,5));
        } else{
            return locationRepository.getTopZonesByDropOffs(PageRequest.of(0,5));
        }
    }

    public List<ZoneTrips> getZoneTrips(Long zoneId, LocalDate date){
        return locationRepository.getZoneTrips(zoneId, date);
    }
}
