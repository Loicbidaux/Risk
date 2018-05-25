import java.util.ArrayList;

public class Territoires {
	String nom;
	int numero;
	int [][] coordonnees;
	ArrayList <Unite> unites = new ArrayList();
	
	public Territoires(String nom, int[][] coordonnees, int numero) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.coordonnees = coordonnees;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int[][] getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(int[][] coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	public ArrayList <Territoires> voisinsTerritoire(Partie partie) {
		ArrayList <Territoires> voisins = new ArrayList();
		Regions region = partie.appartenanceRegionTerritoire(this);
		
		for(int i = 0 ; i < region.adjMatrices[this.numero].length ; i++) {
			if(region.adjMatrices[this.numero][i] != 0) {
				voisins.add(region.territoires.get(i));
			}
		}
		return voisins;
	}
	
	public void ajoutUnites(ArrayList <Unite> unites) {
		for(int i = 0 ; i < unites.size(); i++) {
			this.unites.add(unites.get(0));
			unites.remove(0);
		}
	}
}
