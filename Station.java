import java.util.List;
/**
 * Classe représentant une Station d'arrêt de Bus , Tram ou Métro
 * 
 * @author :  Landry ABLOH  et  Darius SEHOUBO 
 * 
 */
public class Station{
    String nom;
    boolean accHand;
    boolean guichets;
    boolean baguages;
    boolean info;
    boolean toilette;
    boolean shop;
    boolean restaurant;
    double [] longitude;
    double [] latitude ;


/**
 * Constructeur de la classe Station 
 * @param nom        le nom de la station
 * @param accHand    indique l'accessibilité pour les personnes handicapées
 * @param guichets   indique si la station possède des guichets
 * @param baguages   indique si la station gère des services de bagages
 * @param info       indique si la station fournit des informations
 * @param toilette   indique si la station dispose de toilettes
 * @param shop       indique si la station comprend un magasin
 * @param restaurant indique si la station comprend un restaurant
 *  */  
  public Station(String nom, boolean accHand, boolean guichets, boolean baguages, boolean info, boolean toilette,
    boolean shop, boolean restaurant) {
        this.nom = nom;
        this.accHand = accHand;
        this.guichets = guichets;
        this.baguages = baguages;
        this.info = info;
        this.toilette = toilette;
        this.shop = shop;
        this.restaurant = restaurant;
        this.longitude = new double[]{0, 0, 0};  // Valeurs par défaut
        this.latitude = new double[]{0, 0, 0}; 
    }

/**
 * getter du nom d'une station
 *  */    
    public String getNom() {
        return nom;
    }

/**
 * setter du nom d'une station  
 */
    public void setNom(String nom) {
        this.nom = nom;
    }


/**
 * getter de l'accès handicapé d'une station
 */
    public boolean isAccHand() {
        return accHand;
    }
/**
 * setter de l'accès handicapé d'une station
 */
    public void setAccHand(boolean accHand) {
        this.accHand = accHand;
    }

/**
 * Setter de la disponibilité d'un gichet
 */
    public boolean isGuichets() {
        return guichets;
    }
/**
 * 
 * Getter de la disponibilité d'un gichet
 */
    public void setGuichets(boolean guichets) {
        this.guichets = guichets;
    }

/**
 * Getter de la disponibilité d'un espace pour les baguages
 * @return
 */

