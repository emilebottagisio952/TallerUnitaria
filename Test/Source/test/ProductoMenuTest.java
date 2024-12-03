package test;

import static org.junit.jupiter.api.Assertions.*;
import MODELO.ProductoMenu;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Pruebas para la clase ProductoMenu 😊")

public class ProductoMenuTest {
	
	    //Atributos
	 	private ProductoMenu producto;

	 	//Definición de BeforeEach
	 	
	    @BeforeEach
	    public void setUp() {
	        producto = new ProductoMenu("Hamburguesa", 14000, 546);
	    }

	    //Pruebas de métodos
	    
	    // Método 1 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
	    
	    @Test
	    @DisplayName("Pruebas para el método getNombre()")
	    public void testGetNombre() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        assertEquals("Hamburguesa", producto.getNombre(), "El nombre del producto no corresponde");
	    }

	    
	    // Método 2 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^
	    @Test
	    @DisplayName("Pruebas para el método getPrecio())")
	    public void testGetPrecio() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        assertEquals(14000, producto.getPrecio(), "El precio no corresponde");
	    }
	    
	    // Método 3 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 

	    @ParameterizedTest
	    @CsvSource({ "Hamburguesa, 600", "Gaseosa, 100", "Pizza, 800" })
	    @DisplayName("Pruebas para el método getCalorias()")
	    public void testGetCalorias(String nombre, int calorias) {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        producto.setNombre(nombre);
	        producto.setCalorias(calorias);
	        
	        if (producto.getNombre().equalsIgnoreCase(nombre)) {
	            assertEquals(calorias, producto.getCalorias(), "Las calorías no corresponden al producto.");
	        } else {
	            fail("El producto no es " + nombre + ".");
	        }
	    }
	    
	 // Método 4 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 



	    @Test
	    @DisplayName("Pruebas para el método generarTextoFactura()")
	    
	    public void testGenerarTextoFactura() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	    	String factura = producto.generarTextoFactura();
	    	boolean condicion = factura.equals("Hamburguesa---------14000");
	        assertTrue(condicion , "El texto no se generó correctamente porque la información no corresponde");
	    }
	}