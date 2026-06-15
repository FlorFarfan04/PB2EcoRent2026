package ar.edu.unlam;

import java.util.Objects;

public class Operacion {
	
//	Cada operación tendrá un identificador único autoincrementar, cliente y vehículo
//	involucrado y descripción de la operación.

	private int contador = 0;
	private Integer idOperacion;
	private Cliente cliente;
	private Producto producto;
	private String operacion;
	
	public Operacion(Cliente cliente, Producto producto, String operacion) {
		super();
		this.idOperacion = ++contador;
		this.cliente = cliente;
		this.producto = producto;
		this.operacion = operacion;
	}


	public Integer getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOperacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacion other = (Operacion) obj;
		return Objects.equals(idOperacion, other.idOperacion);
	}
	
}
