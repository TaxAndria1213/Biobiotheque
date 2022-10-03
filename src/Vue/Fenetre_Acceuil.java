package Vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre_Acceuil{
	private JFrame frameAcceuil;
	private JButton btnConnexion;
	private JButton btnInscrire;
	
	public Fenetre_Acceuil() {
		this.frameAcceuil = new JFrame();
		this.btnConnexion = new JButton("Connexion");
		this.btnInscrire = new JButton("Inscription");
		
		JPanel panelPpl = new JPanel();
		panelPpl.setLayout(new GridLayout(4, 1));
		
		
		JPanel panelBtnConnexion = new JPanel();
		panelBtnConnexion.add(btnConnexion);
		panelBtnConnexion.setPreferredSize(new Dimension(300, 100));
		
		JPanel pnl = new JPanel();
		panelPpl.add(pnl);
		panelPpl.add(panelBtnConnexion);
		
		JPanel panelBtnInscription = new JPanel();
		panelBtnInscription.add(btnInscrire);
		panelPpl.add(panelBtnInscription);
		
		
		//ajout des actions au bouton inscrire
		btnInscrire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FenetreEnregistrement();
				frameAcceuil.dispose();
			}
		});
		
		btnConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FenetreConnexion();
				frameAcceuil.dispose();
			}
		});
		
		
		
		frameAcceuil.setContentPane(panelPpl);
		frameAcceuil.setSize(300, 200);
		frameAcceuil.setResizable(false);
		frameAcceuil.setLocationRelativeTo(null);
		frameAcceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAcceuil.setVisible(true);
	}
}
