package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, String> {


    @Override
    List<Sesion> findAll();
}
