package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.exceptions.PostAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(postService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(postService.getById(id));
        } catch (PostNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping(params = {"name", "url"})
    public ResponseEntity<?> add(@RequestParam String name, @RequestParam String url) {
        try {
            return ResponseEntity.ok(postService.add(name, url));
        } catch (PostAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(postService.delete(id));
        } catch (PostNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
