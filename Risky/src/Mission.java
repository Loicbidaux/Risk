public class Mission {
	String enonce;
	int conditions;
	int numero;
	String titre;
	public Mission(String enonce, int conditions, int numero, String titre) {
		super();
		this.enonce = enonce;
		this.conditions = conditions;
		this.numero = numero;
		this.titre = titre;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public int getConditions() {
		return conditions;
	}
	public void setConditions(int conditions) {
		this.conditions = conditions;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}