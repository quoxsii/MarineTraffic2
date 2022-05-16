package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.services.VesselService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = {"x-total-count"})
@RestController
@RequestMapping("/api/vessels")
public class VesselController {
    private final VesselService vesselService;

    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(required = false, defaultValue = "true") Boolean paged,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            if (!paged) pageable = Pageable.unpaged();
            return ResponseEntity.ok()
                    .header("x-total-count", String.valueOf(vesselService.getAll(Pageable.unpaged()).size()))
                    .body(vesselService.getAll(pageable));
        } catch (VesselNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(path = "/{mmsi}")
    public ResponseEntity<?> getByMmsi(@PathVariable String mmsi) {
        try {
            return ResponseEntity.ok(vesselService.getByMmsi(mmsi));
        } catch (VesselNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(path = "/search/nameContains")
    public ResponseEntity<?> getByNameContains(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "true") Boolean paged,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            if (!paged) pageable = Pageable.unpaged();
            return ResponseEntity.ok()
                    .header("x-total-count", String.valueOf(vesselService.getByNameContains(name, Pageable.unpaged()).size()))
                    .body(vesselService.getByNameContains(name, pageable));
        } catch (VesselNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
