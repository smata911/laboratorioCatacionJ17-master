package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SampleRepository extends JpaRepository<Sample,String> {
    Optional<Sample> findBySampleId(String sampleId);

}
