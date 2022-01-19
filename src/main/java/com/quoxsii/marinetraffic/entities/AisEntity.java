package com.quoxsii.marinetraffic.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.quoxsii.marinetraffic.models.Ais;
import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.models.Vessel;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "ais")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long channelId;
    private String channel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ais")
    private List<VesselEntity> vesselEntities;

    public static AisEntity toEntity(AisDto dto) {
        AisEntity entity = new AisEntity();
        entity.setChannelId(dto.getChannelId());
        entity.setChannel(dto.getChannel());
        return entity;
    }

    public AisEntity() {
    }

    public List<VesselEntity> getVesselEntities() {
        return vesselEntities;
    }

    public void setVesselEntities(List<VesselEntity> vesselEntities) {
        this.vesselEntities = vesselEntities;
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
