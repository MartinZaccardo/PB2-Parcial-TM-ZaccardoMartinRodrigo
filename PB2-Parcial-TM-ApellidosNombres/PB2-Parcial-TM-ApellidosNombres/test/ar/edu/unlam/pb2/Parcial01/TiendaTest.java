package ar.edu.unlam.pb2.Parcial01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TiendaTest {

	/**
	 * Resolver los siguientes tests
	 * 
	 * @throws VendedorDeLicenciaException
	 */

	@Test(expected = VendedorDeLicenciaException.class)
	public void queAlIntentarAgregarUnaVentaParaUnVendedorDeLicenciaSeLanceUnaVendedorDeLicenciaException()
			throws VendedorDeLicenciaException {
		Tienda tienda = new Tienda("123", "PB2");

		Vendedor vendedor = new Vendedor("123", "Martin");
		vendedor.setDeLicencia(true);
		Cliente cliente = new Cliente("123", "#");
		Venta venta = new Venta("123abc", cliente, vendedor);

		tienda.agregarVenta(venta);
	}

	@Test (expected = VendibleInexistenteException.class)
	public void queAlIntentarAgregarUnVendibleInexistenteAUnaVentaSeLanceUnaVendibleInexistenteException() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("123", "PB2");

		Vendedor vendedor = new Vendedor("123", "Martin");
		Cliente cliente = new Cliente("123", "#");
		Venta venta = new Venta("123abc", cliente, vendedor);
		Producto producto = new Producto(1, "Teclado", 200.0, 20);

		tienda.agregarProductoAVenta(venta.getCodigo(), producto);
		
	}

	@Test
	public void queSePuedaObtenerUnaListaDeProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
		Tienda tienda = new Tienda("123", "PB2");
		
		Producto producto = new Producto(1, "Teclado", 200.0, 20);
		Producto producto2 = new Producto(2, "Monitor", 200.0, 30);
		Producto producto3 = new Producto(3, "Mouse", 200.0, 50);
		
		tienda.agregarProducto(producto, 10);
		tienda.agregarProducto(producto2, 50);
		tienda.agregarProducto(producto3, 50);

		List<Producto> lista = tienda.obtenerProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion();
		
		assertTrue(lista.contains(producto));
		assertTrue(lista.contains(producto3));
		assertFalse(lista.contains(producto2));
	}

	@Test
	public void queSePuedaObtenerUnSetDeClientesOrdenadosPorRazonSocialDescendente() {
		Tienda tienda = new Tienda("123", "PB2");

		Cliente cliente = new Cliente("123", "Hola");
		Cliente cliente2 = new Cliente("123", "Abc");
		Cliente cliente3 = new Cliente("123", "Zzz");
		
		tienda.agregarCliente(cliente);
		tienda.agregarCliente(cliente2);
		tienda.agregarCliente(cliente3);
		
		TreeSet<Cliente> clientesOrdenados = (TreeSet<Cliente>) tienda.obtenerClientesOrdenadosPorRazonSocialDescendente();
	
		Cliente primero = clientesOrdenados.first();
		Cliente ultimo = clientesOrdenados.last();
		 
		assertEquals(cliente3, primero);
		assertEquals(cliente2, ultimo);
	}

	@Test
	public void queSePuedaObtenerUnMapaDeVentasRealizadasPorCadaVendedor() {
		// TODO: usar como key el vendedor y Set<Venta> para las ventas
	}

	@Test
	public void queSePuedaObtenerElTotalDeVentasDeServicios() {
		
	}

	@Test
	public void queAlRealizarLaVentaDeUnProductoElStockSeActualiceCorrectamente() throws VendedorDeLicenciaException, VendibleInexistenteException {
		Tienda tienda = new Tienda("123", "PB2");

		Vendedor vendedor = new Vendedor("123", "Martin");
		Cliente cliente = new Cliente("123", "#");
		Venta venta = new Venta("123abc", cliente, vendedor);
		Producto producto = new Producto(1, "Teclado", 200.0, 20);

		tienda.agregarProducto(producto, 50);
		tienda.agregarVenta(venta);
		tienda.agregarProductoAVenta(venta.getCodigo(), producto);
		
		Integer ve = 49;
		Integer vo = tienda.getStock(producto);
		assertEquals(ve, vo, 0.01);
	}
}
