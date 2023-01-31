package com.uce.calculadoramvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDListarPedidos extends Conexion {

    // =========== METODO REGISTRAR
//    public boolean registrar(Pedido p) {
//        PreparedStatement ps = null;
//        Connection con = getConexion();
//        String sql = "insert into pedido (codigo, cantidad, descripcion, precio_unitario, precio_final) values (?,?,?,?,?)";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, p.getCodigo());
//            ps.setInt(2, p.getCantidad());
//            ps.setString(3, p.getDescripcion());
//            ps.setInt(4, p.getPrecio_unitario());
//            ps.setInt(5, p.getPrecio_final());
//            ps.execute();
//            return true;
//        } catch (SQLException e) {
//            System.err.println(e);
//            return false;
//        }
//    } //------------ FIN REGISTRAR 
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
    public List<Pedido> buscar() {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "select * from pedido";
        try {
            ps = con.prepareStatement(sql);
//            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
//            if (rs.next()) {
            while (rs.next()) {
                Pedido p = new Pedido();
//                u.setId_usuario(resultSet.getInt(1));
//                u.setNome(resultSet.getString(2));
//                u.setEmail(resultSet.getString(3));
//                u.setSenha(resultSet.getString(4));
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setCodigo(rs.getString("codigo"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio_unitario(Integer.parseInt(rs.getString("precio_unitario")));
                p.setPrecio_final(Integer.parseInt(rs.getString("precio_final")));

                listaPedidos.add(p);


            }
            return listaPedidos;
//                p.setId(Integer.parseInt(rs.getString("id")));
//                p.setCodigo(rs.getString("codigo"));
//                p.setCantidad(rs.getInt("cantidad"));
//                p.setDescripcion(rs.getString("descripcion"));
//                p.setPrecio_unitario(Integer.parseInt(rs.getString("precio_unitario")));
//                p.setPrecio_final(Integer.parseInt(rs.getString("precio_final")));

//            }
//            return null;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    } //------------ FIN BUSCAR 
}
