/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Config;

import com.ApiInventrio.ApiInventario.Entity.Rol;
import com.ApiInventrio.ApiInventario.Entity.Usuario;
import com.ApiInventrio.ApiInventario.Repository.RolRepository;
import com.ApiInventrio.ApiInventario.Repository.UsuarioRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author josep
 */
@Configuration
public class DataInitializer implements CommandLineRunner{
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(rolRepository.count() == 0) {
            Rol admin = new Rol(null,"ADMIN","Privilegios Completos");
            Rol operador = new Rol(null, "OPERADOR", "Privilegios Limitados");
            
            rolRepository.save(admin);
            rolRepository.save(operador);
        }
        
        if(usuarioRepository.findByUsername("admin").isEmpty()){
            Rol rolAdmin = rolRepository.findByNombre("ADMIN").get();
            
            Usuario usuario = Usuario.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .estado(true)
                    .correo("admin@admin.com")
                    .apellidos("admin")
                    .creacion(LocalDateTime.now())
                    .rol(rolAdmin)
                    .nombres("admin")
                    .build();
            
            usuarioRepository.save(usuario);
        }
    }
    
    
}
