package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModeloTiempos;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModeloTiempoRepository extends JpaRepository<ModeloTiempos,String> {
    Optional<ModeloTiempos> findBymodeloTiempoTiempoId(String tiempoId);
}
