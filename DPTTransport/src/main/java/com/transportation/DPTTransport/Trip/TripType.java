package com.transportation.DPTTransport.Trip;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TripType {

    @Id
    private long id;

    private String type;
}
