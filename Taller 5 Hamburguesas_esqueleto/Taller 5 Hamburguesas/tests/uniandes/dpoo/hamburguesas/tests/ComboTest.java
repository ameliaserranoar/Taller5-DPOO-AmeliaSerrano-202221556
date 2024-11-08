package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	private Combo combo; 
	private ProductoMenu producto1; 
	private ProductoMenu producto2; 
	private ProductoMenu producto3; 
	private ProductoMenu invalido; 
	private ArrayList<ProductoMenu> items;
	
	
	@BeforeEach
	void SetUp() throws Exception{
		producto1= new ProductoMenu("corral", 14000);
		producto2= new ProductoMenu("papas medianas", 5500);
		producto3= new ProductoMenu("gaseosa", 5000);
		items= new ArrayList<>();
		items.add(producto1); 
		items.add(producto2);
		items.add(producto3);
		items.add(invalido);
		combo= new Combo("combo corral", 10, items);
	}
	@AfterEach
	void tearDown() throws Exception{
		combo= null;
		producto1= null;
		producto2= null;
		producto3= null;
		invalido= null; 
		items= null; 
	}
	@Test
	void testCon() {
		assertEquals("combo corral", combo.getNombre());
		assertEquals(10, combo.getDescuento());
		assertTrue(combo.getItems().contains(producto1));
		assertTrue(combo.getItems().contains(producto2));
		assertTrue(combo.getItems().contains(producto3));
	}
	@Test
	public void testGetNombre() {
		assertEquals("combo corral", combo.getNombre());
	}
	@Test
	public void testGetPrecio() {
		double precio = (14000+5500+5000)*0.1;
		assertEquals(precio , combo.getPrecio());
	}
	@Test
	public void testGenerarTextoFactura() {
		double precio = (14000+5500+5000)*0.1;
		String esperado= "Combo combo corral\n" + "Descuento: 10.0 \n" + "            " + precio + "\n";
		assertEquals(esperado, combo.generarTextoFactura());
	}
	@Test
	public void testProductoFaltanteException() {
		ArrayList<ProductoMenu> itemsInvalidos = new ArrayList<>();
		itemsInvalidos.add(invalido);
		assertThrows(ProductoFaltanteException.class, () ->{
			Combo comboConInvalido= new Combo("Combo con producto faltante", 10, itemsInvalidos);
		});
	}
	@Test
	public void testProductoRepetidoException() {
		ArrayList<ProductoMenu> itemsRepetidos = new ArrayList<>();
		itemsRepetidos.add(producto1);
		itemsRepetidos.add(producto1);
		assertThrows(ProductoRepetidoException.class, () ->{
			Combo comboConrepetido= new Combo("Combo con producto repetido", 10, itemsRepetidos);
		});
		
	}
}
