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
	JLabel transition = new JLabel("");
	JLabel lblCarte = new JLabel("Carte");
	JLabel lblEncartBasDroite = new JLabel("EncartBasDroite");
	
	JButton btnPlay = new JButton("");
	JButton btnFullscreen = new JButton("FullScreen");
	JButton btnFullscreenCarte = new JButton("FullScreenCarte");
	
	CardLayout cl  = new CardLayout();
	
	
	JLabel fenetreRenfort = new JLabel("");
	
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
		btnPlay.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
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
		
		transition.setBounds(0, 0, 1920, 1080);
		transition.setHorizontalAlignment(JLabel.CENTER);
		transition.setHorizontalAlignment(JLabel.CENTER);
		transition.setBackground(Color.black);
		transition.setIcon(new ImageIcon("src/Images/Menu/menuaction/test.gif"));
		contentPane.add(transition,"2");
		
		
		lblCarte.setBounds(0, 0, 1920, 1080);
		lblCarte.setIcon(new ImageIcon("src/Images/carte/BASE-RISK-STARWARS.png"));
		contentPane.add(lblCarte,"3");
		
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
			timer = new Timer(35000, new ActionListener(){      // Timer 4 seconds
	            public void actionPerformed(ActionEvent e) {
	            	cl.show(contentPane, "3");
	            }
	        });
			
		ActionListener Jouer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "2");	
				timer.start();
			}
			
		};
		
		
		
		
		
		btnFullscreen.addMouseListener(fullscreen);
		btnFullscreenCarte.addMouseListener(fullscreen);
		btnPlay.addActionListener(Jouer);
		transition.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				cl.show(contentPane, "3");
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
		String couleur ;
		String camp ;
		ArrayList <Unite> uniteTerritoire = new ArrayList();
		int nbSoldatTerritoire=0 ;
		int nbCavalierTerritoire = 0;
		int nbCanonTerritoire = 0;
		
		
		int[] coordonneesUnite ;
		
		for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
				couleur = partie.regions.get(i).territoires.get(j).proprietaire.couleur;
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
				System.out.println("Les voisins de " + partie.regions.get(i).territoires.get(j).nom+ " sont " + partie.regions.get(i).territoires.get(j).voisinsTerritoire(partie).get(0).nom + " " + partie.regions.get(i).territoires.get(j).voisinsTerritoire(partie).get(1).nom);
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void affichageRenfort (Joueur joueur) {
	
		
		int[] coordonneesUnite ;
		String camp = joueur.camp;
		String couleur = joueur.couleur;
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
						int i = Integer.parseInt(nbCavalier.getText().substring(46,nbCanon.getText().length()-7))+1;
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


public void refreshCarte() {
	lblCarte.removeAll();
	lblCarte.add(btnFullscreenCarte);
	lblCarte.add(lblEncartBasDroite);
	lblCarte.validate();
	lblCarte.repaint();
	
}



}
