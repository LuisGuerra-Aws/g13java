package com.framework.backend.Repositories;

import org.springframework.stereotype.Repository;

import com.framework.backend.Entities.Persona;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Integer>{

    Optional <Persona> findByEmail(String email);
    
}
