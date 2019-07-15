package utils;

public class TPException extends Exception {
	private static final long serialVersionUID = 2883294578206524157L;
	private String mensaje;
	
	public TPException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public TPException(String mensaje, Exception e) {
		super(e);
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
