package com.uce.calculadoramvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDUsuario extends Conexion {

    private int tipo;

    // Registro
    public boolean registrar(Usuario usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into usuario (nombre, apellido, usuario, clave, rol) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getApellido());
            ps.setString(3, usr.getUsuario());
            ps.setString(4, usr.getClave());
            ps.setString(5, usr.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    // Log in
    public boolean iniciar_sesion(Usuario usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from usuario where usuario=? and clave=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getClave());
            rs = ps.executeQuery();
            // valida que haya x lo menos un resultado
            if (rs.next() == true) {

                //establece el id del usuario
                usr.setId(Integer.parseInt(rs.getString("id")));

                return true;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return false;
    }

    public int calcularPrecioFinal(Pedido p) {
        return p.getPrecio_unitario() * p.getCantidad();

    }

    /**
     * @return 1 para usuario de tipo ADMIN
     * @return 0 para usuario no ADMIN
     */
    public int consultarTipoUsuario(Usuario usuario) {
        System.out.println("q pasa?");
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from usuario where id=?";
        try {
            System.out.println("no cacho");
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
          // asigna 1 o 0 segun el tipo de usuario
            tipo = (rs.getString("rol").equalsIgnoreCase("ADMIN")) ? 1 : 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        
        return tipo;
    }
    // =========== METODO MODIFICAR
//    public boolean modificar (Pedido p){
//        PreparedStatement ps = null;
//        Connection con = getConexion();
//        String sql = "update producto set codigo=?, nombre=?, precio=? where id=?";
//        try{
//            ps = con.prepareStatement(sql);
//            ps.setString(1, p.getCodigo());
//            ps.setString(2, p.getNombre());
//            ps.setInt(3, p.getPrecio());
//            ps.setInt(4, p.getId());
//            ps.execute();
//            return true;
//        }catch(SQLException e){
//            System.err.println(e);
//            return false;
//        }
//    } //------------ FIN MODIFICAR 
//    
//            // =========== METODO ELIMINAR
//    public boolean eliminar (Pedido p){
//        PreparedStatement ps = null;
//        Connection con = getConexion();
//        String sql = "delete from producto where id=?";
//        try{
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, p.getId());
//            ps.execute();
//            return true;
//        }catch(SQLException e){
//            System.err.println(e);
//            return false;
//        }
//    } //------------ FIN eliminar 
//    
//    
//                // =========== METODO BUSCAR
//    public boolean buscar (Pedido p){
//        PreparedStatement ps = null;
//        Connection con = getConexion();
//        ResultSet rs = null;
//        String sql = "select * from producto where id=?";
//        try{
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, p.getId());
//            rs = ps.executeQuery();
//            if(rs.next()){
//                p.setId(Integer.parseInt(rs.getString("id"))); 
//                p.setCodigo(rs.getString("codigo"));
//                p.setNombre(rs.getString("nombre"));
//                p.setPrecio(Integer.parseInt(rs.getString("precio"))); 
//                return true;
//            }
//            return false;
//        }catch(SQLException e){
//            System.err.println(e);
//            return false;
//        }
//    } //------------ FIN BUSCAR 
}
