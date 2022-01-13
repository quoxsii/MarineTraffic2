package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.VesselPositionEntity;

import java.sql.Timestamp;

public class VesselPosition {
    private Long id;
    private Long aisId;
    private Long vesselId;
    private Float lat;
    private Float lon;
    private Float cog;
    private Float sog;
    private Integer trueHeading;
    private Float rot;
    private Integer navStateCode;
    private String navState;
    private String destination;
    private String msgTime;

    public static VesselPosition toModel(VesselPositionEntity entity) {
        VesselPosition model = new VesselPosition();
        model.setId(entity.getId());
        model.setAisId(entity.getAis().getId());
        model.setVesselId(entity.getVessel().getId());
        model.setLat(entity.getLat());
        model.setLon(entity.getLon());
        model.setCog(entity.getCog());
        model.setSog(entity.getSog());
        model.setTrueHeading(entity.getTrueHeading());
        model.setRot(entity.getRot());
        model.setNavStateCode(entity.getNavStateCode());
        model.setNavState(entity.getNavState());
        model.setDestination(entity.getDestination());
        model.setMsgTime(entity.getMsgTime());
        return model;
    }

    public VesselPosition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAisId() {
        return aisId;
    }

    public void setAisId(Long aisId) {
        this.aisId = aisId;
    }

    public Long getVesselId() {
        return vesselId;
    }

    public void setVesselId(Long vesselId) {
        this.vesselId = vesselId;
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
