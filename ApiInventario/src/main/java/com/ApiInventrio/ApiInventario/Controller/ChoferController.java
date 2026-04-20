/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Controller;

import com.ApiInventrio.ApiInventario.Service.ChoferService;
import com.ApiInventrio.ApiInventario.dto.request.ChoferRequest;
import com.ApiInventrio.ApiInventario.dto.response.ChoferResponse;
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
@Tag(name = "05 - Choferes")
@RestController
@RequestMapping("/api/choferes")
public class ChoferController {
    @Autowired
    private ChoferService choferService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<ChoferResponse>> listar(){
        return ResponseEntity.ok(choferService.listar());
    }
    
    @PostMapping("/crear")
    public ResponseEntity<ChoferResponse> crear(@RequestBody ChoferRequest request){
        return new ResponseEntity<>(choferService.crear(request),HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ChoferResponse> actualizar(@PathVariable Long id,@RequestBody ChoferRequest request){
        return ResponseEntity.ok(choferService.actualizar(id, request));
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        choferService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
