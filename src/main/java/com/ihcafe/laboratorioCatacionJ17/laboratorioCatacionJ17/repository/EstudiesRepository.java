package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Estudies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudiesRepository extends JpaRepository<Estudies,String > {
    List<Estudies> findAllByEstudiesIdIn(List<String> ids);
    @Override
    List<Estudies>findAll();
}
