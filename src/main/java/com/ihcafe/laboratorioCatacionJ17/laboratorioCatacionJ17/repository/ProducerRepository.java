package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,String> {

    Optional<Producer> findByProducerFirstName(String producerFirstName);
    Optional<Producer> findByProducerIdentidad(String producerIdentidad);



    Page<Producer> findByProducerFirstNameContaining(String producerFirstName, Pageable pageable);


}
