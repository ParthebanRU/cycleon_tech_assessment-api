package com.cycleon.api.controller;

import com.cycleon.api.common.AppConstants;
import com.cycleon.api.common.response.GameResponse;
import com.cycleon.api.model.GameDTO;
import com.cycleon.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "${api.version}/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/")
    public ResponseEntity<String> checkGame() {
        return new ResponseEntity<>("Game is alive", HttpStatus.OK);
    }

    @GetMapping(value = "/active")
    public ResponseEntity<GameResponse> checkForActiveGame() {
        GameDTO game = gameService.getActiveGame();
        GameResponse gameResponse = new GameResponse();
        HttpStatus status;
        if(Objects.isNull(game)) {
            gameResponse.setMessage(AppConstants.NO_ACTIVE_GAME);
            status = HttpStatus.NOT_FOUND;
        } else {
            gameResponse.setGame(game);
            gameResponse.setMessage(AppConstants.ACTIVE_GAME_FOUND);
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(gameResponse, status);
    }

    @PostMapping(value = "/")
    public ResponseEntity<GameResponse> createNewGame() {
        GameResponse gameResponse = new GameResponse();
        GameDTO game = gameService.createNewGame();
        HttpStatus status;
        if(Objects.nonNull(game)) {
            gameResponse.setGame(game);
            gameResponse.setMessage(AppConstants.GAME_CREATED);
            status = HttpStatus.OK;
        } else {
            gameResponse.setMessage(AppConstants.GAME_CREATION_ISSUE);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(gameResponse, status);
    }

    @GetMapping(value = "/{gameId}")
    public ResponseEntity<GameResponse> getGameById(@PathVariable int gameId) {
        GameResponse gameResponse = new GameResponse();
        GameDTO gameDTO = gameService.getGameByID(gameId);
        HttpStatus status;
        if(Objects.isNull(gameDTO)) {
            gameResponse.setMessage(AppConstants.NO_GAME_FOUND);
            status = HttpStatus.BAD_REQUEST;
        } else {
            // gameResponse.setGameDTO(gameDTO);
            gameResponse.setMessage(AppConstants.GAME_FOUND);
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(gameResponse, status);
    }

}
