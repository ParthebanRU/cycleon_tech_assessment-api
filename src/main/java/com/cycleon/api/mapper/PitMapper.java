package com.cycleon.api.mapper;

import com.cycleon.api.entity.Pit;
import com.cycleon.api.entity.Player;
import com.cycleon.api.model.PitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PitMapper {
    PitDTO toDTO(Pit pit);

    Pit toEntity(PitDTO pitDTO);

    List<PitDTO> toDTOList(List<Pit> pitList);
}
