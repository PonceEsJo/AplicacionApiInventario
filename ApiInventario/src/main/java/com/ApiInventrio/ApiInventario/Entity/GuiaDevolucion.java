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
@Table(name = "GuiaDevolucion")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuiaDevolucion {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia_devolucion")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_guia_envio")
    private GuiaEnvio guiaEnvio;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_envio")
    private Usuario usuarioEnvio;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_recibo")
    private Usuario usurioRecibo;
    
    @ManyToOne
    @JoinColumn(name = "id_almacen_origen")
    private Almacen almacenOrigen;
    
    @ManyToOne
    @JoinColumn(name = "id_almacen_destino")
    private Almacen almacenDestino;
    
    private LocalDateTime fecha;
    private String motivoGeneral;
    private String estado;
}
