import java.util.LinkedList;
import java.util.Scanner;
import Passager.Categorie;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;
import java.text.NumberFormat.Style;

public class Main {

    static String[] listeStationA = { "Ashford Road", "Castle Hill", "Brookside Avenue", "Dunham End",
            "Eastbourne West", "Fairfields", "GrandCentral", "High Street", "Ivy Lane", "Jubilee Place", "King's Way",
            "Lakeside", "Market Square", "Northgate Shopping Centre", "Oakwoods", "Parkside Place", "Queensbridge",
            "Riverside", "Southbank Place", "Town Hall", "Union Street", "Victoria Docks", "Waterfront",
            "Xenobiotics Research Centre", "York Road", "Zephyr Close" };
    static String[] listeLigneA = { "Millenium", "Heritage", "University", "Riverview", "Parkland", "Market",
            "Greenway", "Southern Loop" };

    static List<String> listeStation = new ArrayList<>();
    static List<String> listeLigne = new ArrayList<>();

    static List<Station> stations = new ArrayList<>();
    static List<Ligne> lignes = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    static Passager passager = new Passager(null);

    public static void ajoutStation(String[] liste) {

        for (int i = 0; i < liste.length; i++) {
            listeStation.add(liste[i]);
        }

    }

    public static void ajoutLigne(String[] liste) {

        for (int i = 0; i < liste.length; i++) {
            listeLigne.add(liste[i]);
        }

    }

