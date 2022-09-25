package com.transportation.DPTTransport.Location;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "select t1.zone, t1.puTotal, t2.doTotal from (select l.zone, count(l.id) as puTotal from location l join trip t on l.id = t.pickup_location_id group by l.zone) as t1 join (select l.zone, count(l.id) as doTotal from location l join trip t on l.id = t.dropoff_location_id group by l.zone) as t2 on t1.zone = t2.zone order by t1.puTotal desc" , nativeQuery = true)
    public List<TopZone> getTopZonesByPickUps(Pageable pageable);

    @Query(value = "select t1.zone, t1.puTotal, t2.doTotal from (select l.zone, count(l.id) as puTotal from location l join trip t on l.id = t.pickup_location_id group by l.zone) as t1 join (select l.zone, count(l.id) as doTotal from location l join trip t on l.id = t.dropoff_location_id group by l.zone) as t2 on t1.zone = t2.zone order by t2.doTotal desc" , nativeQuery = true)
    public List<TopZone> getTopZonesByDropOffs(Pageable pageable);

    @Query()
    public List<ZoneTrips> getZoneTrips(Long zoneId, LocalDate date);
}
