package com.quoxsii.marinetraffic.entities;

import javax.persistence.*;

@Entity
@Table(name = "vessel_record")
public class VesselRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float lat;
    private Float lon;
    private Float cog;
    private Float sog;
    private Integer trueHeading;
    private String eta;
    private Float rot;
    private Integer navStateCode;
    private String navState;
    private String destination;
    private String msgTime;

    @ManyToOne
    @JoinColumn(name = "vessel_id", nullable = false)
    private VesselEntity vessel;

    public VesselRecordEntity() {
    }

    public VesselEntity getVessel() {
        return vessel;
    }

    public void setVessel(VesselEntity vessel) {
        this.vessel = vessel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getCog() {
        return cog;
    }

    public void setCog(Float cog) {
        this.cog = cog;
    }

    public Float getSog() {
        return sog;
    }

    public void setSog(Float sog) {
        this.sog = sog;
    }

    public Integer getTrueHeading() {
        return trueHeading;
    }

    public void setTrueHeading(Integer trueHeading) {
        this.trueHeading = trueHeading;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public Float getRot() {
        return rot;
    }

    public void setRot(Float rot) {
        this.rot = rot;
    }

    public Integer getNavStateCode() {
        return navStateCode;
    }

    public void setNavStateCode(Integer navStateCode) {
        this.navStateCode = navStateCode;
    }

    public String getNavState() {
        return navState;
    }

    public void setNavState(String navState) {
        this.navState = navState;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
}
