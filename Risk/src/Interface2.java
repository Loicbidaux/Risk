import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Interface2 extends JFrame {
	
	private boolean FSflag = false;
    private int PrevX, PrevY, PrevWidth, PrevHeight;
    JPanel contentPane = new JPanel();
	JPanel panelMenu = new JPanel();
	JPanel panelCarte = new JPanel();
	
	JLabel lblMenu = new JLabel("Menu");
	JLabel lblMenuParametrage = new JLabel("Menu Parametrage");
	JLabel transition = new JLabel("");
	JLabel lblCarte = new JLabel("Carte");
	JLabel lblEncartBasDroite = new JLabel("EncartBasDroite");
	
	
	JButton btnPlay = new JButton("");
	JButton btnFullscreen = new JButton("FullScreen");
	JButton btnFullscreenCarte = new JButton("FullScreenCarte");
	JButton btnDebutDePartie = new JButton("");
	JButton btnSkip = new JButton("Skip");
	
	CardLayout cl  = new CardLayout();
	
	
	JLabel fenetreRenfort = new JLabel("");
	JLabel fenetreChoixAction = new JLabel("");
	JLabel fenetreAttaque = new JLabel("");
	
	int flagSkip =0;
	
	private Timer timer = null;
	
	public Interface2(){
		super();
		
		build();//On initialise notre fenêtre
	}
	
	private void build(){
		setTitle("Risk Ultimate Sublime Warframe"); //On donne un titre à l'application
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setBounds(0, 0, 1920, 1080);
		setContentPane(buildContentPane());
	}

	private JPanel buildContentPane(){
		//Border border = BorderFactory.createLineBorder(Color.red, 5);
		contentPane.setLayout(cl);
		panelMenu.add(lblMenu);
		panelCarte.add(lblCarte);
		cl.show(contentPane, "1");
		
		
		lblMenu.setBounds(0, 0, 1920, 1080);
		lblMenu.setIcon(new ImageIcon("src/Images/Menu/fond.png"));
		contentPane.add(lblMenu, "1");
		
		lblMenu.add(btnPlay);
		btnPlay.setBounds(823, 930, 285, 60);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		btnPlay.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
		btnPlay.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		btnPlay.setVisible(true);
		
		
		lblMenu.add(btnFullscreen);
		btnFullscreen.setOpaque(false);
		btnFullscreen.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		btnFullscreen.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
		btnFullscreen.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		btnFullscreen.setBounds(1780, 920, 83, 81);
		btnFullscreen.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
		btnFullscreen.setVisible(true);
		
		lblMenuParametrage.setBounds(0, 0, 1920, 1080);
 		lblMenuParametrage.setIcon(new ImageIcon("src/Images/Menu/MENU-RISK-STARWARS.png"));
		contentPane.add(lblMenuParametrage,"2");
		
 		lblMenuParametrage.add(btnDebutDePartie);
 		btnDebutDePartie.setOpaque(false);
 		btnDebutDePartie.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
 		btnDebutDePartie.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
 		btnDebutDePartie.setFocusPainted(false); // On n'affiche pas l'effet de focus.
 		btnDebutDePartie.setBounds(760, 960, 375, 81);
 		btnDebutDePartie.setVisible(true);
 		
 		lblMenuParametrage.add(btnFullscreen);
 		
		transition.setBounds(0, 0, 1920, 1080);
 		transition.setHorizontalAlignment(JLabel.CENTER);
 		transition.setHorizontalAlignment(JLabel.CENTER);
 		transition.setBackground(Color.black);
 		transition.setIcon(new ImageIcon("src/Images/Menu/menuaction/test.gif"));
 		contentPane.add(transition,"3");
 		
 		transition.add(btnSkip);
 		btnSkip.setBounds(1680, 965, 200, 50);
 		btnSkip.setOpaque(false);
 		btnSkip.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
 		btnSkip.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
 		btnSkip.setFocusPainted(false); // On n'affiche pas l'effet de focus.
 		btnSkip.setVisible(true);
 		btnSkip.setIcon(new ImageIcon("src/Images/Menu/menuaction/btnSkip.png"));
		
		
		
		lblCarte.setBounds(0, 0, 1920, 1080);
		lblCarte.setIcon(new ImageIcon("src/Images/carte/BASE-RISK-STARWARS.png"));
		contentPane.add(lblCarte,"4");
		
		lblEncartBasDroite.setBounds(0, 0, 1920, 1080);
		lblEncartBasDroite.setIcon(new ImageIcon("src/Images/Menu/menuaction/ENCART-BASDROIT-VIDE.png"));
		lblCarte.add(lblEncartBasDroite);
		
		
		lblCarte.add(btnFullscreenCarte);
		btnFullscreenCarte.setOpaque(false);
		btnFullscreenCarte.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		btnFullscreenCarte.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
		btnFullscreenCarte.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		btnFullscreenCarte.setBounds(10, 990, 83, 81);
		btnFullscreenCarte.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
		btnFullscreenCarte.setVisible(true);
		
		
		
		
		
		
		
		
		
		MouseListener fullscreen = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (FSflag == false) {
	                PrevX = getX();
	                PrevY = getY();
	                PrevWidth = getWidth();
	                PrevHeight = getHeight();

	                // Destroys the whole JFrame but keeps organized every Component
	                // Needed if you want to use Undecorated JFrame dispose() is the
	                // reason that this trick doesn't work with videos.
	                dispose();
	                setUndecorated(true);

	                setBounds(0, 0, getToolkit().getScreenSize().width,
	                        getToolkit().getScreenSize().height);
	                setVisible(true);
	                btnFullscreen.setIcon(new ImageIcon("src/Images/icone/unfullscreen.png"));
	                btnFullscreenCarte.setIcon(new ImageIcon("src/Images/icone/unfullscreen.png"));
	                FSflag = true;
	            } else {
	                setVisible(true);
	                setBounds(PrevX, PrevY, PrevWidth, PrevHeight);
	                dispose();
	                setUndecorated(false);
	                setVisible(true);
	                btnFullscreen.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
	                btnFullscreenCarte.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
	                FSflag = false;
	            }
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			};
			
		timer = new Timer(29000, new ActionListener(){      // Timer 4 seconds
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "4");
				flagSkip = 1;
			}
		});					
		
		ActionListener Jouer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "2");
				
			}
			
		};
		
		ActionListener DebutDePartie = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			cl.show(contentPane, "3");	
			timer.start();
			}
		};
		
		btnFullscreen.addMouseListener(fullscreen);
		btnFullscreenCarte.addMouseListener(fullscreen);
		btnPlay.addActionListener(Jouer);
		
		btnDebutDePartie.addActionListener(DebutDePartie);
		btnSkip.addMouseListener(new MouseListener() {
		 			
			@Override
			public void mouseReleased(MouseEvent e) {
		 	// TODO Auto-generated method stub
				cl.show(contentPane, "4");
				flagSkip = 1;
		 	}
		 			
		 			
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 	// TODO Auto-generated method stub
		 				
		 	}
		 			
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 	// TODO Auto-generated method stub
		 				
		 	}
		 			
		 	@Override
		 	public void mouseEntered(MouseEvent e) {
		 	// TODO Auto-generated method stub
		 				
		 	}
		 			
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 	// TODO Auto-generated method stub
		 				
		 	}
		});
		
		return contentPane;
	}
	
	
	public void affichageUniteCarte(Partie partie ) {
		String couleur;
		String camp;
		ArrayList <Unite> uniteTerritoire = new ArrayList();
		int nbSoldatTerritoire=0 ;
		int nbCavalierTerritoire = 0;
		int nbCanonTerritoire = 0;
		
		
		int[] coordonneesUnite ;
		
		for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
				couleur = partie.regions.get(i).territoires.get(j).proprietaire.Couleur;
				camp = partie.regions.get(i).territoires.get(j).proprietaire.camp;
				uniteTerritoire = partie.regions.get(i).territoires.get(j).unites;
				coordonneesUnite = partie.regions.get(i).territoires.get(j).coordonneesUnite;
				
				for(int k = 0; k<partie.regions.get(i).territoires.get(j).unites.size(); k++) {
					if(partie.regions.get(i).territoires.get(j).unites.get(k).cout == 1) {
						nbSoldatTerritoire++;
					}
					else if(partie.regions.get(i).territoires.get(j).unites.get(k).cout == 3) {
						nbCavalierTerritoire ++;
					}
					else {
						nbCanonTerritoire ++;
					}
				}
				
				JLabel btnUnite = new JLabel("");
				
				btnUnite.setName(partie.regions.get(i).territoires.get(j).nom);
				lblCarte.add(btnUnite);
				btnUnite.setOpaque(false);
				btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 43);
				btnUnite.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/unite.png"));
				
				btnUnite.setVisible(true);
				
				JLabel nbSoldat = new JLabel("<html><font color = 'white'>"+String.valueOf(nbSoldatTerritoire)+"</html>");
				nbSoldat.setBounds(coordonneesUnite[0]+3, coordonneesUnite[1]+40, 25, 25);
				nbSoldat.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblCarte.add(nbSoldat);
				nbSoldat.setHorizontalTextPosition(JLabel.CENTER);
				
				JLabel nbCavalier = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCavalierTerritoire)+"</html>");
				nbCavalier.setBounds(coordonneesUnite[0]+40, coordonneesUnite[1]+40, 25, 25);
				nbCavalier.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblCarte.add(nbCavalier);
				nbCavalier.setHorizontalTextPosition(JLabel.CENTER);
				
				JLabel nbCanon = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCanonTerritoire)+"</html>");
				nbCanon.setBounds(coordonneesUnite[0]+75, coordonneesUnite[1]+40, 25, 25);
				nbCanon.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblCarte.add(nbCanon);
				nbCanon.setHorizontalTextPosition(JLabel.CENTER);
				
				nbSoldatTerritoire=0 ;
				nbCavalierTerritoire = 0;
				nbCanonTerritoire = 0;
				
			}}
	}

	public void affichageUniteCarteDebutPartie(Partie partie ) {
		 		
		while (flagSkip == 0) {
		 	try {
		 		Thread.sleep(1);
		 	} catch (InterruptedException e) {
		 	// TODO Auto-generated catch block
		 		e.printStackTrace();
		 		}
		 	}
		 		
		 	String couleur ;
		 	String camp ;
		 	ArrayList <Unite> uniteTerritoire = new ArrayList();
		 	int nbSoldatTerritoire=0 ;
		 	int nbCavalierTerritoire = 0;
		 	int nbCanonTerritoire = 0;
		 				 		
		 	int[] coordonneesUnite ;
		 		
			for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
		 	try {
		 		Thread.sleep(500);
		 	} catch (InterruptedException e) {
		 	// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
		 						
		 	couleur = partie.regions.get(i).territoires.get(j).proprietaire.Couleur;
		 	camp = partie.regions.get(i).territoires.get(j).proprietaire.camp;
		 	uniteTerritoire = partie.regions.get(i).territoires.get(j).unites;
		 	coordonneesUnite = partie.regions.get(i).territoires.get(j).coordonneesUnite;
		 				
			for(int k = 0; k<partie.regions.get(i).territoires.get(j).unites.size(); k++) {
				if(partie.regions.get(i).territoires.get(j).unites.get(k).cout == 1) {
					nbSoldatTerritoire++;
				}
			}
						
			JLabel btnUnite = new JLabel("");
						
			btnUnite.setName(partie.regions.get(i).territoires.get(j).nom);
			lblCarte.add(btnUnite);
			btnUnite.setOpaque(false);
			btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 43);
			btnUnite.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/unite.png"));
			btnUnite.setVisible(true);
						
			JLabel nbSoldat = new JLabel("<html><font color = 'white'>"+String.valueOf(nbSoldatTerritoire)+"</html>");
			nbSoldat.setBounds(coordonneesUnite[0]+3, coordonneesUnite[1]+40, 25, 25);
			nbSoldat.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
			lblCarte.add(nbSoldat);
			nbSoldat.setHorizontalTextPosition(JLabel.CENTER);
						
			JLabel nbCavalier = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCavalierTerritoire)+"</html>");
			nbCavalier.setBounds(coordonneesUnite[0]+40, coordonneesUnite[1]+40, 25, 25);
			nbCavalier.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
			lblCarte.add(nbCavalier);
			nbCavalier.setHorizontalTextPosition(JLabel.CENTER);
						
			JLabel nbCanon = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCanonTerritoire)+"</html>");
			nbCanon.setBounds(coordonneesUnite[0]+75, coordonneesUnite[1]+40, 25, 25);
			nbCanon.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
			lblCarte.add(nbCanon);
			nbCanon.setHorizontalTextPosition(JLabel.CENTER);
						
			nbSoldatTerritoire=0 ;
			nbCavalierTerritoire = 0;
			nbCanonTerritoire = 0;
						
			}}
		}
		 	
		public void parametragePartie(Partie partie) {
				
			JButton joueurEmpire = new JButton();
			JButton joueurRebelle = new JButton();
			JButton iaEmpire = new JButton();
			JButton iaRebelle = new JButton();
			JButton ajouterJoueur = new JButton();
			JButton ajouterIa = new JButton();
				 
			lblMenuParametrage.add(joueurEmpire);
			joueurEmpire.setOpaque(false);
			joueurEmpire.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			joueurEmpire.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			joueurEmpire.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			joueurEmpire.setBounds(505, 320, 115, 115);
			joueurEmpire.setVisible(true);
				
			lblMenuParametrage.add(joueurRebelle);
			joueurRebelle.setOpaque(false);
			joueurRebelle.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			joueurRebelle.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			joueurRebelle.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			joueurRebelle.setBounds(735, 320, 115, 115);
			joueurRebelle.setVisible(true);
				
			lblMenuParametrage.add(iaEmpire);
			iaEmpire.setOpaque(false);
			iaEmpire.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			iaEmpire.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			iaEmpire.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			iaEmpire.setBounds(1055, 320, 115, 115);
			iaEmpire.setVisible(true);
				
			lblMenuParametrage.add(iaRebelle);
			iaRebelle.setOpaque(false);
			iaRebelle.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			iaRebelle.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			iaRebelle.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			iaRebelle.setBounds(1285, 320, 115, 115);
			iaRebelle.setVisible(true);
				
			lblMenuParametrage.add(ajouterJoueur);
			ajouterJoueur.setOpaque(false);
			ajouterJoueur.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			ajouterJoueur.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			ajouterJoueur.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			ajouterJoueur.setBounds(490, 470, 365, 71);
			ajouterJoueur.setVisible(true);
				
			lblMenuParametrage.add(ajouterIa);
			ajouterIa.setOpaque(false);
			ajouterIa.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			ajouterIa.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			ajouterIa.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			ajouterIa.setBounds(1055, 470, 365, 71);
			ajouterIa.setVisible(true);
				
			lblMenuParametrage.validate();
			lblMenuParametrage.repaint();
	}
	
	public void affichageRenfort (Joueur joueur) {
	
		
		int[] coordonneesUnite ;
		String camp = joueur.camp;
		String couleur = joueur.Couleur;
		int nbSoldatTerritoire=0;
		int nbCavalierTerritoire=0;
		int nbCanonTerritoire=0;
		
		
		fenetreRenfort.setBounds(0,0, 1920, 1080);
		//fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/renfort.png"));
		fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/rebelles/renfort.png"));
		lblEncartBasDroite.add(fenetreRenfort);
		
		JButton finDePhase = new JButton("");
		finDePhase.setIcon(new ImageIcon("src/Images/Menu/menuaction/FIN.png"));
		finDePhase.setOpaque(false);
		finDePhase.setBounds(1760, 765, 92, 60);
		finDePhase.setBorderPainted(true);
		finDePhase.setContentAreaFilled(false);
		finDePhase.setFocusPainted(false);
		finDePhase.setVisible(true);
		fenetreRenfort.add(finDePhase);
		
		finDePhase.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(joueur.getNbRenfort() == 0) {
					
					joueur.setFlagFinDePhase(1);
					
					fenetreRenfort.removeAll();
					fenetreRenfort.repaint();
					fenetreRenfort.validate();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
				nbSoldatTerritoire = 0;
				nbCavalierTerritoire = 0;
				nbCanonTerritoire = 0;
				coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;
				
				for(int k = 0; k<joueur.territoires.get(i).unites.size(); k++) {
					if(joueur.territoires.get(i).unites.get(k).cout == 1) {
						nbSoldatTerritoire++;
					}
					else if(joueur.territoires.get(i).unites.get(k).cout == 3) {
						nbCavalierTerritoire ++;
					}
					else {
						nbCanonTerritoire ++;
					}
				}

				JButton btnUnite = new JButton("");
				
				lblCarte.add(btnUnite);
				btnUnite.setOpaque(false);
				btnUnite.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
				btnUnite.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
				btnUnite.setFocusPainted(false);
				btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 70);
				btnUnite.setVisible(true);
				
				
				JLabel nbSoldat = new JLabel("<html><font color = 'white'><font size = '15'>"+0+"</html>");
				nbSoldat.setHorizontalAlignment(JLabel.CENTER);
				nbSoldat.setVerticalAlignment(JLabel.CENTER);
				nbSoldat.setOpaque(false);
				nbSoldat.setBounds(1465, 940, 60, 60);
				nbSoldat.setVisible(false);
				
				JButton nbSoldatPlus = new JButton("");
				nbSoldatPlus.setOpaque(false);
				nbSoldatPlus.setBounds(1430, 960, 33, 30);
				nbSoldatPlus.setBorderPainted(true);
				nbSoldatPlus.setContentAreaFilled(false);
				nbSoldatPlus.setFocusPainted(false);
				nbSoldatPlus.setVisible(true);
				
				JButton nbSoldatMoins = new JButton("");
				nbSoldatMoins.setOpaque(false);
				nbSoldatMoins.setBounds(1530, 960, 25, 30);
				nbSoldatMoins.setBorderPainted(true);
				nbSoldatMoins.setContentAreaFilled(false);
				nbSoldatMoins.setFocusPainted(false);
				nbSoldatMoins.setVisible(true);
				
				
				
				
				JLabel nbCavalier = new JLabel("<html><font color = 'white'><font size = '15'>"+0+"</html>");
				nbCavalier.setHorizontalAlignment(JLabel.CENTER);
				nbCavalier.setVerticalAlignment(JLabel.CENTER);
				nbCavalier.setOpaque(false);
				nbCavalier.setBounds(1615, 940, 60, 60);
				nbCavalier.setVisible(false);
				
				JButton nbCavalierPlus = new JButton("");
				nbCavalierPlus.setOpaque(false);
				nbCavalierPlus.setBounds(1580, 960, 33, 30);
				nbCavalierPlus.setBorderPainted(true);
				nbCavalierPlus.setContentAreaFilled(false);
				nbCavalierPlus.setFocusPainted(false);
				nbCavalierPlus.setVisible(true);
				
				JButton nbCavalierMoins = new JButton("");
				nbCavalierMoins.setOpaque(false);
				nbCavalierMoins.setBounds(1680, 960, 25, 30);
				nbCavalierMoins.setBorderPainted(true);
				nbCavalierMoins.setContentAreaFilled(false);
				nbCavalierMoins.setFocusPainted(false);
				nbCavalierMoins.setVisible(true);
				
				
				
				JLabel nbCanon = new JLabel("<html><font color = 'white'><font size = '15'>"+0+"</html>");
				nbCanon.setHorizontalAlignment(JLabel.CENTER);
				nbCanon.setVerticalAlignment(JLabel.CENTER);
				nbCanon.setOpaque(false);
				nbCanon.setBounds(1770, 940, 60, 60);
				nbCanon.setVisible(false);
				
				JButton nbCanonPlus = new JButton("");
				nbCanonPlus.setOpaque(false);
				nbCanonPlus.setBounds(1735, 960, 33, 30);
				nbCanonPlus.setBorderPainted(true);
				nbCanonPlus.setContentAreaFilled(false);
				nbCanonPlus.setFocusPainted(false);
				nbCanonPlus.setVisible(true);
				
				JButton nbCanonMoins = new JButton("");
				nbCanonMoins.setOpaque(false);
				nbCanonMoins.setBounds(1830, 960, 25, 30);
				nbCanonMoins.setBorderPainted(true);
				nbCanonMoins.setContentAreaFilled(false);
				nbCanonMoins.setFocusPainted(false);
				nbCanonMoins.setVisible(true);
				
				
				
				JLabel nbRenfortDisponible = new JLabel("<html><font color = 'white'><font size = '15'>"+String.valueOf(joueur.getNbRenfort())+"</html>");
				nbRenfortDisponible.setHorizontalTextPosition(JLabel.CENTER);
				nbRenfortDisponible.setOpaque(false);
				nbRenfortDisponible.setBounds(1730, 775, 112, 70);
				nbRenfortDisponible.setVisible(false);
				
				JButton renfortValider = new JButton("");
				renfortValider.setOpaque(false);
				renfortValider.setBounds(1560, 1010, 200, 50);
				renfortValider.setBorderPainted(true);
				renfortValider.setContentAreaFilled(false);
				renfortValider.setFocusPainted(false);
				renfortValider.setVisible(true);
				
				final Territoires territoire = joueur.territoires.get(i);
				final int maxRenfort =joueur.getNbRenfort();
				
				btnUnite.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println("haha");
						
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.add(nbSoldatPlus);
						nbSoldatPlus.setVisible(true);
						fenetreRenfort.add(nbSoldatMoins);
						nbSoldatMoins.setVisible(true);
						
						fenetreRenfort.add(nbCavalier);
						nbCavalier.setVisible(true);
						fenetreRenfort.add(nbCavalierPlus);
						nbCavalierPlus.setVisible(true);
						fenetreRenfort.add(nbCavalierMoins);
						nbCavalierMoins.setVisible(true);
						
						fenetreRenfort.add(nbCanon);
						nbCanon.setVisible(true);
						fenetreRenfort.add(nbCanonPlus);
						nbCanonPlus.setVisible(true);
						fenetreRenfort.add(nbCanonMoins);
						nbCanonMoins.setVisible(true);
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						
						fenetreRenfort.add(renfortValider);
						renfortValider.setVisible(true);
						
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.removeAll();
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
										
				

				nbSoldatPlus.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))-1;
						
						if (j>=0) {
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7))+1;
						nbSoldat.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbSoldat);
							nbSoldat.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbSoldat);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});

				nbCavalierPlus.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))-3;
						
						if (j>=0) {
						int i = Integer.parseInt(nbCavalier.getText().substring(46,nbCavalier.getText().length()-7))+1;
						nbCavalier.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbCavalier);
						nbCavalier.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbCavalier);
							nbCavalier.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbCavalier);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				nbCanonPlus.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))-7;
						
						if (j>=0) {
						int i = Integer.parseInt(nbCanon.getText().substring(46,nbCanon.getText().length()-7))+1;
						nbCanon.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbCanon);
						nbCanon.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbCanon);
							nbCanon.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbCanon);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});

				
				nbSoldatMoins.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))+1;
						
						if (j<=maxRenfort && Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7)) >=1 ) {
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7))-1;
						nbSoldat.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbSoldat);
							nbSoldat.setVisible(true);
							fenetreRenfort.add(nbSoldatPlus);
							nbSoldatPlus.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbSoldat);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				nbCavalierMoins.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))+3;
						
						if (j<=maxRenfort && Integer.parseInt(nbCavalier.getText().substring(46,nbCavalier.getText().length()-7)) >=1 ) {
						int i = Integer.parseInt(nbCavalier.getText().substring(46,nbCavalier.getText().length()-7))-1;
						nbCavalier.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbCavalier);
						nbCavalier.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbCavalier);
							nbCavalier.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbCavalier);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				nbCanonMoins.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))+7;
						
						if (j<=maxRenfort && Integer.parseInt(nbCanon.getText().substring(46,nbCanon.getText().length()-7)) >=1 ) {
						int i = Integer.parseInt(nbCanon.getText().substring(46,nbCanon.getText().length()-7))-1;
						nbCanon.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbCanon);
						nbCanon.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbCanon);
							nbCanon.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbCanon);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
				
				renfortValider.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7));
						int j = Integer.parseInt(nbCavalier.getText().substring(46,nbCavalier.getText().length()-7));
						int k = Integer.parseInt(nbCanon.getText().substring(46,nbCanon.getText().length()-7));
						int renfortDisponibleValider = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7)) ;
						
						
						for(int ii = 0;ii<i;ii++) {
							
							joueur.ajouterSoldat();
							territoire.ajouterSoldat();
							
						}
						
						for(int jj =0;jj<j;jj++) {
							joueur.ajouterCavalier();
							territoire.ajouterCavalier();
						}
						
						for(int kk =0;kk<k;kk++) {
							joueur.ajouterCanon();
							territoire.ajouterCanon();
						}
						
						
						joueur.setNbRenfort(renfortDisponibleValider);
						joueur.setFlagValider(1);
						
						fenetreRenfort.removeAll();
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		}	
	}

	public void affichageRenfortDebutPartie (Joueur joueur) {
		
		
		int[] coordonneesUnite ;
		String camp = joueur.camp;
		String couleur = joueur.Couleur;
		int nbSoldatTerritoire=0;
		int nbCavalierTerritoire=0;
		int nbCanonTerritoire=0;
		
		
		fenetreRenfort.setBounds(0,0, 1920, 1080);
		//fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/renfort.png"));
		fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/empire/renfort.png"));
		lblEncartBasDroite.add(fenetreRenfort);
		
		JButton finDePhase = new JButton("");
		finDePhase.setOpaque(false);
		finDePhase.setBounds(1760, 765, 92, 60);
		finDePhase.setBorderPainted(true);
		finDePhase.setContentAreaFilled(false);
		finDePhase.setFocusPainted(false);
		finDePhase.setVisible(true);
		finDePhase.setIcon(new ImageIcon("src/Images/Menu/menuaction/FIN.png"));
		fenetreRenfort.add(finDePhase);
		
		
		finDePhase.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(joueur.getNbRenfort() == 0) {
					
					joueur.setFlagFinDePhase(1);
					
					fenetreRenfort.removeAll();
					fenetreRenfort.repaint();
					fenetreRenfort.validate();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
				nbSoldatTerritoire = 0;
				nbCavalierTerritoire = 0;
				nbCanonTerritoire = 0;
				coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;
				
				for(int k = 0; k<joueur.territoires.get(i).unites.size(); k++) {
					if(joueur.territoires.get(i).unites.get(k).cout == 1) {
						nbSoldatTerritoire++;
					}
					else if(joueur.territoires.get(i).unites.get(k).cout == 3) {
						nbCavalierTerritoire ++;
					}
					else {
						nbCanonTerritoire ++;
					}
				}

				JButton btnUnite = new JButton("");
				
				lblCarte.add(btnUnite);
				btnUnite.setOpaque(false);
				btnUnite.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
				btnUnite.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
				btnUnite.setFocusPainted(false);
				btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 70);
				btnUnite.setVisible(true);
				
				
				JLabel nbSoldat = new JLabel("<html><font color = 'white'><font size = '15'>"+0+"</html>");
				nbSoldat.setHorizontalAlignment(JLabel.CENTER);
				nbSoldat.setVerticalAlignment(JLabel.CENTER);
				nbSoldat.setOpaque(false);
				nbSoldat.setBounds(1615, 940, 60, 60);
				nbSoldat.setVisible(false);
				
				JButton nbSoldatPlus = new JButton("");
				nbSoldatPlus.setOpaque(false);
				nbSoldatPlus.setBounds(1580, 960, 33, 30);
				nbSoldatPlus.setBorderPainted(true);
				nbSoldatPlus.setContentAreaFilled(false);
				nbSoldatPlus.setFocusPainted(false);
				nbSoldatPlus.setVisible(true);
				
				JButton nbSoldatMoins = new JButton("");
				nbSoldatMoins.setOpaque(false);
				nbSoldatMoins.setBounds(1680, 960, 25, 30);
				nbSoldatMoins.setBorderPainted(true);
				nbSoldatMoins.setContentAreaFilled(false);
				nbSoldatMoins.setFocusPainted(false);
				nbSoldatMoins.setVisible(true);
				
				
				
				JLabel nbRenfortDisponible = new JLabel("<html><font color = 'white'><font size = '15'>"+String.valueOf(joueur.getNbRenfort())+"</html>");
				nbRenfortDisponible.setHorizontalTextPosition(JLabel.CENTER);
				nbRenfortDisponible.setOpaque(false);
				nbRenfortDisponible.setBounds(1730, 775, 112, 70);
				nbRenfortDisponible.setVisible(false);
				
				JButton renfortValider = new JButton("");
				renfortValider.setOpaque(false);
				renfortValider.setBounds(1560, 1010, 200, 50);
				renfortValider.setBorderPainted(true);
				renfortValider.setContentAreaFilled(false);
				renfortValider.setFocusPainted(false);
				renfortValider.setVisible(true);
				
				
				
				
				final Territoires territoire = joueur.territoires.get(i);
				final int maxRenfort =joueur.getNbRenfort();
				
				btnUnite.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println("haha");
						
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.add(nbSoldatPlus);
						nbSoldatPlus.setVisible(true);
						fenetreRenfort.add(nbSoldatMoins);
						nbSoldatMoins.setVisible(true);
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						
						fenetreRenfort.add(renfortValider);
						renfortValider.setVisible(true);
						
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.removeAll();
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
													

				nbSoldatPlus.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))-1;
						
						if (j>=0) {
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7))+1;
						nbSoldat.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbSoldat);
							nbSoldat.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbSoldat);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			
				
				nbSoldatMoins.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int j = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7))+1;
						
						if (j<=maxRenfort && Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7)) >=1 ) {
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7))-1;
						nbSoldat.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(i)+"</html>");
						
						nbRenfortDisponible.setText("<html><font color = 'white'><font size = '15'>"+String.valueOf(j)+"</html>");
						
						
						fenetreRenfort.add(nbRenfortDisponible);
						nbRenfortDisponible.setVisible(true);
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
						}
						
						
						else {
							fenetreRenfort.add(nbRenfortDisponible);
							nbRenfortDisponible.setVisible(true);
							fenetreRenfort.add(nbSoldat);
							nbSoldat.setVisible(true);
							fenetreRenfort.add(nbSoldatPlus);
							nbSoldatPlus.setVisible(true);
							fenetreRenfort.repaint();
							fenetreRenfort.validate();
						}
					}
					
					
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.remove(nbRenfortDisponible);
						fenetreRenfort.remove(nbSoldat);
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
							
				
				renfortValider.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						int i = Integer.parseInt(nbSoldat.getText().substring(46,nbSoldat.getText().length()-7));
						int renfortDisponibleValider = Integer.parseInt(nbRenfortDisponible.getText().substring(46,nbRenfortDisponible.getText().length()-7)) ;
						
						
						for(int ii = 0;ii<i;ii++) {
							
							joueur.ajouterSoldat();
							territoire.ajouterSoldat();
							
						}
						
						
						joueur.setNbRenfort(renfortDisponibleValider);
						joueur.setFlagValider(1);
						
						fenetreRenfort.removeAll();
						fenetreRenfort.repaint();
						fenetreRenfort.validate();
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		}
	}
	
	public void choixAttaqueDeplacement(Partie partie, Joueur joueur) {
		int nbSoldatTerritoire;
		int nbCavalierTerritoire;
		int nbCanonTerritoire;
		int [] coordonneesUnite;
		
		lblEncartBasDroite.removeAll();
		
		fenetreChoixAction.setBounds(0,0,1920,1080);
		fenetreChoixAction.setIcon(new ImageIcon("src/Images/Menu/menuaction/ATTAQUE-DEPLACEMENT.png"));
		
		JButton finDePhase = new JButton("");
		finDePhase.setIcon(new ImageIcon("src/Images/Menu/menuaction/FIN.png"));
		finDePhase.setOpaque(false);
		finDePhase.setBounds(1560, 735, 200, 50);
		finDePhase.setBorderPainted(true);
		finDePhase.setContentAreaFilled(false);
		finDePhase.setFocusPainted(false);
		finDePhase.setVisible(true);
		lblEncartBasDroite.add(finDePhase);
		
		finDePhase.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				joueur.setFlagFinDePhase(1);
				lblEncartBasDroite.removeAll();
				lblEncartBasDroite.repaint();
				lblEncartBasDroite.validate();
				fenetreAttaque.removeAll();
				fenetreAttaque.repaint();
				fenetreAttaque.validate();
			}
		});
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
			final Territoires territoireAttaquant = joueur.territoires.get(i);
			ArrayList <JButton> territoiresAllies = new ArrayList();
			ArrayList <JButton> territoiresEnnemis = new ArrayList();
			nbSoldatTerritoire = 0;
			nbCavalierTerritoire = 0;
			nbCanonTerritoire = 0;
			coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;
			
			for(int k = 0; k<joueur.territoires.get(i).unites.size(); k++) {
				if(joueur.territoires.get(i).unites.get(k).disponibilite != 0) {
					if(joueur.territoires.get(i).unites.get(k).cout == 1) {
						nbSoldatTerritoire++;
					}
					else if(joueur.territoires.get(i).unites.get(k).cout == 3) {
						nbCavalierTerritoire ++;
					}
					else {
						nbCanonTerritoire ++;
					}
				}
			}
			
			final int nbSoldatTerritoireFinal = nbSoldatTerritoire;
			final int nbCavalierTerritoireFinal = nbCavalierTerritoire;
			final int nbCanonTerritoireFinal = nbCanonTerritoire;
			
			System.out.println(joueur.territoires.get(i).voisinsTerritoire(partie).size());
			for(int j = 0 ; j<joueur.territoires.get(i).voisinsTerritoire(partie).size() ; j++) {
				if(joueur.territoires.contains(joueur.territoires.get(i).voisinsTerritoire(partie).get(j))) {
					JButton territoireAllie = new JButton("");
					territoireAllie.setOpaque(false);
					territoireAllie.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
					territoireAllie.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
					territoireAllie.setFocusPainted(false);
					territoireAllie.setText(joueur.territoires.get(i).voisinsTerritoire(partie).get(j).nom);
					territoiresAllies.add(territoireAllie);
					territoireAllie.setBounds(1700, 850 + territoiresAllies.indexOf(territoireAllie)*30, 112, 20);
					
					territoireAllie.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub

						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				else {
					final Territoires territoireDefense = joueur.territoires.get(i).voisinsTerritoire(partie).get(j);
					
					JButton territoireEnnemi = new JButton("");
					territoireEnnemi.setOpaque(false);
					territoireEnnemi.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
					territoireEnnemi.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
					territoireEnnemi.setFocusPainted(false);
					territoireEnnemi.setText(joueur.territoires.get(i).voisinsTerritoire(partie).get(j).nom);
					territoiresEnnemis.add(territoireEnnemi);
					territoireEnnemi.setBounds(1500, 850 + territoiresEnnemis.indexOf(territoireEnnemi)*30, 112, 20);
					territoireEnnemi.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							lblEncartBasDroite.remove(fenetreChoixAction);
							lblEncartBasDroite.repaint();
							lblEncartBasDroite.validate();
							fenetreAttaque.setBounds(0,0,1920,1080);
							fenetreAttaque.setIcon(new ImageIcon("src/Images/Menu/menuaction/empire/attaque.png"));
							lblEncartBasDroite.add(fenetreAttaque);
							fenetreAttaque.removeAll();
							fenetreAttaque.add(finDePhase);
							
							JLabel soldatAttaque = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							soldatAttaque.setHorizontalAlignment(JLabel.CENTER);
							soldatAttaque.setVerticalAlignment(JLabel.CENTER);
							soldatAttaque.setOpaque(false);
							soldatAttaque.setBounds(1465, 933, 60, 60);
							soldatAttaque.setVisible(true);
							fenetreAttaque.add(soldatAttaque);
							
							JLabel soldatAttaqueDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbSoldatTerritoireFinal+"</html>");
							soldatAttaqueDispo.setHorizontalAlignment(JLabel.CENTER);
							soldatAttaqueDispo.setVerticalAlignment(JLabel.CENTER);
							soldatAttaqueDispo.setOpaque(false);
							soldatAttaqueDispo.setBounds(1465, 957, 60, 60);
							soldatAttaqueDispo.setVisible(true);
							fenetreAttaque.add(soldatAttaqueDispo);
							
							JLabel cavalierAttaque = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							cavalierAttaque.setHorizontalAlignment(JLabel.CENTER);
							cavalierAttaque.setVerticalAlignment(JLabel.CENTER);
							cavalierAttaque.setOpaque(false);
							cavalierAttaque.setBounds(1615, 933, 60, 60);
							cavalierAttaque.setVisible(true);
							fenetreAttaque.add(cavalierAttaque);
							
							JLabel cavalierAttaqueDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbCavalierTerritoireFinal+"</html>");
							cavalierAttaqueDispo.setHorizontalAlignment(JLabel.CENTER);
							cavalierAttaqueDispo.setVerticalAlignment(JLabel.CENTER);
							cavalierAttaqueDispo.setOpaque(false);
							cavalierAttaqueDispo.setBounds(1615, 957, 60, 60);
							cavalierAttaqueDispo.setVisible(true);
							fenetreAttaque.add(cavalierAttaqueDispo);
							
							JLabel canonAttaque = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							canonAttaque.setHorizontalAlignment(JLabel.CENTER);
							canonAttaque.setVerticalAlignment(JLabel.CENTER);
							canonAttaque.setOpaque(false);
							canonAttaque.setBounds(1770, 933, 60, 60);
							canonAttaque.setVisible(true);
							fenetreAttaque.add(canonAttaque);
							
							JLabel canonAttaqueDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbCanonTerritoireFinal+"</html>");
							canonAttaqueDispo.setHorizontalAlignment(JLabel.CENTER);
							canonAttaqueDispo.setVerticalAlignment(JLabel.CENTER);
							canonAttaqueDispo.setOpaque(false);
							canonAttaqueDispo.setBounds(1770, 957, 60, 60);
							canonAttaqueDispo.setVisible(true);
							fenetreAttaque.add(canonAttaqueDispo);
							
							JButton attaquer = new JButton("");
							attaquer.setOpaque(false);
							attaquer.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							attaquer.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							attaquer.setFocusPainted(false);
							attaquer.setBounds(1560, 1010, 200, 50);
							fenetreAttaque.add(attaquer);
							attaquer.setVisible(false);
							
							attaquer.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(soldatAttaque.getText().substring(44,soldatAttaque.getText().length()-7));
									int k = Integer.parseInt(cavalierAttaque.getText().substring(44,cavalierAttaque.getText().length()-7));
									int l = Integer.parseInt(canonAttaque.getText().substring(44,canonAttaque.getText().length()-7));
									ArrayList <Unite> unitesDef = territoireDefense.unitesDef(j+k+l);
									ArrayList <Unite> unitesAtk = new ArrayList();
									for(int q = 0 ; q < territoireAttaquant.unites.size() ; q++) {
										if(j!=0 && territoireAttaquant.unites.get(q).cout==1) {
											unitesAtk.add(territoireAttaquant.unites.get(q));
											j--;
										}
										if(k!=0 && territoireAttaquant.unites.get(q).cout==3) {
											unitesAtk.add(territoireAttaquant.unites.get(q));
											k--;
										}
										if(l!=0 && territoireAttaquant.unites.get(q).cout==7) {
											unitesAtk.add(territoireAttaquant.unites.get(q));
											l--;
										}
									}
									
									Unite unitesMortes [][] = joueur.issueBataille(unitesDef, unitesAtk);
									System.out.println("Nbre d'attaquants : " + unitesAtk.size());
									System.out.println("Avant A: " + territoireAttaquant.unites.size());
									System.out.println("Avant D: " + territoireDefense.unites.size());
									joueur.resultatsBataille(unitesMortes, territoireDefense, territoireAttaquant, unitesAtk);
									System.out.println("Apres A: " +territoireAttaquant.unites.size());
									System.out.println("Apres D: " +territoireDefense.unites.size());
									if(territoireDefense.proprietaire==territoireAttaquant.proprietaire) {
										System.out.println("Je peux m'attaquer ?????");
									}
									else {
										System.out.println("Il n'a pas cédé !");
									}
								
									joueur.setFlagValider(1);	
									lblEncartBasDroite.removeAll();
									lblEncartBasDroite.repaint();
									lblEncartBasDroite.validate();
									
									
									//System.out.println("La defense a perdu " + unitesMortes[0].length + " unites ...");
									//System.out.println("L'attaque a perdu " + unitesMortes[1].length + " unites ...");
								}
							});
							
							JButton soldatAttaquePlus = new JButton("");
							soldatAttaquePlus.setOpaque(false);
							soldatAttaquePlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							soldatAttaquePlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							soldatAttaquePlus.setFocusPainted(false);
							soldatAttaquePlus.setBounds(1430, 960, 33, 30);
							fenetreAttaque.add(soldatAttaquePlus);
							
							soldatAttaquePlus.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(soldatAttaque.getText().substring(44,soldatAttaque.getText().length()-7))+1;
									int k = Integer.parseInt(cavalierAttaque.getText().substring(44,cavalierAttaque.getText().length()-7));
									int l = Integer.parseInt(canonAttaque.getText().substring(44,canonAttaque.getText().length()-7));
									System.out.println("	max : " + nbSoldatTerritoireFinal);
									System.out.println("	j : " + j);
									if (j<=nbSoldatTerritoireFinal && j+k+l<=3 && j+k+l != territoireAttaquant.unites.size()) {
									soldatAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if(j+k+l>0) {
										attaquer.setVisible(true);
									}
								}
							});
							
							JButton soldatAttaqueMoins = new JButton("");
							soldatAttaqueMoins.setOpaque(false);
							soldatAttaqueMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							soldatAttaqueMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							soldatAttaqueMoins.setFocusPainted(false);
							soldatAttaqueMoins.setBounds(1530, 960, 25, 30);
							fenetreAttaque.add(soldatAttaqueMoins);
							
							soldatAttaqueMoins.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(soldatAttaque.getText().substring(44,soldatAttaque.getText().length()-7))-1;
									
									if (j>=0) {
									soldatAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if (j<=0) {
										attaquer.setVisible(false);
									}
								}
							});
							
							JButton cavalierAttaquePlus = new JButton("");
							cavalierAttaquePlus.setOpaque(false);
							cavalierAttaquePlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							cavalierAttaquePlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							cavalierAttaquePlus.setFocusPainted(false);
							cavalierAttaquePlus.setBounds(1580, 960, 33, 30);
							fenetreAttaque.add(cavalierAttaquePlus);
							
							cavalierAttaquePlus.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(cavalierAttaque.getText().substring(44,cavalierAttaque.getText().length()-7))+1;
									int k = Integer.parseInt(soldatAttaque.getText().substring(44,soldatAttaque.getText().length()-7));
									int l = Integer.parseInt(canonAttaque.getText().substring(44,canonAttaque.getText().length()-7));
									
									if (j<=nbCavalierTerritoireFinal && j+k+l<=3 && j+k+l != territoireAttaquant.unites.size()) {
									cavalierAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if(j+k+l>0) {
										attaquer.setVisible(true);
									}
								}
							});
							
							JButton cavalierAttaqueMoins = new JButton("");
							cavalierAttaqueMoins.setOpaque(false);
							cavalierAttaqueMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							cavalierAttaqueMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							cavalierAttaqueMoins.setFocusPainted(false);
							cavalierAttaqueMoins.setBounds(1680, 960, 25, 30);
							fenetreAttaque.add(cavalierAttaqueMoins);
							
							cavalierAttaqueMoins.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub	
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(cavalierAttaque.getText().substring(44,cavalierAttaque.getText().length()-7))-1;
									
									if (j>=0) {
										cavalierAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if (j<=0) {
										attaquer.setVisible(false);
									}
								}
							});
							
							JButton canonAttaquePlus = new JButton("");
							canonAttaquePlus.setOpaque(false);
							canonAttaquePlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							canonAttaquePlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							canonAttaquePlus.setFocusPainted(false);
							canonAttaquePlus.setBounds(1730, 960, 33, 30);
							fenetreAttaque.add(canonAttaquePlus);
							
							canonAttaquePlus.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(canonAttaque.getText().substring(44,canonAttaque.getText().length()-7))+1;
									int k = Integer.parseInt(soldatAttaque.getText().substring(44,soldatAttaque.getText().length()-7));
									int l = Integer.parseInt(cavalierAttaque.getText().substring(44,cavalierAttaque.getText().length()-7));
									
									if (j<=nbCanonTerritoireFinal && j+k+l<=3 && j+k+l != territoireAttaquant.unites.size()) {
									canonAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if(j+k+l>0) {
										attaquer.setVisible(true);
									}
								}
							});
							
							JButton canonAttaqueMoins = new JButton("");
							canonAttaqueMoins.setOpaque(false);
							canonAttaqueMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							canonAttaqueMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							canonAttaqueMoins.setFocusPainted(false);
							canonAttaqueMoins.setBounds(1830, 960, 25, 30);
							fenetreAttaque.add(canonAttaqueMoins);
							
							canonAttaqueMoins.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int j = Integer.parseInt(canonAttaque.getText().substring(44,canonAttaque.getText().length()-7))-1;
									
									if (j>=0) {
									canonAttaque.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
									}
									if (j<=0) {
										attaquer.setVisible(false);
									}
								}
							});
						}
					});
				}
			}

			JButton btnUnite = new JButton("");
			
			lblCarte.add(btnUnite);
			btnUnite.setOpaque(false);
			btnUnite.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			btnUnite.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			btnUnite.setFocusPainted(false);
			btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 70);
			btnUnite.setVisible(true);
			
			btnUnite.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					lblEncartBasDroite.remove(fenetreAttaque);
					lblEncartBasDroite.add(fenetreChoixAction);
					fenetreChoixAction.removeAll();
					fenetreChoixAction.repaint();
					fenetreChoixAction.validate();
					System.out.println(territoiresAllies.size());
					for(int i = 0 ; i < territoiresAllies.size() ; i++) {
						fenetreChoixAction.add(territoiresAllies.get(i));
						territoiresAllies.get(i).setVisible(true);
					}
					for(int i = 0 ; i < territoiresEnnemis.size(); i++) {
						fenetreChoixAction.add(territoiresEnnemis.get(i));
						territoiresEnnemis.get(i).setVisible(true);
					}
				}
			});
			
		}
		
	}
	

	public void refreshCarte() {
		lblCarte.removeAll();
		lblCarte.add(btnFullscreenCarte);
		lblCarte.add(lblEncartBasDroite);
		lblCarte.validate();
		lblCarte.repaint();
	}

	
}
