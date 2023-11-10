package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activo);

    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto esta vacÃ­o
    // Se actualiza un producto si el id del producto NO esta vacÃ­o
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parÃ¡metro
    public void delete(Producto producto);

    //Lista de productos utilizando un método Query Busca el precio de todos los productos y  busca por dos valores
    public List<Producto> consultaQuery(double precioInf, double precioSup);
}
