/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Rol;
import com.ApiInventrio.ApiInventario.Repository.RolRepository;
import com.ApiInventrio.ApiInventario.dto.request.RolRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    
    public List<Rol> listar(){
        return rolRepository.findAll();
    }
    
    public Rol crear(RolRequest request){
        Rol rol = Rol.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
        
        return rolRepository.save(rol);
    }
    
    public void eliminar(Long id){
        if(!rolRepository.existsById(id)){
            throw new RuntimeException("Rol no existente");
        }
        
        rolRepository.deleteById(id);
        
    }
}
