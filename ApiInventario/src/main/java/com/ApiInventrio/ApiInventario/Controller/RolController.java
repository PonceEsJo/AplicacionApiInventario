/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Controller;

import com.ApiInventrio.ApiInventario.Entity.Rol;
import com.ApiInventrio.ApiInventario.Service.RolService;
import com.ApiInventrio.ApiInventario.dto.request.RolRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josep
 */
@Tag(name = "08 - Roles")
@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listar(){
        return ResponseEntity.ok(rolService.listar());
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Rol> crear(@RequestBody RolRequest requets){
        return new ResponseEntity<>(rolService.crear(requets),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
