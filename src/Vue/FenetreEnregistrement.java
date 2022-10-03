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

import Controleur.InsertionEnregistrement;

public class FenetreEnregistrement {
	private JFrame framePrincipale;
	private JPanel panelPrincipal;
	private JLabel labelEnregistrement;
	private JLabel labelNom;
	private JLabel labelMotDePass;
	private JTextField champNom;
	private JPasswordField champMdp;
	private JButton btnEnregistrer;
	private JButton btnRetour;
	
	public FenetreEnregistrement() {
		labelEnregistrement = new JLabel("ENREGISTREMENT");
		labelNom = new JLabel("Nom :");
		labelMotDePass = new JLabel("Mot de pass :");
		champNom = new JTextField();
		champMdp = new JPasswordField();
		btnEnregistrer = new JButton("Enregistrer");
		btnRetour = new JButton("Retour");
		
		
		framePrincipale = new JFrame("Enregistrement utilisateur");
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		
		JPanel panLabelEnregistrement = new JPanel();
		panLabelEnregistrement.add(labelEnregistrement);
		panelPrincipal.add(panLabelEnregistrement, BorderLayout.NORTH);
		
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
		
		JPanel panelBtnEnregistrer = new JPanel();
		panelBtnEnregistrer.add(btnEnregistrer);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(1,2));
		JPanel panelBtnRetour = new JPanel();
		panelBtnRetour.add(btnRetour);
		
		panelBtn.add(panelBtnRetour);
		panelBtn.add(panelBtnEnregistrer);
		
		
		panelComposant.add(panelLabNom);
		panelComposant.add(panelChampNom);
		panelComposant.add(panelLabMdp);
		panelComposant.add(panelChampMdp);
		panelPrincipal.add(panelComposant, BorderLayout.CENTER);
		panelPrincipal.add(panelBtn, BorderLayout.SOUTH);
		
		
		//ajouter une action au bouton : enregistrer.
		this.btnEnregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InsertionEnregistrement(champNom.getText(), champMdp.getPassword());
				framePrincipale.dispose();
				new Fenetre_Acceuil();
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
