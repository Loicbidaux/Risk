import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Territoires {
	String nom;
	int numero;
	ArrayList <Unite> unites = new ArrayList();
	Joueur proprietaire;
	int [] coordonneesUnite;
	
	public Territoires(String nom, int numero, int[] coordonneesUnite) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.coordonneesUnite = coordonneesUnite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public void setUnites(ArrayList <Unite> unites) {
		this.unites = unites;
	}
	
	public ArrayList<Unite> getUnites() {
		return unites;
	}
	//on cherche les territoires voisins � celui demand� en parcourant un graphe
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!COMPLETER POUR INTERCONTINENTAL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public ArrayList <Territoires> voisinsTerritoire(Partie partie) {
		List <Territoires> territoiresTotal = new LinkedList();
		for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
				territoiresTotal.add(partie.regions.get(i).territoires.get(j));
			}
		}
		ArrayList <Territoires> voisins = new ArrayList();
		Regions region = this.appartenanceRegionTerritoire(partie);
		
		for(int i = 0 ; i < partie.adjMatrices[this.numero].length ; i++) {
			if(partie.adjMatrices[this.numero][i] != 0) {
				voisins.add(territoiresTotal.get(i));
			}
		}
		return voisins;
	}
	
	//on determine les unites qui vont defendre un territoire contre une attaque
	public ArrayList <Unite> unitesDef(int nbreAttaquants) {
		ArrayList <Unite> defenseurs = new ArrayList();
		
		//s'il n'y a qu'une unite sur le territoire, elle est la seule a defendre
		if(this.unites.size()==1) {
			defenseurs.add(this.unites.get(0));
			return defenseurs;
		}
		
		//sinon on choisit les 2 a la priorite de defense la plus haute
		else {
			for(int i = 0 ; i< this.unites.size() ; i++) {
				if(i<=1) {
					defenseurs.add(this.unites.get(i));
				}
				else {
					for(int j = 0 ; j<2 ; j++) {
						if(defenseurs.get(j).defense>this.unites.get(i).defense) {
							defenseurs.set(j, this.unites.get(i));
						}
					}
				}
			}
			return defenseurs;
		}
	}
	
	public void ajouterSoldat() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getUnites());
		attaquants2.add(new Soldat(1,"Soldat"));
		this.setUnites(attaquants2);
	}
	
	public void ajouterCavalier() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getUnites());
		attaquants2.add(new Cavalier(2,"Cavalier"));
		this.setUnites(attaquants2);
	}
	
	public void ajouterCanon() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getUnites());
		attaquants2.add(new Canon(3,"Canon"));
		this.setUnites(attaquants2);
	}
	
	//on regarde a quelle region appartient le territoire demande
	public Regions appartenanceRegionTerritoire(Partie partie) {
		for(int i = 0 ; i < partie.regions.size(); i++) {
			if(partie.regions.get(i).territoires.contains(this)) {
				return partie.regions.get(i);
			}
		}
		return partie.regions.get(0);
	}

}