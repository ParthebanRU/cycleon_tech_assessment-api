package com.cycleon.api.jpa;

import com.cycleon.api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM public.player WHERE game_id=?1")
    List<Player> findPlayersByGameId(long gameId);
}