    public static void main(String[] args) {
        // mise a jour et triage de la liste de station et de ligne
        ajoutStation(listeStationA);
        Collections.sort(listeStation);
        ajoutLigne(listeLigneA);
        Collections.sort(listeLigne);

        // création et mise à jour des stations et des lignes
        for (int i = 0; i < listeStation.size(); i++) {
            stations.add(Station.creationStation(listeStation, i));
        }
        for (Station station : stations) {
            station.UpgradeStation();
        }

        for (int i = 0; i < listeLigne.size(); i++) {
            lignes.add(Ligne.creationLigne(listeLigne, i));
        }
        for (Ligne ligne : lignes) {
            ligne.UpgradeLigne();
        }
        Scanner sc = new Scanner(System.in);
        int choix1 = 0;

        // préparation du menu

        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Choissisez une options:");
        System.out.println("1- Affcher la liste des stations ordonées");
        System.out.println("2- Affcher la liste des lignes ordonées");
        System.out.println("3- Afficher les informations d'une station");
        System.out.println("4- Afficher les informations d'une ligne");
        System.out.println("5- Préparer un itinéraire");
        System.out.println("6- quitter ");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        choix1 = sc.nextInt();
        sc.nextLine();

        if (choix1 == 1) {
            for (int i = 0; i < listeStation.size(); i++) {
                System.out.println(listeStation.get(i));
            }
        }
        if (choix1 == 2) {
            for (int i = 0; i < listeLigne.size(); i++) {
                System.out.println(listeLigne.get(i));
            }
        }

        else if (choix1 == 3) {
            System.out.println("Vous désirez les informations de quel station ?");
            String strchoix2 = sc.nextLine();
            for (Station station : stations) {
                if (station.getNom().equals(strchoix2)) {
                    System.out.println(station.displayInformation());
                }
            }
        }

        else if (choix1 == 4) {
            System.out.println("Vous désirez les informations de quel ligne ?");
            String strchoix3 = sc.nextLine();
            for (Ligne ligne : lignes) {
                if (ligne.getNom().equals(strchoix3)) {
                    System.out.println(ligne.displayInformation());
                }
            }
        }

        else if (choix1 == 5) {
            System.out.println("Vous êtes quel type de passager?");
            System.out.println("1-Regulier");
            System.out.println("2-Etudiant");
            System.out.println("3-Senior");
            System.out.println("4-Personne à mobilitée réduite");

            int choix5 = sc.nextInt();
            sc.nextLine();

            if (choix5 == 1) {
                passager.setCategorie(Passager.Categorie.Regulier);
            } else if (choix5 == 2) {
                passager.setCategorie(Passager.Categorie.Etudiant);
            } else if (choix5 == 3) {
                passager.setCategorie(Passager.Categorie.Senior);
            } else if (choix5 == 4) {
                passager.setCategorie(Passager.Categorie.Handicape);
            }
            // si l'utilisateur n'est pas handicapé
            if (passager.categorie != Passager.Categorie.Handicape) {
                System.out.println("Quel type de trajet voulez-vous effectuer ?");
                System.out.println("1- Le trajet le moins chère ?");
                System.out.println("2- Le trajet le plus rapide ?");
                int sousChoix5_1 = sc.nextInt();
                sc.nextLine();

                // si il chosit l'itinéraire le moins chère
                if (sousChoix5_1 == 1) {
                    Graph<String> grapheTrajet = GraphFactory.brackenfordCheminPrix(passager, stations, lignes);
                    System.out.print("Dans quelle station êtes-vous ? : ");
                    String str1 = sc.nextLine();

                    System.out.print("Dans quelle station voulez-vous aller ? : ");
                    String str2 = sc.nextLine();

                    Station station1Trouvee = null;
                    Station station2Trouvee = null;

                    for (Station station : stations) {
                        if (station.getNom().equals(str1)) {
                            station1Trouvee = station;
                        }
                        if (station.getNom().equals(str2)) {
                            station2Trouvee = station;
                        }

                        // Si on a trouvé les deux, on peut sortir de la boucle
                        if (station1Trouvee != null && station2Trouvee != null) {
                            break;
                        }
                    }

                    // Vérification pour éviter une erreur
                    if (station1Trouvee == null || station2Trouvee == null) {
                        System.out.println("Erreur : Une ou les deux stations n'ont pas été trouvées.");
                        return;
                    }

                    // Récupération du nom
                    String stationdepart = station1Trouvee.getNom();
                    String stationarrivee = station2Trouvee.getNom();

                    ArrayList<String> listeChemin = grapheTrajet.pathFollowed(stationdepart, stationarrivee);
                    HashMap<String, Double> Tab = grapheTrajet.fordValues(stationdepart);

                    Double prix = Tab.get(stationarrivee);
                    System.out.println("Suivez le chemin suivant: ");
                    for (int i = 0; i < listeChemin.size(); i++) {
                        sb.append(listeChemin.get(i));
                        if (i == listeChemin.size() - 1) {
                            sb.append(".");
                        } else {
                            sb.append("--");
                        }
                    }

                    sb.append("\n");
                    System.out.println(sb.toString());
                    System.out.println("le prix total est de :" + prix + " €");

                }
                // si il choisit le chemin le plus rapide
                else if (sousChoix5_1 == 2) {
                    Graph<String> grapheTrajet = GraphFactory.brackenfordCheminRapide(stations, lignes);
                    System.out.print("Dans quelle station êtes-vous ? : ");
                    String str1 = sc.nextLine();

                    System.out.print("Dans quelle station voulez-vous aller ? : ");
                    String str2 = sc.nextLine();
                    Station station1Trouvee = null;
                    Station station2Trouvee = null;

                    for (Station station : stations) {
                        if (station.getNom().equals(str1)) {
                            station1Trouvee = station;
                        }
                        if (station.getNom().equals(str2)) {
                            station2Trouvee = station;
                        }

                        // Si on a trouvé les deux, on peut sortir de la boucle
                        if (station1Trouvee != null && station2Trouvee != null) {
                            break;
                        }
                    }

                    // Vérification pour éviter une erreur
                    if (station1Trouvee == null || station2Trouvee == null) {
                        System.out.println("Erreur : Une ou les deux stations n'ont pas été trouvées.");
                        return;
                    }

                    // Récupération du nom
                    String stationdepart = station1Trouvee.getNom();
                    String stationarrivee = station2Trouvee.getNom();

                    HashMap<String, Double> Tab = grapheTrajet.fordValues(stationdepart);
                    Double tempsTot = Tab.get(stationarrivee);
                    int tempsTotint = Double.valueOf(tempsTot).intValue();

                    ArrayList<String> listeChemin = grapheTrajet.pathFollowed(stationdepart, stationarrivee);
                    System.out.println("Suivez le chemin suivant: ");

                    for (int i = 0; i < listeChemin.size(); i++) {
                        sb.append(listeChemin.get(i));
                        if (i == listeChemin.size() - 1) {
                            sb.append(".");
                        } else {
                            sb.append("--");
                        }
                    }
                    sb.append("\n");
                    System.out.println(sb.toString());
                    System.out.println("le temps du trajet est de: " + tempsTotint + "min");

                }

            }
            // si il est handicapé
            else {
                System.out.println("Quel type de trajet voulez-vous effectuer ?");
                System.out.println("1- Le trajet le moins chère ?");
                System.out.println("2- Le trajet le plus rapide ?");
                int sousChoix5_2 = sc.nextInt();
                sc.nextLine();
                // si l'utilisateur est handicapé et choisit l'itinéraire le moins chrère
                if (sousChoix5_2 == 1) {
                    Graph<String> grapheTrajet = GraphFactory.brackenfordHandPrix(passager, stations, lignes);
                    System.out.print("Dans quelle station êtes-vous ? : ");
                    String str1 = sc.nextLine();

                    System.out.print("Dans quelle station voulez-vous aller ? : ");
                    String str2 = sc.nextLine();

                    Station station1Trouvee = null;
                    Station station2Trouvee = null;

                    for (Station station : stations) {
                        if (station.getNom().equals(str1)) {
                            station1Trouvee = station;
                        }
                        if (station.getNom().equals(str2)) {
                            station2Trouvee = station;
                        }

                        // Si on a trouvé les deux, on peut sortir de la boucle
                        if (station1Trouvee != null && station2Trouvee != null) {
                            break;
                        }
                    }

                    // Vérification pour éviter une erreur
                    if (station1Trouvee == null || station2Trouvee == null) {
                        System.out.println("Erreur : Une ou les deux stations n'ont pas été trouvées.");
                        return;
                    }

                    // Récupération du nom
                    String stationdepart = station1Trouvee.getNom();
                    String stationarrivee = station2Trouvee.getNom();

                    if (stationdepart.equals("Ashford Road") || stationdepart.equals("Market Square") || stationdepart.equals("King's Way") || stationdepart.equals("Southbank Place")) {
                        System.out.println("Vous ne pouvez pas partir de cette station");
                        return;
                    } 
                    if (stationarrivee.equals("Ashford Road") || stationarrivee.equals("Market Square") || stationarrivee.equals("King's Way") || stationarrivee.equals("Southbank Place")) {
                        System.out.println("Vous ne pouvez pas descendre de cette station");
                        return;
                    } 
                    else {

                        ArrayList<String> listeChemin = grapheTrajet.pathFollowed(stationdepart, stationarrivee);

                        HashMap<String, Double> Tab = grapheTrajet.fordValues(stationdepart);
                        Double prix = Tab.get(stationarrivee);


                        System.out.println("Suivez le chemin suivant: ");
                        for (int i = 0; i < listeChemin.size(); i++) {
                            sb.append(listeChemin.get(i));
                            if (i == listeChemin.size() - 1) {
                                sb.append(".");
                            } else {
                                sb.append("--");
                            }
                        }
                        sb.append("\n");
                        System.out.println(sb.toString());
                        System.out.println("le prix final est de: " + prix + " €");
                    }

                }
                // si l'utilisateur est handicapé et chosit le trajet le plus court
                else if (sousChoix5_2 == 2) {
                    Graph<String> grapheTrajet = GraphFactory.brackenfordHandCourt(stations, lignes);
                    System.out.print("Dans quelle station êtes-vous ? : ");
                    String str1 = sc.nextLine();

                    System.out.print("Dans quelle station voulez-vous aller ? : ");
                    String str2 = sc.nextLine();

                    Station station1Trouvee = null;
                    Station station2Trouvee = null;

                    for (Station station : stations) {
                        if (station.getNom().equals(str1)) {
                            station1Trouvee = station;
                        }
                        if (station.getNom().equals(str2)) {
                            station2Trouvee = station;
                        }

                        // Si on a trouvé les deux, on peut sortir de la boucle
                        if (station1Trouvee != null && station2Trouvee != null) {
                            break;
                        }
                    }

                    // Vérification pour éviter une erreur
                    if (station1Trouvee == null || station2Trouvee == null) {
                        System.out.println("Erreur : Une ou les deux stations n'ont pas été trouvées.");
                        return;
                    }

                    // Récupération du nom
                    String stationdepart = station1Trouvee.getNom();
                    String stationarrivee = station2Trouvee.getNom();

                    if (stationdepart.equals("Ashford Road") || stationdepart.equals("Market Square") || stationdepart.equals("King's Way") || stationdepart.equals("Southbank Place") ) {
                        System.out.println("Vous ne pouvez pas partir de cette statiion");
                        return;
                    } 
                    else if (stationarrivee.equals("Ashford Road") || stationarrivee.equals("Market Square") || stationarrivee.equals("King's Way") || stationarrivee.equals("Southbank Place")) {
                        System.out.println("Vous ne pouvez pas descendre de cette station");
                        return;
                    }
                    else {
                        ArrayList<String> listeChemin = grapheTrajet.pathFollowed(stationdepart, stationarrivee);

                        HashMap<String, Double> Tab = grapheTrajet.fordValues(stationdepart);
                        Double tempsTot = Tab.get(stationarrivee);
                        int tempsTotInt = Double.valueOf(tempsTot).intValue();
                        System.out.println("Suivez le chemin suivant: ");

                        for (int i = 0; i < listeChemin.size(); i++) {
                            sb.append(listeChemin.get(i));
                            if (i == listeChemin.size() - 1) {
                                sb.append(".");
                            } else {
                                sb.append("--");
                            }
                        }
                        sb.append("\n");
                        System.out.println(sb.toString());
                        System.out.println("le temps de trajet est de: " + tempsTotInt + "min");
                    }

                }

            }
        } else if (choix1 == 6) {
            return;
        }

        sc.close();
    }

}