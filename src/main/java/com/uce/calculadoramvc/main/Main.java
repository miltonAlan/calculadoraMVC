package com.uce.calculadoramvc.main;

import com.uce.calculadoramvc.controlador.ControladorLogin;
import com.uce.calculadoramvc.modelo.CRUDUsuario;
import com.uce.calculadoramvc.modelo.Usuario;
import com.uce.calculadoramvc.vista.VLogin;

public class Main {

    public static void main(String[] args) {
        VLogin frmPri = new VLogin();
        Usuario usuario = new Usuario();
        CRUDUsuario crudUsuario = new CRUDUsuario();
        ControladorLogin ctrlLogin = new ControladorLogin(frmPri, usuario, crudUsuario);
        frmPri.setVisible(true);
    }

}
