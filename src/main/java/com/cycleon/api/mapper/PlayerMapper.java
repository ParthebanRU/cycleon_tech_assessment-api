package com.cycleon.api.mapper;

import com.cycleon.api.entity.Player;
import com.cycleon.api.model.PlayerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = PitMapper.class)
public interface PlayerMapper {

    PlayerDTO toDTO(Player player);

    Player toEntity(PlayerDTO playerDTO);

    List<PlayerDTO> toDTOList(List<Player> playerList);
}
