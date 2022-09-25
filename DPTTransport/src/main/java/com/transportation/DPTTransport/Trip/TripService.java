package com.transportation.DPTTransport.Trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
}
