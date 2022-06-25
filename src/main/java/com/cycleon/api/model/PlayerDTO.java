package com.cycleon.api.model;

import lombok.Data;

import java.util.List;

@Data
public class PlayerDTO {
    private Integer id;
    private String name;
    private List<PitDTO> pits;
}
