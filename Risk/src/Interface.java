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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {
	
	
	private JPanel contentPane;
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
		
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(0, 0, 1920, 1080);
		lblTest.setIcon(new ImageIcon("src/Images/Menu/fond.png"));
		contentPane.add(lblTest);
		
		JLabel lblTest2 = new JLabel("test2");
		lblTest2.setBounds(0, 0, 1920, 1080);
		lblTest2.setIcon(new ImageIcon("src/Images/carte/BASE-RISK-STARWARS.png"));
		contentPane.add(lblTest2);
		
		
		Border border = BorderFactory.createLineBorder(Color.red, 5);
		
		JLabel btnPlay = new JLabel("play");
		lblTest.add(btnPlay);
		btnPlay.setBounds(707, 470, 505, 145);
		btnPlay.setIcon(new ImageIcon("src/Images/Test/btnJouer.png"));
		
		JButton btnFullscreen = new JButton("FullScreen");
		lblTest.add(btnFullscreen);
		btnFullscreen.setOpaque(false);
		btnFullscreen.setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		btnFullscreen.setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
		btnFullscreen.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		btnFullscreen.setBounds(919, 650, 83, 81);
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
	
	public void affichageUniteCarte(Partie partie) {
		Color couleur = null;
		String camp;
		ArrayList <Unite> uniteTerritoire = new ArrayList();
		int[] coordonneesUnite ;
		
		for(int i = 0 ; i<partie.regions.size(); i++) {
			for(int j = 0; j<partie.regions.get(i).territoires.size() ; j++) {
				couleur = partie.regions.get(i).territoires.get(j).proprietaire.couleur;
				camp = partie.regions.get(i).territoires.get(j).proprietaire.camp;
				uniteTerritoire = partie.regions.get(i).territoires.get(j).unites;
				coordonneesUnite = partie.regions.get(i).territoires.get(j).coordonneesUnite;
				
			}}
	}
	
	
	}//fin class
	


