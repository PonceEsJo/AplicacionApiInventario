/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Usuario;
import com.ApiInventrio.ApiInventario.Repository.UsuarioRepository;
import com.ApiInventrio.ApiInventario.Security.JwtUtil;
import com.ApiInventrio.ApiInventario.dto.request.AuthRequest;
import com.ApiInventrio.ApiInventario.dto.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {

        

        Usuario user = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> 
                     new RuntimeException("Usuario no encontrado"));


        boolean match = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!match) {
            throw new RuntimeException("Credenciales invalidas");
        }

        String role = user.getRol() != null ? user.getRol().getNombre() : "SIN ROL";
     

        String accessToken = jwtUtil.generateToken(user.getUsername(),role);
        String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());
        return new AuthResponse(accessToken,refreshToken);
    }
    
    public AuthResponse refresh(String refreshToken){
        String username = jwtUtil.extractUsername(refreshToken);
        
        if(!jwtUtil.isRefreshToken(refreshToken)){
            throw new RuntimeException("Token invalido (no es refresh)");
        }
        
        if(!jwtUtil.isTokenValid(refreshToken, username)){
            throw new RuntimeException("Refresh token inválido o expirado");
        }
        
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Usuaro no encontrado"));
        
        String newAccessToken=jwtUtil.generateToken(usuario.getUsername(), usuario.getRol().getNombre());
        
        return new AuthResponse(newAccessToken,refreshToken);
        
    }
}
