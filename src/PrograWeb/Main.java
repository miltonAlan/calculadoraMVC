package PrograWeb;

import Controlador.ControladorLogin;
import Modelo.CRUDUsuario;
import Modelo.Usuario;
import Vista.VLogin;

public class Main {

    public static void main(String[] args) {
        VLogin frmPri = new VLogin();
        Usuario usuario = new Usuario();
        CRUDUsuario crudUsuario = new CRUDUsuario();
        ControladorLogin ctrlLogin = new ControladorLogin(frmPri, usuario, crudUsuario);
        frmPri.setVisible(true);
    }

}
