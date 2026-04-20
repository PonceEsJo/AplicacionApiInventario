/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Almacen;
import com.ApiInventrio.ApiInventario.Repository.AlmacenRepository;
import com.ApiInventrio.ApiInventario.dto.request.AlmacenRequest;
import com.ApiInventrio.ApiInventario.dto.response.AlmacenResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class AlmacenService {
    
    @Autowired
    private AlmacenRepository almacenRepository;
    
    public List<AlmacenResponse> listar(){
        return almacenRepository.findByEstadoTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public AlmacenResponse crear(AlmacenRequest request){
        Almacen almacen = Almacen.builder()
                .nombre(request.getNombre())
                .ciudad(request.getCiudad())
                .direccion(request.getDireccion())
                .estado(true)
                .fecha_creacion(LocalDateTime.now())
                .build();
        
        return mapToResponse(almacenRepository.save(almacen));
    }
    
    public AlmacenResponse actualizar(Long id, AlmacenRequest request){
        Almacen almacen = almacenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Almacen no encontrado"));
        
        almacen.setNombre(request.getNombre());
        
        return mapToResponse(almacenRepository.save(almacen));
    }
    
    public void eliminar(Long id){
        if(!almacenRepository.existsById(id)){
            throw new RuntimeException("Almacen no existente");
        }
        almacenRepository.deleteById(id);
    }
    
    
    private AlmacenResponse mapToResponse(Almacen almacen){
        return AlmacenResponse.builder()
                .id_almacen(almacen.getId())
                .nombre(almacen.getNombre())
                .ciudad(almacen.getCiudad())
                .direccion(almacen.getDireccion())
                .build();
    }
}
