/**
 * Classe représentant un Passager  Regulier , Etudiant , Senior  ou Handicape  
 * @author :  Landry ABLOH  et  Darius SEHOUBO 
 * 
 */


public class Passager {

    public enum Categorie {
        Regulier, Etudiant , Senior , Handicape
    }

    Categorie categorie ;
    
/**
 * Constructeur de la classe Passager
 * @param categorie : la categorie du passager qui est une enumeration de valeurs : Regulier, Etudiant , Senior , Handicape
    
 */
    public Passager(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setCategorie(Categorie categorie){
        this.categorie = categorie;
    }

    public Categorie get_Categorie(){
        return categorie;
    }





}


