/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Categoria;
import com.ApiInventrio.ApiInventario.Entity.Producto;
import com.ApiInventrio.ApiInventario.Repository.CategoriaRepository;
import com.ApiInventrio.ApiInventario.Repository.ProductoRepository;
import com.ApiInventrio.ApiInventario.dto.request.ProductoRequest;
import com.ApiInventrio.ApiInventario.dto.response.ProductoResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<ProductoResponse> listar(){
        return productoRepository.findByEstadoTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public ProductoResponse crear(ProductoRequest request){
        Categoria categoria = categoriaRepository.findById(request.getId_categoria())
                .orElseThrow(()->new RuntimeException("Categoria no encontrada"));
        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .estado(true)
                .fecha_creacion(LocalDateTime.now())
                .categoria(categoria)
                .build();
       
       return mapToResponse(productoRepository.save(producto));
    }
    
    public ProductoResponse actualizar(Long id,ProductoRequest request){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        Categoria categoria = categoriaRepository.findById(request.getId_categoria())
                .orElseThrow(()->new RuntimeException("Categoria no encontrada"));
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setCategoria(categoria);
        
        return mapToResponse(productoRepository.save(producto));
    }
    
    public void eliminar(Long id){
        if(!productoRepository.existsById(id)){
            throw new RuntimeException("El producto no existe");
        }
        productoRepository.deleteById(id);
    }
    
    private ProductoResponse mapToResponse(Producto producto){
        return ProductoResponse.builder()
               .id_producto(producto.getId())
               .nombre(producto.getNombre())
               .descripcion(producto.getDescripcion())
               .categoria(producto.getCategoria().getNombre())
               .build();
    }
}
