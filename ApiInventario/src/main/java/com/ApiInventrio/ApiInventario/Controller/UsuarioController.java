/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Controller;

import com.ApiInventrio.ApiInventario.Service.UsuarioService;
import com.ApiInventrio.ApiInventario.dto.request.UsuarioRequest;
import com.ApiInventrio.ApiInventario.dto.response.UsuarioResponse;
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
@Tag(name = "02 - Usuarios")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponse>> listar(){
        return ResponseEntity.ok(usuarioService.listar());
    }
    
    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request){
        return new ResponseEntity<>(usuarioService.crear(request),HttpStatus.CREATED); 
    }
    
    @PutMapping("/actualiza/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id,@RequestBody UsuarioRequest request){
        return ResponseEntity.ok(usuarioService.actualizar(request, id));
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
}
