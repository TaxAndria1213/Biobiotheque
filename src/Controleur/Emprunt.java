package Controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JOptionPane;

import Modele.Interface_global;

public class Emprunt {
    public String utilisateur;
    public String livre_emprunter;
    
    public Emprunt(String livre) {
        this.utilisateur = Interface_global.utilisateur_actuel.getNom()+":";
        this.livre_emprunter = livre;
    }
    
    public Emprunt() {
        lire_emprunt();
    }
    
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
            JOptionPane.showMessageDialog(null, "vous pouvez r�cup�rer le livre !", "Emprunt r�ussite", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    
    public void lire_emprunt() {
        String fichier_emprunt = "./Emprunt.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(fichier_emprunt))) {
            String line;
            while((line=br.readLine()) != null) {
                String resultat_utilisateur[] = line.split(":");
                //System.out.println(Interface_global.utilisateur_actuel.getNom());
                if(resultat_utilisateur[0].equals(Interface_global.utilisateur_actuel.getNom())) {
                    Interface_global.emprunt_de_l_utilisateur_actuel.add(resultat_utilisateur[1]);
                }
            }
            
            System.out.println(Interface_global.emprunt_de_l_utilisateur_actuel);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    
}
