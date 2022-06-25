package com.cycleon.api.service;

import com.cycleon.api.entity.Pit;
import com.cycleon.api.model.PitDTO;

public interface PitService {
    PitDTO savePit(Pit pit);
}
