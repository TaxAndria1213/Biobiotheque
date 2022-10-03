package Modele;

import java.io.*;
import java.util.ArrayList;

public interface Interface_donne_static {
    
    static File  fichier_livre = new File("Livres.txt");
    static ArrayList<String> nomLivre = new ArrayList<>();
    
    //Ajout nouveau liste dans le fichier avec Buffered
    static void ecriture_dans_le_fichier(String nom_liv ){
        try {
            FileOutputStream ecriture_donnee = new FileOutputStream(fichier_livre, true);
            byte[] nom_des_livres = nom_liv.getBytes();
            ecriture_donnee.write(nom_des_livres);
            ecriture_donnee.close();
        } catch (Exception e) {
            //TODO: handle exception
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
    //lire les livre dans le fichier livres.txt et l'enregistre dans l'array nomLivre
    static ArrayList<String> Lecture(){
        try (BufferedReader lecture_fichier_livre = new BufferedReader(new FileReader(fichier_livre)))
        {
            String les_livres;
            while ((les_livres = lecture_fichier_livre.readLine()) != null) 
            {
                nomLivre.add(les_livres);
            }
            return nomLivre;
        } catch (IOException e) {
            System.out.println("erreur de selection");
            e.printStackTrace();
        }
        return null;
    }   
}