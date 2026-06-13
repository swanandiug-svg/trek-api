package com.swanandi.trek_api;

import jakarta.persistence.*;

@Entity
@Table(name = "favourites")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Trail getTrail() { return trail; }
    public void setTrail(Trail trail) { this.trail = trail; }
}