package test;
import MODELO.Combo;
import MODELO.ProductoMenu;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

@DisplayName("Pruebas para la clase Combo 😊")

public class ComboTest {
	
	//Atributos
    private Combo todoterreno;

  //Definición de BeforeEach
    @BeforeEach
    public void setUp() {
        // Crear algunos productos para el combo
        ProductoMenu producto1 = new ProductoMenu("todoterreno", 25000, 858);
        ProductoMenu producto2 = new ProductoMenu("papas grandes", 6900, 500);
        ProductoMenu producto3 = new ProductoMenu("gaseosa", 5000, 41);

        // Crear un combo
        todoterreno = new Combo("todoterreno", 0.10, new ArrayList<>(), 0);

        // Agregar productos al combo
        todoterreno.agregarItemACombo(producto1);
        todoterreno.agregarItemACombo(producto2);
        todoterreno.agregarItemACombo(producto3);
    }

  //Pruebas de métodos
    
    // Método 1  ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método getItems()")
    public void testGetItems() {
    	testAgregarItemACombo();
        ArrayList<ProductoMenu> itemsCombo = todoterreno.getItems();
        assertEquals(4, itemsCombo.size(), "No es correcto, no toma en cuenta los agregados");
    }

    // Método 2 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método agregarItemACombo()")
    public void testAgregarItemACombo() {
        // Crear un nuevo producto para agregar al combo
        ProductoMenu producto4 = new ProductoMenu("helado", 8000, 250);
        // Agregar el nuevo producto al combo
        todoterreno.agregarItemACombo(producto4);

        // Verificar que el producto se agregó correctamente
        ArrayList<ProductoMenu> itemsCombo = todoterreno.getItems();
        assertEquals(4, itemsCombo.size());
        assertEquals(44855, todoterreno.getPrecio(), "No corresponde al precio"); // Precio actualizado con el descuento
        assertEquals(1649, todoterreno.getCalorias(), "No son las calorias totales");
    }
    
    // Método 3 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Pruebas para el método getDescuento()")
    public void testGetDescuento() {
        double descuento = todoterreno.getdescuento();
        assertEquals(0.10, descuento, "El descuento es incorrecto");
    }

    
    // Método 4 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Pruebas para el método GetNombre()")
    public void testGetNombre() {
        String nombreCombo = todoterreno.getNombre();
        assertTrue(nombreCombo.equalsIgnoreCase("todoterreno"), "No es el nombre del combo");
    }

    // Método 5 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método getCalorias()")
    public void testGetCalorias() {
        int calorias = todoterreno.getCalorias();
        assertEquals(1399, calorias, "No corresponde a las calorias esperadas");
    }


    // Métodos 4 y 7 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método getPrecio() y generarTextoFactura()")
    public void testGetPrecioYGenerarTextoFactura() {
        // Ejecutar las pruebas de modificación
    	assertNotNull(todoterreno, "Error: ProductoAjustado no inicializado");
    	testAgregarItemACombo();

        // Verificar que el método getPrecio devuelve el precio correctamente
        int precio = todoterreno.getPrecio();
        Assertions.assertEquals(44855, precio, "No concuerda el precio");

        // Verificar que el método generarTextoFactura devuelve el texto de la factura correctamente
        String textoFactura = todoterreno.generarTextoFactura();
        String textoFacturaEsperado = "todoterreno---------44855";
        Assertions.assertEquals(textoFacturaEsperado, textoFactura, "No corresponde ni el precio ni texto esperados");
    }
}
