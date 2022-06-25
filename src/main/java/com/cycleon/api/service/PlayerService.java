package com.cycleon.api.service;

import com.cycleon.api.entity.Player;
import com.cycleon.api.model.PlayerDTO;

public interface PlayerService {
    PlayerDTO savePlayer(Player player);
}
