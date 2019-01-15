/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.persistencia.implementacion;

import com.fisi.bean.Empleado;
import com.fisi.persistencia.BD;
import com.fisi.persistencia.interfaces.EmpleadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class EmpleadoDAOImpl implements EmpleadoDAO{

    @Override
    public boolean insertar(Empleado empleado) throws SQLException {
        try {
            Connection cn = BD.conectar();

            String sqlCodigo = "SELECT MAX(CODIGO) AS CODIGO FROM EMPLEADO";

            PreparedStatement ps = cn.prepareStatement(sqlCodigo);

            ResultSet rs = ps.executeQuery();
            int codActual = 0;
            if (rs.next()) {
                codActual = rs.getInt("CODIGO");
            }
            codActual++;

            String sql = "INSERT INTO EMPLEADO(CODIGO,APELLIDOS,NOMBRES,DNI,FECHA_NACIMIENTO) "
                    + "VALUES (?,?,?,?,?)";
            ps = cn.prepareStatement(sql);

            empleado.setCodigo(codActual);

            ps.setLong(1, empleado.getCodigo());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getNombres());
            ps.setString(4, empleado.getDni());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            ps.setString(5, sdf.format(empleado.getFechaNacimiento()));

            ps.executeUpdate();

            cn.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    @Override
    public boolean actualizar(Empleado empleado) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "update empleado set apellidos=?,nombres=?,"
                    + "dni=?, fecha_nacimiento=? where codigo=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, empleado.getApellidos());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getDni());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ps.setString(4, sdf.format(empleado.getFechaNacimiento()));

            ps.setLong(5, empleado.getCodigo());

            ps.executeUpdate();

            cn.close();

            return true;
        } catch (Exception e) {
            throw new SQLException(e);
        }

    }

    @Override
    public boolean eliminar(Empleado empleado) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "delete from empleado where codigo=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setLong(1, empleado.getCodigo());

            ps.executeUpdate();

            cn.close();

            return true;

        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Empleado buscarXCodigo(long codigo) throws SQLException {
        try {

            Connection cn = BD.conectar();

            String sql = "select CODIGO,APELLIDOS,NOMBRES,DNI,FECHA_NACIMIENTO from EMPLEADO"
                    + " where CODIGO =?";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigo(rs.getLong("CODIGO"));
                empleado.setApellidos(rs.getString("APELLIDOS"));
                empleado.setNombres(rs.getString("NOMBRES"));
                empleado.setDni(rs.getString("DNI"));
                empleado.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                return empleado;
            }
            cn.close();
            return null;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<Empleado> buscarXApellidos(String apellidos) throws SQLException {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {

            Connection cn = BD.conectar();

            String sql = "select CODIGO,APELLIDOS,NOMBRES,DNI,FECHA_NACIMIENTO from EMPLEADO"
                    + " where APELLIDOS like ?";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + apellidos + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigo(rs.getLong("CODIGO"));
                empleado.setApellidos(rs.getString("APELLIDOS"));
                empleado.setNombres(rs.getString("NOMBRES"));
                empleado.setDni(rs.getString("DNI"));
                empleado.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                empleados.add(empleado);
            }
            cn.close();
            return empleados;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    
}
