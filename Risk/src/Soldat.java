public class Soldat extends Unite {
	
	public Soldat(int numero, String nom) {
		super(cout, puissance, attaque, defense, mouvement, disponibilite, numero, nom);
		// TODO Auto-generated constructor stub
	}
	static final int cout = 1;
	static final int [] puissance = {1,2,3,4,5,6};
	static final int attaque = 2;
	static final int defense = 1;
	static final int mouvement = 2;
	static final int disponibilite = 1;
	
	
	//redonne toutes ses capacités à l'unité
	protected void revigoree() {
		this.setMouvement(2);
		this.setDisponibilite(1);
	}
}