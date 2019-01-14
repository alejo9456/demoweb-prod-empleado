/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.persistencia.interfaces;

import com.fisi.bean.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface ProductoDAO {
    
    public boolean insertar(Producto producto) throws SQLException;
    
    public boolean actualizar(Producto producto) throws SQLException;
    
    public boolean eliminar(Producto producto) throws SQLException;
    
    public Producto buscarXCodigo(long codigo)throws SQLException;
    
    public List<Producto> buscarXNombre(String nombre)throws SQLException;
}
