package com.cycleon.api.service.impl;

import com.cycleon.api.entity.Pit;
import com.cycleon.api.jpa.PitRepository;
import com.cycleon.api.mapper.PitMapper;
import com.cycleon.api.model.PitDTO;
import com.cycleon.api.service.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitServiceImpl implements PitService {

    @Autowired
    private PitRepository pitRepository;

    @Autowired
    private PitMapper pitMapper;

    /**
     * @param pit - Pit object to Save
     * @return - DTO to display as Pit
     */
    @Override
    public PitDTO savePit(Pit pit) {
        Pit savedPit = pitRepository.save(pit);
        return pitMapper.toDTO(savedPit);
    }
}
