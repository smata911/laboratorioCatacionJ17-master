package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,String> {

    Optional<Producer> findByProducerFirstName(String producerFirstName);
    Optional<Producer> findByProducerIdentidad(String producerIdentidad);

    @Override
    List<Producer> findAll();


    Page<Producer> findByProducerIdentidadContainingIgnoreCaseOrderByProducerFechaRegistroDesc(
            String producerIdentidad, Pageable pageable
    );
    @Query("SELECT p FROM Producer p LEFT JOIN FETCH p.producerFarm")
    List<Producer> findAllWithFarms();

// Page<Producer> findByProducerFirstNameContaining(String producerFirstName, Pageable pageable);


}
