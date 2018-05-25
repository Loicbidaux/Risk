
public abstract class Unite {
	int cout;
	int puissance [];
	int attaque;
	int defense;
	int mouvement;
	int disponibilite;
	int numero;
	
	public Unite(int cout, int puissance [], int attaque, int defense, int mouvement, int disponibilite, int numero) {
		super();
		this.cout = cout;
		this.puissance = puissance;
		this.attaque = attaque;
		this.defense = defense;
		this.mouvement = mouvement;
		this.disponibilite = disponibilite;
		this.numero = numero;
	}
	
	public void setCout(int cout) {
		this.cout = cout;
	}
	public int [] getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance []) {
		this.puissance = puissance;
	}
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getMouvement() {
		return mouvement;
	}
	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void attaque() {
		
	}
	
	public void deplacement() {
		
	}
}
