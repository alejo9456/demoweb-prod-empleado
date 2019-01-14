/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.bean;

import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Empleado {
    
    private long codigo;
    private String apellidos;
    private String nombres;
    private String dni;
    private Date fechaNacimiento;

    public Empleado() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
    
}
