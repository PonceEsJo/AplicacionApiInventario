/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author josep
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoResponse {
    private Long id_vehiculo;
    private String placa;
    private String marca;
    private String modelo;
}
