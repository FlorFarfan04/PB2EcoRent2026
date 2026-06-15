package ar.edu.unlam;

import java.time.LocalDate;

public class Auto extends Producto implements IVendible, IAlquilable{


//	Autos:
//		
//		idAuto
//		
//		Marca
//		
//		Modelo
//		
//		Año de fabricación
//		
//		Patente
//		
//		Capacidad de pasajeros
	private Integer idAuto;
	private String marca;
	private String modelo;
	private LocalDate fechaDeFabricacion;
	private String patente;
	private Integer cantDePasajeros;
	private Boolean disponible;
	private Double precioDeAlquilerPorDia;
	private Double precioDeVenta;
	
	public Auto(Integer codigo, String descripcion, Integer idAuto, String marca, String modelo,
			LocalDate fechaDeFabricacion, String patente, Integer cantDePasajeros, Double precioDeAlquilerPorDia, 
			Double precioDeVenta) {
		super(codigo, descripcion);
		this.idAuto = idAuto;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaDeFabricacion = fechaDeFabricacion;
		this.patente = patente;
		this.cantDePasajeros = cantDePasajeros;
		this.disponible = true;
		this.precioDeAlquilerPorDia = precioDeAlquilerPorDia;
		this.precioDeVenta = precioDeVenta;
	}

	@Override
	public void vender() {
		// TODO Auto-generated method stub
		
	}
	
	public Integer getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getFechaDeFabricacion() {
		return fechaDeFabricacion;
	}

	public void setFechaDeFabricacion(LocalDate fechaDeFabricacion) {
		this.fechaDeFabricacion = fechaDeFabricacion;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getCantDePasajeros() {
		return cantDePasajeros;
	}

	public void setCantDePasajeros(Integer cantDePasajeros) {
		this.cantDePasajeros = cantDePasajeros;
	}

	public Double getPrecioDeAlquilerPorDia() {
		return precioDeAlquilerPorDia;
	}

	public void setPrecioDeAlquilerPorDia(Double precioDeAlquilerPorDia) {
		this.precioDeAlquilerPorDia = precioDeAlquilerPorDia;
	}

	public Double getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(Double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	@Override
	public Double obtenerPrecioDeVenta() {
		// TODO Auto-generated method stub
		return this.precioDeVenta;
	}

	@Override
	public void obtenerEstaDisponible(Boolean disponible) {
		// TODO Auto-generated method stub
		this.disponible = disponible;;
	}

	@Override
	public boolean estaDisponible() {
		// TODO Auto-generated method stub
		return this.disponible;
	}

	@Override
	public Double obtenerPrecioDeAlquilerPorDia() {
		// TODO Auto-generated method stub
		return this.precioDeAlquilerPorDia;
	}

	
	
}
