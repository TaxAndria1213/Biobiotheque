package Controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import Modele.Interface_global;

public class Emprunt {
    public String utilisateur;
    public String livre_emprunter;

    public Emprunt() {
    }
    public Emprunt(String livre) {
        this.utilisateur = Interface_global.utilisateur_actuel.getNom()+":";
        this.livre_emprunter = livre;
    }
    //Enregietrement des emprainte dans le fichier "Emprunt.txt"
    public void enregistrer_une_emprunt() {
        try {
            String browse = "./Emprunt.txt";
            File f = new File(browse);
            
            if(f.createNewFile()) {
                System.out.println("fichier cr��!");
                ecrire_emprunt(f);
            }
            else {
                ecrire_emprunt(f);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    //ecriture dan le fichier
    public void ecrire_emprunt(File f) {
        try {
            String chemin = "./Emprunt.txt";
            FileOutputStream fos = new FileOutputStream(chemin, true);
            String nom = this.utilisateur;
            String livre_emprunt = this.livre_emprunter+"\n";
            byte[] byteNom = nom.getBytes();
            fos.write(byteNom);
            byte[] byteMdp = livre_emprunt.getBytes();
            fos.write(byteMdp);
            fos.close();
            JOptionPane.showMessageDialog(null, "vous pouvez recuperer le livre !", "Emprunt reussite", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e);
        }  
    }
    public void Livres_empraint_array(String livres){
        Interface_global.nomLivre_deja_emprainter.add(livres);
    }
    //verifier les livres deja emprainter
    public void lecture_emprunt()
    {
        try(BufferedReader emprunt = new BufferedReader(new FileReader("./Emprunt.txt"))) {
            String les_livres_emprainter;
            while((les_livres_emprainter = emprunt.readLine()) != null)
            {
                String tableau_get_livre_emprunter[] = les_livres_emprainter.split(":");
                for(int j = 0; j < tableau_get_livre_emprunter.length ; j++) {
                    Livres_empraint_array(tableau_get_livre_emprunter[j]);
				}
            }
            // System.out.println("livre emprenter function lecture : "+ Interface_global.nomLivre_deja_emprainter);
        } catch (Exception e) {
            System.out.println("erreur");
            e.printStackTrace();
        }
    }
    public void recuperer_nom_livres_seulement() {
        for (int index = 0; index < Interface_global.nomLivre_deja_emprainter.size(); index++) {
            if (index % 2 != 0) {
                Livres livres = new Livres();
                livres.ecriture_dans_le_fichier(Interface_global.nomLivre_deja_emprainter.get(index)+"\n", new File("./livre_emprainter.txt"));
            }    
        }
        System.out.println("les livres deja emprainter " + Interface_global.nomLivre_deja_emprainter);
    }
    // // fonction qui permet d'enlever les livre deja emprainter
    public void tester_livre_emprainter(){
        try (BufferedReader lecture_fichier_livre = new BufferedReader(new FileReader( new File("./livre_emprainter.txt"))))
        {
            String les_livres_emprainter;
            while ((les_livres_emprainter = lecture_fichier_livre.readLine()) != null) 
            {
					Interface_global.livres_dans_emprunte.add(les_livres_emprainter);
            }
            System.out.println(Interface_global.nomLivre);
        } catch (IOException e) {
            System.out.println("erreur de selection");
            e.printStackTrace();
        }
    }
    
    
}
