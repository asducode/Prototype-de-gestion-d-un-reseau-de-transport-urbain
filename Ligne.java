import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Classe représentant une ligne de transport en commun  
 * 
 * @author :  Landry ABLOH  et  Darius SEHOUBO 
 * 
 */
public class Ligne {


    Type type;
    String nom ; 
    String [] stations; // La liste de stations qui appartiennent à la 
    
    enum Type{
        Tram,
        Bus,
        Metro,
    }

    int vitesse;

 
/**
 * Geter du type de la ligne 
 *  */ 
    public Type getType() {
        return type;
    }
/**
 * Seter du type de la ligne
 */
    public void setType(Type type) {
        this.type = type;
    }
/**
 * Geter de la vitesse de la ligne  
 */
    public int getVitesse() {
        return vitesse;
    }
/** 
 * Seter de la vitesse de la ligne
 */
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
/**
 * Geter du nom de la ligne 
 */
    public String getNom() {
        return nom;
    }
/**
 * Seter du nom de la ligne
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
/**
 * Geter de la liste des stations de la ligne
 */
    public String [] getStations() {
        return stations;
    }
    /**
     * Seter de la liste des stations de la ligne
     */
    public void setStations(String[] stations) {
        this.stations = stations;
    }

/**
 * Constructeur de la classe Ligne
 * @param nom : nom de la ligne
 */
    public Ligne(String nom) {
        this.nom = nom;
    
    }

/**
 * Methode pour ajouter la liste de toute les lignes . 
 * @param listeLigne : liste de toutes les lignes . Pour le string present à la position @param i  de @param listeLigne , on crée une ligne avec ce nom
 * @return : la ligne créee en utilisant le constructeur de la classe Ligne
 * 
 *  */
   static Ligne creationLigne(List<String> listeLigne, int i){
        String nomLigne = listeLigne.get(i); 
        return new Ligne(nomLigne);
    }

/**
 * Methode pour ajouter la liste de toutes les stations associées à une ligne correspondante . 
 * 
 */


    void UpgradeLigne(){
        if(this.nom.equals("Millenium")){
            this.type=Type.Metro ;
            List<String> stationsList = Arrays.asList("Jubilee Place", "King's Way", "GrandCentral", "Market Square", "Northgate Shopping Centre");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Heritage")){
            this.type=Type.Metro;
            List<String> stationsList = Arrays.asList("Ashford Road","Brookside Avenue","Fairfields","GrandCentral","Town Hall","Victoria Docks");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("University")){
            this.type=Type.Bus;
            List<String> stationsList = Arrays.asList("Ashford Road", "Castle Hill" , "High Street", "Northgate Shopping Centre" , "Xenobiotics Research Centre" , "Victoria Docks");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Riverview")){
            this.type=Type.Bus;
            List<String> stationsList = Arrays.asList("Victoria Docks","Waterfront", "Union Street", "Southbank Place");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Parkland")){
            this.type=Type.Tram;
            List<String> stationsList = Arrays.asList("Southbank Place","GrandCentral","Eastbourne West", "Brookside Avenue","King's Way","Jubilee Place","Parkside Place");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Market")){
            this.type=Type.Tram;
            List<String> stationsList = Arrays.asList("Eastbourne West", "Fairfields", "Market Square", "Victoria Docks");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Greenway")){
            this.type=Type.Bus;
            List<String> stationsList = Arrays.asList("Zephyr Close", "Dunham End", "King's Way", "GrandCentral", "Fairfields", "Lakeside", "High Street");
            Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        if(this.nom.equals("Southern Loop")){
            this.type=Type.Bus;
            List<String> stationsList = Arrays.asList("Eastbourne West","Ivy Lane","Oakwoods","Queensbridge","Riverside","York Road","Parkside Place");
                Collections.sort(stationsList);
            this.setStations(stationsList.toArray(new String[0]));
        }
        vitesse = switch(this.type){
            case Tram -> 400;
            case Bus -> 300;
            case Metro -> 500;
            default -> 0;
        };
    }

/**
 * Methode pour afficher les informations de la ligne
 * */
    String displayInformation(){
    StringBuilder sb = new StringBuilder();
    sb.append("la ligne ");
    sb.append(this.getNom());
    sb.append(" est une ligne de ");
    sb.append(this.getType());
    sb.append(".");
    sb.append("\n");
    sb.append("Dans cette station passe: ");
    for(int i=0; i<this.stations.length;i++){
        sb.append(this.stations[i]);
        if(i==this.stations.length-1){
            sb.append(".");
        }
        else{
        sb.append("--");}
    }
    sb.append("\n");
    sb.append("Venez vite nous rendre visite !");
    sb.append("\n");
    return sb.toString();
}


/*
public String afficheItineraire(String Stationdebut , String Stationfin) {
int indexDebut =0 ;
int indexFin = 0 ;
//Station debut = new Station();
String itineraire = " ";
for(int i = 0 ; i<= listeStationAssociesOrdonne.size();i++) {


 if(listeStationAssociesOrdonne.get(i).nom.equals(Stationdebut)) {

//debut = listeStationAssociesOrdonne.get(i) ;
    indexDebut = i ;
 }

 if(listeStationAssociesOrdonne.get(i).nom.equals(Stationfin)) {
    indexFin = i ;
    
    }

}

for(int i = indexDebut ; i<= indexFin;i++) { 

itineraire +=listeStationAssociesOrdonne.get(i).nom +" -->";

}

return itineraire ;

}

*/

}