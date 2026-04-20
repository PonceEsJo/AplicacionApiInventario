/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiInventrio.ApiInventario.Service;

import com.ApiInventrio.ApiInventario.Entity.Categoria;
import com.ApiInventrio.ApiInventario.Repository.CategoriaRepository;
import com.ApiInventrio.ApiInventario.dto.request.CategoriaRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josep
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }
    
    public Categoria crear(CategoriaRequest request){
        Categoria categoria = Categoria.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
        return categoriaRepository.save(categoria);
    }
    
    public void eliminar(Long id){
        if(!categoriaRepository.existsById(id)){
            throw new RuntimeException("Categoria no existe");
        }
        categoriaRepository.deleteById(id);
    }
}
