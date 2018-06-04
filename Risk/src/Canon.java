public class Canon extends Unite {
	
	public Canon(int numero, String nom) {
		super(cout, puissance, attaque, defense, mouvement, disponibilite, numero, nom);

		// TODO Auto-generated constructor stub
	}
	static final int cout = 7;
	static final int [] puissance = {4,5,6,7,8,9};
	static final int attaque = 3;
	static final int defense = 2;
	static final int mouvement = 1;
	static final int disponibilite = 1;
	
	protected void revigoree() {
		this.setMouvement(1);
		this.setDisponibilite(1);
	}
	
}
