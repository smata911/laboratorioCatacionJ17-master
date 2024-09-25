package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FarmRepository  extends JpaRepository<Farm,String> {

    Optional<Farm> findByFarmId(String s);
    Optional<Farm> findByFarmNameAndProducerId(String farmName, Producer producer);
}
