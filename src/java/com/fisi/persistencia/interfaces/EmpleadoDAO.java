/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.persistencia.interfaces;

import com.fisi.bean.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface EmpleadoDAO {
    
     public boolean insertar(Empleado empleado) throws SQLException;
    
    public boolean actualizar(Empleado empleado)throws SQLException;
    
    public boolean eliminar(Empleado empleado) throws SQLException;
    
    public Empleado buscarXCodigo(long codigo)throws SQLException;
    
    public List<Empleado> buscarXApellidos(String nombre)throws SQLException;
}
