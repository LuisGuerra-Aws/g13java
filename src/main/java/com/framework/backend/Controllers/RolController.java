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

import com.framework.backend.Entities.Rol;
import com.framework.backend.Services.RolService;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/{id}")
    public Rol get(@PathVariable("id") String sid) {
        Integer id;
        Rol rolresp;
        try{
            id = Integer.valueOf(sid);
            rolresp = rolService.get(id);

        }
        catch (NumberFormatException nException){
            rolresp = new Rol();
            rolresp.setDescription("Identificador debe ser un Número");
        }
        return rolresp;
    }

    @GetMapping("/all")
    public List<Rol> getAll(){
        return rolService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rol save(@RequestBody Rol rol){
        return rolService.save(rol);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rol updateByObject(@RequestBody Rol rol){
        return rolService.updateByObject(rol);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol updateById(@PathVariable("id") String sid, @RequestBody Rol rol){
        Integer id;
        Rol rolresp;
        try{
            id = Integer.valueOf(sid);
            rolresp = rolService.updateById(id, rol);
        }
        catch (NumberFormatException nException){
            rolresp = new Rol();
            rolresp.setDescription("Identificador debe ser un Número");
        }
        return rolresp;
    }

    @DeleteMapping("{id}")
    public Rol delete(@PathVariable("id")String sid){
        Integer id;
        Rol rolresp;
        try{
            id = Integer.valueOf(sid);
            rolresp = rolService.delete(id);
        }
        catch (NumberFormatException nException){
            rolresp = new Rol();
            rolresp.setDescription("Identificador debe ser un Número");
        }
        return rolresp;
    }

}
