package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FarmRepository extends JpaRepository<Farm, String> {

    Optional<Farm> findByFarmId(String s);

    @Override
    List<Farm> findAll();

    List<Farm> findFarmsByProducer_ProducerId(String producerId);



    // Usa producer_ProducerId en lugar de producerId
    @Query("SELECT f FROM Farm f JOIN Producer p ON p.producerId = :producerId WHERE f.farmName = :farmName")
    Optional<Farm> findByFarmNameAndProducer_ProducerId(@Param("farmName") String farmName, @Param("producerId") String producerId);
}
