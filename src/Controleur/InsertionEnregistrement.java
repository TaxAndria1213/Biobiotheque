package Controleur;

import Modele.User;

public class InsertionEnregistrement {
	
	public InsertionEnregistrement(String nom, char[] mdp) {
			User utilisateur = new User(nom, new String(mdp));
			utilisateur.enregistrer();
	}
}
