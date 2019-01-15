/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.persistencia.implementacion;

import com.fisi.bean.Producto;
import com.fisi.persistencia.BD;
import com.fisi.persistencia.interfaces.ProductoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ProductoDAOImpl implements ProductoDAO{
    
    @Override
    public boolean insertar(Producto producto) throws SQLException {
        try {
            Connection cn = BD.conectar();

            String sqlCodigo = "SELECT MAX(CODIGO) AS CODIGO FROM PRODUCTO";

            PreparedStatement ps = cn.prepareStatement(sqlCodigo);

            ResultSet rs = ps.executeQuery();
            int codActual = 0;
            if (rs.next()) {
                codActual = rs.getInt("CODIGO");
            }
            codActual++;

            String sql = "INSERT INTO PRODUCTO(CODIGO,NOMBRE,PRECIO,STOCK,ESTADO) "+"VALUES (?,?,?,?,?)";
            ps = cn.prepareStatement(sql);

            producto.setCodigo(codActual);

            ps.setLong(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, "1");

            ps.executeUpdate();

            cn.close();

            return true;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public boolean actualizar(Producto producto) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "update producto set nombre=?,"
                    + "precio=?, stock=? where codigo=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setLong(4, producto.getCodigo());

            ps.executeUpdate();

            cn.close();

            return true;
        } catch (Exception e) {
            throw new SQLException(e);
        }

    }

    @Override
    public boolean eliminar(Producto producto) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "delete from producto where codigo=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setLong(1, producto.getCodigo());

            ps.executeUpdate();

            cn.close();

            return true;

        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Producto buscarXCodigo(long codigo) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "select CODIGO,NOMBRE,PRECIO,STOCK from PRODUCTO"
                    + " where CODIGO =?";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("CODIGO"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setStock(rs.getInt("STOCK"));
                return producto;
            }
            cn.close();
            return null;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<Producto> buscarXNombre(String nombre) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try {

            Connection cn = BD.conectar();

            String sql = "select CODIGO,NOMBRE,PRECIO,STOCK from PRODUCTO"+" where NOMBRE like ?";
            PreparedStatement ps = cn.prepareStatement(sql);            
            ps.setString(1,"%"+nombre+"%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("CODIGO"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setStock(rs.getInt("STOCK"));
                productos.add(producto);
            }
            cn.close();
            return productos;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
