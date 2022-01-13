package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.exceptions.VesselAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.services.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vessels")
public class VesselController {
    @Autowired
    private VesselService vesselService;

    @PostMapping
    public ResponseEntity addVessel(@RequestBody VesselEntity vessel) {
        try {
            vesselService.add(vessel);
            return ResponseEntity.ok("Судно успешно добавлено");
        } catch (VesselAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = "id")
    public ResponseEntity getOneVessel(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(vesselService.getOne(id));
        } catch (VesselNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllVessels() {
        try {
            return ResponseEntity.ok(vesselService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVessel(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(vesselService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
