package paquetes;

public class Carta {
	private String material;
	private String tamanio;
	private String estadoenvio;
	private String direccionentrega;
	
	
		// toString Falta tabularlo y mostrarlo bien
	
	public String toString() {
		return getMaterial() + getTamanio() + getEstadoenvio() + getDireccionentrega();
	}
	
			// getters and setters
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public String getEstadoenvio() {
		return estadoenvio;
	}
	public void setEstadoenvio(String estadoenvio) {
		this.estadoenvio = estadoenvio;
	}
	public String getDireccionentrega() {
		return direccionentrega;
	}
	public void setDireccionentrega(String direccionentrega) {
		this.direccionentrega = direccionentrega;
	}
}
