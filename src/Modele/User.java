package Modele;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class User {
	private String nom;
	private String mot_de_passe;
	
	public User(String nom, String mdp) {
		this.nom = nom+":";
		this.mot_de_passe = mdp+"\n";
	}
	
	private String getNom() {
		return this.nom;
	}
	
	private String getMotDePass() {
		return this.mot_de_passe;
	}
	
	public void enregistrer() {
		try {
			String browse = "./donnees_user.txt";
			File f = new File(browse);
			
			if(f.createNewFile()) {
				System.out.println("fichier créé!");
				ecrire(f);
			}
			else {
				ecrire(f);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void ecrire(File f) {
		try {
			String chemin = "./donnees_user.txt";
			FileOutputStream fos = new FileOutputStream(chemin, true);
			String nom = this.getNom();
			String mdp = this.getMotDePass();
			byte[] byteNom = nom.getBytes();
			fos.write(byteNom);
			byte[] byteMdp = mdp.getBytes();
			fos.write(byteMdp);
			fos.close();
			JOptionPane.showMessageDialog(null, "Enregistrement réussit.", "Inscription", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
