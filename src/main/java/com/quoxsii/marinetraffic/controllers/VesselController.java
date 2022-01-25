package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.services.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vessel")
public class VesselController {
    private final VesselService vesselService;

    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @GetMapping(params = "mmsi")
    public ResponseEntity<?> getByMmsi(@RequestParam String mmsi) {
        try {
            return ResponseEntity.ok(vesselService.getByMmsi(mmsi));
        } catch (VesselNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(vesselService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
