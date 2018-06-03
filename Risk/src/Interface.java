import java.awt.BorderLayout;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {
	
	
	private JPanel contentPane = new JPanel();
	private JLabel lblTest2 = new JLabel("test2");
	private boolean FSflag = false;
    private int PrevX, PrevY, PrevWidth, PrevHeight;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(0, 0, 1920, 1080);
		lblTest.setIcon(new ImageIcon("src/Images/Menu/fond.png"));
		contentPane.add(lblTest);
		
		
		lblTest2.setBounds(0, 0, 1920, 1080);
		lblTest2.setIcon(new ImageIcon("src/Images/carte/BASE-RISK-STARWARS.png"));
		contentPane.add(lblTest2);
		
		
		Border border = BorderFactory.createLineBorder(Color.red, 5);
		
		JLabel btnPlay = new JLabel("play");
		lblTest.add(btnPlay);
		btnPlay.setBounds(707, 470, 505, 145);
		
		
		JButton btnFullscreen = new JButton("FullScreen");
		lblTest.add(btnFullscreen);
		btnFullscreen.setOpaque(false);
		btnFullscreen.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		btnFullscreen.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
		btnFullscreen.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		btnFullscreen.setBounds(0, 0, 83, 81);
		btnFullscreen.setIcon(new ImageIcon("src/Images/icone/fullscreen.png"));
		btnFullscreen.setVisible(true);

		JButton btnFullscreenCarte = new JButton("FullScreenCarte");
		lblTest2.add(btnFullscreenCarte);
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
			
			
			
			
		btnPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO Auto-generated method stub
				lblTest.setVisible(false);
				contentPane.remove(lblTest);
				contentPane.add(lblTest2);
				contentPane.validate();
				System.out.println("ok");
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

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnFullscreen.addMouseListener(fullscreen);
		btnFullscreenCarte.addMouseListener(fullscreen);

	
	
	}//fin constructeur	
	
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
				lblTest2.add(btnUnite);
				btnUnite.setOpaque(false);
				btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 43);
				btnUnite.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/unite.png"));
				System.out.println("Les voisins de " + partie.regions.get(i).territoires.get(j).nom+ " sont " + partie.regions.get(i).territoires.get(j).voisinsTerritoire(partie).get(0).nom + " " + partie.regions.get(i).territoires.get(j).voisinsTerritoire(partie).get(1).nom);
				btnUnite.setVisible(true);
				
				JLabel nbSoldat = new JLabel("<html><font color = 'white'>"+String.valueOf(nbSoldatTerritoire)+"</html>");
				nbSoldat.setBounds(coordonneesUnite[0]+4, coordonneesUnite[1]+40, 25, 25);
				nbSoldat.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblTest2.add(nbSoldat);
				nbSoldat.setHorizontalTextPosition(JLabel.CENTER);
				
				JLabel nbCavalier = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCavalierTerritoire)+"</html>");
				nbCavalier.setBounds(coordonneesUnite[0]+40, coordonneesUnite[1]+40, 25, 25);
				nbCavalier.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblTest2.add(nbCavalier);
				nbCavalier.setHorizontalTextPosition(JLabel.CENTER);
				
				JLabel nbCanon = new JLabel("<html><font color = 'white'>"+String.valueOf(nbCanonTerritoire)+"</html>");
				nbCanon.setBounds(coordonneesUnite[0]+75, coordonneesUnite[1]+40, 25, 25);
				nbCanon.setIcon(new ImageIcon("src/Images/icone/"+camp+"/"+couleur+"/cercleunite.png"));
				lblTest2.add(nbCanon);
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
		
		JLabel fenetreRenfort = new JLabel("");
		fenetreRenfort.setBounds(0,0, 1920, 1080);
		//fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/"+camp+"/renfort.png"));
		fenetreRenfort.setIcon(new ImageIcon("src/Images/Menu/menuaction/empire/renfort.png"));
		lblTest2.add(fenetreRenfort);
		
		for(int i = 0 ; i<joueur.territoires.size(); i++) {
				nbSoldatTerritoire = 0;
				nbCavalierTerritoire = 0;
				nbCanonTerritoire = 0;
				coordonneesUnite = joueur.territoires.get(i).coordonneesUnite;
				
				for(int k = 0; k<joueur.territoires.get(i).unites.size(); k++) {
					if(joueur.territoires.get(i).unites.get(k).cout == 1) {
						nbSoldatTerritoire++;
						System.out.println("hhaha" + joueur.territoires.get(i).nom);
					}
					else if(joueur.territoires.get(i).unites.get(k).cout == 3) {
						nbCavalierTerritoire ++;
					}
					else {
						nbCanonTerritoire ++;
					}
				}

				JButton btnUnite = new JButton("");
				
				lblTest2.add(btnUnite);
				btnUnite.setOpaque(false);
				btnUnite.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
				btnUnite.setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
				btnUnite.setFocusPainted(false);
				btnUnite.setBounds(coordonneesUnite[0], coordonneesUnite[1], 112, 70);
				btnUnite.setVisible(true);
				
				JLabel nbSoldat = new JLabel("<html><font color = 'white'><font size = '15'>"+String.valueOf(nbSoldatTerritoire)+"</html>");
				fenetreRenfort.add(nbSoldat);
				nbSoldat.setHorizontalTextPosition(JLabel.CENTER);
				nbSoldat.setOpaque(false);
				nbSoldat.setBounds(1485, 935, 112, 70);
				nbSoldat.setVisible(false);
				
				JLabel nbCavalier = new JLabel("<html><font color = 'white'><font size = '15'>"+String.valueOf(nbCavalierTerritoire)+"</html>");
				fenetreRenfort.add(nbSoldat);
				nbCavalier.setHorizontalTextPosition(JLabel.CENTER);
				nbCavalier.setOpaque(false);
				nbCavalier.setBounds(1637, 935, 112, 70);
				nbCavalier.setVisible(false);
				
				JLabel nbCanon = new JLabel("<html><font color = 'white'><font size = '15'>"+String.valueOf(nbCanonTerritoire)+"</html>");
				fenetreRenfort.add(nbCanon);
				nbCanon.setHorizontalTextPosition(JLabel.CENTER);
				nbCanon.setOpaque(false);
				nbCanon.setBounds(1790, 935, 112, 70);
				nbCanon.setVisible(false);
				
				btnUnite.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println("haha");
						
						fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.add(nbCavalier);
						nbCavalier.setVisible(true);
						fenetreRenfort.add(nbCanon);
						nbCanon.setVisible(true);
						fenetreRenfort.validate();
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						fenetreRenfort.removeAll();
						nbSoldat.setVisible(false);
						nbCavalier.setVisible(false);
						nbCanon.setVisible(false);
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
				
				JButton nbSoldatPlus = new JButton("");
				fenetreRenfort.add(nbSoldatPlus);
				nbSoldatPlus.setOpaque(false);
				nbSoldatPlus.setBounds(0, 0, 112, 70);
				nbSoldatPlus.setBorderPainted(true);
				nbSoldatPlus.setVisible(true);
				final Territoires territoire = joueur.territoires.get(i);
				
				
				nbSoldatPlus.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println("haha");
						
						/*fenetreRenfort.add(nbSoldat);
						nbSoldat.setVisible(true);
						fenetreRenfort.add(nbCavalier);
						nbCavalier.setVisible(true);
						fenetreRenfort.add(nbCanon);
						nbCanon.setVisible(true);*/
						int [] tableau = {1,1};
						System.out.println("Avant = " + territoire.unites.size());
						territoire.unites.add(new Soldat(1,tableau,1,1,1,1,1,"soldatA"));
						System.out.println("Apres = " + territoire.unites.size());
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
	
	}//fin class
	


