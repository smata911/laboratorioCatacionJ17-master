package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    Optional<UserEntity> findByUserName(String userName);



    //@Query("select u from UserEntity u where u.username=?1")
    //Optional<UserEntity> getName(String name);
}
