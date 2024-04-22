package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoastRepository extends JpaRepository<Roast,String> {

    Optional<Roast> findByRoastId(String roastId);


}
