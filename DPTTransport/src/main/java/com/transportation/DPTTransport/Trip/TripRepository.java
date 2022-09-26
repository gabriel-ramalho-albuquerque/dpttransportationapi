package com.transportation.DPTTransport.Trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("select t from Trip t where t.tripType = 1 and (:id is null or t.id = :id) and (:pickupDate is null or t.pickupDateTime = :pickupDate) and (:dropoffDate is null or t.dropoffDateTime = :dropoffDate)")
    Page<Trip> getYellowListByMultipleFilters(Long id, LocalDate pickupDate, LocalDate dropoffDate, Pageable pageable);
}
