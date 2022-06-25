package com.cycleon.api.mapper;

import com.cycleon.api.entity.Game;
import com.cycleon.api.model.GameDTO;
import org.mapstruct.Mapper;

@Mapper(uses = PlayerMapper.class)
public interface GameMapper {

    Game toEntity(GameDTO gameDTO);
    GameDTO toDto(Game game);

}
