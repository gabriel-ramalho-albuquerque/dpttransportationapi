package com.transportation.DPTTransport.Location;

import java.math.BigInteger;

public class TopZoneDTO {
    private String zone;

    private BigInteger puTotal;

    private BigInteger doTotal;

    public TopZoneDTO() {
    }

    public TopZoneDTO(String zone, BigInteger puTotal, BigInteger  doTotal) {
        this.zone = zone;
        this.puTotal = puTotal;
        this.doTotal = doTotal;
    }

    public String getZone() {
        return this.zone;
    }

    public BigInteger getPuTotal() {
        return this.puTotal;
    }

    public BigInteger getDoTotal() {
        return this.doTotal;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setPuTotal(BigInteger  puTotal) {
        this.puTotal = puTotal;
    }

    public void setDoTotal(BigInteger  doTotal) {
        this.doTotal = doTotal;
    }
}
