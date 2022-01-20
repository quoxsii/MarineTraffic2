package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class Vessel {
    private String mmsi;
    private String imo;
    private String country;
    private Integer length;
    private Integer width;
    private Float draught;
    private String callSign;
    private Integer typeCode;
    private String type;
    private String typeDetail;
    private String name;
    private VesselRecord vesselRecord;

    public static Vessel toModel(VesselEntity entity) {
        Vessel model = new Vessel();
        model.setMmsi(entity.getMmsi());
        model.setImo(entity.getImo());
        model.setCountry(entity.getCountry());
        model.setLength(entity.getLength());
        model.setWidth(entity.getWidth());
        model.setDraught(entity.getDraught());
        model.setCallSign(entity.getCallSign());
        model.setTypeCode(entity.getTypeCode());
        model.setType(entity.getType());
        model.setTypeDetail(entity.getTypeDetail());
        model.setName(entity.getName());
        List<VesselRecord> vr = entity.getVesselRecordEntities().stream().map(VesselRecord::toModel).collect(Collectors.toList());
        model.setVesselRecord(vr.get(vr.size() - 1));
        return model;
    }

    public static Vessel toModel(@NonNull AisDto dto) {
        Vessel model = new Vessel();
        model.setMmsi(dto.getMmsi());
        model.setImo(dto.getImo());
        model.setCountry(dto.getCountry());
        model.setLength(dto.getLength());
        model.setWidth(dto.getWidth());
        model.setDraught(dto.getDraught());
        model.setCallSign(dto.getCallSign());
        model.setTypeCode(dto.getTypeCode());
        model.setType(dto.getType());
        model.setTypeDetail(dto.getTypeDetail());
        model.setName(dto.getName());
        return model;
    }

    public Vessel() {
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Float getDraught() {
        return draught;
    }

    public void setDraught(Float draught) {
        this.draught = draught;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VesselRecord getVesselRecord() {
        return vesselRecord;
    }

    public void setVesselRecord(VesselRecord vesselRecord) {
        this.vesselRecord = vesselRecord;
    }
}
