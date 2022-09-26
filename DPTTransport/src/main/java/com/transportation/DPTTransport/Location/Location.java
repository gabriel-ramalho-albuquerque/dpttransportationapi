package com.transportation.DPTTransport.Location;

import lombok.*;

import javax.persistence.*;

@NamedNativeQuery(name = "Location.getTopZonesByPickUps",
        query = "select t1.zone, t1.puTotal, t2.doTotal from (select l.zone, count(l.id) as puTotal from location l join trip t on l.id = t.pickup_location_id group by l.zone) as t1 join (select l.zone, count(l.id) as doTotal from location l join trip t on l.id = t.dropoff_location_id group by l.zone) as t2 on t1.zone = t2.zone order by t1.puTotal desc",
        resultSetMapping = "Mapping.TopZoneDTO")
@NamedNativeQuery(name = "Location.getTopZonesByDropOffs",
        query = "select t1.zone, t1.puTotal, t2.doTotal from (select l.zone, count(l.id) as puTotal from location l join trip t on l.id = t.pickup_location_id group by l.zone) as t1 join (select l.zone, count(l.id) as doTotal from location l join trip t on l.id = t.dropoff_location_id group by l.zone) as t2 on t1.zone = t2.zone order by t2.doTotal desc",
        resultSetMapping = "Mapping.TopZoneDTO")
@SqlResultSetMapping(name = "Mapping.TopZoneDTO",
        classes = @ConstructorResult(targetClass = TopZoneDTO.class,
                columns = {@ColumnResult(name = "zone"),
                        @ColumnResult(name = "puTotal"),
                        @ColumnResult(name = "doTotal")}))
@NamedNativeQuery(name = "Location.getZoneTrips",
        query = "select t1.zone as zone, t1.pickup_datetime as date, t1.pu as puSum, t2.do as doSum from (select l.zone, t.pickup_datetime, count(t.pickup_location_id) as pu from location l join trip t on l.id = t.pickup_location_id where l.id = :zoneId and (t.pickup_datetime = :date or t.dropoff_datetime = :date)) as t1, (select l.zone, t.pickup_datetime, count(t.dropoff_location_id) as do from location l join trip t on l.id = t.dropoff_location_id where l.id = :zoneId and (t.pickup_datetime = :date or t.dropoff_datetime = :date)) as t2",
        resultSetMapping = "Mapping.ZoneTripsDTO")
@SqlResultSetMapping(name = "Mapping.ZoneTripsDTO",
        classes = @ConstructorResult(targetClass = ZoneTripsDTO.class,
                columns = {@ColumnResult(name = "zone"),
                        @ColumnResult(name = "date"),
                        @ColumnResult(name = "puSum"),
                        @ColumnResult(name = "doSum")}))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    private long id;
    private String borough;
    private String zone;
    @Column(name = "SERVICE_ZONE")
    private String serviceZone;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", borough='" + borough + '\'' +
                ", zone='" + zone + '\'' +
                ", serviceZone='" + serviceZone + '\'' +
                '}';
    }
}
