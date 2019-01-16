<%-- 
    Document   : empleado-listado
    Created on : 13-ene-2019, 22:15:55
    Author     : Alejandro
--%>

<%@page import="com.fisi.bean.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="com.fisi.persistencia.implementacion.EmpleadoDAOImpl"%>
<%@page import="com.fisi.persistencia.interfaces.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Empleados</title>
        <!--Import Google Icon Font-->
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
    </head>
    <body>
        <div class="section container">
            <%
            EmpleadoDAO empleadoDAO =  new EmpleadoDAOImpl();
            List<Empleado> empleados = empleadoDAO.buscarXApellidos("");
        %>
        <h2 class="center blue white-text">Listado de Empleados</h2>
        <table class="striped">
            <tr>
                <th>Código</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>DNI</th>
            </tr>
            <%
                for(Empleado empleado:empleados){%>
                <tr>
                    <td><%out.println(empleado.getCodigo());%></td>
                    <td><%out.println(empleado.getNombres());%></td>
                    <td><%out.println(empleado.getFechaNacimiento());%></td>
                    <td><%out.println(empleado.getDni());%></td>
                </tr>
            <%  }%>
            <tr>
                <th>  Total: <%=empleados.size()%></th>
            </tr>
        </table>
             
        </div>
        
    </body>
    <!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.js"></script>
</html>
