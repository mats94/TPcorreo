package clientedao;

import java.util.Collection;

import entidades.Cliente;

public interface ClienteDAO {

	public void insertarCliente(Cliente u);
	public void deleteClienteByUsername(String nombre);
	public void updateCliente(Cliente u);
	public Cliente getClienteByUsername(String nombre);
	public Collection getAllClientes();
	
}