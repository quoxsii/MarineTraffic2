package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.exceptions.AisNotFoundException;
import com.quoxsii.marinetraffic.models.Ais;
import com.quoxsii.marinetraffic.services.AisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
@RequestMapping("/ais")
public class AisController {
    @Autowired
    private AisService aisService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    CompletableFuture<ResponseEntity> getAll() {
        try {
            return aisService.getAll().<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleGetAisFailure);
        } catch (Exception ex) {
            return null;
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

    private static Function<Throwable, ResponseEntity<? extends List<Ais>>> handleGetAisFailure = throwable -> {
        System.out.printf("Failed to read records: {}", throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    };
}
