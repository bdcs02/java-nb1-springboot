package com.example.java.repository;

import com.example.java.model.PlayerPostsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerPostsRepository extends CrudRepository<PlayerPostsModel,Integer> {
    Optional<PlayerPostsModel> findById(int id);
}
