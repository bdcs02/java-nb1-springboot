package com.java_nb1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java_nb1.model.ClubsModel;

//Ez is csak a olvasáshoz kellett volna a klub nevek miatt de meghagytam
public interface ClubsRepo extends JpaRepository<ClubsModel, Integer> {
}



