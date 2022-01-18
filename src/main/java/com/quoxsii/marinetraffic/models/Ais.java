package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.AisEntity;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class Ais {
    private Long id;
    private Long channelId;
    private String channel;
    private List<Vessel> vessels;

    public static Ais toModel(AisEntity entity) {
        Ais model = new Ais();
        model.setId(entity.getId());
        model.setChannelId(entity.getChannelId());
        model.setChannel(entity.getChannel());
        model.setVessels(entity.getVesselEntities().stream().map(Vessel::toModel).collect(Collectors.toList()));
        return model;
    }

    public static Ais toModel(@NonNull AisDto dto) {
        Ais model = new Ais();
        model.setChannelId(dto.getChannelId());
        model.setChannel(dto.getChannel());
        return model;
    }

    public Ais() {
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

    public List<Vessel> getVessels() {
        return vessels;
    }

    public void setVessels(List<Vessel> vessels) {
        this.vessels = vessels;
    }
}
