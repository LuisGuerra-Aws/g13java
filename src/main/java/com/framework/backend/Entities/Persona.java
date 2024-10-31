package com.framework.backend.Entities;


import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "personas", indexes = @Index(name = "idx_persona", columnList="idPersona", unique=true))
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @NonNull
    @Column(name = "personName", nullable = false, length = 30)
    private String name;

    @NonNull
    @Column(name = "personLastName", nullable = false, length = 40)
    private String lastname;

    @NonNull
    @Column(name = "personEmail", nullable = false, length = 150)
    private String email;


    @NonNull
    @Column(name = "personMobile", nullable = false, length = 10)
    private Long mobile;    

    @OneToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    private Rol rol;


}
