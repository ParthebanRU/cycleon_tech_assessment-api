package com.cycleon.api.entity;

import com.cycleon.api.common.jpa.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Game extends AbstractEntity<Long> {
    private boolean active;
    @OneToMany
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<Player> players;
}
