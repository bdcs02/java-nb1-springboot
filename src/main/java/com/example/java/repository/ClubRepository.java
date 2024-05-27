package com.example.java.repository;

import com.example.java.model.ClubsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends CrudRepository<ClubsModel,Integer> {
    Optional<ClubsModel> findById(int id);
}
