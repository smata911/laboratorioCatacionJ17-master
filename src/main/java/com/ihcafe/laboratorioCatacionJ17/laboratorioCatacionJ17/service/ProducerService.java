package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import org.springframework.data.domain.Page;

public interface ProducerService {
    /**
     * Saves given Student into DB.
     *
     * @param producerDto Student
     * @return
     */
    ProducerDto saveProducer(ProducerDto producerDto);

    /**
     * Find a student by its ID.
     * @param producerId String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by ID
     */
    ProducerDto findProducertById(final String producerId) throws ProducerNotFoundException;

    /**
     * Find a student by its name.
     * @param producerFirstName String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by name
     */
    ProducerDto findProducerByName(final String producerFirstName) throws ProducerNotFoundException;

    /**
     * Find a student by its name.
     * @param producerIdentidad String
     * @return Student StudentDto
     * @throws ProducerNotFoundException when no Student is found by name
     */
    ProducerDto findProducerByIdentidad(final String producerIdentidad) throws ProducerNotFoundException;
    /**
     * Delete producer by its ID.
     * @param producerId
     */
    void deleteProducerById(final String producerId);

    /**
     * Return a page of sorted students.
     * @param producerFirstName Student names to sort by.
     * @param page Page number to query by.
     * @param size Page size to query by.
     * @param sort Extra sort params to sort by.
     * @return PageResponseDto Student.
     */
    Page<ProducerDto> findPaginatedSortedStudents(String producerFirstName, int page, int size, String[] sort);

    /**
     * Evaluate if subject exists by subjectName.
     * @param productName String
     * @return  boolean
     */




}
