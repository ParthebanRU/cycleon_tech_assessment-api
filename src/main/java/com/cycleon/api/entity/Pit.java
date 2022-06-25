package com.cycleon.api.entity;

import com.cycleon.api.common.jpa.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Pit extends AbstractEntity<Long> {
    private String type;
    private int seedCount;
}
