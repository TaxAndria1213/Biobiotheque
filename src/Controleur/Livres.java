package Controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import Modele.Interface_global;

/**
 * Livres
 */
public class Livres implements Interface_global{
    
    static String livre_non_dispo, status_emprunter_ok, status_emprunter_ko;
    int index_remover;
    //Ajout nouveau liste dans le fichier avec FileOutputStream
    public void ecriture_dans_le_fichier(String nom_liv, File fichier_cible ){
        try {
            FileOutputStream ecriture_donnee = new FileOutputStream(fichier_cible, true);
            byte[] nom_des_livres = nom_liv.getBytes();
            ecriture_donnee.write(nom_des_livres);
            ecriture_donnee.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    public void ajout_livre(String nom_du__livre_a_ajouter)
    {
        try {
            if (fichier_livre.createNewFile()) {
                ecriture_dans_le_fichier(nom_du__livre_a_ajouter, fichier_livre);
            } else {
                ecriture_dans_le_fichier(nom_du__livre_a_ajouter, fichier_livre);
            }
            livre_env_dans_array();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    public void nouvelle_livre(String nouv_livre) {
        Boolean test_donner_existant = false;
        livre_env_dans_array();
        for (int i = 0; i < Interface_global.nomLivre.size(); i++) {
            if (nouv_livre.equals(Interface_global.nomLivre.get(i))) {
                test_donner_existant = true;
                System.out.println(Interface_global.nomLivre.get(i));
                break;
            }
        }
        if (test_donner_existant == true) {
            System.out.println("cette livre existe deja");
        } else {
            ajout_livre(nouv_livre);
        }    
    }
    public void Livres_array(String livres){
        Interface_global.nomLivre.add(livres);
    }
    
    

    public void livre_env_dans_array() {
        try (BufferedReader lecture_fichier_livre = new BufferedReader(new FileReader(fichier_livre)))
        {
            String les_livres;
            while ((les_livres = lecture_fichier_livre.readLine()) != null) 
            {
					Livres_array(les_livres);
            }
            System.out.println(Interface_global.nomLivre);
        } catch (IOException e) {
            System.out.println("erreur de selection");
            e.printStackTrace();
        }
    }

    public void emprinter_livre(String nom_du_livre_aempr) {  
        new Emprunt(nom_du_livre_aempr).enregistrer_une_emprunt();
    }
    @Override
    public void ajouterDonneeClient(String line) {
        
    }
    @Override
    public void Livres_empraint_array(String livres) {
        
    }
}