package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //Pone los set y get...
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //Llave de la clase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto; 

    //Se puso en orden segun la base de datos
    //private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private Boolean activo;

    @ManyToOne //Ya que se pone esto, se quita el "private Long idCategoria;"
    @JoinColumn(name="id_categoria")
     Categoria categoria;
}
