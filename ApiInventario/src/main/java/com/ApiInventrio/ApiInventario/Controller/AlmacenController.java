/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Controller;

import com.ApiInventrio.ApiInventario.Service.AlmacenService;
import com.ApiInventrio.ApiInventario.dto.request.AlmacenRequest;
import com.ApiInventrio.ApiInventario.dto.response.AlmacenResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josep
 */
@Tag(name = "07 - Almacenes")
@RestController
@RequestMapping("/api/alamacenes")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<AlmacenResponse>> listar(){
        return ResponseEntity.ok(almacenService.listar());
    }
    
    @PostMapping("/crear")
    public ResponseEntity<AlmacenResponse> crear(@RequestBody AlmacenRequest request){
        return new ResponseEntity<>(almacenService.crear(request),HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AlmacenResponse> actualizar(@PathVariable Long id,@RequestBody AlmacenRequest request){
        return ResponseEntity.ok(almacenService.actualizar(id, request));
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        almacenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
