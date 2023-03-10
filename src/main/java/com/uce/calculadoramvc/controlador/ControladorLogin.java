package com.uce.calculadoramvc.controlador;

import com.uce.calculadoramvc.modelo.CRUDListarPedidos;
import com.uce.calculadoramvc.modelo.CRUDPedido;
import com.uce.calculadoramvc.modelo.CRUDUsuario;
import com.uce.calculadoramvc.modelo.Pedido;
import com.uce.calculadoramvc.modelo.Usuario;
import com.uce.calculadoramvc.vista.VListarProductos;
import com.uce.calculadoramvc.vista.VLogin;
import com.uce.calculadoramvc.vista.VPrincipal;
import com.uce.calculadoramvc.vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {

    private Usuario usuario;
//    private VProducto frmPro;
    private CRUDPedido proC;
//    private CRUDUsuario usrCrud;
    private VLogin log;
    private CRUDUsuario crudUsuario;

    public ControladorLogin(VLogin login, Usuario usuario, CRUDUsuario crudUsuario) {
        this.log = login;
        this.usuario = usuario;
        this.crudUsuario = crudUsuario;
        this.log.btn_crear_user.addActionListener(this);
        this.log.btn_iniciar_sesion.addActionListener(this);

//        oculta los campos de crear usuario cuando es primera vez
        visibilidadCamposCrearUsuario(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //// boton crear usuario
        if (e.getSource() == log.btn_crear_user) {
            visibilidadCamposIniciarSesion(false);
            visibilidadCamposCrearUsuario(true);

            // mapear atributos para persistir en la BDD
            this.usuario.setNombre(log.txt_nombre_nuevo.getText());
            this.usuario.setApellido(log.txt_apellido_nuevo.getText());
            this.usuario.setUsuario(log.txt_usuario_nuevo.getText());
            this.usuario.setClave(log.txt_clave_nueva.getText());
            this.usuario.setRol(log.combo_rol_escoger.getSelectedItem().toString());
            if (log.txt_clave_nueva.getText().length() > 0) {
                JOptionPane.showMessageDialog(null, "Usuario  registrado");
                crudUsuario.registrar(usuario);
                limpiar();
            } else {
                if (log.txt_clave_nueva.getText().length() > 0) {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario");
                }
                limpiar();
            }
        }

        //// boton iniciar sesion
        if (e.getSource() == log.btn_iniciar_sesion) {
            visibilidadCamposCrearUsuario(false);
            visibilidadCamposIniciarSesion(true);

            this.usuario.setUsuario(log.txt_nombre.getText());
            this.usuario.setClave(log.txt_contrasenia.getText());
            //valida si hay texto en ambos campos
            if (log.txt_contrasenia.getText().length() > 0 && log.txt_nombre.getText().length() > 0) {

                if (crudUsuario.iniciar_sesion(usuario)) {
                    Pedido pro = new Pedido();

                    CRUDListarPedidos crudListaPedidos = new CRUDListarPedidos();
                    CRUDPedido proC = new CRUDPedido();

                    VProducto frmPro = new VProducto();
                    VPrincipal frmPri = new VPrincipal();
                    VListarProductos frmLstProd = new VListarProductos();

                    ControladorProducto ctrlPro = new ControladorProducto(pro, frmPro, proC, frmPri, usuario, crudUsuario);
                    ControladorListarProductos ctrlLstPro = new ControladorListarProductos(pro, crudListaPedidos, frmPri, frmLstProd);
                    ControladorPrincipal ctrlPri = new ControladorPrincipal(frmPri, frmPro, frmLstProd);

                    ctrlPri.inciar();
                    this.log.dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido " + this.usuario.getUsuario());
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                }
            }
//            if (proC.registrar(ped)) {
//                JOptionPane.showMessageDialog(null, "Producto agregado");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al agregar");
//                limpiar();
//            }
        }

        //// boton modificar
//        if(e.getSource()==frmPro.btn_modificar){
//            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
//            pro.setCodigo(frmPro.txt_codigo.getText());
//            pro.setNombre(frmPro.txt_nombre.getText());
//            pro.setPrecio(Integer.parseInt(frmPro.txt_precio.getText()));
//            if(proC.modificar(pro)){
//                JOptionPane.showMessageDialog(null, "Producto modificado");
//                limpiar();
//            }else{
//                JOptionPane.showMessageDialog(null, "Error al modificar");
//                limpiar();
//            }
//        } //------------------------ fin modificar
//        
        //// boton eliminar
//        if(e.getSource()==frmPro.btn_eliminar){
//            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
//            if(proC.eliminar(pro)){
//                JOptionPane.showMessageDialog(null, "Producto eliminado");
//                limpiar();
//            }else{
//                JOptionPane.showMessageDialog(null, "Error al eliminar");
//                limpiar();
//            }
//        } //------------------------ fin eliminar
//        
//                                //// boton buscar
//        if(e.getSource()==frmPro.btn_buscar){
//            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
//            if(proC.buscar(pro)){
//                frmPro.txt_id.setText(String.valueOf(pro.getId()));
//                frmPro.txt_codigo.setText(pro.getCodigo());
//                frmPro.txt_nombre.setText(pro.getNombre());
//                frmPro.txt_precio.setText(String.valueOf(pro.getPrecio()));
//
//            }else{
//                JOptionPane.showMessageDialog(null, "Error al buscar");
//                limpiar();
//            }
//        } //------------------------ fin buscar
//        
//        if(e.getSource()==frmPro.btn_limpiar){
//            limpiar();
//        }
//        
    }//fin action

    public void limpiar() {
        log.txt_nombre_nuevo.setText(null);
        log.txt_apellido_nuevo.setText(null);
        log.txt_usuario_nuevo.setText(null);
        log.txt_clave_nueva.setText(null);
        log.txt_nombre.setText(null);
        log.txt_contrasenia.setText(null);
    }

    private void visibilidadCamposCrearUsuario(boolean booleano) {
//        txt's
        this.log.txt_nombre_nuevo.setVisible(booleano);
        this.log.txt_apellido_nuevo.setVisible(booleano);
        this.log.txt_usuario_nuevo.setVisible(booleano);
        this.log.txt_clave_nueva.setVisible(booleano);
        this.log.combo_rol_escoger.setVisible(booleano);

//        labels
        this.log.label_nombre_nuevo.setVisible(booleano);
        this.log.label_apellido_nuevo.setVisible(booleano);
        this.log.label_usuario_nuevo.setVisible(booleano);
        this.log.label_clave_nueva.setVisible(booleano);
        this.log.label_rol_nuevo.setVisible(booleano);
    }

    private void visibilidadCamposIniciarSesion(boolean booleano) {
//        txt's
        this.log.txt_nombre.setVisible(booleano);
        this.log.txt_contrasenia.setVisible(booleano);

//        labels
        this.log.label_usuario.setVisible(booleano);
        this.log.label_contrasenia.setVisible(booleano);
    }
}
