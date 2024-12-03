package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Procesamiento.Producto;
import MODELO.Ingrediente;

import MODELO.ProductoAjustado;

@DisplayName("Pruebas para la clase ProductoAjustado 😊")

class ProductoAjustadoTest {
	
	//Atributos
	private ProductoAjustado producto;
	
	//Definición de BeforeEach

    @BeforeEach
    public void setUp() {
        // Configuración inicial para cada prueba
        String nombre = "Corral";
        int precio = 14000;
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        int calorias = 0;

        producto = new ProductoAjustado(nombre, precio, agregados, eliminados, calorias);
    }
    
  //Pruebas de métodos
    
    // Métodos 1 y 4 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 

    @Test
    @DisplayName("Pruebas para el método getPrecio() y generarTextoFactura()")
    public void testGetPrecioYGenerarTextoFactura() {
        // Ejecutar las pruebas de modificación
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
        testAgregar();

        // Verificar que el método getPrecio devuelve el precio correctamente
        int precio = producto.getPrecio();
        Assertions.assertEquals(15000, precio);

        // Verificar que el método generarTextoFactura devuelve el texto de la factura correctamente
        String textoFactura = producto.generarTextoFactura();
        String textoFacturaEsperado = "Corral. adicion de.cebolla---------15000";
        Assertions.assertEquals(textoFacturaEsperado, textoFactura, "No corresponde ni el precio ni texto esperados");
    }


 // Método 2 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método agregar()")
    public void testAgregar() {
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
        // Verificar que el método agregar incrementa el precio y las calorías correctamente
        Ingrediente ingrediente = new Ingrediente("cebolla", 1000, 40);
        
        // Verificar si el ingrediente ya está agregado antes de agregarlo nuevamente
        boolean ingredienteAgregado = false;
        for (int i = 0; i < producto.getAgregados().size(); i++) {
            if (producto.getAgregados().get(i).getNombre().equals(ingrediente.getNombre())) {
                ingredienteAgregado = true;
                break; // Terminar el ciclo si el ingrediente ya está agregado
            }
        }
        
        if (ingredienteAgregado) {
            fail("El producto ya está agregado");
        } else {
            producto.agregar(ingrediente);
        }

        Assertions.assertEquals(15000, producto.getPrecio());
        Assertions.assertEquals(40, producto.getCalorias());
    }

    
 // Métodos 3 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método quitar()")
    public void testQuitar() {
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
        // Verificar que el método quitar actualiza el nombre correctamente
        Ingrediente ingrediente = new Ingrediente("cebolla", 1000, 40);
        
        boolean ingredienteEliminado = false;
        for (int i = 0; i < producto.getAgregados().size(); i++) {
            if (producto.getAgregados().get(i).getNombre().equals(ingrediente.getNombre())) {
                ingredienteEliminado = true;
                break; // Terminar el ciclo si el ingrediente ya está agregado
            }
        }
        
        if (ingredienteEliminado) {
            fail("El producto ya está eliminado");
        } else {
            producto.quitar(ingrediente);
        }

        String nombreEsperado = "Corral. sin.cebolla";
        Assertions.assertEquals(nombreEsperado, producto.getNombre());
    }

}