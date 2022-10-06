package Controleur;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import Modele.Interface_donne_static;

/**
 * Livres
 */
public class Livres implements Interface_donne_static{
    int index_remover;
    public Livres(){
    }
    //Ajout nouveau liste dans le fichier avec Buffered
    static void ecriture_dans_le_fichier(String nom_liv ){
        try {
            FileOutputStream ecriture_donnee = new FileOutputStream(fichier_livre, true);
            byte[] nom_des_livres = nom_liv.getBytes();
            ecriture_donnee.write(nom_des_livres);
            ecriture_donnee.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    static void ajout_livre(String nom_du__livre_a_ajouter)
    {
        try {
            if (fichier_livre.createNewFile()) {
                ecriture_dans_le_fichier(nom_du__livre_a_ajouter);
            } else {
                ecriture_dans_le_fichier(nom_du__livre_a_ajouter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    public void nouvelle_livre(String nouv_livre) {
        livre_env_dans_array();
        Boolean test_donner_existant = false;
        for (int i = 0; i < Interface_donne_static.nomLivre.size(); i++) {
            if (nouv_livre.equals(Interface_donne_static.nomLivre.get(i))) {
                test_donner_existant = true;
                System.out.println(Interface_donne_static.nomLivre.get(i));
                break;
            }
        }
        if (test_donner_existant == true) {
            System.out.println("cette livre existe deja");
        } else {
            ajout_livre(nouv_livre);
        }    
    }
    public void Lecture(String livres){
        Interface_donne_static.nomLivre.add(livres);
    }

    public void livre_env_dans_array() {
        try (BufferedReader lecture_fichier_livre = new BufferedReader(new FileReader(fichier_livre)))
        {
            String les_livres;
            while ((les_livres = lecture_fichier_livre.readLine()) != null) 
            {
                Lecture(les_livres);
            }
        } catch (IOException e) {
            System.out.println("erreur de selection");
            e.printStackTrace();
        }
    }

    // public String nom_du_livre_emprt(String nom_liv)
    // {
    //     if (nom_liv != null) {
    //         return nom_liv;  
    //     } else {
    //        return null; 
    //     }
    // }

    public void emprinter_livre(String nom_du_livre_aempr) {
        livre_env_dans_array();
        Boolean visibilite_livre_aempr = false;
        for (int i = 0; i < nomLivre.size(); i++) {
            if (nom_du_livre_aempr.equals(nomLivre.get(i)))
            {
                visibilite_livre_aempr = true;
                index_remover = i;
                break;
                
            }
         }
        if (visibilite_livre_aempr == true) {
            System.out.println("Vous avez emprenter " + nom_du_livre_aempr);
            nomLivre.remove(index_remover);
            System.out.println("status " +nomLivre);  
        }
        else
        {
            System.out.println(nom_du_livre_aempr + " n'existe pas dans nos librairie"); 
        }  
    }
}