package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import org.springframework.data.domain.Page;

public interface RoastService {


    /**
     * Saves given Student into DB.
     *
     * @param roastDto Student
     * @return
     */
    RoastDto saveRoast(String sampleId,RoastDto roastDto);

    /**
     * Find a student by its ID.
     * @param roastId String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by ID
     */
    ProducerDto findRoastById(final String roastId) throws ProducerNotFoundException;

    /**
     * Find a student by its name.
     * @param roastFirstName String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by name
     */
    ProducerDto findRoastByName(final String roastFirstName) throws ProducerNotFoundException;

    /**
     * Find a student by its name.
     * @param roustIdentidad String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by name
     */
    RoastDto findRoustByIdentidad(final String roustIdentidad) throws ProducerNotFoundException;
    /**
     * Delete producer by its ID.
     * @param roustId
     */
    void deleteRoustById(final String roustId);

    /**
     * Return a page of sorted students.
     * @param RoustFirstName Student names to sort by.
     * @param page Page number to query by.
     * @param size Page size to query by.
     * @param sort Extra sort params to sort by.
     * @return PageResponseDto Student.
     */
    Page<RoastDto> findPaginatedSortedRoust(String RoustFirstName, int page, int size, String[] sort);

    /**
     * Evaluate if subject exists by subjectName.
     * @param roustName String
     * @return  boolean
     */
}
