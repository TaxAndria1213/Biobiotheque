package Modele;

import java.util.ArrayList;

public interface Interface_global {
	public static ArrayList<String> user = new ArrayList<String>();
	public static User utilisateur_actuel = new User(null, null);

	public void ajouterDonneeClient(String line);
}
