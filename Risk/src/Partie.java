import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class Partie {
	public int tour = 0;
	public int nbreJoueursTotal;
	public int nbreJoueursHumains;
	public Territoires [] noeuds;
	public int adjMatrices [][];
	public ArrayList <Joueur> joueurs = new ArrayList();
	public ArrayList <Missions> missionsDispo = new ArrayList();
	public ArrayList <Regions> regions = new ArrayList();
	
	public int flagParametrageDebut = 0;
	public int flagDebutDePartie =0;
	public int flagAjouter =0;
	
	public Partie(int tour, ArrayList <Regions> regions, int adjMatrices [][]) {
		super();
		this.tour = tour;
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
	
	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	//fonction ne se lancant qu'au debut de la partie
	public void miseEnPlace() {
		int randomNum;
		int randomNum2;
		
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
				territoires.get(randomNum2).ajouterSoldat();
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
				territoires.get(randomNum2).ajouterSoldat();
				territoires.get(randomNum2).setProprietaire(this.joueurs.get(randomNum));
				territoires.remove(randomNum2);
				joueursChanceux.add(this.joueurs.get(randomNum));
			}
		}	
		
		for(int i = 0 ; i < this.joueurs.size(); i++) {
			this.joueurs.get(i).setNbRenfort(this.joueurs.get(i).nbRenfort - this.joueurs.get(i).territoires.size());
		}
	}
	
	
	
	//on increment le compteur du nombre de tours
	public void tourJoueur(Joueur joueur, Interface2 frame) {
		if(!joueur.verifDefaite()) {
			if(joueur.Humain) {
				joueur.appelRenforts();
				joueur.attributionRenfort(this,frame);
				joueur.reposTroupes();
				joueur.actionJoueur(this, frame);
			}
			else {
				//code intell. artif.
			}
		}
		else {
			this.joueurs.remove(joueur);
		}
	}
	
	public void ajouterMissions(int nbreJoueurs) {
		this.missionsDispo.add(new Missions("Contrôler 3 régions et au moins 18 territoires", 1));
		this.missionsDispo.add(new Missions("Contrôler la plus grosse région + 1 autre région", 2));
		if(nbreJoueurs == 2) {
			this.missionsDispo.add(new Missions("Conquérir tous les territoires", 3));
			this.missionsDispo.add(new Missions("Contrôler 30 territoires", 4));
		}
		else if(nbreJoueurs == 3) {
			this.missionsDispo.add(new Missions("Conquérir tous les territoires", 3));
			this.missionsDispo.add(new Missions("Contrôler 30 territoires", 4));
			this.missionsDispo.add(new Missions("Détruire le joueur ", 5));
			this.missionsDispo.add(new Missions("Contrôler 18 territoires avec au moins 2 armées", 6));
		}
		else if(nbreJoueurs == 4 || nbreJoueurs == 5) {
			this.missionsDispo.add(new Missions("Détruire le joueur ", 3));
			this.missionsDispo.add(new Missions("Contrôler 18 territoires avec au moins 2 armées", 4));
			this.missionsDispo.add(new Missions("Contrôler 24 territoires", 5));
		}
		else if(nbreJoueurs == 6) {
			this.missionsDispo.add(new Missions("Détruire le joueur ", 3));
			this.missionsDispo.add(new Missions("Contrôler 18 territoires avec au moins 2 armées", 4));
			this.missionsDispo.add(new Missions("Contrôler 21 territoires", 5));
		}
	}
	
	public void parametragePartie(Interface2 frame) {
		while(flagDebutDePartie == 0) {
			
			frame.refreshMenuParametrage();
			frame.parametragePartie(this);
			while(flagAjouter ==0) {
				if(flagDebutDePartie==1) {flagAjouter=1;}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("let's go baby");
			flagAjouter=0;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flagDebutDePartie =0;
		frame.refreshCarte();
	}
	
	
}