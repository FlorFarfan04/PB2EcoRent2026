package ar.edu.unlam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;


public class EmpresaTest {

	/*
	 * empresa: tiene Autos

Motos

Bicicletas

Accesorios de vehículos


metodos: Venta

Alquiler

2. Se requiere llevar un registro de todas las operaciones realizadas.
3. Cada operación tendrá un identificador único autoincrementar, cliente y vehículo
involucrado y descripción de la operación.



Interfaces: Los productos "Vendibles" son los autos, las bicicletas y los accesorios, y para ello
debemos poder conocer el precioDeVenta()

Los productos "Alquilables" son los autos y las motos, y por consiguiente debemos
poder conocer el precioDeAlquilerPorDia(). Los productos "alquilables" deben estar disponibles para ser alquilados.



Clientes
De los clientes nos interesa saber:

Código de cliente

Nombre

Apellido

Número de licencia de conducir
	 * 
	 * 
	 * 
	 * Moto: Motos:

idMoto

Marca

Modelo

Cilindrada

Patente

Autos:

idAuto

Marca

Modelo

Año de fabricación

Patente

Capacidad de pasajeros

Vehiculo; id, marca, 
	 * 
	 * 
	 * */
	
	@Test
	public void dadoQueExisteUnaEmpresaNoSePuedanRegistrarDosVehiculosConElMismoCodigoYDescripcion() {
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);
		Auto auto = new Auto(1, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		
		empresa.agregarProducto(moto);
		empresa.agregarProducto(auto);

		assertEquals(1, empresa.getProductos().size());
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaSePuedanRegistrarClientes() {
		Empresa empresa = new Empresa();
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		Cliente cliente2 = new Cliente(2, "Horacio", "Perez", 1255);

		empresa.agregarClientes(cliente);
		empresa.agregarClientes(cliente2);

		assertEquals(2, empresa.getClientes().size());
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaNoSePuedarRealizarUnaVentaDeUnVehiculo() {
		Empresa empresa = new Empresa();
		Auto auto = new Auto(1, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
//		empresa.agregarProducto(auto);

		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		assertFalse(empresa.realizarVenta(auto, cliente));
	}

	@Test
	public void dadoQueExisteUnaEmpresaNoSePuedaRealizarUnAlquilerDeUnVehiculo() {
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);

//		empresa.agregarProducto(auto);

		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		assertFalse(empresa.realizarAlquiler(moto, cliente));
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaSePuedaRealizarLaDevolucionDeUnVehiculo() {
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);
		empresa.agregarProducto(moto);
		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		empresa.realizarAlquiler(moto, cliente);
		
		assertTrue(empresa.realizarDevolucion(moto));
	}
	
	@Test
	public void queUnAlquilerNoPuedaDevolverUnVehiculoYaAlquilado() {		
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);
		empresa.agregarProducto(moto);
		
		
		
		assertFalse(empresa.realizarDevolucion(moto));
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaSePuedaObtenerLosVehiculosDisponibles() {
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);
		Auto auto = new Auto(2, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		
		empresa.agregarProducto(moto);
		empresa.agregarProducto(auto);

		HashSet<Producto> vehiculosDispo = new HashSet<Producto>();
		vehiculosDispo = empresa.obtenerVehiculosDisponibles();
		
		assertEquals(2, vehiculosDispo.size());
	}
	
	@Test
	public void dadoQueExisteUnAlquilerSePuedeObtenerElMayorPrecio() {
		Empresa empresa = new Empresa();
		Moto moto = new Moto(1, "Moto1", 10, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);
		Auto auto = new Auto(2, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		
		empresa.agregarProducto(moto);
		empresa.agregarProducto(auto);
		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		empresa.realizarAlquiler(moto, cliente);
		empresa.realizarAlquiler(auto, cliente);
		
		assertEquals(1500.0, empresa.obtenerMayorPrecioDeAlquiler(), 0.1);
	}
	
	@Test
	public void dadoQueExisteUnaVentaPuedaObtenerLaCantidadDeVehiculosActualizadaDespuesDeLaMisma() {
		Empresa empresa = new Empresa();
		Auto auto = new Auto(1, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		Auto auto2 = new Auto(2, "Moto1", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 16000.0);

		
		empresa.agregarProducto(auto);
		empresa.agregarProducto(auto2);
		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		empresa.realizarVenta(auto2, cliente);
		
		assertEquals(1, empresa.getProductos().size());
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaSePuedaObtenerRegistroDeLasOperaciones() {		
		Empresa empresa = new Empresa();
		Auto auto = new Auto(1, "Auto", 10, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		Auto auto2 = new Auto(2, "Auto2", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1600.0, 16000.0);
		Moto moto = new Moto(3, "Moto1", 30, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);

		empresa.agregarProducto(auto);
		empresa.agregarProducto(auto2);
		empresa.agregarProducto(moto);
		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		
		empresa.realizarVenta(auto2, cliente);
		empresa.realizarVenta(auto, cliente);
		empresa.realizarAlquiler(moto, cliente);
		
		assertEquals(3, empresa.getOperaciones().size());
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaSePuedaObtenerLasOperacionesPorCliente() {
		Empresa empresa = new Empresa();
		Auto auto = new Auto(1, "Auto", 10, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1500.0, 10000.0);
		Auto auto2 = new Auto(2, "Auto2", 20, "Nissan", "ART-X", LocalDate.of(2002, 04, 03), "Pat0V4", 5, 1600.0, 16000.0);
		Moto moto = new Moto(3, "Moto1", 30, "Nissan", "ART-X", 3.0, "Pat0V4", 500.0);

		empresa.agregarProducto(auto);
		empresa.agregarProducto(auto2);
		empresa.agregarProducto(moto);
		
		Cliente cliente = new Cliente(1, "Patricio", "Perez", 122);
		empresa.agregarClientes(cliente);
		Cliente cliente2 = new Cliente(2, "Antonio", "Palacios", 444);
		empresa.agregarClientes(cliente2);
		
		empresa.realizarVenta(auto2, cliente2);
		empresa.realizarVenta(auto, cliente);
		empresa.realizarAlquiler(moto, cliente);
		
		
		assertEquals(2, empresa.obtenerOperacionesPorCliente(cliente).size());
	
	}
	
	@Test
	public void esteEsUnTestVacio() {
		String n = "Vacio";
		
		assertEquals("Vacio", n);
	}
	
	//este es un msj para ver si hacer hacer commit en una branch
	
	
	
	
}
