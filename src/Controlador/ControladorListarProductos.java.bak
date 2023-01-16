package Controlador;

import Modelo.CRUDPedido;
import Modelo.Pedido;
import Vista.VListarProductos;
import Vista.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListarProductos implements ActionListener {

    private Pedido ped;
    private VListarProductos vListarProductos;
    private CRUDPedido proC;
    private VPrincipal vPrincipal;

    public ControladorListarProductos(Pedido pro, CRUDPedido proC, VPrincipal vPrincipal, VListarProductos vListarProductos) {
        this.ped = pro;
        this.proC = proC;
        this.vPrincipal = vPrincipal;
        this.vListarProductos = vListarProductos;
        this.vListarProductos.btn_volver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        //// boton agregar
//        if (e.getSource() == frmPro.btn_agregar) {
//            ped.setCodigo(frmPro.txt_codigo.getText());
//            ped.setDescripcion(frmPro.txt_descripcion.getText());
//            ped.setCantidad(Integer.parseInt(frmPro.txt_cantidad.getText()));
//            ped.setPrecio_unitario(Integer.parseInt(frmPro.txt_precio_unitario.getText()));
//            ped.setPrecio_final(Integer.parseInt(frmPro.txt_precio_final.getText()));
//            if (proC.registrar(ped)) {
//                JOptionPane.showMessageDialog(null, "Producto agregado");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al agregar");
//                limpiar();
//            }
//        }

        // boton volver
        if (e.getSource() == vListarProductos.btn_volver) {
            System.out.println("entra el btn volver");
            this.vPrincipal.setVisible(true);
            this.vListarProductos.dispose();
        }

//        // boton btn_listar
//        if (e.getSource() == frmPro.btn_listar) {
//
//            // oculta campos disponibles para admins
////            visibilidadCamposAdmin(false);
//        }
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
    }

//    private void visibilidadCamposAdmin(boolean boleano) {
//        frmPro.label_codigo.setVisible(boleano);
//        frmPro.txt_codigo.setVisible(boleano);
//
//        frmPro.label_descripcion.setVisible(boleano);
//        frmPro.txt_descripcion.setVisible(boleano);
//
//        frmPro.txt_precio_final.setVisible(boleano);
//        frmPro.label_precio_final.setVisible(boleano);
//
//        frmPro.label_precio_unitario.setVisible(boleano);
//        frmPro.txt_precio_unitario.setVisible(boleano);
//
//        frmPro.label_cantidad.setVisible(boleano);
//        frmPro.txt_cantidad.setVisible(boleano);
//
//        frmPro.btn_calcular_precio_final.setVisible(boleano);
//        frmPro.btn_agregar.setVisible(boleano);
//
//        frmPro.label_calcular_pedido.setVisible(boleano);
//
//    }//fin action
//
//    public void limpiar() {
//        frmPro.txt_codigo.setText(null);
//        frmPro.txt_id.setText(null);
//        frmPro.txt_descripcion.setText(null);
//        frmPro.txt_precio_unitario.setText(null);
//        frmPro.txt_cantidad.setText(null);
//        frmPro.txt_precio_final.setText(null);
//    }

}
