package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManager {

	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE pedidos ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
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
	public void crearPedido(String nombre, String apellido, String direccion, String telefono) {
		String sql = "INSERT INTO pedidos (nombre, apellido, direccion, telefono) VALUES ('" + nombre + "', '" + apellido + "', '" + direccion + "', '" + telefono + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void borraPedido(int id) {
		String sql = "DELETE FROM pedidos WHERE user = '" + id + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
	
	public void actualizaPedido(int id, String user, String email, String pass) {
		String sql = "UPDATE pedidos set email = '" + email + "', pass = '" + user + "' WHERE ID = '" + id + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
	
	public void muestraPedido(int id) {
		String sql = "SELECT * FROM pedidos WHERE user = '" + id + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
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
