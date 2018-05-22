import java.util.ArrayList;

public class Partie {
	int tour;
	int nbreJoueursTotal;
	int nbreJoueursHumains;
	ArrayList <Joueur> joueurs = new ArrayList();
	
	public Partie(int tour, int nbreJoueursTotal, int nbreJoueursHumains) {
		super();
		this.tour = tour;
		this.nbreJoueursTotal = nbreJoueursTotal;
		this.nbreJoueursHumains = nbreJoueursHumains;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public int getNbreJoueursTotal() {
		return nbreJoueursTotal;
	}

	public void setNbreJoueursTotal(int nbreJoueursTotal) {
		this.nbreJoueursTotal = nbreJoueursTotal;
	}

	public int getNbreJoueursHumains() {
		return nbreJoueursHumains;
	}

	public void setNbreJoueursHumains(int nbreJoueursHumains) {
		this.nbreJoueursHumains = nbreJoueursHumains;
	}
	
	public void ajouterTour() {
		
	}
	
	public void miseEnPlace() {
		
	}
	
	public void tourJoueur() {
		
	}
	
	
}
