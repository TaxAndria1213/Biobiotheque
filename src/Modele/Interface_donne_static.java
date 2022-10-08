package Modele;

import java.io.*;
import java.util.ArrayList;

public interface Interface_donne_static {
    
    static File  fichier_livre = new File("Livres.txt");
    static ArrayList<String> nomLivre = new ArrayList<>();
    public void Livres_array(String livres);
}