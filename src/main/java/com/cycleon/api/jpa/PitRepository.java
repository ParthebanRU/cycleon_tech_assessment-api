package com.cycleon.api.jpa;

import com.cycleon.api.entity.Pit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PitRepository extends JpaRepository<Pit, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM public.pit WHERE player_id=?1")
    List<Pit> findByPlayerId(long playerId);
}
