package com.swanandi.trek_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/{username}")
    public ResponseEntity<List<Favourite>> getFavourites(@PathVariable String username) {
        return ResponseEntity.ok(favouriteService.getFavouritesByUsername(username));
    }

    @PostMapping("/{username}/{trailId}")
    public ResponseEntity<Favourite> addFavourite(@PathVariable String username, @PathVariable Long trailId) {
        Favourite favourite = favouriteService.addFavourite(username, trailId);
        if (favourite != null) {
            return ResponseEntity.status(201).body(favourite);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{favouriteId}")
    public ResponseEntity<Void> removeFavourite(@PathVariable Long favouriteId) {
        favouriteService.removeFavourite(favouriteId);
        return ResponseEntity.noContent().build();
    }
}