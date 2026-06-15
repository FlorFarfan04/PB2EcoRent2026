package ar.edu.unlam;


public class Moto extends Producto implements IAlquilable{

//	Motos:
//		
//		idMoto
//		
//		Marca
//		
//		Modelo
//		
//		Cilindrada
//		
//		Patente
	
	private Integer idMoto;
	private String marca;
	private String modelo;
	private Double cilindrada;
	private String patente;
	private Boolean disponible;
	private Double precioDeAlquilerPorDia;
	
	public Moto(Integer codigo, String descripcion, Integer idMoto, String marca, String modelo, Double cilindrada,
			String patente, Double precioDeAlquilerPorDia) {
		super(codigo, descripcion);
		this.idMoto = idMoto;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.patente = patente;
		this.disponible = true;
		this.precioDeAlquilerPorDia = precioDeAlquilerPorDia;
	}

	public Integer getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Integer idMoto) {
		this.idMoto = idMoto;
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

	public Double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
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
