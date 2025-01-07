package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VarietiesRepository extends JpaRepository<Varieties,String> {

   // List<Varieties> findAllByIdIn(List<String> ids);
    List<Varieties> findAllByVarietiesIdIn(List<String> ids);

    @Override
    List<Varieties> findAll();
}
