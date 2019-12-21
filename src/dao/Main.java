package dao;

import java.sql.SQLException;

import entidades.Pedido;
import entidades.Usuario;
import utils.TPException;

public class Main {

	public static void main(String [] args) throws TPException {
		
		DataManager tm = new DataManager();
		tm.createUserTable();
		try {
		tm.createUsuariosTable();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		DataManager dm = new DataManager();
		
		String usuario =  "admin";
		String password = "admin";
		String nombre = "matias";
		String apellido = "barros";
		String direccion = "calle falsa";
		String telefono = "12345";
		String tipo = "administrador";
		Usuario p = new Usuario();
		p.setApellido(apellido);
		p.setDireccion(direccion);
		p.setUsuario(usuario);
		p.setPassword(password);
		p.setTelefono(telefono);
		p.setTipo(tipo);
		p.setNombre(nombre);
		try{
			dm.registrarUsuario(p);
		}
		catch(TPException e) {
			System.out.println(e.getMensaje());
			throw new TPException(e.getMensaje());
		}
		catch(SQLException s) {
			System.out.println(s.getMessage());
		}
		
		
		
	/*	System.out.println("Ahora voy a mostrar el usuario recien cargado");
		String unUser = Dentre.texto("ingrese el username del usuario recien creado");
		dm.muestraUsuario(unUser);
		System.out.println("---------");
		
		System.out.println("Voy a modificar un usuario");
		String user2 = Dentre.texto("ingrese el nombre usuario a modificar:");
		String email2 = Dentre.texto("ingrese nuevo email:");
		String pass2 = Dentre.texto("ingrese nueva password:");
		dm.actualizaUsuario(user2, email2, pass2);
		
		System.out.println("Tengo estos usuarios:");
		dm.muestraTodosLosusuarios();
		System.out.println("------");
		
		
		System.out.println("Voy a borrar un usuario segun su username");
		String user3 = Dentre.texto("ingrese el nombre usuario a borrar:");
		dm.borraUsuario(user3);
		
		System.out.println("Tengo estos usuarios:");
		dm.muestraTodosLosusuarios();
		System.out.println("------");
		
		//tm.dropUserTable();*/
		
	}
	
}
