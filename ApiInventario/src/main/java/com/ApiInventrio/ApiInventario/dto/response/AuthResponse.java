/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author josep
 */
@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String refreshToken;
}
