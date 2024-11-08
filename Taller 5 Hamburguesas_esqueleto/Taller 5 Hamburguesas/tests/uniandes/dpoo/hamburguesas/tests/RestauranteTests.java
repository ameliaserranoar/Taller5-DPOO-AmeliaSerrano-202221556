package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTests {
	private Restaurante restaurante;
	
@BeforeEach
void SetUp() throws IOException, HamburguesaException{
	restaurante= new Restaurante();
	try {
	File archivoMenu= new File("Taller 5 Hamburguesas_esqueleto/Taller 5 Hamburguesas/data/menu.txt");
	File archivoIngredientes= new File("Taller 5 Hamburguesas_esqueleto/Taller 5 Hamburguesas/data/ingredientes.txt");
	File archivoCombos= new File("Taller 5 Hamburguesas_esqueleto/Taller 5 Hamburguesas/data/combos.txt");
	restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);}
	catch (IOException e) {
		fail("Error al cargar los archivos de prueba: " + e.getMessage());}
	
	}
@Test
void testIniciarPedido() {
	try {
	restaurante.iniciarPedido("Amelia Serrano", "Calle 114 #21-73");
	assertNotNull(restaurante.getPedidoEnCurso(), "Iniciado");
	assertThrows(YaHayUnPedidoEnCursoException.class, () ->{
		restaurante.iniciarPedido("Marcela", "Calle 123 #23");
	});
	} catch (Exception e) {
		fail("No debe haber ninguna excepcion en el primer pedido: " + e.getMessage());
		
}}
@Test
void testCerrarGuardarPedido(){
	
}


}
	

