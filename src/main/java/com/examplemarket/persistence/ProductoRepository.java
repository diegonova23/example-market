package com.examplemarket.persistence;

import com.examplemarket.persistence.crud.ProductoCrudRepository;
import com.examplemarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    // recuperar todos los productos de la DB
    public List<Producto> getAll() {
        // se debe hacer cast para volverlo una lista
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
