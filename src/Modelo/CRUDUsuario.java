package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDUsuario extends Conexion {

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
