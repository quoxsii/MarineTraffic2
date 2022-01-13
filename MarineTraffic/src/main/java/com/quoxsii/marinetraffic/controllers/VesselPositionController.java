package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.entities.VesselPositionEntity;
import com.quoxsii.marinetraffic.models.VesselPositionUpdater;
import com.quoxsii.marinetraffic.services.VesselPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/vessels_positions")
public class VesselPositionController {
    @Autowired
    private VesselPositionService positionService;

    @PostMapping
    public ResponseEntity addPosition(@RequestBody VesselPositionEntity position, @RequestParam Long aisId, @RequestParam Long vesselId) {
        try {
            return ResponseEntity.ok(positionService.add(position, aisId, vesselId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updatePosition(@RequestParam Long id, @RequestBody VesselPositionUpdater updater) {
        try {
            return ResponseEntity.ok(positionService.update(id, updater));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
