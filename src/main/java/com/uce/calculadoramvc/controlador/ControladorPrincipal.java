package com.uce.calculadoramvc.controlador;

import com.uce.calculadoramvc.vista.VListarProductos;
import com.uce.calculadoramvc.vista.VPrincipal;
import com.uce.calculadoramvc.vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {

    private VPrincipal frmPri;
    private VProducto frmPro;
    private VListarProductos frmListar;

    public ControladorPrincipal(VPrincipal frmPri, VProducto frmPro, VListarProductos frmListar) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmListar = frmListar;
        this.frmPri.menu_producto.addActionListener(this);
        this.frmPri.menu_listar_pedidos.addActionListener(this);
    }

    public void inciar() {
        frmPro.setTitle("Pedido");
        frmPri.setTitle("Principal");
        frmListar.setTitle("Lista Pedidos");

        frmPri.setLocationRelativeTo(null);
        frmPro.setLocationRelativeTo(null);
        frmListar.setLocationRelativeTo(null);

        frmPri.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPri.menu_producto) {
            frmPro.setVisible(true);
            frmPri.dispose();
        }

        if (e.getSource() == frmPri.menu_listar_pedidos) {
            frmListar.setVisible(true);
            frmPri.dispose();
        }
    }

}
