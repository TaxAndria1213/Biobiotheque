package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePrincipale {
	private JFrame framePpl;
	private JLabel label_emprunt_utilisateur;
	private JLabel label_livre_dispo;
	private JLabel label_tout_emprunts;
	
	
	public FenetrePrincipale() {
	    label_emprunt_utilisateur = new JLabel("Emprunt de l'utilisateur : ");
	    label_livre_dispo = new JLabel("Livre(s) disponible(s) : ");
	    label_tout_emprunts = new JLabel("Tout les emprunts : ");
	    
	    
		framePpl = new JFrame();
		
		JPanel paneau_principal = new JPanel();
		JPanel conteneur = new JPanel();
		
		paneau_principal.setLayout(new BorderLayout());
		
		conteneur.setLayout(new GridLayout(1,3));
		
		JPanel pane_emprunt_utilisateur = new JPanel();
		pane_emprunt_utilisateur.setBackground(Color.cyan);
		pane_emprunt_utilisateur.add(label_emprunt_utilisateur);
		
		JPanel pane_livre_dispo = new JPanel();
		pane_livre_dispo.setBackground(Color.gray);
		pane_livre_dispo.add(label_livre_dispo);
		
		JPanel pane_tout_les_emprunts = new JPanel();
		pane_tout_les_emprunts.setBackground(Color.GREEN);
		pane_tout_les_emprunts.add(label_tout_emprunts);
		
		
		
		conteneur.add(pane_emprunt_utilisateur);
		conteneur.add(pane_livre_dispo);
		conteneur.add(pane_tout_les_emprunts);
		
		
		paneau_principal.add(conteneur, BorderLayout.CENTER);
		
		framePpl.setContentPane(paneau_principal);
		framePpl.setSize(1080, 720);
		framePpl.setResizable(false);
		framePpl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePpl.setLocationRelativeTo(null);
		framePpl.setVisible(true);
	}
}
