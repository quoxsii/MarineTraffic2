package com.quoxsii.marinetraffic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AISListDto {
    private List<AISDto> items;

    public List<AISDto> getItems() {
        return items;
    }

    public void setItems(List<AISDto> items) {
        this.items = items;
    }
}
