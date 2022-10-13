package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Controleur.Emprunt;
import Controleur.Livres;
import Modele.Interface_global;

	


public class FenetrePrincipale {
	private JFrame framePpl;
	private JLabel label_emprunt_utilisateur;
	private JLabel label_livre_dispo;
	private JLabel label_tout_emprunts;
	JMenuBar barre_de_menu = new JMenuBar();
	JMenu User_menu = new JMenu("Utilisateur");
	JMenu Livre_menu = new JMenu("Livres");
	
	
	
	public FenetrePrincipale() {
		Emprunt emp = new Emprunt();
		Livres liv = new Livres();
	    liv.livre_env_dans_array();
		emp.lecture_emprunt();
		emp.recuperer_nom_livres_seulement();
		emp.tester_livre_emprainter();
	    label_emprunt_utilisateur = new JLabel("Emprunt de l'utilisateur : ");
	    JPanel panel_label_emprunt_utilisateur = new JPanel();
	    panel_label_emprunt_utilisateur.add(label_emprunt_utilisateur);
	    
	    JPanel panel_label_livre_dispo = new JPanel();
	    label_livre_dispo = new JLabel("Livre(s) disponible(s) : ");
	    panel_label_livre_dispo.add(label_livre_dispo);
	    
	    label_tout_emprunts = new JLabel("Tout les emprunts : ");
	    
	    
	    
	    
		framePpl = new JFrame();

		barre_de_menu.add(User_menu);
		barre_de_menu.add(Livre_menu);

		
		JPanel paneau_principal = new JPanel();
		JPanel conteneur = new JPanel();
		
		paneau_principal.setLayout(new BorderLayout());
		paneau_principal.add(barre_de_menu, BorderLayout.NORTH);
		conteneur.setLayout(new GridLayout(1,3));
		
		JPanel pane_emprunt_utilisateur = new JPanel();
		pane_emprunt_utilisateur.setLayout(new BorderLayout());
		pane_emprunt_utilisateur.setBackground(new Color(187,213,251));
		pane_emprunt_utilisateur.add(panel_label_emprunt_utilisateur, BorderLayout.NORTH);
		
		
		
		JPanel pane_conteneur_emprunt = new JPanel();
		JPanel pane_liste_emprunt = new JPanel();
		
		pane_emprunt_utilisateur.add(pane_conteneur_emprunt, BorderLayout.CENTER);
		
		//Ajouter tout les emprunts de l'utilisateur dans la premi�re colonne de la fen�tre principale.
		pane_liste_emprunt.setLayout(new GridLayout(0,1));
		
		for(int nb_emprunt = 0; nb_emprunt < Interface_global.emprunt_de_l_utilisateur_actuel.size(); nb_emprunt++) {
		    JLabel label_livre_emprunte = new JLabel();
		    label_livre_emprunte.setText(Interface_global.emprunt_de_l_utilisateur_actuel.get(nb_emprunt));
		    pane_liste_emprunt.add(label_livre_emprunte);
		}
		
		
		pane_conteneur_emprunt.add(pane_liste_emprunt);
		
		JPanel pane_livre_dispo = new JPanel();
		pane_livre_dispo.setLayout(new BorderLayout());
		pane_livre_dispo.add(panel_label_livre_dispo, BorderLayout.NORTH);
		
		
		JPanel conteneur_panel_liste_livre = new JPanel();
		
		JPanel pane_liste_livre = new JPanel();
		pane_liste_livre.setLayout(new GridLayout(0,2));
		
		conteneur_panel_liste_livre.add(pane_liste_livre);
		Boolean tester_livre_empainter = false;
		for (int i = 0; i < Interface_global.nomLivre.size(); i++) {
			for (int j = 0; j < Interface_global.livres_dans_emprunte.size(); j++) {
				if(Interface_global.nomLivre.get(i).equals(Interface_global.livres_dans_emprunte.get(j))){
					// System.out.println(Interface_global.nomLivre.get(i)+ "==" +Interface_global.livres_dans_emprunte.get(j));
					// System.out.println("status equals == " + Interface_global.nomLivre.get(i).equals(Interface_global.livres_dans_emprunte.get(j)));
					tester_livre_empainter = true;
					break;
				}
			}
			//System.out.println("status tester_livre_empainter == " + tester_livre_empainter);
			JPanel panel_label_livre = new JPanel();
			JLabel label_livre = new JLabel(Interface_global.nomLivre.get(i));
			panel_label_livre.add(label_livre);
			
			JPanel panel_btn_emprunter = new JPanel();
			JButton btn_emprunter = new JButton("Emprunter");
			panel_btn_emprunter.add(btn_emprunter);
			int identifiant = i;
			btn_emprunter.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					liv.emprinter_livre(Interface_global.nomLivre.get(identifiant));
					
					emp.tester_livre_emprainter();
					//System.out.println(Interface_global.nomLivre.get(identifiant));
				}
			});

			if(tester_livre_empainter == true){
				System.out.println("tous les livre dispo sisa reo oh");
			}
			else{
				pane_liste_livre.add(panel_label_livre);
				pane_liste_livre.add(panel_btn_emprunter);
				pane_livre_dispo.add(conteneur_panel_liste_livre, BorderLayout.CENTER);
			}

			tester_livre_empainter = false;
				
        }  
		
		
		JPanel pane_tout_les_emprunts = new JPanel();
		//pane_tout_les_emprunts.add(label_tout_emprunts);
		pane_tout_les_emprunts.setLayout(new BorderLayout());
		
		JPanel pane_label_tout_les_emprunts = new JPanel();
		pane_label_tout_les_emprunts.add(label_tout_emprunts);
		
		JPanel pane_conteneur_panel_tout_emprunt = new JPanel();
		
		JPanel pane_liste_tout_emprunts = new JPanel();
		pane_liste_tout_emprunts.setLayout(new GridLayout(0, 2));
		
		
		//ajout de la liste de tous les emprunt
		tout_les_emprunts();
		for(int i_emp = 0; i_emp < Interface_global.tout_emprunts.size(); i_emp++) {
		    String result_emp[] = Interface_global.tout_emprunts.get(i_emp).split(":");
		    JPanel pane_label_emprunteur = new JPanel();
		    JLabel label_emprunteur = new JLabel(result_emp[0]+" : ");
		    pane_label_emprunteur.add(label_emprunteur);
		    JPanel pane_label_livre_emprunte = new JPanel();
		    JLabel label_livre_emprunte = new JLabel(result_emp[1]);
		    pane_label_livre_emprunte.add(label_livre_emprunte);
		    
		    pane_liste_tout_emprunts.add(pane_label_emprunteur);
		    pane_liste_tout_emprunts.add(pane_label_livre_emprunte);
		}
		
		
		pane_conteneur_panel_tout_emprunt.add(pane_liste_tout_emprunts);
		
		
		pane_tout_les_emprunts.add(pane_label_tout_les_emprunts, BorderLayout.NORTH);
		pane_tout_les_emprunts.add(pane_conteneur_panel_tout_emprunt, BorderLayout.CENTER);
		
		conteneur.add(pane_emprunt_utilisateur);
		conteneur.add(pane_livre_dispo);
		conteneur.add(pane_tout_les_emprunts);
		
		
		paneau_principal.add(conteneur, BorderLayout.CENTER);
		
		framePpl.setContentPane(paneau_principal);
		framePpl.setSize(1080, 720);
		//framePpl.setResizable(false);
		framePpl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePpl.setLocationRelativeTo(null);
		framePpl.setVisible(true);
	}
	
	public void tout_les_emprunts() {
        String fichier_emprunt = "./Emprunt.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(fichier_emprunt))){
            String line_emprunt;
            while((line_emprunt = br.readLine()) != null) {
                Interface_global.tout_emprunts.add(line_emprunt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
