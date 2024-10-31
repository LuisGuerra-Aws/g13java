package com.framework.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.backend.Entities.Rol;
import com.framework.backend.Repositories.RolRepository;
//import com.framework.backend.ValueObjects.ResponseProcess;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
//    private ResponseProcess responseProcess;

    public Rol save(Rol rol){
        if ((rol.getDescription() != null) &&  (rol.getName() != null) )
            return rolRepository.save(rol);
        else {
            rol.setIdRol(null);
            rol.setName("Inserción NO Realizada, datos Obligatorios con Nulo");
            rol.setDescription("Inserción NO Realizada, datos Obligatorios con Nulo");
            return rol;
        }
    }

    private Optional<Rol> findById(Integer id){
        return rolRepository.findById(id);
    }

    public Rol updateByObject(Rol rol){
        Optional<Rol> rolopt = findById(rol.getIdRol());
//        ResponseProcess responseProcess = new ResponseProcess();
        if (rolopt.isPresent()){
            Rol rolUpdate = rolopt.get();

            if (rol.getDescription() != null)
                rolUpdate.setDescription(rol.getDescription());

            if (rol.getName() != null)
                rolUpdate.setName(rol.getName());

            return rolRepository.save(rolUpdate);
//            responseProcess.setCodeResponse(0);
//            responseProcess.setMessageResponse("Actualización Realizada");   
        }
        else {
            rol.setIdRol(null);
            rol.setName("Actualización NO Realizada, Identificador Inexistente");
            rol.setDescription("Actualización NO Realizada, Identificador Inexistente");
            return rol;
//            responseProcess.setCodeResponse(1);
//            responseProcess.setMessageResponse("Actualización NO Realizada, Identificador Inexistente");   
        }
    }

    public Rol updateById(Integer id, Rol rol){
        Optional<Rol> rolopt = findById(id);
//        ResponseProcess responseProcess = new ResponseProcess();
        if (rolopt.isPresent()){
            Rol rolUpdate = rolopt.get();

            if (rol.getDescription() != null)
                rolUpdate.setDescription(rol.getDescription());

            if (rol.getName() != null)
                rolUpdate.setName(rol.getName());

            return rolRepository.save(rolUpdate);
//            responseProcess.setCodeResponse(0);
//            responseProcess.setMessageResponse("Actualización Realizada");   
        }
        else {
            rol.setIdRol(null);
            rol.setName("Actualización NO Realizada, Identificador Inexistente");
            rol.setDescription("Actualización NO Realizada, Identificador Inexistente");
            return rol;
//            responseProcess.setCodeResponse(1);
//            responseProcess.setMessageResponse("Actualización NO Realizada, Identificador Inexistente");   
        }
    }


    public List<Rol> getAll(){
        return rolRepository.findAll();
    }

    public Rol get(Integer id){
        Rol rol = new Rol();
        rol.setIdRol(null);
        rol.setName("Consulta NO Realizada, Identificador Inexistente");
        rol.setDescription("Consulta NO Realizada, Identificador Inexistente");

        return rolRepository.findById(id).orElse(rol);
    }

    public Rol delete(Integer id){
        Optional<Rol> rolopt = findById(id);
        Rol rol = new Rol();
        if (rolopt.isPresent()){
            rolRepository.deleteById(id);
            rol.setIdRol(null);
            rol.setName("Eliminación Realizada");
            rol.setDescription("Eliminación Realizada");
        }
        else {
            rol.setIdRol(null);
            rol.setName("Eliminación NO Realizada, Identificador Inexistente");
            rol.setDescription("Eliminación NO Realizada, Identificador Inexistente");
        }
        return rol;

    }
}
