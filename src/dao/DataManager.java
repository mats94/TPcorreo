package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManager {

	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE clientes ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256))";
		
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
	public void crearCliente(String nombre, String apellido, String direccion, String telefono) {
		String sql = "INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES ('" + nombre + "', '" + apellido + "', '" + direccion + "', '" + telefono + "')";
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
	
	public void borraCliente(String nombre) {
		String sql = "DELETE FROM clientes WHERE user = '" + nombre + "'";
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
	
	public void actualizaCliente(String user, String email, String pass) {
		String sql = "UPDATE clientes set email = '" + email + "', pass = '" + user + "' WHERE user = '" + user + "'";
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
	
	public void muestraUsuario(String username) {
		String sql = "SELECT * FROM clientes WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Clientes:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
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
	
	
	public void muestraTodosLosusuarios() {
		String sql = "SELECT * FROM clientes";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Clientes:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
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
