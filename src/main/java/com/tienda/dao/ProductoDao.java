package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao
        extends JpaRepository<Producto, Long> {

    //Lista de productos utilizando un método Query Busca el precio de todos los productos y  busca por dos valores
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
