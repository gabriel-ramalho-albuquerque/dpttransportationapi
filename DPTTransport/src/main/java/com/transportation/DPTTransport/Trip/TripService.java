package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public Page<Trip> getListYellow(Long id, LocalDate pickupDate, LocalDate dropoffDate, Pageable pageable){
        return tripRepository.getYellowListByMultipleFilters(id, pickupDate, dropoffDate, pageable);
    }
}
