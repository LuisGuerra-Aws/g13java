package com.framework.backend.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.backend.Entities.Persona;
import com.framework.backend.Entities.Rol;
import com.framework.backend.Repositories.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
//    private ResponseProcess responseProcess;

    public Persona save(Persona persona){

        System.out.println("name" + persona.getName());
        System.out.println("getLastname" + persona.getLastname());
        System.out.println("getMobile" + persona.getMobile());
        System.out.println("getEmail" + persona.getEmail());
        System.out.println("getRol" + persona.getRol().getIdRol());



        if ((persona.getName() != null) &&  (persona.getLastname() != null)
        &&  (persona.getEmail() != null) &&  (persona.getRol().getIdRol() != null) &&  (persona.getMobile() != null)){
            System.out.println(persona.getRol());
            return personaRepository.save(persona);
        }
        else {
            Rol rolempty = new Rol("","");
            persona.setIdPersona(null);
            persona.setName("Inserción NO Realizada, datos Obligatorios con Nulo");
            persona.setLastname(" ");
            persona.setEmail(" ");
            persona.setMobile(0L);
            persona.setRol(rolempty);
            return persona;
        }
    }

    private Optional<Persona> findById(Integer id){
        return personaRepository.findById(id);
    }

    private Optional<Persona> findByEmail(String email){
        return personaRepository.findByEmail(email);
    }

    public Persona updateByObject(Persona persona){
        Optional<Persona> personaopt = findById(persona.getIdPersona());

        if (personaopt.isPresent()){
            Persona personaUpdate = personaopt.get();

            if (persona.getName() != null)
                personaUpdate.setName(persona.getName());

            if (persona.getLastname() != null)
                personaUpdate.setLastname(persona.getLastname());

            if (persona.getEmail() != null)
                personaUpdate.setEmail(persona.getEmail());

            if (persona.getMobile() != null)
                personaUpdate.setMobile(persona.getMobile());

            if (persona.getRol().getIdRol() != null)
                personaUpdate.setRol(persona.getRol());


            return personaRepository.save(personaUpdate);
        }
        else {
            Rol rolempty = new Rol("","");
            persona.setIdPersona(null);
            persona.setName("Actualización NO Realizada, Identificador Inexistente");
            persona.setLastname(" ");
            persona.setEmail(" ");
            persona.setMobile(0L);
            persona.setRol(rolempty);
            return persona;
 
        }
    }

    public Persona updateById(Integer id, Persona persona){
        Optional<Persona> personaopt = findById(id);
//        ResponseProcess responseProcess = new ResponseProcess();
        if (personaopt.isPresent()){
            Persona personaUpdate = personaopt.get();

            if (persona.getName() != null)
                personaUpdate.setName(persona.getName());

            if (persona.getLastname() != null)
                personaUpdate.setLastname(persona.getLastname());

            if (persona.getEmail() != null)
                personaUpdate.setEmail(persona.getEmail());

            if (persona.getMobile() != null)
                personaUpdate.setMobile(persona.getMobile());

            if (persona.getRol().getIdRol() != null)
                personaUpdate.setRol(persona.getRol());


            return personaRepository.save(personaUpdate);  
        }
        else {
            Rol rolempty = new Rol("","");
            persona.setIdPersona(null);
            persona.setName("Actualización NO Realizada, Identificador Inexistente");
            persona.setLastname(" ");
            persona.setEmail(" ");
            persona.setMobile(0L);
            persona.setRol(rolempty);
            return persona;
        }
    }


    public List<Persona> getAll(){
        return personaRepository.findAll();
    }

    public Persona get(Integer id){
        Persona persona = new Persona();
        Rol rolempty = new Rol("","");
        persona.setIdPersona(null);
        persona.setName("Consulta NO Realizada, Identificador Inexistente");
        persona.setLastname(" ");
        persona.setEmail(" ");
        persona.setMobile(0L);
        persona.setRol(rolempty);
        return personaRepository.findById(id).orElse(persona);
    }


    public Persona getByEmail(String sEmail){
        Persona persona = new Persona();
        Rol rolempty = new Rol("","");
        persona.setIdPersona(null);
        persona.setName("Consulta NO Realizada, Email Inexistente");
        persona.setLastname(" ");
        persona.setEmail(" ");
        persona.setMobile(0L);
        persona.setRol(rolempty);
        return findByEmail(sEmail).orElse(persona);
    }

        

    public Persona delete(Integer id){
        Optional<Persona> personaopt = findById(id);
        Persona persona = new Persona();
        if (personaopt.isPresent()){
            Rol rolempty = new Rol("","");
            personaRepository.deleteById(id);
            persona.setIdPersona(null);
            persona.setName("Eliminación Realizada");
            persona.setLastname(" ");
            persona.setEmail(" ");
            persona.setMobile(0L);
            persona.setRol(rolempty);
        }
        else {
            persona.setIdPersona(null);
            Rol rolempty = new Rol("","");
            personaRepository.deleteById(id);
            persona.setIdPersona(null);
            persona.setName("Eliminación No Realizada, Identificador no Existe");
            persona.setLastname(" ");
            persona.setEmail(" ");
            persona.setMobile(0L);
            persona.setRol(rolempty);
        }
        return persona;

    }
}
