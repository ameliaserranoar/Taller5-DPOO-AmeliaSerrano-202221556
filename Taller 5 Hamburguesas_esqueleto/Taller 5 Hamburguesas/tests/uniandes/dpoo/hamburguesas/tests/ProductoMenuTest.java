package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	
	private ProductoMenu producto; 

	@BeforeEach
	void  setUp() throws Exception {
		producto= new ProductoMenu("corral",14000);
	}
	@AfterEach
	void tearDown() throws Exception{
		producto= null;
	}
	
	@Test
	public void testCons() {
		assertEquals("corral", producto.getNombre());
		assertEquals(14000,producto.getPrecio());	
	}
	@Test
	public void testGetNombre() {
		assertEquals("corral", producto.getNombre());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(14000,producto.getPrecio());
	}
	@Test
	public void testGenerarTextoFactura() {
		String esperado= "corral: 14000";
		assertEquals(esperado, producto.generarTextoFactura());
	}
	@Test
	public void testProductoRepetido() {
		Exception exception= assertThrows(ProductoRepetidoException.class, () ->{
			new ProductoMenu("corral", 14000);
		});
		String esperado= "El producto ya esta registrado en el menu";
		assertEquals(esperado, exception.getMessage());
	}
	@Test
	public void testProductoFaltante() {
		Exception exception= assertThrows(ProductoFaltanteException.class, () ->{
			new ProductoMenu("nada", 0);
			producto.getNombre();
		});
		String esperado= "El producto ya esta no está en el menu";
		assertEquals(esperado, exception.getMessage());
	}
}
