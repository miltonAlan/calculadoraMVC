package com.uce.calculadoramvc.controlador;

import com.uce.calculadoramvc.modelo.CRUDListarPedidos;
import com.uce.calculadoramvc.modelo.Pedido;
import com.uce.calculadoramvc.vista.VListarProductos;
import com.uce.calculadoramvc.vista.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorListarProductos implements ActionListener {

    private Pedido ped;
    private VListarProductos vListarProductos;
    private CRUDListarPedidos crudListarPedidos;
    private VPrincipal vPrincipal;

    public ControladorListarProductos(Pedido pro, CRUDListarPedidos crudListarPedidos, VPrincipal vPrincipal, VListarProductos vListarProductos) {
        this.ped = pro;
        this.crudListarPedidos = crudListarPedidos;
        this.vPrincipal = vPrincipal;
        this.vListarProductos = vListarProductos;
        this.vListarProductos.btn_listar_pedidos.addActionListener(this);
        this.vListarProductos.btn_volver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //// boton listar
        if (e.getSource() == vListarProductos.btn_listar_pedidos) {
            List<Pedido> listaPedidos = crudListarPedidos.buscar();
            String col[] = {"CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO UNITARIO", "PRECIO FINAL"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            vListarProductos.table_lista_productos.setModel(tableModel);
            if (listaPedidos != null) {
                for (Pedido pedido : listaPedidos) {
                    Object[] objs = {pedido.getCodigo(), pedido.getDescripcion(), pedido.getCantidad(), pedido.getPrecio_unitario(), pedido.getPrecio_final()};
                    tableModel.addRow(objs);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al consultar, consulte con el administrador");
            }
        }

        // boton volver
        if (e.getSource() == vListarProductos.btn_volver) {
            System.out.println("entra el btn volver");
            this.vPrincipal.setVisible(true);
            this.vListarProductos.dispose();
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
