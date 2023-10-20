
package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaterigoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao CategoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activo) {
       var categorias = CategoriaDao.findAll();
       
       return categorias;
    }
    
}