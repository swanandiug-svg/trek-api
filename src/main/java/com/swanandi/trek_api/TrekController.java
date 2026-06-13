package com.swanandi.trek_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trails")
public class TrekController {

    @Autowired
    private TrailService trailService;

    @GetMapping
    public List<Trail> getAllTrails() {
        return trailService.getAllTrails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trail> getTrailById(@PathVariable Long id) {
        Optional<Trail> trail = trailService.getTrailById(id);
        return trail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trail> createTrail(@Valid @RequestBody Trail trail) {
        Trail savedTrail = trailService.createTrail(trail);
        return ResponseEntity.status(201).body(savedTrail);
    }

    @GetMapping("/filter/difficulty/{difficulty}")
    public ResponseEntity<List<Trail>> getByDifficulty(@PathVariable String difficulty) {
        return ResponseEntity.ok(trailService.getTrailsByDifficulty(difficulty));
    }

    @GetMapping("/filter/state/{state}")
    public ResponseEntity<List<Trail>> getByState(@PathVariable String state) {
        return ResponseEntity.ok(trailService.getTrailsByState(state));
    }

    @GetMapping("/filter/distance/{distance}")
    public ResponseEntity<List<Trail>> getByMaxDistance(@PathVariable Double distance) {
        return ResponseEntity.ok(trailService.getTrailsByMaxDistance(distance));
    }

    @GetMapping("/filter/difficulty/{difficulty}/state/{state}")
    public ResponseEntity<List<Trail>> getTrailsByDifficultyAndState(
            @PathVariable String difficulty,
            @PathVariable String state) {
        return ResponseEntity.ok(trailService.getTrailsByDifficultyAndState(difficulty, state));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Trail>> searchTrails(@RequestParam String name) {
        return ResponseEntity.ok(trailService.searchTrailsByName(name));
    }

    @GetMapping("/sort/distance")
    public ResponseEntity<List<Trail>> getTrailsSortedByDistance() {
        return ResponseEntity.ok(trailService.getTrailsSortedByDistance());
    }

    @GetMapping("/sort/elevation")
    public ResponseEntity<List<Trail>> getTrailsSortedByElevation() {
        return ResponseEntity.ok(trailService.getTrailsSortedByElevation());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trail> updateTrail(@PathVariable Long id, @RequestBody Trail trail) {
        return ResponseEntity.ok(trailService.updateTrail(id, trail));
    }
}