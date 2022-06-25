package com.cycleon.api.service.impl;

import com.cycleon.api.common.enums.PitType;
import com.cycleon.api.entity.Game;
import com.cycleon.api.entity.Pit;
import com.cycleon.api.entity.Player;
import com.cycleon.api.jpa.GameRepository;
import com.cycleon.api.jpa.PitRepository;
import com.cycleon.api.jpa.PlayerRepository;
import com.cycleon.api.mapper.GameMapper;
import com.cycleon.api.model.GameDTO;
import com.cycleon.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PitRepository pitRepository;

    /**
     * @return - The game with pits
     */
    @Override
    public GameDTO getActiveGame() {

        Object[] results = gameRepository.checkActiveGames();

        if(Objects.nonNull(results) && results.length > 0) {
            // Casting to Long directly as we know we will fetch ID as long from DB
            Long gameId = Long.valueOf(String.valueOf(results[0]));
            Optional<Game> gameOptional = gameRepository.findById(gameId);
            if(gameOptional.isPresent()) {
                return gameMapper.toDto(gameOptional.get());
            }
        }
        return null;
    }

    /**
     * @return - Game for the given ID
     */
    @Override
    public GameDTO getGameByID(int gameID) {
        Optional<Game> gameOptional = gameRepository.findById((long) gameID);
        return gameOptional.map(game -> gameMapper.toDto(game)).orElse(null);
    }

    /**
     * @return - The game with Pits
     */
    @Override
    public GameDTO createNewGame() {
        Game game = new Game();
        game.setActive(true);
        game.setPlayers(createPlayers());
        return gameMapper.toDto(gameRepository.save(game));
    }

    public List<Player> createPlayers() {

        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setName("Player 1");
        player1.setPits(initializePitForPlayer());
        Player savedPlayer1 = playerRepository.save(player1);
        players.add(savedPlayer1);

        Player player2 = new Player();
        player2.setName("Player 2");
        player2.setPits(initializePitForPlayer());
        Player savedPlayer2 = playerRepository.save(player2);
        players.add(savedPlayer2);

        return players;

    }

    public List<Pit> initializePitForPlayer() {
        List<Pit> pits = new ArrayList<>();
        for(int i=0; i<7; i++) {
            Pit pit = new Pit();
            if(i == 6) {
                pit.setSeedCount(0);
                pit.setType(PitType.KALAH.name());
            } else {
                pit.setSeedCount(4);
                pit.setType(PitType.REGULAR.name());
            }
            pits.add(pitRepository.save(pit));
        }

        return pits;
    }
}
