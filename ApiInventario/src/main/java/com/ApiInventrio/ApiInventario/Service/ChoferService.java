/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Chofer;
import com.ApiInventrio.ApiInventario.Repository.ChoferRepository;
import com.ApiInventrio.ApiInventario.dto.request.ChoferRequest;
import com.ApiInventrio.ApiInventario.dto.response.ChoferResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class ChoferService {
    @Autowired
    private ChoferRepository choferRepository;
    
    public List<ChoferResponse> listar(){
        return choferRepository.findByEstadoTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public ChoferResponse crear(ChoferRequest request){
        Chofer chofer = Chofer.builder()
                .nombre(request.getNombre())
                .dni(request.getDni())
                .licencia(request.getLicencia())
                .telefono(request.getTelefono())
                .estado(true)
                .build();
        
        return mapToResponse(choferRepository.save(chofer));
    }
    
    public ChoferResponse actualizar(Long id,ChoferRequest request){
        Chofer chofer = choferRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Chofer no encontrado"));
        chofer.setNombre(request.getNombre());
        chofer.setLicencia(request.getLicencia());
        chofer.setTelefono(request.getTelefono());
        
        return mapToResponse(choferRepository.save(chofer));
    }
    
    public void eliminar(Long id){
        if(!choferRepository.existsById(id)){
            throw new RuntimeException("Chofer no existe");
        }
        
        choferRepository.deleteById(id);
    }
    
    private ChoferResponse mapToResponse(Chofer chofer){
        return ChoferResponse.builder()
                .id_chofer(chofer.getId())
                .nombre(chofer.getNombre())
                .dni(chofer.getDni())
                .licencia(chofer.getLicencia())
                .telefono(chofer.getTelefono())
                .build();
    }
    
}
