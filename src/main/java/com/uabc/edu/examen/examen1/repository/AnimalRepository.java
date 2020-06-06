package com.uabc.edu.examen.examen1.repository;

import com.uabc.edu.examen.examen1.model.AnimalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalRepository
        extends CrudRepository<AnimalEntity, Integer> {

}