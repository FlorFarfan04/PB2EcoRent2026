package ar.edu.unlam;

public interface IAlquilable {

	public void obtenerEstaDisponible(Boolean d);
	
	public boolean estaDisponible();
	
	public Double obtenerPrecioDeAlquilerPorDia();
}

