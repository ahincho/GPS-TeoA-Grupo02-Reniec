package com.unsa.reniec.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.unsa.reniec.domain.entities.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    Optional<PersonEntity> findByDocumentNumber(String documentNumber);

}
