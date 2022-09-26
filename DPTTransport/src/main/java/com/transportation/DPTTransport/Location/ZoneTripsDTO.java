package com.transportation.DPTTransport.Location;

import java.math.BigInteger;
import java.util.Date;

public class ZoneTripsDTO {

    private String zone;

    private Date date;

    private BigInteger puSum;

    private BigInteger doSum;

    public ZoneTripsDTO() {
    }

    public ZoneTripsDTO(String zone, Date date, BigInteger puSum, BigInteger doSum) {
        this.zone = zone;
        this.date = date;
        this.puSum = puSum;
        this.doSum = doSum;
    }

    public String getZone() {
        return zone;
    }

    public Date getDate() {
        return date;
    }

    public BigInteger getPuSum() {
        return puSum;
    }

    public BigInteger getDoSum() {
        return doSum;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPuSum(BigInteger puSum) {
        this.puSum = puSum;
    }

    public void setDoSum(BigInteger doSum) {
        this.doSum = doSum;
    }
}
