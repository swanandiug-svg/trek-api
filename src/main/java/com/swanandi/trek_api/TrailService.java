package com.swanandi.trek_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    public List<Trail> getAllTrails() {
        return trailRepository.findAll();
    }

    public Optional<Trail> getTrailById(Long id) {
        return trailRepository.findById(id);
    }

    public Trail createTrail(Trail trail) {
        return trailRepository.save(trail);
    }

    public List<Trail> getTrailsByDifficulty(String difficulty) {
        return trailRepository.findByDifficulty(difficulty);
    }

    public List<Trail> getTrailsByState(String state) {
        return trailRepository.findByState(state);
    }
    public List<Trail> getTrailsByDifficultyAndState(String difficulty , String state) {
        return trailRepository.findByDifficultyAndState(difficulty,state);
    }

    public List<Trail> getTrailsByMaxDistance(Double distance) {
        return trailRepository.findByDistanceLessThanEqual(distance);
    }
    public List<Trail> searchTrailsByName(String name) {
        return trailRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Trail> getTrailsSortedByDistance() {
        return trailRepository.findByOrderByDistanceAsc();
    }

    public List<Trail> getTrailsSortedByElevation() {
        return trailRepository.findByOrderByElevationDesc();
    }
    public Trail updateTrail(Long id, Trail updatedTrail) {
        Trail existing = trailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail not found"));
        existing.setName(updatedTrail.getName());
        existing.setLocation(updatedTrail.getLocation());
        existing.setState(updatedTrail.getState());
        existing.setDifficulty(updatedTrail.getDifficulty());
        existing.setDistance(updatedTrail.getDistance());
        existing.setElevation(updatedTrail.getElevation());
        existing.setDescription(updatedTrail.getDescription());
        return trailRepository.save(existing);
    }
}