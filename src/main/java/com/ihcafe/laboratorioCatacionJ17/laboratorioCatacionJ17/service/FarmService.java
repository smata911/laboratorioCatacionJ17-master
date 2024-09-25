package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;

public interface FarmService {
    /**
     * Saves given Student into DB.
     *
     * @param farmDto Student
     * @return
     */

    FarmDto saveFarm(String producerIdp, FarmDto farmDto);

    /**
     * Find a student by its ID.
     * @param farmId String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by ID
     */
    FarmDto findFarmtById(final String farmId) throws ProducerNotFoundException;

}
