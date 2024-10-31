package com.framework.backend.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.framework.backend.Entities.Persona;
import com.framework.backend.Services.PersonaService;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public Persona get(@PathVariable("id") String sid) {
        Integer id;
        Persona personaresp;
        try{
            id = Integer.valueOf(sid);
            personaresp = personaService.get(id);

        }
        catch (NumberFormatException nException){
            personaresp = new Persona();
            personaresp.setName("Identificador debe ser un Número");
        }
        return personaresp;
    }

    @GetMapping("/email/{email}")
    public Persona getbyEmail(@PathVariable("email") String semail) {
        Persona personaresp;
        personaresp = personaService.getByEmail(semail);
        return personaresp;
    }    
    

    @GetMapping("/all")
    public List<Persona> getAll(){
        return personaService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Persona save(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Persona updateByObject(@RequestBody Persona persona){
        return personaService.updateByObject(persona);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona updateById(@PathVariable("id") String sid, @RequestBody Persona persona){
        Integer id;
        Persona personaresp;
        try{
            id = Integer.valueOf(sid);
            personaresp = personaService.updateById(id, persona);
        }
        catch (NumberFormatException nException){
            personaresp = new Persona();
            personaresp.setName("Identificador debe ser un Número");
        }
        return personaresp;
    }

    @DeleteMapping("{id}")
    public Persona delete(@PathVariable("id")String sid){
        Integer id;
        Persona personaresp;
        try{
            id = Integer.valueOf(sid);
            personaresp = personaService.delete(id);
        }
        catch (NumberFormatException nException){
            personaresp = new Persona();
            personaresp.setName("Identificador debe ser un Número");
        }
        return personaresp;
    }

}
