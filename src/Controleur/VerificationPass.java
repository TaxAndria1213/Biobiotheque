package Controleur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modele.Interface_global;
import Vue.FenetrePrincipale;

public class VerificationPass implements Interface_global {

	public VerificationPass(String nom, char[] mdp, JFrame frame) {
		String fichierUtilisateur = "./donnees_user.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(fichierUtilisateur))) {
			String line;
			while ((line = br.readLine()) != null) {
				String res[] = line.split(":");
				for(int j = 0; j < res.length ; j++) {
					ajouterDonneeClient(res[j]);
				}
			}
			verifier(nom, mdp, frame); 
		} catch (IOException e) {
			System.out.println("An error occured !");
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterDonneeClient(String line) {
		
		Interface_global.user.add(line);
	}
	
	public void verifier(String nom, char[] mdp, JFrame frame) {
		try {
			String pass = "";
			ArrayList<String> verifie = Interface_global.user;
			System.out.println(nom);
			
			//v�rification de la connexion
			for(int i = 0; i < verifie.size(); i++) {
				while(i%2 == 0) {
					if(verifie.get(i).equals(nom)) {
						pass = verifie.get(i+1);
						if(pass.equals(new String(mdp))) { //si le mot de passe est correcte, 
							frame.dispose(); //fermer le fen�tre de connexion
							//JOptionPane.showMessageDialog(null, "vous �tes dans l'application !", "connexion r�ussite", JOptionPane.INFORMATION_MESSAGE); //ouvrir le fen�tre principal
							Interface_global.utilisateur_actuel.setNom(nom);
							Interface_global.utilisateur_actuel.setMotDePass(new String(mdp));
							new FenetrePrincipale();
							System.out.println("L'utilisateur actuelle est : "+Interface_global.utilisateur_actuel.getNom());
						}
						else {
							JOptionPane.showMessageDialog(null, "Veuiller entrer un mot de passe valide !", "Erreur", JOptionPane.WARNING_MESSAGE);
							Interface_global.user.clear();
						}
					}
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void effacerChamps(JTextField champsNom, JPasswordField champsMdp) {
		champsNom.setText("");
		champsMdp.setText("");
	}

	@Override
	public void Livres_empraint_array(String livres) {
		
	}

	@Override
	public void Livres_array(String livres) {
		
	}
}
