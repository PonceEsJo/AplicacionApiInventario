/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author josep
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder endoce =new BCryptPasswordEncoder();
        System.out.println(endoce.encode("123456"));
    }
}
