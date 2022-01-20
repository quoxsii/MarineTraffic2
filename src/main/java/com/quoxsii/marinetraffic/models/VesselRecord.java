package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import org.springframework.lang.NonNull;

public class VesselRecord {
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

    public static VesselRecord toModel(VesselRecordEntity entity) {
        VesselRecord model = new VesselRecord();
        model.setLat(entity.getLat());
        model.setLon(entity.getLon());
        model.setCog(entity.getCog());
        model.setSog(entity.getSog());
        model.setTrueHeading(entity.getTrueHeading());
        model.setEta(entity.getEta());
        model.setRot(entity.getRot());
        model.setNavStateCode(entity.getNavStateCode());
        model.setNavState(entity.getNavState());
        model.setDestination(entity.getDestination());
        model.setMsgTime(entity.getMsgTime());
        return model;
    }

    public static VesselRecord toModel(@NonNull AisDto dto) {
        VesselRecord model = new VesselRecord();
        model.setLat(dto.getLat());
        model.setLon(dto.getLon());
        model.setCog(dto.getCog());
        model.setSog(dto.getSog());
        model.setTrueHeading(dto.getTrueHeading());
        model.setRot(dto.getRot());
        model.setNavStateCode(dto.getNavStateCode());
        model.setNavState(dto.getNavState());
        model.setDestination(dto.getDestination());
        model.setMsgTime(dto.getMsgTime());
        return model;
    }

    public VesselRecord() {
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
