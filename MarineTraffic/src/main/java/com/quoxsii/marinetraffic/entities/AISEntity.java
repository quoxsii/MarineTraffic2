package com.quoxsii.marinetraffic.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ais")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AISEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long channelId;
    private String channel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ais")
    private List<VesselPositionEntity> vesselPositionEntities;

    public AISEntity() {
    }

    public List<VesselPositionEntity> getVesselPositionEntities() {
        return vesselPositionEntities;
    }

    public void setVesselPositionEntities(List<VesselPositionEntity> vesselPositionEntities) {
        this.vesselPositionEntities = vesselPositionEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
