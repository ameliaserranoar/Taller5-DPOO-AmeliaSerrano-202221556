package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido;
	private ProductoMenu producto1;
	private ProductoMenu producto2;
	private ProductoMenu producto3;
	private Combo combo;
	private ProductoAjustado ajustado; 
	private Ingrediente extra; 
	private ArrayList<ProductoMenu> items; 
	
	@BeforeEach
	void SetUp() {
		pedido= new Pedido("Amelia Serrano", "21#114-72");
		producto1= new ProductoMenu("Corral",14000);
		producto2= new ProductoMenu("papas medianas", 5500);
		producto3= new ProductoMenu("gaseosa", 5000);
		items= new ArrayList<>();
		items.add(producto1); 
		items.add(producto2);
		items.add(producto3);
		combo= new Combo("combo corral", 10, items);
		ArrayList<Ingrediente> agregados = ajustado.getAgregados();
		agregados.add(extra);
		
	}
	
	@AfterEach
	void tearDown() {
		pedido= null;
		producto1= null;
		producto2= null; 
		producto3= null;
		combo= null;
		
	}
	
	@Test
	void testGenerarTextoFactura() {
		pedido.agregarProducto(producto1);
		pedido.agregarProducto(combo);
		String esperado= "Cliente: \n" + pedido.getNombreCliente() + "\n" + "Dirección: \n" + pedido.getDireccionCliente() +"\n" 
		+"----------------\n" 
		+ producto1.generarTextoFactura() + combo.generarTextoFactura() + pedido.getPrecioNetoPedido()   
		+pedido.getPrecioIVAPedido() + pedido.getPrecioTotalPedido();
		assertEquals(esperado, pedido.generarTextoFactura());
	}
	@Test
	void testGuardarFactura() {
		
	}
}
	

