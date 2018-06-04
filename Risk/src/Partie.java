import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class Partie {
	int tour;
	int nbreJoueursTotal;
	int nbreJoueursHumains;
	Territoires [] noeuds;
	int adjMatrices [][];
	ArrayList <Joueur> joueurs = new ArrayList();
	ArrayList <Missions> missionsDispo = new ArrayList();
	ArrayList <Regions> regions = new ArrayList();
	
	int flagParametrageDebut = 0;
	
	public Partie(int tour, int nbreJoueursTotal, int nbreJoueursHumains, ArrayList <Regions> regions, int adjMatrices [][]) {
		super();
		this.tour = tour;
		this.nbreJoueursTotal = nbreJoueursTotal;
		this.nbreJoueursHumains = nbreJoueursHumains;
		this.regions = regions;
		this.adjMatrices = adjMatrices;
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
	
	public void setAdjMatrices(int[][] adjMatrices) {
		this.adjMatrices = adjMatrices;
	}
	
	public void ajouterTour() {
		this.setTour(this.tour + 1);
	}
	
	public void setMissionsDispo(ArrayList<Missions> missionsDispo) {
		this.missionsDispo = missionsDispo;
	}

	//on regarde a quelle region appartient la region demandee
	public Regions appartenanceRegionTerritoire(Territoires territoire) {
		for(int i = 0 ; i < this.regions.size(); i++) {
			if(this.regions.get(i).territoires.contains(territoire)) {
				return this.regions.get(i);
			}
		}
		return this.regions.get(0);
	}
	
	//fonction ne se lancant qu'au debut de la partie
	public void miseEnPlace() {
		int randomNum;
		int randomNum2;
		
		for(int i=0 ; i<nbreJoueursTotal ; i++) {
			Joueur joueur = new Joueur(i,"gege", true);
			joueur.setCamp("rebelles");
			if (i==0) {
				joueur.setCouleur("red");
			}
			else if(i==1) {
				joueur.setCouleur("black");
			}
			else if(i==2) {
				joueur.setCouleur("pink");
			}
			else if(i==3) {
				joueur.setCouleur("orange");
			}
			else if(i==4) {
				joueur.setCouleur("green");
			}
			else {
				joueur.setCouleur("blue");
			}
			this.joueurs.add(joueur);
			
		}
		
		//tableau contenant tous les territoires
		List <Territoires> territoires = new LinkedList();
		for(int i = 0 ; i<this.regions.size(); i++) {
			for(int j = 0; j<this.regions.get(i).territoires.size() ; j++) {
				territoires.add(this.regions.get(i).territoires.get(j));
			}
		}
		
		//calcul du nombre de territoires dus aux joueurs
		int nbreTerritoires = territoires.size();
		int territoiresParJoueur = Math.round(nbreTerritoires/this.nbreJoueursTotal);

		for(int i = 0 ; i<this.nbreJoueursTotal ; i++) {
			
			//attribution des missions
			randomNum = ThreadLocalRandom.current().nextInt(0, this.missionsDispo.size());
			this.joueurs.get(i).mission = this.missionsDispo.get(randomNum);
			if(this.joueurs.get(i).mission.enonce.charAt(0)== "D".charAt(0)) {
				randomNum = ThreadLocalRandom.current().nextInt(0, this.nbreJoueursTotal);
				while(randomNum == this.joueurs.get(i).numero) {
					randomNum = ThreadLocalRandom.current().nextInt(0, this.nbreJoueursTotal);
				}
				this.joueurs.get(i).mission.setEnonce(this.joueurs.get(i).mission.enonce+randomNum);
			}
			
			//attribution des territoires
			for(int j=0 ; j<territoiresParJoueur ; j++) {
				randomNum2 = ThreadLocalRandom.current().nextInt(0, territoires.size());
				this.joueurs.get(i).territoires.add(territoires.get(randomNum2));
				territoires.get(randomNum2).setProprietaire(this.joueurs.get(i));
				territoires.remove(randomNum2);
			}
			
			//attribution des armees
			for(int j=1; j<50-5*this.nbreJoueursTotal +1 ; j++) {
				this.joueurs.get(i).nbRenfort++;
			}
		}
		
		ArrayList <Joueur> joueursChanceux = new ArrayList();
		
		//les territoires non distribues sont donnes aleatoirement a des joueurs differents
		while(!territoires.isEmpty()) {
			randomNum = ThreadLocalRandom.current().nextInt(0, this.joueurs.size());
			if(!joueursChanceux.contains(this.joueurs.get(randomNum))) {
				randomNum2 = ThreadLocalRandom.current().nextInt(0, territoires.size());
				this.joueurs.get(randomNum).territoires.add(territoires.get(randomNum2));
				territoires.get(randomNum2).setProprietaire(this.joueurs.get(randomNum));
				territoires.remove(randomNum2);
				joueursChanceux.add(this.joueurs.get(randomNum));
			}
		}	
	}
	
	
	
	//on increment le compteur du nombre de tours
	public void tourJoueur(Joueur joueur) {
		if(joueur.Humain) {
			joueur.appelRenforts();
			joueur.action(this);
		}
		else {
			//code intell. artif.
		}
	}
	
	public void ajouterMissions(int nbreJoueurs) {
		this.missionsDispo.add(new Missions("Contr�ler 3 r�gions et au moins 18 territoires", 1));
		this.missionsDispo.add(new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion", 2));
		if(nbreJoueurs == 2) {
			this.missionsDispo.add(new Missions("Conqu�rir tous les territoires", 3));
			this.missionsDispo.add(new Missions("Contr�ler 30 territoires", 4));
		}
		else if(nbreJoueurs == 3) {
			this.missionsDispo.add(new Missions("Conqu�rir tous les territoires", 3));
			this.missionsDispo.add(new Missions("Contr�ler 30 territoires", 4));
			this.missionsDispo.add(new Missions("D�truire le joueur ", 5));
			this.missionsDispo.add(new Missions("Contr�ler 18 territoires avec au moins 2 arm�es", 6));
		}
		else if(nbreJoueurs == 4 || nbreJoueurs == 5) {
			this.missionsDispo.add(new Missions("D�truire le joueur ", 3));
			this.missionsDispo.add(new Missions("Contr�ler 18 territoires avec au moins 2 arm�es", 4));
			this.missionsDispo.add(new Missions("Contr�ler 24 territoires", 5));
		}
		else if(nbreJoueurs == 6) {
			this.missionsDispo.add(new Missions("D�truire le joueur ", 3));
			this.missionsDispo.add(new Missions("Contr�ler 18 territoires avec au moins 2 arm�es", 4));
			this.missionsDispo.add(new Missions("Contr�ler 21 territoires", 5));
		}
	}
	
	
}