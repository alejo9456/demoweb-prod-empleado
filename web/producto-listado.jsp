<%-- 
    Document   : producto-listado
    Created on : 13-ene-2019, 22:15:42
    Author     : Alejandro
--%>

<%@page import="com.fisi.bean.Producto"%>
<%@page import="java.util.List"%>
<%@page import="com.fisi.persistencia.implementacion.ProductoDAOImpl"%>
<%@page import="com.fisi.persistencia.interfaces.ProductoDAO"%>
<%@page import="com.fisi.persistencia.interfaces.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
        <!--Import Google Icon Font-->
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
    </head>
    <body>
              <%
            ProductoDAO productoDAO =  new ProductoDAOImpl();
            List<Producto> productos = productoDAO.buscarXNombre("");
        %>
        <h3>Listado de Productos</h3>
        <table>
            <tr>
                <th>Código</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>DNI</th>
            </tr>
            <%
                for(Producto producto:productos){%>
                <tr>
                    <td><%out.println(producto.getCodigo());%></td>
                    <td><%out.println(producto.getNombre());%></td>
                    <td><%out.println(producto.getPrecio());%></td>
                    <td><%out.println(producto.getStock());%></td>
                </tr>
            <%  }%>
            <tr>
                <th>  Total: <%=productos.size()%></th>
            </tr>
        </table>  
    </body>
        <!--JavaScript at end of body for optimized loading-->
     <script type="text/javascript" src="js/materialize.js"></script>
</html>
