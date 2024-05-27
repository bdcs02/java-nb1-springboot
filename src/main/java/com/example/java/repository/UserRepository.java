package com.example.java.repository;

import com.example.java.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>
{
    Optional<UserModel> findByUsername(String username);
}


