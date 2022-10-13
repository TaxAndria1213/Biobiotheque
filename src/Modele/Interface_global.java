package Modele;

import java.io.File;
import java.util.ArrayList;

public interface Interface_global {
	public static ArrayList<String> user = new ArrayList<String>();
	public static User utilisateur_actuel = new User(null, null);
	public static ArrayList<String> tout_emprunts = new ArrayList<String>();
    static ArrayList<String> nomLivre_deja_emprainter = new ArrayList<>();
	static File  fichier_livre = new File("Livres.txt");
    static ArrayList<String> nomLivre = new ArrayList<>();
	static ArrayList<String> livres_dans_emprunte = new ArrayList<>();
    public void Livres_array(String livres);

	public void ajouterDonneeClient(String line);
	
    public void Livres_empraint_array(String livres);
}
