package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Pedido;
import entidades.Usuario;
import interfaces.Modificacion;
import interfaces.PedidoBO;
import utils.TPException;

public class DataManager {

	public DataManager() {
	}//CREATE TABLE usuarios (usuario VARCHAR(256), password VARCHAR(256), nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256), tipo VARCHAR(256));
	public void createUserTable(){

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE pedidos ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256), direcciondestino VARCHAR(256), estadoenvio VARCHAR(256));";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				//e.printStackTrace();
				//bo.mensaje("Ya existe la DB");
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
	public void createUsuariosTable() throws SQLException{

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios (usuario VARCHAR(256), password VARCHAR(256), nombre VARCHAR(256), apellido VARCHAR(256), direccion VARCHAR(256), telefono VARCHAR(256), tipo VARCHAR(256));";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				//e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	public void crearPedido(Pedido p) throws SQLException,TPException{
		String sql = "INSERT INTO pedidos (nombre, apellido, direccion, telefono, direcciondestino, estadoenvio) VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '" + p.getDireccion() + "', '" + p.getTelefono() + "', '" + p.getDestino() + "', '" + p.getEstado() + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			throw new TPException("Ejecutado correctamente");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				//bo.error("no se puedo terminar la conexion");
			}
		}
	}
	
	public void borraPedido(String dato) throws TPException, SQLException{
		String sql = "DELETE FROM pedidos WHERE apellido = '" + dato + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			throw new TPException("eliminado exitoso");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				//bo.error("usuario incorrecto");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void actualizaPedido(Pedido p) throws TPException, SQLException{
		String sql = "UPDATE pedidos set direccion = '" + p.getDireccion() + "', nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', direcciondestino = '" + p.getDestino() +  "' WHERE apellido = '" + p.getApellido() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			throw new TPException("actualizado con exito");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	public void actualizaUsuario(Usuario p) throws TPException, SQLException{
		String sql = "UPDATE pedidos set direccion = '" + p.getDireccion() + "', nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', telefono = '" + p.getTelefono() + "', tipo = '" + p.getTipo() + "'" +  "' WHERE usuario = '" + p.getUsuario() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			throw new TPException("actualizado con exito");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	public void muestraPedido(String ape) throws TPException{
		String sql = "SELECT * FROM pedidos WHERE apellido = '" + ape + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				throw new TPException(rs.getString("Nombre") + " | " + rs.getString("Apellido") + " | " + rs.getString("direccion") + " | " + rs.getString("direcciondestino") + " | " + rs.getString("estadoenvio"));
			}
			
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
	
	public void muestraPedidoUsuario(String user) throws TPException, SQLException{
		String sql = "SELECT * FROM usuarios WHERE usuario = '" + user + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				throw new TPException(rs.getString("Nombre") + " | " + rs.getString("Apellido") + " | " + rs.getString("direccion") + " | " + rs.getString("telefono") + " | " + rs.getString("tipo"));
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void muestraTodosLosPedidos() throws TPException, SQLException{
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
	
	public void auth(String User, String Password) throws TPException, SQLException{
		String sql = "SELECT * FROM USUARIOS WHERE Usuario='" + User + "' AND Password= '" + Password + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			throw new TPException("ok");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void registrarUsuario(Usuario u) throws SQLException,TPException{
		String sql = "INSERT INTO usuarios (usuario, password, nombre, apellido, direccion, telefono, tipo) VALUES('" + u.getUsuario() + "', '" + u.getPassword() + "', '" + u.getNombre() + "', '" + u.getApellido() + "', '" + u.getDireccion() + "', '" + u.getTelefono() + "', '" + u.getTipo() + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			throw new TPException("Usuario creado correctamente");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new TPException(e.getMessage());
		} finally {
			try {
				c.close();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void borrarUsuario(Usuario u) throws SQLException,TPException{
		String sql = "DELETE FROM usuarios WHERE usuario='" + u.getUsuario() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			throw new TPException("Usuario eliminado correctamente");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new TPException(e.getMessage());
		} finally {
			try {
				c.close();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
