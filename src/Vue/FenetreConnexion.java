package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controleur.VerificationPass;


public class FenetreConnexion {
	private JFrame framePrincipale;
	private JPanel panelPrincipal;
	private JLabel labelConnexion;
	private JLabel labelNom;
	private JLabel labelMotDePass;
	private JTextField champNom;
	private JPasswordField champMdp;
	private JButton btnConnexion;
	private JButton btnRetour;
	
	public FenetreConnexion() {
		labelConnexion = new JLabel("CONNEXION");
		labelNom = new JLabel("Nom :");
		labelMotDePass = new JLabel("Mot de pass :");
		champNom = new JTextField();
		champMdp = new JPasswordField();
		btnConnexion = new JButton("Se connecter");
		btnRetour = new JButton("Retour");
		
		
		framePrincipale = new JFrame("Connexion");
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		
		JPanel panLabelConnexion = new JPanel();
		panLabelConnexion.add(labelConnexion);
		panelPrincipal.add(panLabelConnexion, BorderLayout.NORTH);
		
		JPanel panelComposant = new JPanel();
		panelComposant.setLayout(new GridLayout(2,2));
		
		JPanel panelLabNom = new JPanel();
		panelLabNom.add(labelNom);
		
		JPanel panelLabMdp = new JPanel();
		panelLabMdp.add(labelMotDePass);
		
		JPanel panelChampNom = new JPanel();
		panelChampNom.add(champNom);
		this.champNom.setPreferredSize(new Dimension(150, 20));
		
		JPanel panelChampMdp = new JPanel();
		panelChampMdp.add(champMdp);
		this.champMdp.setPreferredSize(new Dimension(150, 20));
		
		JPanel panelBtnConnexion = new JPanel();
		panelBtnConnexion.add(btnConnexion);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(1,2));
		JPanel panelBtnRetour = new JPanel();
		panelBtnRetour.add(btnRetour);
		
		panelBtn.add(panelBtnRetour);
		panelBtn.add(panelBtnConnexion);
		
		
		panelComposant.add(panelLabNom);
		panelComposant.add(panelChampNom);
		panelComposant.add(panelLabMdp);
		panelComposant.add(panelChampMdp);
		panelPrincipal.add(panelComposant, BorderLayout.CENTER);
		panelPrincipal.add(panelBtn, BorderLayout.SOUTH);
		
		
		//ajouter une action au bouton : connexion.
		this.btnConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {  //vérifier le mot de passe et le nom
				VerificationPass verifier = new VerificationPass(champNom.getText(), champMdp.getPassword(), framePrincipale);
				verifier.effacerChamps(champNom, champMdp);
			}
		});
		
		//ajouter une action au bouton : retour;
		this.btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipale.dispose();
				new Fenetre_Acceuil();
			}
		});
		
		
		framePrincipale.setContentPane(panelPrincipal);
		framePrincipale.setSize(400, 220);
		framePrincipale.setLocationRelativeTo(null);
		framePrincipale.setResizable(false);
		framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipale.setVisible(true);
	}
}
