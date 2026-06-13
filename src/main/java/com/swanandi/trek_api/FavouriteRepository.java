package com.swanandi.trek_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    List<Favourite> findByUsername(String username);
}