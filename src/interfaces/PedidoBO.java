package interfaces;


import java.sql.SQLException;

import dao.DataManager;
import entidades.Pedido;
import entidades.Usuario;
import utils.TPException;
public class PedidoBO {

	Handler myhandler;
	DataManager dao;
	PedidoBO(Handler handler) throws TPException{
		myhandler = handler;
		dao = new DataManager();
		dao.createUserTable();
	}
	
	public void crearPedido(Pedido u)throws TPException{
		//u.setDestino(null);
		if(u.getDestino()!= null) {
			try {
			dao.crearPedido(u);
			}catch(SQLException e) {
				myhandler.mostrarERROR("ERROR " + e);
			}catch(TPException e) {
				throw new TPException(e.getMensaje());
			}
		}
		else {
			myhandler.mostrarERROR("Datos incorrectos");
		}
	}
	
	public void insertarPedido(Pedido u) { //throws DAOException
		insertarPedido(u);
	}
	
	public void crearUsuario(Usuario u) throws TPException{
		try{
			dao.registrarUsuario(u);
			}
		catch(TPException e) {
			throw new TPException(e.getMensaje());
		}
		catch(SQLException e) {
			
		}
	}
	
	public void borraPedido(String user) throws TPException, SQLException{
		try{
			dao.borraPedido(user);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}
	
	public void actualizaPedido(Pedido u) throws TPException, SQLException{
		try{
			dao.actualizaPedido(u);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}
	
	public void actualizaUsuario(Usuario u) throws TPException, SQLException{
		try{
			dao.actualizaUsuario(u);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}
	
	/*public void muestraPedido(Pedido p) throws TPException, SQLException{
		try{
			myhandler.mostrarMOD(p);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}*/
	
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
	public void buscarinfo(String dato) throws TPException{
		try{
			dao.muestraPedido(dato);
		}catch(TPException e) {
			throw e;
		}
	}
	public void buscarinfoUsuario(String dato) throws TPException, SQLException{
		try{
			dao.muestraPedidoUsuario(dato);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}
	
	public void authUser(String usuario, String password) throws TPException,SQLException{
		try {
			dao.auth(usuario, password);
		}catch(TPException e) {
			throw e;
		}catch(SQLException e) {
			throw e;
		}
	}
}
