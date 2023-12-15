package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author user
 */
@Data //Pone los set y get...
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id //Llave de la clase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    //private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;

    public Long getIdCategoria() {
        return categoria != null ? categoria.getIdCategoria() : null;
    }

    public void setIdCategoria(Long idCategoria) {
        if (categoria == null) {
            categoria = new Categoria();
        }
        categoria.setIdCategoria(idCategoria);
    }
}
