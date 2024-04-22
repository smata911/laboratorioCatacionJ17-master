package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature,String> {


}
