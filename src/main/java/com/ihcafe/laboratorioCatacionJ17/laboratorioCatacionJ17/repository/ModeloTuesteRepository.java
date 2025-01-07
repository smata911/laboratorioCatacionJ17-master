package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModeloTiempos;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ModeloTuesteRepository extends JpaRepository<ModelosTueste,String> {
    @Override
    List<ModelosTueste> findAll();

   // Optional<ModeloTiempos> findBymodeloTiempoTiempoId(String tiempoId);

    @Query("SELECT m FROM ModelosTueste m " +
            "JOIN  FETCH m.modeloTiempos mt " +
            "WHERE m.modeloVariedad = :modeloVariedad " +
            "AND m.modeloStatus = :modeloStatus " +
            "AND m.typeProcess.typeProcessId = :typeProcessId " +
            "ORDER BY mt.modeloTiempoValue ASC")
    ModelosTueste findByModeloVariedadAndModeloStatusAndTypeProcessId(
            @Param("typeProcessId") int typeProcessId,
            @Param("modeloVariedad") String modeloVariedad,
            @Param("modeloStatus") int modeloStatus

    );

}
