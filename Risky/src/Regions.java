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
	
	public void appartenanceRegion() {
		
	}
}
