package clientedao;

import java.util.Collection;

import entidades.Pedido;

public interface PedidoDAO {

	public void insertarPedido(Pedido u);
	public void deletePedidoByUsername(String nombre);
	public void updatePedido(Pedido u);
	public Pedido getPedidoByUsername(String nombre);
	public Collection getAllPedido();
	
}