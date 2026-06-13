package com.swanandi.trek_api;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "trails")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }

    public Double getElevation() { return elevation; }
    public void setElevation(Double elevation) { this.elevation = elevation; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Difficulty is required")
    private String difficulty;

    @Positive(message = "Distance must be positive")
    private Double distance;

    @Positive(message = "Elevation must be positive")
    private Double elevation;
}
