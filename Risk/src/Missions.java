import java.lang.*;

public class Missions {
	String enonce;
	int numero;
	public Missions(String enonce, int numero) {
		super();
		this.enonce = enonce;
		this.numero = numero;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}