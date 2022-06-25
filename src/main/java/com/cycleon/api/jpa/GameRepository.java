package com.cycleon.api.jpa;

import com.cycleon.api.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = "SELECT id FROM game WHERE active=true")
    Object[] checkActiveGames();

}
