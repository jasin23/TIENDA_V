package com.tienda.service;

import org.springframework.web.multipart.MultipartFile;

//Interface que permite cargar imagenes 
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-v1-66518.appspot.com";

    //Esta es la ruta bÃ¡sica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //UbicaciÃ³n donde se encuentra el archivo de configuraciÃ³n Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json (firebase)
    final String archivoJsonFile = "techshop-v1-66518-firebase-adminsdk-fuzab-1a296aef7b.Json";
}