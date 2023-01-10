package PrograWeb;

import Controlador.ControladorLogin;
import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;
import Modelo.CRUDPedido;
import Modelo.CRUDUsuario;
import Modelo.Pedido;
import Modelo.Usuario;
import Vista.VLogin;
import Vista.VPrincipal;
import Vista.VProducto;

public class Main {

    public static void main(String[] args) {
        VLogin frmPri = new VLogin();
        Usuario usuario = new Usuario();
        CRUDUsuario crudUsuario = new CRUDUsuario();
        ControladorLogin ctrlLogin = new ControladorLogin(frmPri, usuario, crudUsuario);
        frmPri.setVisible(true);
    }

}
