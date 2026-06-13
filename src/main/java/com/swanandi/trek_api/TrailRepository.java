package com.swanandi.trek_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {
    List<Trail> findByDifficulty(String difficulty);
    List<Trail> findByState(String state);
    List<Trail> findByDistanceLessThanEqual(Double distance);
    List<Trail> findByDifficultyAndState(String difficulty, String state);
    List<Trail> findByNameContainingIgnoreCase(String name);
    List<Trail> findByOrderByDistanceAsc();
    List<Trail> findByOrderByElevationDesc();
}

