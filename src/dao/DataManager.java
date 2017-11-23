package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Pedido;
import interfaces.Modificacion;
import interfaces.PedidoBO;


public class DataManager {

	private PedidoBO bo;
	public DataManager(PedidoBO pedido) {
		bo = pedido;
	}
	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE pedidos ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256), direcciondestino VARCHAR(256), estadoenvio VARCHAR(256))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				bo.mensaje("Ya existe la DB");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	public void crearPedido(Pedido p) {
		String sql = "INSERT INTO pedidos (nombre, apellido, direccion, telefono, direcciondestino, estadoenvio) VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '" + p.getDireccion() + "', '" + p.getTelefono() + "', '" + p.getDestino() + "', '" + p.getEstado() + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				bo.error("no se puede hacer el pedido");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				bo.error("no se puedo terminar la conexion");
			}
		}
	}
	
	public void borraPedido(String dato) {
		String sql = "DELETE FROM pedidos WHERE apellido = '" + dato + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			bo.mensaje("eliminado exitoso");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				bo.error("usuario incorrecto");
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void actualizaPedido(Pedido p) {
		String sql = "UPDATE pedidos set direccion = '" + p.getDireccion() + "', nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', direcciondestino = '" + p.getDestino() +  "' WHERE apellido = '" + p.getApellido() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			bo.mensaje("se actualizo con exito");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}

	}
	
	public void muestraPedido(String ape, Modificacion m) {
		String sql = "SELECT * FROM pedidos WHERE apellido = '" + ape + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Pedido:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("nombre"));
				System.out.print("\t" + rs.getString("apellido"));
				System.out.print("\t" + rs.getString("direccion"));
				System.out.println();
				Pedido pedido = new Pedido();
				pedido.setNombre(rs.getString("Nombre"));
				pedido.setApellido(rs.getString("Apellido"));
				pedido.setDireccion(rs.getString("direccion"));
				pedido.setDestino(rs.getString("direcciondestino"));
				pedido.setEstado(rs.getString("estadoenvio"));
				bo.muestraPedido(pedido ,m);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	public void muestraTodosLosPedidos() {
		String sql = "SELECT * FROM pedidos";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Pedido:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("Nombre"));
				System.out.print("\t" + rs.getString("Apellido"));
				System.out.print("\t" + rs.getString("Direccion"));
				System.out.print("\t" + rs.getString("Telefono"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
}
