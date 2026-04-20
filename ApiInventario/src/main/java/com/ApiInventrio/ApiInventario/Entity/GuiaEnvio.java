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
@Table(name = "guiasEnvios")
public class GuiaEnvio {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia_envio")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_envia")
    private Usuario usuarioEnvia;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_recibe")
    private Usuario usuarioRecibe;
    
    @ManyToOne
    @JoinColumn(name = "id_almacen_origen")
    private Almacen almacenOrigen;
    
    @ManyToOne
    @JoinColumn(name = "id_almacen_destino")
    private Almacen almacenDestino;
    
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id_chofer")
    private Chofer chofer;
    
    private LocalDateTime fechaEnvio;
    private LocalDateTime fechaRecibo;
    
    private String estado;
    private String observacion;
}
