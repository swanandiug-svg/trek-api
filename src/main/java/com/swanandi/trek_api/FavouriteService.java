package com.swanandi.trek_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private TrailRepository trailRepository;

    public List<Favourite> getFavouritesByUsername(String username) {
        return favouriteRepository.findByUsername(username);
    }

    public Favourite addFavourite(String username, Long trailId) {
        Optional<Trail> trail = trailRepository.findById(trailId);
        if (trail.isPresent()) {
            Favourite favourite = new Favourite();
            favourite.setUsername(username);
            favourite.setTrail(trail.get());
            return favouriteRepository.save(favourite);
        }
        return null;
    }

    public void removeFavourite(Long favouriteId) {
        favouriteRepository.deleteById(favouriteId);
    }
}