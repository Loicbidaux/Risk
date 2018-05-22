import java.util.ArrayList;

public class Joueur {
	int numero;
	String Pseudo;
	Mission mission;
	ArrayList <Unit> armees = new ArrayList();
	ArrayList <Territoires> territoires = new ArrayList();
	
	public Joueur(int numero, String pseudo, Mission mission, ArrayList<Unité> armees,
			ArrayList<Territoires> territoires) {
		super();
		this.numero = numero;
		Pseudo = pseudo;
		this.mission = mission;
		this.armees = armees;
		this.territoires = territoires;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public ArrayList<Unité> getArmees() {
		return armees;
	}

	public void setArmees(ArrayList<Unité> armees) {
		this.armees = armees;
	}

	public ArrayList<Territoires> getTerritoires() {
		return territoires;
	}

	public void setTerritoires(ArrayList<Territoires> territoires) {
		this.territoires = territoires;
	}
	
	public void verifVictoire() {
		
	}
	
	public void appelRenforts() {
		
	}
	
}
