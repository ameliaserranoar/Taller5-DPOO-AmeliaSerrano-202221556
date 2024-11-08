package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
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
	
	@BeforeEach
	void SetUp() {
		pedido= new Pedido("Amelia Serrano", "21#114-72");
		producto1= new ProductoMenu("Corral",14000);
		producto2= new ProductoMenu("papas medianas", 5500);
		
	}

	
	
}