    public boolean isBaguages() {
        return baguages;
    }
/**
 * Setter de la disponibilité d'un espace pour les baguages
 * @param baguages
 */
    public void setBaguages(boolean baguages) {
        this.baguages = baguages;
    }
/**
 * Getter de la disponibilité d'information sur les lignes
 * @return
 */
    public boolean isInfo() {
        return info;
    }
/**
 * Setter de la disponibilité d'information sur les lignes
 * @param info
 */
    public void setInfo(boolean info) {
        this.info = info;
    }
/**
 * Getter de la disponibilité de toilette
 * @return
 */
    public boolean isToilette() {
        return toilette;
    }
/**
 * Setter de la disponibilité de toilette
 * @param toilette
 */
    public void setToilette(boolean toilette) {
        this.toilette = toilette;
    }
/**
 * Getter de la disponibilité de magasin
 * @return
 */
    public boolean isShop() {
        return shop;
    }
/**
 * Setter de la disponibilité de magasin
 * @param shop
 */
    public void setShop(boolean shop) {
        this.shop = shop;
    }
/**
 * Getter de la disponibilité de restaurant
 * @return
 */
    public boolean isRestaurant() {
        return restaurant;
    }
/**
 * Setter de la disponibilité de restaurant
 * @param restaurant
 */
    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

/**
 * Getter du tableau de la Latitude d'une station contenant ses coordonnées géographiques , degré  , minutes , secondes 
 */
    public double[] getLatitude() {
        return latitude;
    }
/**
 * Setter du tableau de la Latitude d'une station 
 */
    public void setLatitude(double[] latitude) {
        this.latitude = latitude;
    }
/**
 * Getter du tableau de la Longitude d'une station contenant ses coordonnées géographiques , degré  , minutes , secondes
 */
    public double[] getLongitude() {
        return longitude;
    }
/**
 * Setter du tableau de la Longitude d'une station
 */
    public void setLongitude(double[] longitude) {
        this.longitude = longitude;
    }

/**
* Méthode de création d'une station à partir d'une liste de stations et d'un indice
* @param : listeStation , liste de toutes les stations
* @param : i , indice de la station à créer
* @return : Station
*/
    static Station creationStation(List<String> listeStation, int i){
        String nomStation = listeStation.get(i); 
        return new Station(nomStation,true ,false,false,false,false,false,false);
    }


/**
 * @brief Met à jour les informations d'une station en fonction de son nom.
 * Cette méthode ajuste les caractéristiques d'une station (accessibilité, 
 * présence de guichets, espace pour les bagages, affichage des informations, 
 * disponibilité des toilettes et présence de commerces et restaurants) en fonction 
 * de son nom. De plus, elle met à jour les coordonnées géographiques 
 * (latitude et longitude) de la station si son nom est reconnu. 
 * @note : Cette mise à jour repose sur une liste prédéfinie de stations et leurs attributs spécifiques.
 * @return void
 */
    public  void UpgradeStation(){
        if(this.nom.equals("Ashford Road") || this.nom.equals("GrandCentral") || this.nom.equals("Victoria Docks")){
            this.baguages=true;

        }
        if(this.nom.equals("Ashford Road") || this.nom.equals("Brookside Avenue") || this.nom.equals("Fairfields") || this.nom.equals("GrandCentral") || this.nom.equals("Jubilee Place") || this.nom.equals("King's Way") || this.nom.equals("Market Square") || this.nom.equals("Northgate Shopping Centre") || this.nom.equals("Victoria Docks")){
            this.guichets=true;
        }
        if(this.nom.equals("Ashford Road") || this.nom.equals("King's Way") || this.nom.equals("Market Square") || this.nom.equals("Southbank Place")){
            this.accHand=false;
        }
        if(this.nom.equals("Ashford Road") || this.nom.equals("GrandCentral") || this.nom.equals("King's Way")){
            this.info=true;
        }
        if(this.nom.equals("GrandCentral") || this.nom.equals("High Street") || this.nom.equals("Market Square") || this.nom.equals("Northgate Shopping Centre") || this.nom.equals("Southbank Place")){
            this.shop= true;
        }
        if(this.nom.equals("GrandCentral") || this.nom.equals("Victoria Docks")){
            this.toilette=true;
        }  


        // coordonnée
        if (this.nom.equals("Ashford Road")) {
            this.setLatitude(new double[]{52, 39, 0.7884});
            this.setLongitude(new double[]{1, 17, 55.4244}); } 

        if (this.nom.equals("Brookside Avenue")) {
            this.setLatitude( new double[]{52, 38, 52.9512});
            this.setLongitude(new double[]{1, 17, 27.276});} 

        if (this.nom.equals("Castle Hill")) {
            this.setLatitude( new double[]{52, 38, 55.6116});
            this.setLongitude (new double[]{1, 18, 28.4184});}

        if (this.nom.equals("Dunham End")) {
            this.setLatitude( new double[]{52, 38, 55.608});
            this.setLongitude (new double[]{1, 16, 34.8996});}

        if (this.nom.equals("Eastbourne West")) {
            this.setLatitude( new double[]{52, 38, 45.9276});
            this.setLongitude (new double[]{1, 17, 14.1252});}
            
        if (this.nom.equals("Fairfields")) {
            this.setLatitude( new double[]{52, 38, 41.1936});
            this.setLongitude (new double[]{1, 17, 27.276});}
            
        if (this.nom.equals("GrandCentral")) {
            this.setLatitude( new double[]{52, 38, 25.3716});
            this.setLongitude (new double[]{1, 17, 20.5836});}
            
        if (this.nom.equals("High Street")) {
            this.setLatitude( new double[]{52, 38, 38.5332});
            this.setLongitude (new double[]{1, 18, 21.4956});}
            
        if (this.nom.equals("Ivy Lane")) {
            this.setLatitude( new double[]{52, 38, 37.1328});
            this.setLongitude (new double[]{1, 16, 52.2048});}
            
        if (this.nom.equals("Jubilee Place")) {
            this.setLatitude( new double[]{52, 38, 39.336});
            this.setLongitude (new double[]{1, 15, 50.832});}
            
        if (this.nom.equals("King's Way")) {
            this.setLatitude( new double[]{52, 38, 21.7608});
            this.setLongitude (new double[]{1, 16, 44.13});}
            
        if (this.nom.equals("Lakeside")) {
            this.setLatitude( new double[]{52, 38, 41.1936});
            this.setLongitude (new double[]{1, 18, 0.9612});} 

        if (this.nom.equals("Market Square")) {
            this.setLatitude( new double[]{52, 38, 19.77});
            this.setLongitude (new double[]{1, 17, 47.8104});}

        if (this.nom.equals("Northgate Shopping Centre")) {
            this.setLatitude( new double[]{52, 38, 23.712});
            this.setLongitude (new double[]{1, 18, 26.5716});}
            
        if (this.nom.equals("Oakwoods")) {
            this.setLatitude(new double[]{52, 38, 16.5516});
            this.setLongitude(new double[]{1, 16, 58.404});}

        if (this.nom.equals("Parkside Place")) {
            this.setLatitude( new double[]{52, 37, 17.1132});
            this.setLongitude (new double[]{1, 16, 23.5956});}

        if (this.nom.equals("Queensbridge")) {
            this.setLatitude( new double[]{52, 38, 1.0104});
            this.setLongitude (new double[]{1, 16, 42.9744});}

        if (this.nom.equals("Riverside")) {
            this.setLatitude( new double[]{52, 37, 57.0864});
            this.setLongitude (new double[]{1, 16, 24.5172});}

        if (this.nom.equals("Southbank Place")) {
            this.setLatitude( new double[]{52, 37, 55.3368});
            this.setLongitude (new double[]{1, 17, 18.9708});}

        if (this.nom.equals("Town Hall")) {
            this.setLatitude( new double[]{52, 38, 14.4528});
            this.setLongitude (new double[]{1, 17, 18.9708});}

        if (this.nom.equals("Union Street")) {
            this.setLatitude( new double[]{52, 37, 59.3292});
            this.setLongitude (new double[]{1, 17, 44.2572});}

        if (this.nom.equals("Victoria Docks")) {
            this.setLatitude( new double[]{52, 38, 7.17});
            this.setLongitude (new double[]{1, 18, 0.0396});}

        if (this.nom.equals("Waterfront")) {
            this.setLatitude( new double[]{52, 37, 57.2268});
            this.setLongitude (new double[]{1, 17, 56.8068});}

        if (this.nom.equals("Xenobiotics Research Centre")) {
            this.setLatitude( new double[]{52, 38, 9.2688});
            this.setLongitude(new double[]{1, 18, 21.9384});}

        if (this.nom.equals("York Road")) {
            this.setLatitude( new double[]{52, 38, 6.3312});
            this.setLongitude(new double[]{1, 16, 10.6752});}

        if (this.nom.equals("Zephyr Close")) {
            this.setLatitude(new double[]{52, 39, 5.4108});
            this.setLongitude (new double[]{1, 16, 48.0504});}
        
    }

/**
 * @brief Génère une description détaillée des équipements et services disponibles dans la station.
 * 
 * Cette méthode construit une chaîne de caractères contenant le nom de la station 
 * ainsi que ses différentes caractéristiques, telles que l'accessibilité, la présence 
 * de guichets, d'espaces pour les bagages, d'affichages d'informations, de toilettes, 
 * de boutiques et de restaurants.
 * 
 * @return : Une chaîne de caractères décrivant les services et équipements de la station.
 */
    String displayInformation(){
        StringBuilder sb = new StringBuilder();
        sb.append("la station ");
        sb.append(this.getNom());

        if(this.accHand==true){
            sb.append(" est accessible par les personnes à mobilité réduite, ");
        }
        else{ sb.append(" n'est pas accessible par les personnes à mobilité réduite, ");}

        sb.append("de plus");

        if(this.baguages==true){
            sb.append(" elle possède un espace pour les baguages.");
        }
        else{ sb.append(" ne possède pas d'espace pour les baguages. ");}

        sb.append(this.getNom());
        if(this.guichets==true){
            sb.append(" a un guichet accessible et ");
        }
        else{ sb.append(" n'a pas de guichet accessible et ");}


        if(this.info==true){
            sb.append("affiche les informations des lignes.");
        }
        else{sb.append("n'affiche pas les informations des lignes.");}

        if(this.toilette==true){
            sb.append(" Elle contient aussi des toilettes. ");
        }
        else{
            sb.append(" Elle ne contient pas de toilletes. ");}

        sb.append(this.getNom());

        if(this.shop==true){
            sb.append(" abrite une large gamme de boutique. ");
        }
        else{
            sb.append(" n'héberge pas de boutique. ");}

        sb.append("Finalement, ");
        sb.append(this.getNom());

        if(this.restaurant==true){
            sb.append(" possède des restaurant. ");
        }
        else{
            sb.append(" ne possède des restaurant. ");}
            
        sb.append("\n");
        sb.append("Venez vite nous rendre visite !");
        sb.append("\n");
        return sb.toString();
    }




}