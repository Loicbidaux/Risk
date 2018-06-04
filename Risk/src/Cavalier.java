public class Cavalier extends Unite {

	public Cavalier(int numero, String nom) {
		super(cout, puissance, attaque, defense, mouvement, disponibilite, numero, nom);
		// TODO Auto-generated constructor stub
	}
	
	static final int cout = 3;
	static final int [] puissance = {2,3,4,5,6,7};
	static final int attaque = 1;
	static final int defense = 3;
	static final int mouvement = 3;
	static final int disponibilite = 1;
	
	protected void revigoree() {
		this.setMouvement(3);
		this.setDisponibilite(1);
	}
}
