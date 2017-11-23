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
		if(u.getApellido() != null && u.getNombre() != null && u.getDireccion() != null && u.getTelefono() != null && u.getCarta().getDireccionentrega() != null) {
			dao.crearPedido(u);
		}
		else {
			myhandler.mostrarmsj("Datos incorrectos");
		}
	}
	
	public void insertarPedido(Pedido u) {
		insertarPedido(u);
	}
	public void borraPedido(String user) {
		borraPedido(user);
	}
	public void actualizaPedido(Pedido u) {
		actualizaPedido(u);
	}
	public Pedido muestraPedido(String user) {
		return muestraPedido(user);
	}
	public void muestraTodosLosPedido() {
		return;
	}
	public void error(String msj) {
		// pasar msj al handler para que el despues lo muestre en pantalla
		myhandler.mostrarmsj(msj);
		
	}
}
