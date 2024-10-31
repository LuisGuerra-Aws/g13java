package com.framework.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.framework.backend.Entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
