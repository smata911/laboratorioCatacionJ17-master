package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoastRepository extends JpaRepository<Roast,String> {

    Optional<Roast> findByRoastId(String roastId);

    @Override
    List<Roast> findAll();


    Page<Roast> findBySample_sampleNumeroMuestraContainingIgnoreCaseAndRoastStatus(String sampleNumeroMuestra,String roastStatus, Pageable pageable);
    Page<Roast> findBySample_sampleNumeroMuestraContainingIgnoreCase(String sampleNumeroMuestra, Pageable pageable);



}
