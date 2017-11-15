package bo;

import java.util.Collection;

import clientedao.ClienteDAO;
import entidades.Cliente;

public class ClienteBO {

	private ClienteDAO dao;
	
	public void insertarCliente(Cliente u) {
		dao.insertarCliente(u);
	}
	public void deleteClienteById(String user) {
		dao.deleteClienteByUsername(user);
	}
	public void updateCliente(Cliente u) {
		updateCliente(u);
	}
	public Cliente getClienteByUsername(String user) {
		return getClienteByUsername(user);
	}
	public Collection getAllClientes() {
		return getAllClientes();
	}
	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}
	
	
}