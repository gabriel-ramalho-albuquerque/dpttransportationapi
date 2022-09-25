package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public Page<Trip> getListYellow(PageRequest pageRequest){
        return tripRepository.findAll(pageRequest);
    }
}
