package Modele;
/**
 * Livres
 */
public class Livres implements Interface_donne_static{
    String insertion_error;
    public Livres(){
    }

    public void nouvelle_livre(String nouv_livre) {
        Boolean test_donner_existant = false;
        for (int i = 0; i < nomLivre.size(); i++) {
            if (nouv_livre.equals(nomLivre.get(i))) {
                test_donner_existant = true;
                break;
            }
        }
        if (test_donner_existant == true) {
            System.out.println("cette livre existe deja");
        } else {
            Interface_donne_static.ajout_livre(nouv_livre);
        }    
    }

    public void chaque_livre() {
        for ( String livres : Interface_donne_static.Lecture()) {
            System.out.println(livres);
        } 
    }

    public String nom_du_livre_emprt(String nom_liv)
    {
        if (nom_liv != null) {
            return nom_liv;  
        } else {
           return null; 
        }
    }

    public void emprinter_livre(String nom_du_livre_aempr) {
        Boolean visibilite_livre_aempr = false;
        for (int i = 0; i < nomLivre.size(); i++) {
            if (nom_du_livre_aempr.equals(nomLivre.get(i)))
            {
                visibilite_livre_aempr = true;
                break;
            }
        }
        if (visibilite_livre_aempr == true) {
            System.out.println("Vous avez emprenter " + nom_du_livre_aempr);
        }
        else
        {
            System.out.println(nom_du_livre_aempr + " n'existe pas dans nos librairie"); 
        }    
    }
}