package ar.edu.unlam;

import java.util.Objects;

public class Cliente {

//
//	Clientes
//	De los clientes nos interesa saber:
//	
//	Código de cliente
//	
//	Nombre
//	
//	Apellido
//	
//	Número de licencia de conducir
	
	private Integer codigoCliente;
	private String nombre;
	private String apellido;
	private Integer nroLicenciaDeConducir;
	
	public Cliente(Integer codigoCliente, String nombre, String apellido, Integer nroLicenciaDeConducir) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroLicenciaDeConducir = nroLicenciaDeConducir;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
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

	public Integer getNroLicenciaDeConducir() {
		return nroLicenciaDeConducir;
	}

	public void setNroLicenciaDeConducir(Integer nroLicenciaDeConducir) {
		this.nroLicenciaDeConducir = nroLicenciaDeConducir;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codigoCliente, other.codigoCliente);
	}
	
}
