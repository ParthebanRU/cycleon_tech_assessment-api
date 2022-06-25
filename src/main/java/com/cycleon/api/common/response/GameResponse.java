package com.cycleon.api.common.response;

import com.cycleon.api.model.GameDTO;
import com.cycleon.api.model.PitDTO;
import lombok.Data;

import java.util.List;

@Data
public class GameResponse {
    private GameDTO game;
    private String message;
}
