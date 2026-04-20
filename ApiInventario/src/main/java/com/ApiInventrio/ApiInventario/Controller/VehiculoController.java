/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Controller;

import com.ApiInventrio.ApiInventario.Service.VehiculoService;
import com.ApiInventrio.ApiInventario.dto.response.VehiculoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josep
 */
@Tag(name = "06 - Vehiculos")
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    
    @GetMapping("/vehiculos")
    public ResponseEntity<List<VehiculoResponse>> listar(){
        return ResponseEntity.ok(vehiculoService.listar());
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        vehiculoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
