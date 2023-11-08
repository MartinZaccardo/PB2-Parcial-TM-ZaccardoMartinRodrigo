package ar.edu.unlam.pb2.Parcial01;

public class Cliente implements Comparable<Cliente>{

	private String cuit;
	private String razonSocial;
	
	public Cliente(String cuit, String razonSocial) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/*@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getRazonSocial().compareTo(o2.getRazonSocial()) * (-1);
	}*/

	@Override
	public int compareTo(Cliente o) {
		return this.razonSocial.compareTo(o.razonSocial) * (-1);
	}

	// TODO: Completar con los getters y setters necesarios
	
}
