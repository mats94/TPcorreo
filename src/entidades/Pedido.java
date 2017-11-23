package entidades;

import paquetes.Carta;

public class Pedido {

	private String nombre;
	private String apellido;
	private String buscarnombre;
	private String buscarapellido;
	private String direccion;
	private String telefono;
	private String estado;
	private String destino;
	private Carta carta;


	public Carta getCarta() {
		return carta;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getBuscarnombre() {
		return buscarnombre;
	}
	public String getBuscarapellido() {
		return buscarapellido;
	}
	public void setBuscarnombre(String buscarnombre) {
		this.buscarnombre = buscarnombre;
	}
	public void setBuscarapellido(String buscarapellido) {
		this.buscarapellido = buscarapellido;
	}

}
