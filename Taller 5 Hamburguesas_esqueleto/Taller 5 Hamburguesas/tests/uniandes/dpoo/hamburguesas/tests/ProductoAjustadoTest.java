package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	private ProductoMenu producto; 
	private ProductoAjustado ajustado; 
	private Ingrediente ingrediente1; 
	private Ingrediente ingrediente2; 
	private Ingrediente ingrediente3;
	private ArrayList<Ingrediente> ingredientes;
	
	
	@BeforeEach
	void SetUp() throws Exception{
		producto= new ProductoMenu("corral",14000);
		ingrediente1= new Ingrediente("lechuga", 1000);
		ingrediente2= new Ingrediente("cebolla", 1000);
		ingrediente3= new Ingrediente("tomate", 1000);
		ingredientes= new ArrayList<>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		ajustado= new ProductoAjustado(producto);
	}
	@AfterEach
	void tearDown() throws Exception{
		producto= null;
		ingrediente1= null; 
		ingrediente2= null;
		ingrediente3= null;
		ingredientes= null; 
		ajustado= null; 
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("corral", ajustado.getNombre());
	}
	@Test
	public void testGetPrecio() {
		double esperado= producto.getPrecio()+ ingrediente1.getCostoAdicional()+ ingrediente2.getCostoAdicional();
		assertEquals(esperado, ajustado.getPrecio());
	}
	@Test
	public void testGenerarTextoFactura() {
		String esperado= "Producto ajustado: corral \n" + "    +lechuga                1000\n"+ "    +cebolla                1000\n" + "    -tomate\n" + "            16000\n";
		assertEquals(esperado, ajustado.generarTextoFactura());
	}
	@Test
	public void testAgregarIngredienteRepetido() {
		assertThrows(IngredienteRepetidoException.class, () ->{
		ArrayList<Ingrediente> agregados= ajustado.getAgregados();
		agregados.add(ingrediente1);
		});
	}
}
