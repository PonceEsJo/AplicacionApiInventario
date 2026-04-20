/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Repository;

import com.ApiInventrio.ApiInventario.Entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josep
 */

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByEstadoTrue();
}
