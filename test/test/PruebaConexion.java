/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fisi.persistencia.BD;
import java.sql.Connection;

/**
 *
 * @author Alejandro
 */
public class PruebaConexion {
    
    public static void main(String[] args) {
        try {
            Connection cn = BD.conectar();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
}
