package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.AISEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AIS {
    private Long id;
    private Integer channelId;
    private String channel;
    private List<VesselPosition> vesselPositions;

    public static AIS toModel(AISEntity entity) {
        AIS model = new AIS();
        model.setId(entity.getId());
        model.setChannelId(entity.getChannelId());
        model.setChannel(entity.getChannel());
        model.setVesselPositions(entity.getVesselPositionEntities().stream().map(VesselPosition::toModel).collect(Collectors.toList()));
        return model;
    }

    public AIS() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<VesselPosition> getVesselPositions() {
        return vesselPositions;
    }

    public void setVesselPositions(List<VesselPosition> vesselPositions) {
        this.vesselPositions = vesselPositions;
    }
}
