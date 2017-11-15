package dbImlp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import dao.DBManager;

import clientedao.ClienteDAO;
import entidades.Cliente;

public class ClienteDAODBImpl implements ClienteDAO{

	@Override
	public void deleteClienteByUsername(String nombre) {
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

	@Override
	public Collection getAllClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getClienteByUsername(String nombre) {
		Cliente retorna = null;
		String sql = "SELECT * FROM clientes WHERE user = '" + nombre + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String u = rs.getString("nombre");
				String e = rs.getString("direccion");
				String p = rs.getString("apellido");
				String q = rs.getString("telefono");
				retorna = new Cliente();
				retorna.setDireccion(e);
				retorna.setApellido(p);
				retorna.setNombre(u);
				retorna.setTelefono(q);
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
		return retorna;
	}

	@Override
	public void insertarCliente(Cliente u) {
		String sql = "INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES ('" + u.getNombre() + "', '" + u.getApellido() + "', '" + u.getDireccion() + "', '" + u.getTelefono() + "')";
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

	@Override
	public void updateCliente(Cliente u) {
		String sql = "UPDATE clientes set dirreccion = '" + u.getDireccion() + "', telefono = '" + u.getTelefono() + "' WHERE user = '" + u.getNombre() + "'";
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

	
	
}