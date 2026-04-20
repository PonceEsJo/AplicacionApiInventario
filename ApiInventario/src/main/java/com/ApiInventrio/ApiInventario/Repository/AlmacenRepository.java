/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Repository;

import com.ApiInventrio.ApiInventario.Entity.Almacen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josep
 */
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{
    List<Almacen> findByEstadoTrue();
}
