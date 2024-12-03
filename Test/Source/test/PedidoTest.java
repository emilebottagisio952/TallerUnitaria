package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import MODELO.Pedido;
import MODELO.PedidoValorSuperiorException;
import MODELO.ProductoMenu;
import Procesamiento.Producto;

@DisplayName("Pruebas para la clase Pedido 😊")

public class PedidoTest {
	
	//Atributos
    private Pedido pedido;
    
   //Definición de BeforeEach
    
    @BeforeEach
    public void setUp() {
        int numeroPedido = 00001;
        int id = 204;
        String cliente = "Sofia";
        String dir = "Cl 4 NO605";
        ArrayList<Producto> itemsPedido = new ArrayList<>();
        int precioneto = 0;
        int preciototal = 0;
        int precioiva = 0;

        pedido = new Pedido(numeroPedido, id, cliente, dir, itemsPedido, precioneto, preciototal, precioiva);
    }

    
    //Pruebas de métodos
    
    // Método 1 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Pruebas para el método getId()")
    public void testGetID() {
        assertEquals(204, pedido.getID());
    }
    
    // Método 2 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    @DisplayName("Pruebas para el método getPedido()")
    public void testGetPedido() {
        ArrayList<Producto> itemsPedido = new ArrayList<>();
        Producto producto1 = new ProductoMenu("Producto 1", 100, 50);
        Producto producto2 = new ProductoMenu("Producto 2", 200, 100);
        itemsPedido.add(producto1);
        itemsPedido.add(producto2);

        pedido.setItemsPedido(itemsPedido);

        assertEquals(itemsPedido, pedido.getPedido());
    }

    
    // Método 3 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Primera prueba para el método agregarProducto()")
    public void testAgregarProducto() throws PedidoValorSuperiorException {
        ProductoMenu producto1 = new ProductoMenu("Producto 1", 100, 50);
        ProductoMenu producto2 = new ProductoMenu("Producto 2", 200, 100);

        pedido.agregarProducto(producto1);

        assertEquals(100, pedido.getPrecioNetoPedido());

        pedido.agregarProducto(producto2);

        assertEquals(300, pedido.getPrecioNetoPedido());

        ProductoMenu producto3 = new ProductoMenu("Producto 3", 200000, 500);
        assertThrows(PedidoValorSuperiorException.class, () -> {
            try {
                pedido.agregarProducto(producto3);
            } catch (PedidoValorSuperiorException e) {
                assertEquals(200300, e.getPrecio());
                throw e;
            }
        });
    }

    
    @ParameterizedTest
    @CsvSource({ "Producto 1, 100", "Producto 2, 200", "Producto 3, 170000" })
    @DisplayName("Segunda prueba para el método agregarProducto(), incluye PedidoValorSuperiorException")
    public void testAgregarProductoParametrizado(String nombre, int precio) {
        ProductoMenu producto = new ProductoMenu(nombre, precio, 0);

        if (precio > 150000) {
            assertThrows(PedidoValorSuperiorException.class, () -> pedido.agregarProducto(producto));
        } else {
            assertDoesNotThrow(() -> pedido.agregarProducto(producto));
        }
    }


    // Método 4 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 

    @Test
    @DisplayName("Prueba para el método getPrecioIvaPedido()")
    public void testGetPrecioIvaPedido() {
        assertEquals(0, pedido.getPrecioIvaPedido());
    }

    // Método 5 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Prueba para el método getItemsString()")
    public void testGetItemsString() throws PedidoValorSuperiorException {
        ProductoMenu producto1 = new ProductoMenu("Producto 1", 100, 50);
        ProductoMenu producto2 = new ProductoMenu("Producto 2", 200, 100);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        ArrayList<String> itemsString = pedido.getItemsString();
        assertEquals(2, itemsString.size());
        assertEquals("Producto 1", itemsString.get(0));
        assertEquals("Producto 2", itemsString.get(1));
    }

    // Método 6 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Primera prueba para el método getPrecioNetoPedido()")
    public void testGetPrecioNetoPedido() {
        assertEquals(0, pedido.getPrecioNetoPedido());
    }

    // Método 7 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    
    @Test
    @DisplayName("Prueba para el método generarFacturaImprimir()")
    public void testGetPrecioTotalPedido() {
        assertEquals(0, pedido.getPrecioTotalPedido());
    }

    // Método 8 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @Test
    public void testGenerarFacturaImprimir() throws PedidoValorSuperiorException {
        ProductoMenu producto1 = new ProductoMenu("Producto 1", 100, 50);
        ProductoMenu producto2 = new ProductoMenu("Producto 2", 200, 100);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        ArrayList<String> factura = pedido.generarFacturaImprimir();

        assertEquals("DPOO BURGIRS", factura.get(0));
        assertEquals("--------------------------------------------------------------", factura.get(1));
        assertEquals("ID204----Pedido.no.1", factura.get(2));  // Corregir el intercambio entre ID y número de pedido
        assertEquals("Cliente:Sofia", factura.get(3));
        assertEquals("Direccion:Cl 4 NO605", factura.get(4));
        assertEquals("-ITEMS------------------------------------------------------", factura.get(5));
        assertEquals("Producto 1-----------100", factura.get(6));
        assertEquals("Producto 2-----------200", factura.get(7));
        assertEquals("-COSTO------------------------------------------------------", factura.get(8));
        assertEquals("Precio Neto:300", factura.get(9));
        assertEquals("IVA 19%:57", factura.get(10));
        assertEquals("Total:0", factura.get(11));
        assertEquals("-CALORIAS---------------------------------------------------", factura.get(12));
        assertEquals("150", factura.get(13));
    }


    @Test
    // Método 9 ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ ^.^ 
    @DisplayName("Prueba para el método guardar()")
    public void testGuardar() throws PedidoValorSuperiorException {
        ProductoMenu producto1 = new ProductoMenu("Producto1", 100, 50);
        ProductoMenu producto2 = new ProductoMenu("Producto2", 200, 100);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        String resultado = pedido.guardar();

        assertEquals("204;1;Sofia;Cl 4 NO605;Producto1,Producto2,300;57;0", resultado);
    }

}
