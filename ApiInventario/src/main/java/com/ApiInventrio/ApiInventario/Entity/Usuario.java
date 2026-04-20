/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author josep
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    
    //Si normalizamos tendremos que separar con 1° nombre y 2° nombre
    private String nombres;
    //Si normalizamos tendremos que separar con apellido materno y apellido paterno
    private String apellidos;
    
    //Agregaremos la notacion para que sea unico
    @Column(nullable = false,unique = true)
    private String correo;
    
    private boolean estado;
    
    private LocalDateTime creacion;
            
    @Column(nullable = false,unique = true)
    private String username;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
