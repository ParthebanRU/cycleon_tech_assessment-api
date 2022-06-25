package com.cycleon.api.entity;

import com.cycleon.api.common.jpa.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Player extends AbstractEntity<Long> {

    private String name;
    @OneToMany
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private List<Pit> pits;

}
