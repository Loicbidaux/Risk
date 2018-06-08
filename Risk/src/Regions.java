import java.util.ArrayList;

public class Regions {
	String nom;
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
	
	//verifie si la region appartient au joueur
	public void appartenanceRegionJoueur(Joueur joueur) {
		boolean appartient = true;
		for(int i = 0 ; i<this.territoires.size(); i++) {
			if(!joueur.territoires.contains(this.territoires.get(i))) {
				if(joueur.regions.contains(this)) {
					joueur.regions.remove(this);
				}
				appartient = false;
				break;
			}
		}
		if(appartient) {
			joueur.regions.add(this);
		}
	}
	
}
