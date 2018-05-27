import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {

	private JPanel contentPane;

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
		setBounds(0, 0, 655, 518);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(0, 0, 640, 480);
		lblTest.setIcon(new ImageIcon("src/Images/Menu/menu1.png"));
		contentPane.add(lblTest);
		
		JLabel lblTest2 = new JLabel("test2");
		lblTest2.setBounds(0, 0, 640, 480);
		lblTest2.setIcon(new ImageIcon("src/Images/Menu/menu1.png"));
		
		
		
		Border border = BorderFactory.createLineBorder(Color.red, 5);

		JLabel btnPlay = new JLabel("play");
		btnPlay.setBounds(196, 95, 256, 26);
		btnPlay.setBorder(border);
		lblTest.add(btnPlay);
		
		btnPlay.addMouseListener(new MouseListener() {
			
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
				lblTest.setVisible(false);
				contentPane.remove(lblTest);
				contentPane.add(lblTest2);
				contentPane.validate();
				System.out.println("ok");
			}
		});
		
		
	}
	}