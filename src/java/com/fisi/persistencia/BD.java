/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alejandro
 */
public class BD {
    
    
    private static boolean cargarDriver(){
        String driver ="oracle.jdbc.OracleDriver";
        try {
            Class.forName(driver);
            System.out.println("Exito al cargar el driver ");
            return true;
        } catch (Exception e) {
            System.out.println("Error al cargar el driver "+e.getMessage());
            return false;
        }
    }
    
    public static Connection conectar(){
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "webproducto";
        String clave = "123456";
        
        if(!cargarDriver()){
            return null;
        }
        
        try {
            Connection cn = DriverManager.getConnection(URL,usuario,clave);
            System.out.println("Exito al conectar BD");
            return cn;
        } catch (Exception e) {
            System.out.println("Error al conectar BD"+e.getMessage());
            return null;
        }
        
    }
    
    
}
