package com.cycleon.api.service;

import com.cycleon.api.model.GameDTO;
import com.cycleon.api.model.PitDTO;

import java.util.List;

public interface GameService {

    GameDTO getActiveGame();

    GameDTO createNewGame();

    GameDTO getGameByID(int gameID);
}
