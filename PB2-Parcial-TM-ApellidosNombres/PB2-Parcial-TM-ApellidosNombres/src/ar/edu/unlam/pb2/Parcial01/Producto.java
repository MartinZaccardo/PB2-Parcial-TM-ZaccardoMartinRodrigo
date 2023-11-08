package ar.edu.unlam.pb2.Parcial01;

public class Producto extends Item implements Comparable<Producto>{
	
	private Integer puntoDeReposicion;
	//private Integer stock;
	
	public Producto(Integer codigo, String nombre, Double precio, Integer puntoDeReposicion) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		super(codigo, nombre, precio);
		this.puntoDeReposicion = puntoDeReposicion;
		//this.stock = 0;
	}
	// TODO: Completar con los getters y setters necesarios

	public Integer getPuntoDeReposicion() {
		return puntoDeReposicion;
	}

	public void setPuntoDeReposicion(Integer puntoDeReposicion) {
		this.puntoDeReposicion = puntoDeReposicion;
	}
	@Override
	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

	
	/*public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}*/
	
