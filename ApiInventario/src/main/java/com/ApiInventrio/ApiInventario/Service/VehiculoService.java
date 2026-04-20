/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Vehiculo;
import com.ApiInventrio.ApiInventario.Repository.VehiculoRepository;
import com.ApiInventrio.ApiInventario.dto.request.VehiculoRequest;
import com.ApiInventrio.ApiInventario.dto.response.VehiculoResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    public List<VehiculoResponse> listar(){
        return vehiculoRepository.findByEstadoTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public VehiculoResponse crear(VehiculoRequest request){
        Vehiculo vehiculo = Vehiculo.builder()
                .marca(request.getMarca())
                .modelo(request.getModelo())
                .placa(request.getPlaca())
                .build();
        
        return mapToResponse(vehiculoRepository.save(vehiculo));
    }
    
    public void eliminar(Long id){
        if(!vehiculoRepository.existsById(id)){
            throw new RuntimeException("Vehiculo no existente");
        }
        
        vehiculoRepository.deleteById(id);
        
    }
    
    private VehiculoResponse mapToResponse(Vehiculo vehiculo){
        return VehiculoResponse.builder()
                .id_vehiculo(vehiculo.getId())
                .marca(vehiculo.getMarca())
                .modelo(vehiculo.getModelo())
                .placa(vehiculo.getPlaca())
                .build();
    }
}
