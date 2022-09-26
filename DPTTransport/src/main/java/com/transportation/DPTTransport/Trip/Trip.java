package com.transportation.DPTTransport.Trip;

import com.transportation.DPTTransport.Location.Location;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private long id;

    private long vendorId;

    @Column(name = "PICKUP_DATETIME")
    private LocalDate pickupDateTime;

    @Column(name = "DROPOFF_DATETIME")
    private LocalDate dropoffDateTime;

    private int passengerCount;

    private String tripDistance;

    private long rateCodeId;

    private String storeAndFwdFlag;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location puLocation;

    @ManyToOne
    @JoinColumn(name = "dropoff_location_id")
    private Location doLocation;

    @ManyToOne
    @JoinColumn(name = "trip_type_id")
    private TripType tripType;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", vendorId=" + vendorId +
                ", pickupDateTime=" + pickupDateTime +
                ", dropoffDateTime=" + dropoffDateTime +
                ", passengerCount=" + passengerCount +
                ", tripDistance='" + tripDistance + '\'' +
                ", rateCodeId=" + rateCodeId +
                ", storeAndFwdFlag='" + storeAndFwdFlag + '\'' +
                ", puLocation=" + puLocation +
                ", doLocation=" + doLocation +
                ", tripType=" + tripType +
                '}';
    }
}
