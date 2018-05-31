import java.util.ArrayList;

public class Regions {
	String nom;
	//Territoires [] noeuds;
	//int adjMatrices [][];
	ArrayList <Territoires> territoires = new ArrayList();
	
	public Regions(String nom, ArrayList<Territoires> territoires) {
		super();
		this.nom = nom;
		this.territoires = territoires;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Territoires> getTerritoires() {
		return territoires;
	}
	public void setTerritoires(ArrayList<Territoires> territoires) {
		this.territoires = territoires;
	}
	
	//public void setAdjMatrices(int[][] adjMatrices) {
		//this.adjMatrices = adjMatrices;
	//}
	public void appartenanceRegionJoueur(Joueur joueur) {
		boolean appartient = true;
		for(int i = 0 ; i<this.territoires.size(); i++) {
			if(!joueur.territoires.contains(this.territoires.get(i))) {
				appartient = false;
				break;
			}
		}
		if(appartient) {
			joueur.regions.add(this);
		}
	}
	
}
