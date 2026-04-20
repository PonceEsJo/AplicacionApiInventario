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
import jakarta.persistence.Table;
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
@Table(name = "choferes")
public class Chofer {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chofer")
    private Long id;
    
    private String nombre;
    
    @Column(nullable = false,unique = true)
    private String dni;
    private String licencia;
    private String telefono;
    private boolean estado;
}
