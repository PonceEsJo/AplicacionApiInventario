/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Rol;
import com.ApiInventrio.ApiInventario.Entity.Usuario;
import com.ApiInventrio.ApiInventario.Repository.RolRepository;
import com.ApiInventrio.ApiInventario.Repository.UsuarioRepository;
import com.ApiInventrio.ApiInventario.dto.request.UsuarioRequest;
import com.ApiInventrio.ApiInventario.dto.response.UsuarioResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public List<UsuarioResponse> listar(){
        return usuarioRepository.findByEstadoTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public UsuarioResponse crear(UsuarioRequest request){
        Rol rol = rolRepository.findById(request.getId_rol())
                .orElseThrow(()-> new RuntimeException("Rol no encontrado"));
        Usuario usuario = Usuario.builder()
                .nombres(request.getNombre())
                .apellidos(request.getApellido())
                .correo(request.getCorreo())
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .creacion(LocalDateTime.now())
                .estado(true)
                .rol(rol)
                .build();
        return mapToResponse(usuarioRepository.save(usuario));
    }
    
    public UsuarioResponse actualizar(UsuarioRequest request,Long id){
        Rol rol = rolRepository.findById(request.getId_rol())
                .orElseThrow(()-> new RuntimeException("Rol no encontrado"));
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        
        usuario.setNombres(request.getNombre());
        usuario.setApellidos(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setRol(rol);
        
        return mapToResponse(usuarioRepository.save(usuario));
    }
    
    public void eliminar(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no existe");
        }
        
        usuarioRepository.deleteById(id);
    }
    
    private UsuarioResponse mapToResponse(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombres())
                .apellido(usuario.getApellidos())
                .correo(usuario.getCorreo())
                .username(usuario.getUsername())
                .rol(usuario.getRol().getNombre())
                .build();
    }
}
