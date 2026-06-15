package ar.edu.unlam;

import java.util.ArrayList;
import java.util.HashSet;


public class Empresa {

	private HashSet<Producto> productos;
	private HashSet<Cliente> clientes;
	private ArrayList<Operacion> operaciones;

	public Empresa() {
		super();
		this.productos = new HashSet<Producto>();
		this.clientes = new HashSet<Cliente>();
		this.operaciones = new ArrayList<Operacion>();
	}
	

	public ArrayList<Operacion> obtenerOperacionesPorCliente(Cliente c) {
		// TODO Auto-generated method stub
		ArrayList<Operacion> operacionesPorCliente = new ArrayList<Operacion>();
		for (Operacion operacion : operaciones) {
			if(operacion.getCliente().equals(c)) {
				operacionesPorCliente.add(operacion);
			}
		}
		return operacionesPorCliente;
	}

	public Double obtenerMayorPrecioDeAlquiler() {
		// TODO Auto-generated method stub
		Double precioMayor = 0.0;
		for (Producto producto : productos) {
			if(producto instanceof IAlquilable) {
				Double precioActual = ((IAlquilable) producto).obtenerPrecioDeAlquilerPorDia();
				if(precioActual > precioMayor) {
					precioMayor = precioActual;
				}
			}
		}
		return precioMayor;
	}
	
	public HashSet<Producto> obtenerVehiculosDisponibles() {
		// TODO Auto-generated method stub
		HashSet<Producto> productosDispo = new HashSet<Producto>();
		
		for (Producto producto : productos) {
			if(producto instanceof IAlquilable && ((IAlquilable) producto).estaDisponible()) {
				productosDispo.add(producto);
			}
		}
		return productosDispo;
	}
	
	public Boolean realizarDevolucion(Producto moto) {
		// TODO Auto-generated method stub
		Boolean seDevolvio = false;
		if(moto instanceof IAlquilable && ((IAlquilable)moto).estaDisponible() == false) {
			
			((IAlquilable)moto).obtenerEstaDisponible(true);
			seDevolvio = true;
		}
		return seDevolvio;
	}

	public Boolean realizarAlquiler(Producto p, Cliente cliente) {
		// TODO Auto-generated method stub
		Boolean seAlquilo = false;
		if(productos.contains(p) && p instanceof IAlquilable && clientes.contains(cliente) && 
				((IAlquilable)p).estaDisponible()) {
			
			Operacion operacion = new Operacion(cliente, p, "Alquiler");
			operaciones.add(operacion);
			((IAlquilable)p).obtenerEstaDisponible(false);
			seAlquilo = true;
		}
		return seAlquilo;
	}
	
	public Boolean realizarVenta(Producto p, Cliente c) {
		Boolean seVendio = false;
		if(productos.contains(p) && p instanceof IVendible && clientes.contains(c)) {
			Operacion operacion = new Operacion(c, p, "Venta");
			operaciones.add(operacion);
			productos.remove(p);
			seVendio = true;
		}
		return seVendio;
	}
	

	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}


	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}


	public void agregarProducto(Producto p) {
		this.productos.add(p);
	}
	
	public void agregarClientes(Cliente c) {
		this.clientes.add(c);
	}
	
	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(HashSet<Producto> productos) {
		this.productos = productos;
	}


}
