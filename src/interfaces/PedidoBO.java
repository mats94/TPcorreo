package interfaces;


import dao.DataManager;
import entidades.Pedido;
public class PedidoBO {

	Handler myhandler;
	DataManager dao;
	PedidoBO(Handler handler){
		myhandler = handler;
		dao = new DataManager(this);
		dao.createUserTable();
	}
	
	public void crearPedido(Pedido u) {
		//u.setDestino(null);
		if(u.getDestino()!= null) {
			dao.crearPedido(u);
		}
		else {
			myhandler.mostrarERROR("Datos incorrectos");
		}
	}
	
	public void insertarPedido(Pedido u) {
		insertarPedido(u);
	}
	
	public void borraPedido(String user) {
		dao.borraPedido(user);
	}
	
	public void actualizaPedido(Pedido u) {
		dao.actualizaPedido(u);
	}
	
	public void muestraPedido(Pedido p, Modificacion m) {
		myhandler.mostrarMOD(p, m);
	}
	
	public void muestraTodosLosPedido() {
		return;
	}
	public void mensaje(String msj) {
		myhandler.mostrarmsj(msj);
	}
	public void error(String msj) {
		// pasar msj al handler para que el despues lo muestre en pantalla
		myhandler.mostrarERROR(msj);
		
	}
	public void buscarinfo(String dato,Modificacion m) {
		dao.muestraPedido(dato,m);
	}
}
