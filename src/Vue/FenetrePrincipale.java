package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Controleur.Livres;
import Modele.Interface_donne_static;

	


public class FenetrePrincipale {
	private JFrame framePpl;
	private JLabel label_emprunt_utilisateur;
	private JLabel label_livre_dispo;
	private JLabel label_tout_emprunts;
	JMenuBar barre_de_menu = new JMenuBar();
	JMenu User_menu = new JMenu("Utilisateur");
	JMenu Livre_menu = new JMenu("Livres");
	
	
	
	public FenetrePrincipale() {
	    new Livres().livre_env_dans_array();
	    label_emprunt_utilisateur = new JLabel("Emprunt de l'utilisateur : ");
	    
	    JPanel panel_label_livre_dispo = new JPanel();
	    label_livre_dispo = new JLabel("Livre(s) disponible(s) : ");
	    panel_label_livre_dispo.add(label_livre_dispo);
	    
	    label_tout_emprunts = new JLabel("Tout les emprunts : ");
	    
	    label_emprunt_utilisateur.setBackground(Color.WHITE);
	    
		framePpl = new JFrame();

		barre_de_menu.add(User_menu);
		barre_de_menu.add(Livre_menu);

		
		JPanel paneau_principal = new JPanel();
		JPanel conteneur = new JPanel();
		
		paneau_principal.setLayout(new BorderLayout());
		paneau_principal.add(barre_de_menu, BorderLayout.NORTH);
		conteneur.setLayout(new GridLayout(1,3));
		
		JPanel pane_emprunt_utilisateur = new JPanel();
		pane_emprunt_utilisateur.setBackground(new Color(187,213,251));
		pane_emprunt_utilisateur.add(label_emprunt_utilisateur);
		
		JPanel pane_livre_dispo = new JPanel();
		pane_livre_dispo.setLayout(new BorderLayout());
		pane_livre_dispo.setBackground(new Color(247, 223, 179));
		pane_livre_dispo.add(panel_label_livre_dispo, BorderLayout.NORTH);
		
		//JPanel pane_liste = new JPanel();
		
		JPanel pane_liste_livre = new JPanel();
		pane_liste_livre.setLayout(new GridLayout(0,2));
		
		
		
		
		
		
		String fichier_live = "./Livres.txt";
		/*try(BufferedReader br = new BufferedReader(new FileReader(fichier_live))) {
            String line_livre;
            int compter_livre = 0;
            while((line_livre = br.readLine()) != null) {
                String res_livre[] = line_livre.split(":");
                compter_livre += 1;
                if(res_livre[1].equals("0")) {
                    JPanel panel_label_livre = new JPanel();
                    JLabel label_livre = new JLabel();
                    panel_label_livre.add(label_livre);
                    
                    JPanel panel_btn_emprunter = new JPanel();
                    JButton btn_emprunter = new JButton("Emprunter");
                    panel_btn_emprunter.add(btn_emprunter);
                    
                    pane_liste_livre.add(panel_label_livre);
                    pane_liste_livre.add(panel_btn_emprunter);
                    pane_livre_dispo.add(pane_liste_livre, BorderLayout.CENTER);
                    
                    JList<Object> livre = new JList<Object>();
                                        
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }*/
		for (int i = 0; i < Interface_donne_static.nomLivre.size(); i++) {
            JPanel panel_label_livre = new JPanel();
            JLabel label_livre = new JLabel(Interface_donne_static.nomLivre.get(i));
            panel_label_livre.add(label_livre);
            
            JPanel panel_btn_emprunter = new JPanel();
            JButton btn_emprunter = new JButton("Emprunter");
            panel_btn_emprunter.add(btn_emprunter);
            int identifiant = i;
            
            btn_emprunter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    System.out.println(Interface_donne_static.nomLivre.get(identifiant));
                }
            });
            
            pane_liste_livre.add(panel_label_livre);
            pane_liste_livre.add(panel_btn_emprunter);
            pane_livre_dispo.add(pane_liste_livre, BorderLayout.CENTER);
        }  
		
		
		JPanel pane_tout_les_emprunts = new JPanel();
		pane_tout_les_emprunts.setBackground(new Color(185, 248, 175));
		pane_tout_les_emprunts.add(label_tout_emprunts);
		
		
		
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
}
