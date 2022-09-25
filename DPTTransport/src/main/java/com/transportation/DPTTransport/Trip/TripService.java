package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public Page<Trip> getListYellow(Pageable pageable){
        return tripRepository.findAll(pageable);
    }
}
