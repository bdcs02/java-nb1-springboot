package com.example.java.repository;

import com.example.java.model.ContactFormModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactRepository extends CrudRepository<ContactFormModel,Integer> {

}
