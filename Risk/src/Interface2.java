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
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Interface2 extends JFrame {

	
	//On instancie les jlabel, jpanel et jbutton fixe
	//On instancie les flags
	
	private boolean FSflag = false;
	private boolean Sflag = false;
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
	JButton btnFullscreenMenuParametrage = new JButton("btnFullscreenMenuParametrage");
	JButton btnSon = new JButton("FullScreen");
	JButton btnSonCarte = new JButton("FullScreenCarte");
	JButton btnSonParametrage = new JButton("btnFullscreenMenuParametrage");
	JButton btnDebutDePartie = new JButton("");
	JButton btnSkip = new JButton("Skip");
	
	CardLayout cl  = new CardLayout();
	
	
	JLabel fenetreRenfort = new JLabel("");
	JLabel fenetreChoixAction = new JLabel("");
	JLabel fenetreAttaque = new JLabel("");
	JLabel fenetreDeplacement = new JLabel("");
	
	int flagSkip =0;
	String choixCamp ="";
	
	private Timer timer = null;
	Sound Theme = new Sound("src/Sons/Intro.wav");
	Sound mainTheme = new Sound("src/Sons/Music.wav");
	
	public Interface2() throws Exception{
		super();
		
		build();
		//On initialise notre fenêtre et on la rempli avec les premiers labels
		//On utilise un card layout pour switch entre l'accueil, le menu, la transition et la carte
	}
	
	private void build() throws Exception{
		setTitle("Risk Ultimate Sublime Warframe"); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(0, 0, 1920, 1080);
		setContentPane(buildContentPane());
	}

	private JPanel buildContentPane() throws Exception{
		
		 
		
		Theme.PlaySoundC();
		contentPane.setLayout(cl);
		panelMenu.add(lblMenu);
		panelCarte.add(lblCarte);
		cl.show(contentPane, "1");
		
		
		lblMenu.setBounds(0, 0, 1920, 1080);
		lblMenu.setIcon(new ImageIcon("src/Images/Menu/fond.png"));
		contentPane.add(lblMenu, "1");
		
		lblMenu.add(btnPlay);
		btnPlay.setBounds(823, 945, 285, 60);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false); 
		btnPlay.setBorderPainted(true); 
		btnPlay.setFocusPainted(false); 
		btnPlay.setVisible(true);
		
		
		lblMenu.add(btnFullscreen);
		btnFullscreen.setOpaque(false);
		btnFullscreen.setContentAreaFilled(false); 
		btnFullscreen.setBorderPainted(false); 
		btnFullscreen.setFocusPainted(false); 
		btnFullscreen.setBounds(1780, 920, 83, 81);
		btnFullscreen.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
		btnFullscreen.setVisible(true);
		
		lblMenu.add(btnSon);
		btnSon.setOpaque(false);
		btnSon.setContentAreaFilled(false); 
		btnSon.setBorderPainted(false); 
		btnSon.setFocusPainted(false); 
		btnSon.setBounds(1690, 920, 83, 81);
		btnSon.setIcon(new ImageIcon("src/Images/icone/mute.png"));
		btnSon.setVisible(true);
		
		lblMenuParametrage.setBounds(0, 0, 1920, 1080);
 		lblMenuParametrage.setIcon(new ImageIcon("src/Images/Menu/MENU-RISK-STARWARS.png"));
		contentPane.add(lblMenuParametrage,"2");
 		
 		lblMenuParametrage.add(btnFullscreenMenuParametrage);
 		
		transition.setBounds(0, 0, 1920, 1080);
 		transition.setHorizontalAlignment(JLabel.CENTER);
 		transition.setHorizontalAlignment(JLabel.CENTER);
 		transition.setBackground(Color.black);
 		transition.setIcon(new ImageIcon("src/Images/Menu/menuaction/test.gif"));
 		contentPane.add(transition,"3");
 		
 		btnFullscreenMenuParametrage.setOpaque(false);
 		btnFullscreenMenuParametrage.setContentAreaFilled(false); 
 		btnFullscreenMenuParametrage.setBorderPainted(false); 
 		btnFullscreenMenuParametrage.setFocusPainted(false); 
 		btnFullscreenMenuParametrage.setBounds(1780, 920, 83, 81);
 		btnFullscreenMenuParametrage.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
 		btnFullscreenMenuParametrage.setVisible(true);
 		
 		lblMenuParametrage.add(btnSonParametrage);
 		btnSonParametrage.setOpaque(false);
 		btnSonParametrage.setContentAreaFilled(false); 
 		btnSonParametrage.setBorderPainted(false); 
 		btnSonParametrage.setFocusPainted(false); 
 		btnSonParametrage.setBounds(1690, 920, 83, 81);
 		btnSonParametrage.setIcon(new ImageIcon("src/Images/icone/mute.png"));
 		btnSonParametrage.setVisible(true);
 		
 		transition.add(btnSkip);
 		btnSkip.setBounds(1680, 965, 200, 50);
 		btnSkip.setOpaque(false);
 		btnSkip.setContentAreaFilled(false); 
 		btnSkip.setBorderPainted(false); 
 		btnSkip.setFocusPainted(false); 
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
		btnFullscreenCarte.setContentAreaFilled(false); 
		btnFullscreenCarte.setBorderPainted(false); 
		btnFullscreenCarte.setFocusPainted(false); 
		btnFullscreenCarte.setBounds(17, 280, 83, 81);
		btnFullscreenCarte.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
		btnFullscreenCarte.setVisible(true);
		
		lblCarte.add(btnSonCarte);
		btnSonCarte.setOpaque(false);
		btnSonCarte.setContentAreaFilled(false); 
		btnSonCarte.setBorderPainted(false); 
		btnSonCarte.setFocusPainted(false); 
		btnSonCarte.setBounds(110, 280, 83, 81);
		btnSonCarte.setIcon(new ImageIcon("src/Images/icone/mute.png"));
		btnSonCarte.setVisible(true);
		
		//On crée un mouselistener particulier pour les boutons fulscreen et d'autres pour les bouton son
		//on utilise un flag pour connaitre la postion du bouton 
		
		MouseListener fullscreen = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (FSflag == false) {
	                PrevX = getX();
	                PrevY = getY();
	                PrevWidth = getWidth();
	                PrevHeight = getHeight();

	                
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
			
			
			MouseListener sonMenu = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					if (Sflag == false) {
				         
						try {
							Theme.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							}
				        btnSon.setIcon(new ImageIcon("src/Images/icone/son.png"));
				        btnSonParametrage.setIcon(new ImageIcon("src/Images/icone/son.png"));
				        Sflag = true;
				        } else {
				       	try {
				  		Theme.PlaySoundC();
						} catch (Exception e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				    btnSon.setIcon(new ImageIcon("src/Images/icone/mute.png"));
	                btnSonParametrage.setIcon(new ImageIcon("src/Images/icone/mute.png"));
	                Sflag = false;
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
			
			MouseListener sonCarte = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					if (Sflag == false) {
		                
						try {
							mainTheme.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                btnSonCarte.setIcon(new ImageIcon("src/Images/icone/son.png"));
		                Sflag = true;
		            } else {
		            	try {
							mainTheme.PlaySoundC();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                btnSonCarte.setIcon(new ImageIcon("src/Images/icone/mute.png"));
		                Sflag = false;
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
								
							
		// on crée un timer si le joueur laisse la vidéo en entiere
		timer = new Timer(29000, new ActionListener(){      // Timer 4 seconds
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "4");
				flagSkip = 1;//on passe notre flag du début de partie
			}
		});					
		
		ActionListener Jouer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "2");
				
			}
			
		};
		
		btnFullscreen.addMouseListener(fullscreen);
		btnFullscreenCarte.addMouseListener(fullscreen);
		btnFullscreenMenuParametrage.addMouseListener(fullscreen);
		btnSon.addMouseListener(sonMenu);
		btnSonParametrage.addMouseListener(sonMenu);
		btnSonCarte.addMouseListener(sonCarte);
		btnPlay.addActionListener(Jouer);
		
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
	
	//Cette fonction permet d'afficher les unitées sur la cartes avec les nombres de soldats cavaliers et canon
	public void affichageUniteCarte(Partie partie) {
		String couleur;
		String camp;
		ArrayList <Unite> uniteTerritoire = new ArrayList<Unite>();
		int nbSoldatTerritoire=0 ;
		int nbCavalierTerritoire = 0;
		int nbCanonTerritoire = 0;
		int[] coordonneesUnite ;
		
		
		
		for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
				couleur = partie.regions.get(i).territoires.get(j).proprietaire.Couleur;//on recupere la couleur du joueur
				camp = partie.regions.get(i).territoires.get(j).proprietaire.camp;//son camp
				uniteTerritoire = partie.regions.get(i).territoires.get(j).unites;//la liste des unitées
				coordonneesUnite = partie.regions.get(i).territoires.get(j).coordonneesUnite;//les coordonées de l'unité 
				
				//On boucle sur les nitées pour récupérer le nombre de chaque unitées
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

	//même fonction que affichageUniteCarte mais on ajoute un délai entre chaque appartition pour créer du suspens
	//on démarre également la deuxieme partie du son
	public void affichageUniteCarteDebutPartie(Partie partie ) throws Exception {
	 		
			while (flagSkip == 0) {
			 	try {
			 		Thread.sleep(1);
			 	} catch (InterruptedException e) {
			 	// TODO Auto-generated catch block
			 		e.printStackTrace();
			 		}
			 	}
			
			if(Sflag == false) {
				Theme.Stop();
				mainTheme.PlaySoundC();
			}
		 		
		 	String couleur ;
		 	String camp ;
		 	ArrayList <Unite> uniteTerritoire = new ArrayList<Unite>();
		 	int nbSoldatTerritoire=0 ;
		 	int nbCavalierTerritoire = 0;
		 	int nbCanonTerritoire = 0;
		 				 		
		 	int[] coordonneesUnite ;
		 		
			for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
		 	try {
		 		Thread.sleep(200);
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
	
	//Cette fonction correspond a l'écran avant la partie pour ajouter des joueurs 
	public void parametragePartie(Partie partie) {
				
			JButton joueurEmpire = new JButton();
			JButton joueurRebelle = new JButton();
			JButton iaEmpire = new JButton();
			JButton iaRebelle = new JButton();
			JButton ajouterJoueur = new JButton();
			JButton ajouterIa = new JButton();
			
			JTextField fieldPseudo = new JTextField("");

			int nbJoueur =partie.getNbreJoueursTotal();
			
			lblMenuParametrage.add(fieldPseudo);
			fieldPseudo.setText("");
			fieldPseudo.setOpaque(false);
			fieldPseudo.setBorder(null);
			fieldPseudo.setBounds(595, 253, 895, 40);
			Font font = new Font("Arial",Font.BOLD,25);
			fieldPseudo.setForeground(Color.WHITE);
			fieldPseudo.setFont(font);
				 
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
			
			MouseListener ajoutJoueur = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
					if(choixCamp != "" && !fieldPseudo.getText().isEmpty() && fieldPseudo.getText().length()<9 && nbJoueur<6) {
						
						Joueur joueur = new Joueur(nbJoueur,fieldPseudo.getText(), true);
						joueur.setCamp(choixCamp);
						if(nbJoueur ==0) {
							joueur.setCouleur("black");
							
						}
						if(nbJoueur ==1) {
							joueur.setCouleur("red");
						}
						if(nbJoueur ==2) {
							joueur.setCouleur("pink");						
						}
						if(nbJoueur ==3) {
							joueur.setCouleur("green");
						}
						if(nbJoueur ==4) {
							joueur.setCouleur("orange");
						}
						
						if(nbJoueur ==5) {
							joueur.setCouleur("blue");
						}
						
						
						ArrayList <Joueur> listejoueur = new ArrayList<Joueur>(partie.getJoueurs());
						listejoueur.add(joueur);
						partie.setJoueurs(listejoueur);
						
						
						
						partie.setNbreJoueursHumains(partie.getNbreJoueursHumains()+1);
						partie.setNbreJoueursTotal(partie.getNbreJoueursTotal()+1);
						
						choixCamp ="";
						partie.flagAjouter=1;
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
			
			ajouterJoueur.addMouseListener(ajoutJoueur);
			
			
			lblMenuParametrage.add(ajouterIa);
			ajouterIa.setOpaque(false);
			ajouterIa.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
			ajouterIa.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
			ajouterIa.setFocusPainted(false); // On n'affiche pas l'effet de focus.
			ajouterIa.setBounds(1055, 470, 365, 71);
			ajouterIa.setVisible(true);
			
			MouseListener ajoutIa = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
					if(choixCamp != "" && !fieldPseudo.getText().isEmpty() && fieldPseudo.getText().length()<9 && nbJoueur<6) {
						
						Joueur joueur = new Joueur(nbJoueur,fieldPseudo.getText(), false);
						joueur.setCamp(choixCamp);
						if(nbJoueur ==0) {
							joueur.setCouleur("black");
							
						}
						if(nbJoueur ==1) {
							joueur.setCouleur("red");
						}
						if(nbJoueur ==2) {
							joueur.setCouleur("pink");
							
						}
						if(nbJoueur ==3) {
							joueur.setCouleur("green");
						}
						if(nbJoueur ==4) {
							joueur.setCouleur("orange");
						}
						
						if(nbJoueur ==5) {
							joueur.setCouleur("blue");
						}
						
						
						ArrayList <Joueur> listejoueur = new ArrayList<Joueur>(partie.getJoueurs());
						listejoueur.add(joueur);
						partie.setJoueurs(listejoueur);
						
						partie.setNbreJoueursTotal(partie.getNbreJoueursTotal()+1);
						
						choixCamp ="";
						partie.flagAjouter=1;
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
			
			ajouterIa.addMouseListener(ajoutIa);
			
			lblMenuParametrage.add(btnDebutDePartie);
	 		btnDebutDePartie.setOpaque(false);
	 		btnDebutDePartie.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
	 		btnDebutDePartie.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
	 		btnDebutDePartie.setFocusPainted(false); // On n'affiche pas l'effet de focus.
	 		btnDebutDePartie.setBounds(760, 960, 375, 81);
	 		btnDebutDePartie.setVisible(true);
			
			ActionListener DebutDePartie = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(nbJoueur > 1 ) {
						cl.show(contentPane, "3");
						partie.flagDebutDePartie = 1;
						timer.start();
					}
				
				}
			};
			
			btnDebutDePartie.addActionListener(DebutDePartie);
			
			if(nbJoueur!= 0) {
				for(int i =0; i< nbJoueur; i++) {
					String pseudo = partie.getJoueurs().get(i).Pseudo;
					String couleur = partie.getJoueurs().get(i).Couleur;
					String camp = partie.getJoueurs().get(i).camp;
					
					JLabel joueur = new JLabel(pseudo);
					joueur.setOpaque(false);
					joueur.setBounds(500, 700+i*40, 500, 25);
					joueur.setBounds(500, 700+i*40, 500, 25);
					joueur.setForeground(Color.WHITE);
					joueur.setVisible(true);
					joueur.setFont(font);
					
					JLabel iconeJoueur = new JLabel();
					iconeJoueur.setOpaque(false);
					iconeJoueur.setBounds(1285, 700+i*40, 25, 25);
					iconeJoueur.setVisible(true);
					iconeJoueur.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/logocamp.png"));
					
					
					
					lblMenuParametrage.add(joueur);
					lblMenuParametrage.add(iconeJoueur);
				}
			}
			
			MouseListener choixCampEmpire = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					choixCamp="empire";
					
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
			
			MouseListener choixCampRebelles = new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						choixCamp="rebelles";
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
				
			joueurEmpire.addMouseListener(choixCampEmpire);
			joueurRebelle.addMouseListener(choixCampRebelles);
			iaEmpire.addMouseListener(choixCampEmpire);
			iaRebelle.addMouseListener(choixCampRebelles);
					
			lblMenuParametrage.validate();
			lblMenuParametrage.repaint();
	}
	
	
	//Cette fonction gere l'ajout de renfort par le joueur
	public void affichageRenfort (Joueur joueur) {
	
		
		int[] coordonneesUnite ;
		String camp = joueur.camp;
		
		fenetreRenfort.setBounds(0,0, 1920, 1080);
		fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/renfort.png"));
		lblEncartBasDroite.add(fenetreRenfort);
		
		JLabel tourDePseudo = new JLabel("<html><font color = 'white'><font size = 10>Tour de "+ joueur.Pseudo + "</html>");
		lblCarte.add(tourDePseudo);
		tourDePseudo.setOpaque(false);
		tourDePseudo.setBounds(60, 10, 400, 100);
		
		tourDePseudo.setVisible(true);
		
		JLabel tourDeNumero = new JLabel("<html><font color = 'white'><font size = 5>(Joueur "+ joueur.numero + ")</html>");
		lblCarte.add(tourDeNumero);
		tourDeNumero.setOpaque(false);
		tourDeNumero.setBounds(60, 40, 400, 100);
		
		tourDeNumero.setVisible(true);
		
		JLabel missionJoueur = new JLabel("<html><font color = 'white'><font size = 5>Mission : "+ joueur.mission.enonce +"</html>");
		lblCarte.add(missionJoueur);
		missionJoueur.setOpaque(false);
		missionJoueur.setBounds(40,80,400,100);
		
		missionJoueur.setVisible(true);
		
		JLabel nomPhase = new JLabel("<html><font color = 'yellow'><font size = 10>Phase attribution des renforts</html>");
		lblCarte.add(nomPhase);
		nomPhase.setOpaque(false);
		nomPhase.setBounds(40, 140, 400, 100);
		
		nomPhase.setVisible(true);
		
		
		
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
				
				coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;

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
						// i est le nb de soldat il est recuperer en soustrayant l'html du text du label et en le vertissant en int
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
						// i est le nb de nbCavalier il est recuperer en soustrayant l'html du text du label et en le vertissant en int
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
						// i est le nb de nbRenfortDisponible il est recuperer en soustrayant l'html du text du label et en le vertissant en int
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
		
		fenetreRenfort.setBounds(0,0, 1920, 1080);
		fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/renfortSoldat.png"));
		lblEncartBasDroite.add(fenetreRenfort);
		
		JLabel tourDePseudo = new JLabel("<html><font color = 'white'><font size = 10>Tour de "+ joueur.Pseudo + "</html>");
		lblCarte.add(tourDePseudo);
		tourDePseudo.setOpaque(false);
		tourDePseudo.setBounds(60, 10, 400, 100);
		
		tourDePseudo.setVisible(true);
		
		JLabel tourDeNumero = new JLabel("<html><font color = 'white'><font size = 5>(Joueur "+ joueur.numero + ")</html>");
		lblCarte.add(tourDeNumero);
		tourDeNumero.setOpaque(false);
		tourDeNumero.setBounds(60, 40, 400, 100);
		
		tourDeNumero.setVisible(true);
		
		JLabel missionJoueur = new JLabel("<html><font color = 'white'><font size = 5>Mission : "+ joueur.mission.enonce +"</html>");
		lblCarte.add(missionJoueur);
		missionJoueur.setOpaque(false);
		missionJoueur.setBounds(40,80,400,100);
		
		missionJoueur.setVisible(true);
		
		JLabel nomPhase = new JLabel("<html><font color = 'yellow'><font size = 10>Phase attribution des renforts</html>");
		lblCarte.add(nomPhase);
		nomPhase.setOpaque(false);
		nomPhase.setBounds(40, 140, 400, 100);
		
		nomPhase.setVisible(true);
		
		
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
				coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;

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
		String camp = joueur.camp;
		
		lblEncartBasDroite.removeAll();
		
		fenetreChoixAction.setBounds(0,0,1920,1080);
		fenetreChoixAction.setIcon(new ImageIcon("src/Images/Menu/menuaction/ATTAQUE-DEPLACEMENT.png"));
		
		JLabel tourDePseudo = new JLabel("<html><font color = 'white'><font size = 10>Tour de "+ joueur.Pseudo + "</html>");
		lblCarte.add(tourDePseudo);
		tourDePseudo.setOpaque(false);
		tourDePseudo.setBounds(60, 10, 400, 100);
		
		tourDePseudo.setVisible(true);
		
		JLabel tourDeNumero = new JLabel("<html><font color = 'white'><font size = 5>(Joueur "+ joueur.numero + ")</html>");
		lblCarte.add(tourDeNumero);
		tourDeNumero.setOpaque(false);
		tourDeNumero.setBounds(60, 40, 400, 100);
		
		tourDeNumero.setVisible(true);
		
		JLabel missionJoueur = new JLabel("<html><font color = 'white'><font size = 5>Mission : "+ joueur.mission.enonce +"</html>");
		lblCarte.add(missionJoueur);
		missionJoueur.setOpaque(false);
		missionJoueur.setBounds(40,80,400,100);
		
		missionJoueur.setVisible(true);
		
		JLabel nomPhase = new JLabel("<html><font color = 'yellow'><font size = 10>Phase Attaque/Deplacement</html>");
		lblCarte.add(nomPhase);
		nomPhase.setOpaque(false);
		nomPhase.setBounds(40, 140, 400, 100);
		
		nomPhase.setVisible(true);
		
		JButton finDePhase = new JButton("");
		finDePhase.setIcon(new ImageIcon("src/Images/Menu/menuaction/FIN.png"));
		finDePhase.setOpaque(false);
		finDePhase.setBounds(1600, 765, 92, 60);
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
			final Territoires territoireJoueur = joueur.territoires.get(i);
			ArrayList <JButton> territoiresAllies = new ArrayList<JButton>();
			ArrayList <JButton> territoiresEnnemis = new ArrayList<JButton>();
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
			
			for(int j = 0 ; j<joueur.territoires.get(i).voisinsTerritoire(partie).size() ; j++) {
				if(joueur.territoires.contains(joueur.territoires.get(i).voisinsTerritoire(partie).get(j))) {
					final Territoires territoireCible = joueur.territoires.get(i).voisinsTerritoire(partie).get(j);
					JButton territoireAllie = new JButton("");
					territoireAllie.setOpaque(false);
					territoireAllie.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
					territoireAllie.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
					territoireAllie.setFocusPainted(false);
					territoireAllie.setText(joueur.territoires.get(i).voisinsTerritoire(partie).get(j).nom);
					territoireAllie.setFont(new Font("Arial", Font.BOLD ,  12));
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
							lblEncartBasDroite.remove(fenetreChoixAction);
							lblEncartBasDroite.repaint();
							lblEncartBasDroite.validate();
							fenetreDeplacement.setBounds(0,0,1920,1080);
							fenetreDeplacement.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/deplacement.png"));
							lblEncartBasDroite.add(fenetreDeplacement);
							fenetreDeplacement.removeAll();
							finDePhase.setVisible(false);
							repaint();
							validate();
							
							JLabel soldatDeplacement = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							soldatDeplacement.setHorizontalAlignment(JLabel.CENTER);
							soldatDeplacement.setVerticalAlignment(JLabel.CENTER);
							soldatDeplacement.setOpaque(false);
							soldatDeplacement.setBounds(1465, 933, 60, 60);
							soldatDeplacement.setVisible(true);
							fenetreDeplacement.add(soldatDeplacement);
							
							JLabel soldatDeplacementDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbSoldatTerritoireFinal+"</html>");
							soldatDeplacementDispo.setHorizontalAlignment(JLabel.CENTER);
							soldatDeplacementDispo.setVerticalAlignment(JLabel.CENTER);
							soldatDeplacementDispo.setOpaque(false);
							soldatDeplacementDispo.setBounds(1465, 957, 60, 60);
							soldatDeplacementDispo.setVisible(true);
							fenetreDeplacement.add(soldatDeplacementDispo);
							
							JLabel cavalierDeplacement = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							cavalierDeplacement.setHorizontalAlignment(JLabel.CENTER);
							cavalierDeplacement.setVerticalAlignment(JLabel.CENTER);
							cavalierDeplacement.setOpaque(false);
							cavalierDeplacement.setBounds(1615, 933, 60, 60);
							cavalierDeplacement.setVisible(true);
							fenetreDeplacement.add(cavalierDeplacement);
							
							JLabel cavalierDeplacementDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbCavalierTerritoireFinal+"</html>");
							cavalierDeplacementDispo.setHorizontalAlignment(JLabel.CENTER);
							cavalierDeplacementDispo.setVerticalAlignment(JLabel.CENTER);
							cavalierDeplacementDispo.setOpaque(false);
							cavalierDeplacementDispo.setBounds(1615, 957, 60, 60);
							cavalierDeplacementDispo.setVisible(true);
							fenetreDeplacement.add(cavalierDeplacementDispo);
							
							JLabel canonDeplacement = new JLabel("<html><font color = 'white'><font size = 15>"+0+"</html>");
							canonDeplacement.setHorizontalAlignment(JLabel.CENTER);
							canonDeplacement.setVerticalAlignment(JLabel.CENTER);
							canonDeplacement.setOpaque(false);
							canonDeplacement.setBounds(1770, 933, 60, 60);
							canonDeplacement.setVisible(true);
							fenetreDeplacement.add(canonDeplacement);
							
							JLabel canonDeplacementDispo = new JLabel("<html><font color = 'yellow'><font size = 5>/"+nbCanonTerritoireFinal+"</html>");
							canonDeplacementDispo.setHorizontalAlignment(JLabel.CENTER);
							canonDeplacementDispo.setVerticalAlignment(JLabel.CENTER);
							canonDeplacementDispo.setOpaque(false);
							canonDeplacementDispo.setBounds(1770, 957, 60, 60);
							canonDeplacementDispo.setVisible(true);
							fenetreDeplacement.add(canonDeplacementDispo);
							

							JButton deplacer = new JButton("");
							deplacer.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
							deplacer.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
							deplacer.setFocusPainted(false);
							deplacer.setOpaque(false);
							deplacer.setBounds(1560, 1010, 200, 50);
							deplacer.setVisible(false);
							fenetreDeplacement.add(deplacer);
							
							deplacer.addMouseListener(new MouseListener() {
								
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
									int j = Integer.parseInt(soldatDeplacement.getText().substring(44,soldatDeplacement.getText().length()-7));
									int k = Integer.parseInt(cavalierDeplacement.getText().substring(44,cavalierDeplacement.getText().length()-7));
									int l = Integer.parseInt(canonDeplacement.getText().substring(44,canonDeplacement.getText().length()-7));
									ArrayList <Unite> unitesDeplacees = new ArrayList<Unite>();
									for(int q = 0 ; q < territoireJoueur.unites.size() ; q++) {
										if(j!=0 && territoireJoueur.unites.get(q).cout==1) {
											unitesDeplacees.add(territoireJoueur.unites.get(q));
											j--;
										}
										if(k!=0 && territoireJoueur.unites.get(q).cout==3) {
											unitesDeplacees.add(territoireJoueur.unites.get(q));
											k--;
										}
										if(l!=0 && territoireJoueur.unites.get(q).cout==7) {
											unitesDeplacees.add(territoireJoueur.unites.get(q));
											l--;
										}
									}
									joueur.deplacerUnites(territoireJoueur, territoireCible, unitesDeplacees);
									joueur.setFlagValider(1);
									lblEncartBasDroite.removeAll();
									lblEncartBasDroite.repaint();
									lblEncartBasDroite.validate();
								}
							});
							
							if(nbSoldatTerritoireFinal>0) {
								JButton soldatDeplacementPlus = new JButton("");
								soldatDeplacementPlus.setOpaque(false);
								soldatDeplacementPlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								soldatDeplacementPlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								soldatDeplacementPlus.setFocusPainted(false);
								soldatDeplacementPlus.setBounds(1430, 960, 33, 30);
								fenetreDeplacement.add(soldatDeplacementPlus);
							
								soldatDeplacementPlus.addMouseListener(new MouseListener() {
								
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
										int j = Integer.parseInt(soldatDeplacement.getText().substring(44,soldatDeplacement.getText().length()-7))+1;
										int k = Integer.parseInt(cavalierDeplacement.getText().substring(44,cavalierDeplacement.getText().length()-7));
										int l = Integer.parseInt(canonDeplacement.getText().substring(44,canonDeplacement.getText().length()-7));
										if (j<=nbSoldatTerritoireFinal && j+k+l != territoireJoueur.unites.size()) {
											soldatDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if(j+k+l>0) {
											deplacer.setVisible(true);
										}
									}
								});
							
								JButton soldatDeplacementMoins = new JButton("");
								soldatDeplacementMoins.setOpaque(false);
								soldatDeplacementMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								soldatDeplacementMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								soldatDeplacementMoins.setFocusPainted(false);
								soldatDeplacementMoins.setBounds(1530, 960, 25, 30);
								fenetreDeplacement.add(soldatDeplacementMoins);
							
								soldatDeplacementMoins.addMouseListener(new MouseListener() {
								
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
										int j = Integer.parseInt(soldatDeplacement.getText().substring(44,soldatDeplacement.getText().length()-7))-1;
									
										if (j>=0) {
											soldatDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if (j<=0) {
											deplacer.setVisible(false);
										}
									}
								});
							
							}
							
							if(nbCavalierTerritoireFinal>0) {
								JButton cavalierDeplacementPlus = new JButton("");
								cavalierDeplacementPlus.setOpaque(false);
								cavalierDeplacementPlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								cavalierDeplacementPlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								cavalierDeplacementPlus.setFocusPainted(false);
								cavalierDeplacementPlus.setBounds(1580, 960, 33, 30);
								fenetreDeplacement.add(cavalierDeplacementPlus);
								
								cavalierDeplacementPlus.addMouseListener(new MouseListener() {
									
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
										int j = Integer.parseInt(cavalierDeplacement.getText().substring(44,cavalierDeplacement.getText().length()-7))+1;
										int k = Integer.parseInt(soldatDeplacement.getText().substring(44,soldatDeplacement.getText().length()-7));
										int l = Integer.parseInt(canonDeplacement.getText().substring(44,canonDeplacement.getText().length()-7));
										
										if (j<=nbCavalierTerritoireFinal && j+k+l != territoireJoueur.unites.size()) {
										cavalierDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if(j+k+l>0) {
											deplacer.setVisible(true);
										}
									}
								});
								
								JButton cavalierDeplacementMoins = new JButton("");
								cavalierDeplacementMoins.setOpaque(false);
								cavalierDeplacementMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								cavalierDeplacementMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								cavalierDeplacementMoins.setFocusPainted(false);
								cavalierDeplacementMoins.setBounds(1680, 960, 25, 30);
								fenetreDeplacement.add(cavalierDeplacementMoins);
								
								cavalierDeplacementMoins.addMouseListener(new MouseListener() {
									
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
										int j = Integer.parseInt(cavalierDeplacement.getText().substring(44,cavalierDeplacement.getText().length()-7))-1;
										
										if (j>=0) {
											cavalierDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if (j<=0) {
											deplacer.setVisible(false);
										}
									}
								});
							
							}
							
							
							if(nbCanonTerritoireFinal>0) {
								JButton canonDeplacementPlus = new JButton("");
								canonDeplacementPlus.setOpaque(false);
								canonDeplacementPlus.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								canonDeplacementPlus.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								canonDeplacementPlus.setFocusPainted(false);
								canonDeplacementPlus.setBounds(1730, 960, 33, 30);
								fenetreDeplacement.add(canonDeplacementPlus);
								
								canonDeplacementPlus.addMouseListener(new MouseListener() {
									
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
										int j = Integer.parseInt(canonDeplacement.getText().substring(44,canonDeplacement.getText().length()-7))+1;
										int k = Integer.parseInt(soldatDeplacement.getText().substring(44,soldatDeplacement.getText().length()-7));
										int l = Integer.parseInt(cavalierDeplacement.getText().substring(44,cavalierDeplacement.getText().length()-7));
										
										if (j<=nbCanonTerritoireFinal && j+k+l != territoireJoueur.unites.size()) {
										canonDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if(j+k+l>0) {
											deplacer.setVisible(true);
										}
									}
								});
								
								JButton canonDeplacementMoins = new JButton("");
								canonDeplacementMoins.setOpaque(false);
								canonDeplacementMoins.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
								canonDeplacementMoins.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
								canonDeplacementMoins.setFocusPainted(false);
								canonDeplacementMoins.setBounds(1830, 960, 25, 30);
								fenetreDeplacement.add(canonDeplacementMoins);
								
								canonDeplacementMoins.addMouseListener(new MouseListener() {
									
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
										int j = Integer.parseInt(canonDeplacement.getText().substring(44,canonDeplacement.getText().length()-7))-1;
										
										if (j>=0) {
										canonDeplacement.setText("<html><font color = 'white'><font size = 15>"+String.valueOf(j)+"</html>");
										}
										if (j<=0) {
											deplacer.setVisible(false);
										}
									}
								});
								
							}
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
							fenetreAttaque.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/attaque.png"));
							lblEncartBasDroite.add(fenetreAttaque);
							fenetreAttaque.removeAll();
							finDePhase.setVisible(false);
							repaint();
							validate();
							
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
									ArrayList <Unite> unitesAtk = new ArrayList<Unite>();
									for(int q = 0 ; q < territoireJoueur.unites.size() ; q++) {
										if(j!=0 && territoireJoueur.unites.get(q).cout==1) {
											unitesAtk.add(territoireJoueur.unites.get(q));
											j--;
										}
										if(k!=0 && territoireJoueur.unites.get(q).cout==3) {
											unitesAtk.add(territoireJoueur.unites.get(q));
											k--;
										}
										if(l!=0 && territoireJoueur.unites.get(q).cout==7) {
											unitesAtk.add(territoireJoueur.unites.get(q));
											l--;
										}
									}
									
									Unite unitesMortes [][] = joueur.issueBataille(unitesDef, unitesAtk);
									joueur.resultatsBataille(unitesMortes, territoireDefense, territoireJoueur, unitesAtk,partie);
									joueur.setFlagValider(1);	
									
									lblEncartBasDroite.removeAll();
									lblEncartBasDroite.repaint();
									lblEncartBasDroite.validate();
									
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
									if (j<=nbSoldatTerritoireFinal && j+k+l<=3 && j+k+l != territoireJoueur.unites.size()) {
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
									
									if (j<=nbCavalierTerritoireFinal && j+k+l<=3 && j+k+l != territoireJoueur.unites.size()) {
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
									
									if (j<=nbCanonTerritoireFinal && j+k+l<=3 && j+k+l != territoireJoueur.unites.size()) {
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
					lblEncartBasDroite.remove(fenetreDeplacement);
					lblEncartBasDroite.add(fenetreChoixAction);
					fenetreChoixAction.removeAll();
					fenetreChoixAction.repaint();
					fenetreChoixAction.validate();
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
	
	public void affichageBtnFinDePhase(Joueur joueur) {
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
					
					lblEncartBasDroite.removeAll();
					lblEncartBasDroite.repaint();
					lblEncartBasDroite.validate();
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
	}

	public void refreshCarte() {
		lblCarte.removeAll();
		lblCarte.add(btnFullscreenCarte);
		lblCarte.add(btnSonCarte);
		lblCarte.add(lblEncartBasDroite);
		lblCarte.validate();
		lblCarte.repaint();
	}
	
	public void refreshMenuParametrage() {
		lblMenuParametrage.removeAll();
		lblMenuParametrage.add(btnFullscreenMenuParametrage);
		lblMenuParametrage.add(btnSonParametrage);
		lblMenuParametrage.validate();
		lblMenuParametrage.repaint();
	}
	
	public void victoire() {
		JLabel victoire = new JLabel("");
		victoire.setBounds(0,0,1920,1080);
		victoire.setIcon(new ImageIcon("src/Images/Menu/menuaction/VICTOIRE.gif"));
		victoire.setVisible(true);
		lblCarte.add(victoire);
		lblCarte.validate();
		lblCarte.repaint();
	}
}
