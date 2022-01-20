package com.quoxsii.marinetraffic.entities;

import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.models.Vessel;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vessel")
public class VesselEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @ManyToOne
    @JoinColumn(name = "ais_id", nullable = false)
    private AisEntity ais;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vessel")
    private List<VesselRecordEntity> vesselRecordEntities;

    public static VesselEntity toEntity(AisEntity ais, AisDto dto) {
        VesselEntity entity = new VesselEntity();
        entity.setMmsi(dto.getMmsi());
        entity.setImo(dto.getImo());
        entity.setCountry(dto.getCountry());
        entity.setLength(dto.getLength());
        entity.setWidth(dto.getWidth());
        entity.setDraught(dto.getDraught());
        entity.setCallSign(dto.getCallSign());
        entity.setTypeCode(dto.getTypeCode());
        entity.setType(dto.getType());
        entity.setTypeDetail(dto.getTypeDetail());
        entity.setName(dto.getName());
        entity.setAis(ais);
        return entity;
    }

    public VesselEntity() {
    }

    public AisEntity getAis() {
        return ais;
    }

    public void setAis(AisEntity ais) {
        this.ais = ais;
    }

    public List<VesselRecordEntity> getVesselRecordEntities() {
        return vesselRecordEntities;
    }

    public void setVesselRecordEntities(List<VesselRecordEntity> vesselRecordEntities) {
        this.vesselRecordEntities = vesselRecordEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMmsi() {
        return mmsi;
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

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
