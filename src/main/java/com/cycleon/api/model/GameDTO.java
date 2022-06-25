package com.cycleon.api.model;

import lombok.Data;

import java.util.List;

@Data
public class GameDTO {
    private Integer id;
    private boolean active;
    private List<PlayerDTO> players;
}
