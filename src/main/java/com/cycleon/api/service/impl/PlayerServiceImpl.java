package com.cycleon.api.service.impl;

import com.cycleon.api.entity.Player;
import com.cycleon.api.jpa.PlayerRepository;
import com.cycleon.api.mapper.PlayerMapper;
import com.cycleon.api.model.PlayerDTO;
import com.cycleon.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    /**
     * @param player - Player to save
     * @return - Player DTO to display
     */
    @Override
    public PlayerDTO savePlayer(Player player) {
        Player savedPlayer = playerRepository.save(player);
        return playerMapper.toDTO(savedPlayer);
    }
}
