package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.entities.AISEntity;
import com.quoxsii.marinetraffic.exceptions.AISAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.AISNotFoundException;
import com.quoxsii.marinetraffic.services.AISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ais")
public class AISController {
    @Autowired
    private AISService aisService;

    /*@PostMapping
    public ResponseEntity addAIS(@RequestBody AISEntity ais) {
        try {
            aisService.add(ais);
            return ResponseEntity.ok("АИС успешно добавлен");
        } catch (AISAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }*/

    @GetMapping(params = "id")
    public ResponseEntity getOneAIS(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(aisService.getOne(id));
        } catch (AISNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllAIS() {
        try {
            return ResponseEntity.ok(aisService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAIS(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(aisService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
