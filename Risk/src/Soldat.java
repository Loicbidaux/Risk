
public class Soldat extends Unite {

	public static final int COUNT = 1;
	
	public static final int [] puissance1 = {1,2,3,4,5,6};
	
	public Soldat(int cout, int puissance [], int attaque, int defense, int mouvement, int disponibilite, int numero) {
		super(cout, puissance, attaque, defense, mouvement, disponibilite, numero);
		// TODO Auto-generated constructor stub
		this.cout = 1;
		this.puissance = puissance1;
		this.attaque = 2;
		this.defense = 1;
		this.mouvement = 2;
		this.disponibilite = 1;
	}
}
