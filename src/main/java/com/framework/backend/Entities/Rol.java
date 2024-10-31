package com.framework.backend.Entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "roles", indexes = @Index(name = "idx_rol", columnList="idRol", unique=true))
public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @NonNull
    @Column(name = "rolName", nullable = false, length = 30)
    private String name;

    @NonNull
    @Column(name = "rolDescription", nullable =  false, length = 200)
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "rol")
    @JsonIgnoreProperties("rol")
    private List<Persona> persona;


}
