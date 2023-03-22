package com.examplemarket.persistence;

import com.examplemarket.persistence.crud.ProductoCrudRepository;
import com.examplemarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Se le indica a Spring que esta clase interactúa con la DB
@Repository
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

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    // guardar un producto del API
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
