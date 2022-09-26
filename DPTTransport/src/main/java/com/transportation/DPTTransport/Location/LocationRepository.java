package com.transportation.DPTTransport.Location;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(nativeQuery = true)
    public List<TopZoneDTO> getTopZonesByPickUps(Pageable pageable);

    @Query(nativeQuery = true)
    public List<TopZoneDTO> getTopZonesByDropOffs(Pageable pageable);

    @Query(nativeQuery = true)
    public List<ZoneTripsDTO> getZoneTrips(Long zoneId, LocalDate date);
}
