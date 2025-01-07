package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SampleRepository extends JpaRepository<Sample,String> {
    Optional<Sample> findBySampleId(String sampleId);

    //@Override
    //List<Sample>findAll();

    @Query("SELECT s FROM Sample s WHERE s.sampleStatus =:status")
    List<Sample> findAllExceptFinalizado(@Param("status") String status);


    List<Sample> findByFarm_FarmId(String farm_Id);

    @Query(value = """
    SELECT 
        CASE
            WHEN MONTH(NOW()) >= 10 THEN 
                COALESCE(
                    (SELECT MAX(CAST(REPLACE(s.sample_numero_muestra, '-', '') AS SIGNED)) + 1 
                     FROM tbl_sample s
                     WHERE SUBSTRING(s.sample_numero_muestra, 1, 4) = YEAR(NOW()) + 1), 
                     CONCAT(YEAR(NOW()) + 1, "0001"))
            ELSE 
                COALESCE(
                    (SELECT MAX(CAST(REPLACE(s.sample_numero_muestra, '-', '') AS SIGNED)) + 1 
                     FROM tbl_sample s
                     WHERE SUBSTRING(s.sample_numero_muestra, 1, 4) = YEAR(NOW())), 
                     CONCAT(YEAR(NOW()), "0001"))
        END AS maxNumeroMuestra
    """, nativeQuery = true)
    String findNextSampleNumber();

}
