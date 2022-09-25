package com.transportation.DPTTransport.Trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Page<Trip> findById(Long id, Pageable pageable);

    Page<Trip> findByPickupDateTime(LocalDate pickupDate, Pageable pageable);

    Page<Trip> findByDropoffDateTime(LocalDate dropoffDate, Pageable pageable);

    Page<Trip> findByPuLocationId(Long puLocationId, Pageable pageable);

    Page<Trip> findByDoLocationId(Long doLocationId, Pageable pageable);

    @Query("select t from Trip t where t.id = :id and (:pickupDate is null or t.pickupDateTime = :pickupDate) and (:dropoffDate is null or t.dropoffDateTime = :dropoffDate)")
    Page<Trip> findByMultipleFilters(Long id, LocalDate pickupDate, LocalDate dropoffDate, Pageable pageable);
}
