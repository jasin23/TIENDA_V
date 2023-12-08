package com.tienda.dao;

import com.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username);

    //Buscamos un usuario por contraseña
    Usuario findByUsernameAndPassword(String username, String Password); 

    //Buscamos un usuario por correo
    Usuario findByUsernameOrCorreo(String username, String correo);

    //Si se registra, se busca si ya tiene ese correo y se notifica.  
    boolean existsByUsernameOrCorreo(String username, String correo);
}