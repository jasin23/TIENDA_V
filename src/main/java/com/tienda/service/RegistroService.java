package com.tienda.service;

import com.tienda.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    //Para activar un usuario
    public Model activar(Model model, String usuario, String clave);

    //Para crear correctamente el usuario
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;

    //Imagen del usuario
    public void activar(Usuario usuario, MultipartFile imagenFile);

    //Recuerda la contraseña 
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}