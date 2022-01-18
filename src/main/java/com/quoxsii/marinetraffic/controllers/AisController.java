package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.exceptions.AisNotFoundException;
import com.quoxsii.marinetraffic.services.AisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ais")
public class AisController {
    @Autowired
    private AisService aisService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(aisService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(params = "id")
    public ResponseEntity getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(aisService.getById(id));
        } catch (AisNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
