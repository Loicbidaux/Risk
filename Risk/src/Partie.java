import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class Partie {
	int tour;
	int nbreJoueursTotal;
	int nbreJoueursHumains;
	ArrayList <Joueur> joueurs = new ArrayList();
	ArrayList <Missions> missionsDispo = new ArrayList();
	ArrayList <Regions> regions = new ArrayList();
	
	public Partie(int tour, int nbreJoueursTotal, int nbreJoueursHumains, ArrayList <Missions> missionsDispo, ArrayList <Regions> regions) {
		super();
		this.tour = tour;
		this.nbreJoueursTotal = nbreJoueursTotal;
		this.nbreJoueursHumains = nbreJoueursHumains;
		this.missionsDispo = missionsDispo;
		this.regions = regions;
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
		this.setTour(this.tour + 1);
	}
	
	public void ajoutMissions() {
		
	}
	
	public Regions appartenanceRegionTerritoire(Territoires territoire) {
		for(int i = 0 ; i < this.regions.size(); i++) {
			if(this.regions.get(i).territoires.contains(territoire)) {
				return this.regions.get(i);
			}
		}
		return this.regions.get(0);
	}
	
	public void miseEnPlace() {
		int randomNum;
		int randomNum2;
		int puissSoldat [] = {1,2,3,4,5,6};
		
		for(int i=0 ; i<nbreJoueursTotal ; i++) {
			this.joueurs.add(new Joueur(i, "oui", true));
		}
		
		//tableau contenant tous les territoires
		List <Territoires> territoires = new LinkedList();
		for(int i = 0 ; i<this.regions.size(); i++) {
			for(int j = 0; j<this.regions.get(i).territoires.size() ; j++) {
				territoires.add(this.regions.get(i).territoires.get(j));
			}
		}
		
		int nbreTerritoires = territoires.size();
		int territoiresParJoueur = Math.round(nbreTerritoires/this.nbreJoueursTotal);

		for(int i = 0 ; i<this.nbreJoueursTotal ; i++) {
			//attribution des missions
			randomNum = ThreadLocalRandom.current().nextInt(0, this.missionsDispo.size());
			this.joueurs.get(i).mission = this.missionsDispo.get(randomNum);
			
			//attribution des territoires
			for(int j=0 ; j<territoiresParJoueur ; j++) {
				randomNum2 = ThreadLocalRandom.current().nextInt(0, territoires.size());
				this.joueurs.get(i).territoires.add(territoires.get(randomNum2));
				territoires.remove(randomNum2);
			}
			
			//attribution des armees
			for(int j=1; j<50-5*this.nbreJoueursTotal +1 ; j++) {
				this.joueurs.get(i).armees.add(new Soldat(1,puissSoldat,2,1,2,1,j));
			}
		}
		
		ArrayList <Joueur> joueursChanceux = new ArrayList();
		
		while(!territoires.isEmpty()) {
			randomNum = ThreadLocalRandom.current().nextInt(0, this.joueurs.size());
			if(!joueursChanceux.contains(this.joueurs.get(randomNum))) {
				randomNum2 = ThreadLocalRandom.current().nextInt(0, territoires.size());
				this.joueurs.get(randomNum).territoires.add(territoires.get(randomNum2));
				territoires.remove(randomNum2);
				joueursChanceux.add(this.joueurs.get(randomNum));
			}
		}	
	}
	
	public void tourJoueur(Joueur joueur) {
		if(joueur.Humain) {
			joueur.appelRenforts();
			joueur.action(this);
		}
		else {
			//code intell. artif.
		}
	}
	
	
}