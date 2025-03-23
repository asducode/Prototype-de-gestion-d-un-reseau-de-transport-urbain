import java.util.Arrays;
import java.util.List;

/**
 * Classe GraphFactory : permet de créer des Graphes de reseaux de transport en commun , Backenford dans notre cas , elle exploite la class @see Graph dont l'auteur est Richard WOODWARD
 * @author :  Landry ABLOH  et  Darius SEHOUBO 
 * 
 */


public class GraphFactory {



 


  
/**
 * Creation d'un graphe pour les utilisateurs n'ayant pas d'handicap et souhaitant prendre le chemin le plus rapide .  
 * @param passager : le passager qui utilise le réseau de transport en commun.
 * @param stations : Liste des stations du reseau de Backenford.
 * @param lignes : Liste des lignes de transport du reseau de Backenford.
 * @return Un graphe representant le reseau de transport en commun de Brackenford pour un utilisateur qui veut avancer en suivant le chemin le plus rapide .
 */
    public static Graph<String> brackenfordCheminRapide(List<Station> stations,List<Ligne> lignes){
        Graph<String> graph = new Graph<>(true, true);
        //A
        graph.addEdge("Ashford Road","Brookside Avenue",calculTemps(stations.get(0),stations.get(1),lignes));
        graph.addEdge("Ashford Road","Castle Hill",calculTemps(stations.get(0),stations.get(2),lignes));
        //B
        graph.addEdge("Brookside Avenue","Ashford Road",calculTemps(stations.get(1),stations.get(0),lignes));
        graph.addEdge("Brookside Avenue","Eastbourne West",calculTemps(stations.get(1),stations.get(4),lignes));
        graph.addEdge("Brookside Avenue","Fairfields",calculTemps(stations.get(1),stations.get(5),lignes));
        //C
        graph.addEdge("Castle Hill","Ashford Road",calculTemps(stations.get(2),stations.get(0),lignes)); 
        graph.addEdge("Castle Hill","High Street",calculTemps(stations.get(2),stations.get(7),lignes));
        //D
        graph.addEdge("Dunham End","Zephyr Close",calculTemps(stations.get(3),stations.get(25),lignes));
        graph.addEdge("Dunham End","King's Way",calculTemps(stations.get(3),stations.get(10),lignes));
        //E
        graph.addEdge("Eastbourne West","Brookside Avenue",calculTemps(stations.get(4),stations.get(1),lignes));
        graph.addEdge("Eastbourne West","Fairfields",calculTemps(stations.get(4),stations.get(5),lignes));
        graph.addEdge("Eastbourne West","GrandCentral",calculTemps(stations.get(4),stations.get(6),lignes));
        graph.addEdge("Eastbourne West","Ivy Lane",calculTemps(stations.get(4),stations.get(8),lignes));
        //F
        graph.addEdge("Fairfields","Brookside Avenue",calculTemps(stations.get(5),stations.get(1),lignes));
        graph.addEdge("Fairfields","Eastbourne West",calculTemps(stations.get(5),stations.get(4),lignes));
        graph.addEdge("Fairfields","GrandCentral",calculTemps(stations.get(5),stations.get(6),lignes));
        graph.addEdge("Fairfields","Lakeside",calculTemps(stations.get(5),stations.get(11),lignes));
        graph.addEdge("Fairfields","Market Square",calculTemps(stations.get(5),stations.get(12),lignes));
        //G
        graph.addEdge("GrandCentral","Eastbourne West",calculTemps(stations.get(6),stations.get(4),lignes));
        graph.addEdge("GrandCentral","Fairfields",calculTemps(stations.get(6),stations.get(5),lignes));
        graph.addEdge("GrandCentral","King's Way",calculTemps(stations.get(6),stations.get(10),lignes));
        graph.addEdge("GrandCentral","Market Square",calculTemps(stations.get(6),stations.get(12),lignes));
        graph.addEdge("GrandCentral","Town Hall",calculTemps(stations.get(6),stations.get(19),lignes));
        graph.addEdge("GrandCentral","Southbank Place",calculTemps(stations.get(6),stations.get(18),lignes));
        //H
        graph.addEdge("High Street","Castle Hill",calculTemps(stations.get(7),stations.get(2),lignes));
        graph.addEdge("High Street","Lakeside",calculTemps(stations.get(7),stations.get(11),lignes));
        graph.addEdge("High Street","Northgate Shopping Centre",calculTemps(stations.get(7),stations.get(13),lignes));
        //I
        graph.addEdge("Ivy Lane","Eastbourne West",calculTemps(stations.get(8),stations.get(4),lignes));
        graph.addEdge("Ivy Lane","Oakwoods",calculTemps(stations.get(8),stations.get(14),lignes));
        //J
        graph.addEdge("Jubilee Place","King's Way",calculTemps(stations.get(9),stations.get(10),lignes));
        graph.addEdge("Jubilee Place","Parkside Place",calculTemps(stations.get(9),stations.get(15),lignes));
        //K
        graph.addEdge("King's Way","Dunham End",calculTemps(stations.get(10),stations.get(3),lignes));
        graph.addEdge("King's Way","GrandCentral",calculTemps(stations.get(10),stations.get(6),lignes));
        graph.addEdge("King's Way","Jubilee Place",calculTemps(stations.get(10),stations.get(9),lignes));
        //L
        graph.addEdge("Lakeside","Fairfields",calculTemps(stations.get(11),stations.get(5),lignes));
        graph.addEdge("Lakeside","High Street",calculTemps(stations.get(11),stations.get(7),lignes));
        //M
        graph.addEdge("Market Square","Fairfields",calculTemps(stations.get(12),stations.get(5),lignes));
        graph.addEdge("Market Square","GrandCentral",calculTemps(stations.get(12),stations.get(6),lignes));
        graph.addEdge("Market Square","Northgate Shopping Centre",calculTemps(stations.get(12),stations.get(13),lignes));
        graph.addEdge("Market Square","Victoria Docks",calculTemps(stations.get(12),stations.get(21),lignes));
        //N
        graph.addEdge("Northgate Shopping Centre","High Street",calculTemps(stations.get(13),stations.get(7),lignes));
        graph.addEdge("Northgate Shopping Centre","Market Square",calculTemps(stations.get(13),stations.get(12),lignes));
        graph.addEdge("Northgate Shopping Centre","Xenobiotics Research Centre",calculTemps(stations.get(13),stations.get(23),lignes));
        //O
        graph.addEdge("Oakwoods","Ivy Lane",calculTemps(stations.get(14),stations.get(8),lignes));
        graph.addEdge("Oakwoods","Queensbridge",calculTemps(stations.get(14),stations.get(16),lignes));
        //P
        graph.addEdge("Parkside Place","Jubilee Place",calculTemps(stations.get(15),stations.get(9),lignes));
        graph.addEdge("Parkside Place","York Road",calculTemps(stations.get(15),stations.get(24),lignes));
        //Q
        graph.addEdge("Queensbridge","Oakwoods",calculTemps(stations.get(16),stations.get(14),lignes));
        graph.addEdge("Queensbridge","Parkside Place",calculTemps(stations.get(16),stations.get(15),lignes));
        graph.addEdge("Queensbridge","Riverside",calculTemps(stations.get(16),stations.get(17),lignes));
        //R
        graph.addEdge("Riverside","Queensbridge",calculTemps(stations.get(17),stations.get(16),lignes));
        graph.addEdge("Riverside","York Road",calculTemps(stations.get(17),stations.get(24),lignes));
        //S
        graph.addEdge("Southbank Place","GrandCentral",calculTemps(stations.get(18),stations.get(6),lignes));
        graph.addEdge("Southbank Place","King's Way",calculTemps(stations.get(18),stations.get(10),lignes));
        graph.addEdge("Southbank Place","Union Street",calculTemps(stations.get(18),stations.get(20),lignes));
        //T
        graph.addEdge("Town Hall","GrandCentral",calculTemps(stations.get(19),stations.get(6),lignes));
        graph.addEdge("Town Hall","Victoria Docks",calculTemps(stations.get(19),stations.get(21),lignes));
        //U
        graph.addEdge("Union Street","Southbank Place",calculTemps(stations.get(20),stations.get(18),lignes));
        graph.addEdge("Union Street","Waterfront",calculTemps(stations.get(20),stations.get(22),lignes));
        //V
        graph.addEdge("Victoria Docks","Market Square",calculTemps(stations.get(21),stations.get(12),lignes));
        graph.addEdge("Victoria Docks","Town Hall",calculTemps(stations.get(21),stations.get(19),lignes));
        graph.addEdge("Victoria Docks","Waterfront",calculTemps(stations.get(21),stations.get(22),lignes));
        graph.addEdge("Victoria Docks","Xenobiotics Research Centre",calculTemps(stations.get(21),stations.get(23),lignes));
        //W
        graph.addEdge("Waterfront","Union Street",calculTemps(stations.get(22),stations.get(20),lignes));
        graph.addEdge("Waterfront","Victoria Docks",calculTemps(stations.get(22),stations.get(21),lignes));
        //X
        graph.addEdge("Xenobiotics Research Centre","Northgate Shopping Centre",calculTemps(stations.get(23),stations.get(13),lignes));
        graph.addEdge("Xenobiotics Research Centre","Victoria Docks",calculTemps(stations.get(23),stations.get(21),lignes));
        //Y
        graph.addEdge("York Road","Parkside Place",calculTemps(stations.get(24),stations.get(15),lignes));
        graph.addEdge("York Road","Riverside",calculTemps(stations.get(24),stations.get(17),lignes));
        //Z
        graph.addEdge("Zephyr Close","Dunham End",calculTemps(stations.get(25),stations.get(3),lignes));

        return graph;
    }


/**
 * Creation d'un graphe pour les utilisateurs n'ayant pas d'handicap et souhaitant prendre le chemin le moins chere .  
 * @param passager : le passager qui utilise le réseau de transport en commun.
 * @param stations : Liste des stations du reseau de Backenford.
 * @param lignes : Liste des lignes de transport du reseau de Backenford.
 * @return Un graphe représentant le reseau de transport en commun de Brackenford pour un utilisateur qui veut avancer en suivant le chemin le moins chère .
 */
      public static Graph<String> brackenfordCheminPrix(Passager passager,List<Station> stations,List<Ligne> lignes){
        Graph<String> graph = new Graph<>(true, true);
        //A
        graph.addEdge("Ashford Road","Brookside Avenue",calculPrix(passager,stations.get(0),stations.get(1),lignes));
        graph.addEdge("Ashford Road","Castle Hill",calculPrix(passager,stations.get(0),stations.get(2),lignes));
        //B
        graph.addEdge("Brookside Avenue","Ashford Road",calculPrix(passager,stations.get(1),stations.get(0),lignes));
        graph.addEdge("Brookside Avenue","Eastbourne West",calculPrix(passager,stations.get(1),stations.get(4),lignes));
        graph.addEdge("Brookside Avenue","Fairfields",calculPrix(passager,stations.get(1),stations.get(5),lignes));
        //C
        graph.addEdge("Castle Hill","Ashford Road",calculPrix(passager,stations.get(2),stations.get(0),lignes)); 
        graph.addEdge("Castle Hill","High Street",calculPrix(passager,stations.get(2),stations.get(7),lignes));
        //D
        graph.addEdge("Dunham End","Zephyr Close",calculPrix(passager,stations.get(3),stations.get(25),lignes));
        graph.addEdge("Dunham End","King's Way",calculPrix(passager,stations.get(3),stations.get(10),lignes));
        //E
        graph.addEdge("Eastbourne West","Brookside Avenue",calculPrix(passager,stations.get(4),stations.get(1),lignes));
        graph.addEdge("Eastbourne West","Fairfields",calculPrix(passager,stations.get(4),stations.get(5),lignes));
        graph.addEdge("Eastbourne West","GrandCentral",calculPrix(passager,stations.get(4),stations.get(6),lignes));
        graph.addEdge("Eastbourne West","Ivy Lane",calculPrix(passager,stations.get(4),stations.get(8),lignes));
        //F
        graph.addEdge("Fairfields","Brookside Avenue",calculPrix(passager,stations.get(5),stations.get(1),lignes));
        graph.addEdge("Fairfields","Eastbourne West",calculPrix(passager,stations.get(5),stations.get(4),lignes));
        graph.addEdge("Fairfields","GrandCentral",calculPrix(passager,stations.get(5),stations.get(6),lignes));
        graph.addEdge("Fairfields","Lakeside",calculPrix(passager,stations.get(5),stations.get(11),lignes));
        graph.addEdge("Fairfields","Market Square",calculPrix(passager,stations.get(5),stations.get(12),lignes));
        //G
        graph.addEdge("GrandCentral","Eastbourne West",calculPrix(passager,stations.get(6),stations.get(4),lignes));
        graph.addEdge("GrandCentral","Fairfields",calculPrix(passager,stations.get(6),stations.get(5),lignes));
        graph.addEdge("GrandCentral","King's Way",calculPrix(passager,stations.get(6),stations.get(10),lignes));
        graph.addEdge("GrandCentral","Market Square",calculPrix(passager,stations.get(6),stations.get(12),lignes));
        graph.addEdge("GrandCentral","Town Hall",calculPrix(passager,stations.get(6),stations.get(19),lignes));
        graph.addEdge("GrandCentral","Southbank Place",calculPrix(passager,stations.get(6),stations.get(18),lignes));
        //H
        graph.addEdge("High Street","Castle Hill",calculPrix(passager,stations.get(7),stations.get(2),lignes));
        graph.addEdge("High Street","Lakeside",calculPrix(passager,stations.get(7),stations.get(11),lignes));
        graph.addEdge("High Street","Northgate Shopping Centre",calculPrix(passager,stations.get(7),stations.get(13),lignes));
        //I
        graph.addEdge("Ivy Lane","Eastbourne West",calculPrix(passager,stations.get(8),stations.get(4),lignes));
        graph.addEdge("Ivy Lane","Oakwoods",calculPrix(passager,stations.get(8),stations.get(14),lignes));
        //J
        graph.addEdge("Jubilee Place","King's Way",calculPrix(passager,stations.get(9),stations.get(10),lignes));
        graph.addEdge("Jubilee Place","Parkside Place",calculPrix(passager,stations.get(9),stations.get(15),lignes));
        //K
        graph.addEdge("King's Way","Dunham End",calculPrix(passager,stations.get(10),stations.get(3),lignes));
        graph.addEdge("King's Way","GrandCentral",calculPrix(passager,stations.get(10),stations.get(6),lignes));
        graph.addEdge("King's Way","Jubilee Place",calculPrix(passager,stations.get(10),stations.get(9),lignes));
        //L
        graph.addEdge("Lakeside","Fairfields",calculPrix(passager,stations.get(11),stations.get(5),lignes));
        graph.addEdge("Lakeside","High Street",calculPrix(passager,stations.get(11),stations.get(7),lignes));
        //M
        graph.addEdge("Market Square","Fairfields",calculPrix(passager,stations.get(12),stations.get(5),lignes));
        graph.addEdge("Market Square","GrandCentral",calculPrix(passager,stations.get(12),stations.get(6),lignes));
        graph.addEdge("Market Square","Northgate Shopping Centre",calculPrix(passager,stations.get(12),stations.get(13),lignes));
        graph.addEdge("Market Square","Victoria Docks",calculPrix(passager,stations.get(12),stations.get(21),lignes));
        //N
        graph.addEdge("Northgate Shopping Centre","High Street",calculPrix(passager,stations.get(13),stations.get(7),lignes));
        graph.addEdge("Northgate Shopping Centre","Market Square",calculPrix(passager,stations.get(13),stations.get(12),lignes));
        graph.addEdge("Northgate Shopping Centre","Xenobiotics Research Centre",calculPrix(passager,stations.get(13),stations.get(23),lignes));
        //O
        graph.addEdge("Oakwoods","Ivy Lane",calculPrix(passager,stations.get(14),stations.get(8),lignes));
        graph.addEdge("Oakwoods","Queensbridge",calculPrix(passager,stations.get(14),stations.get(16),lignes));
        //P
        graph.addEdge("Parkside Place","Jubilee Place",calculPrix(passager,stations.get(15),stations.get(9),lignes));
        graph.addEdge("Parkside Place","York Road",calculPrix(passager,stations.get(15),stations.get(24),lignes));
        //Q
        graph.addEdge("Queensbridge","Oakwoods",calculPrix(passager,stations.get(16),stations.get(14),lignes));
        graph.addEdge("Queensbridge","Parkside Place",calculPrix(passager,stations.get(16),stations.get(15),lignes));
        graph.addEdge("Queensbridge","Riverside",calculPrix(passager,stations.get(16),stations.get(17),lignes));
        //R
        graph.addEdge("Riverside","Queensbridge",calculPrix(passager,stations.get(17),stations.get(16),lignes));
        graph.addEdge("Riverside","York Road",calculPrix(passager,stations.get(17),stations.get(24),lignes));
        //S
        graph.addEdge("Southbank Place","GrandCentral",calculPrix(passager,stations.get(18),stations.get(6),lignes));
        graph.addEdge("Southbank Place","King's Way",calculPrix(passager,stations.get(18),stations.get(10),lignes));
        graph.addEdge("Southbank Place","Union Street",calculPrix(passager,stations.get(18),stations.get(20),lignes));
        //T
        graph.addEdge("Town Hall","GrandCentral",calculPrix(passager,stations.get(19),stations.get(6),lignes));
        graph.addEdge("Town Hall","Victoria Docks",calculPrix(passager,stations.get(19),stations.get(21),lignes));
        //U
        graph.addEdge("Union Street","Southbank Place",calculPrix(passager,stations.get(20),stations.get(18),lignes));
        graph.addEdge("Union Street","Waterfront",calculPrix(passager,stations.get(20),stations.get(22),lignes));
        //V
        graph.addEdge("Victoria Docks","Market Square",calculPrix(passager,stations.get(21),stations.get(12),lignes));
        graph.addEdge("Victoria Docks","Town Hall",calculPrix(passager,stations.get(21),stations.get(19),lignes));
        graph.addEdge("Victoria Docks","Waterfront",calculPrix(passager,stations.get(21),stations.get(22),lignes));
        graph.addEdge("Victoria Docks","Xenobiotics Research Centre",calculPrix(passager,stations.get(21),stations.get(23),lignes));
        //W
        graph.addEdge("Waterfront","Union Street",calculPrix(passager,stations.get(22),stations.get(20),lignes));
        graph.addEdge("Waterfront","Victoria Docks",calculPrix(passager,stations.get(22),stations.get(21),lignes));
        //X
        graph.addEdge("Xenobiotics Research Centre","Northgate Shopping Centre",calculPrix(passager,stations.get(23),stations.get(13),lignes));
        graph.addEdge("Xenobiotics Research Centre","Victoria Docks",calculPrix(passager,stations.get(23),stations.get(21),lignes));
        //Y
        graph.addEdge("York Road","Parkside Place",calculPrix(passager,stations.get(24),stations.get(15),lignes));
        graph.addEdge("York Road","Riverside",calculPrix(passager,stations.get(24),stations.get(17),lignes));
        //Z
        graph.addEdge("Zephyr Close","Dunham End",calculPrix(passager,stations.get(25),stations.get(3),lignes));

        return graph;
    }
    
/** 
 * Creation d'un graphe pour les utilisateurs ayant un handicap souhaitant prendre le chemin le plus court pour un itinéraire .
 * @param stations : Liste des stations du reseau de Backenford.
 * @param lignes : Liste des lignes de transport du reseau de Backenford.
 * @return Un graphe représentant le reseau de transport en commun de Brackenford pour un utilisateur atteint de handicap souhaitant avancer en suivant le chemin le plus rapide.
 */
    public static Graph<String> brackenfordHandCourt(List<Station> stations,List<Ligne> lignes){
        Graph<String> graph = new Graph<>(true, true);
        //A
        graph.addEdge("Ashford Road","Brookside Avenue",Double.MAX_VALUE);
        graph.addEdge("Ashford Road","Castle Hill",Double.MAX_VALUE);
        //B
        graph.addEdge("Brookside Avenue","Ashford Road",Double.MAX_VALUE);
        graph.addEdge("Brookside Avenue","Eastbourne West",calculTemps(stations.get(1),stations.get(4),lignes));
        graph.addEdge("Brookside Avenue","Fairfields",calculTemps(stations.get(1),stations.get(5),lignes));
        //C
        graph.addEdge("Castle Hill","Ashford Road",Double.MAX_VALUE); 
        graph.addEdge("Castle Hill","High Street",calculTemps(stations.get(2),stations.get(7),lignes));
        //D
        graph.addEdge("Dunham End","Zephyr Close",calculTemps(stations.get(3),stations.get(25),lignes));
        graph.addEdge("Dunham End","King's Way",Double.MAX_VALUE);
        //E
        graph.addEdge("Eastbourne West","Brookside Avenue",calculTemps(stations.get(4),stations.get(1),lignes));
        graph.addEdge("Eastbourne West","Fairfields",calculTemps(stations.get(4),stations.get(5),lignes));
        graph.addEdge("Eastbourne West","GrandCentral",calculTemps(stations.get(4),stations.get(6),lignes));
        graph.addEdge("Eastbourne West","Ivy Lane",calculTemps(stations.get(4),stations.get(8),lignes));
        //F
        graph.addEdge("Fairfields","Brookside Avenue",calculTemps(stations.get(5),stations.get(1),lignes));
        graph.addEdge("Fairfields","Eastbourne West",calculTemps(stations.get(5),stations.get(4),lignes));
        graph.addEdge("Fairfields","GrandCentral",calculTemps(stations.get(5),stations.get(6),lignes));
        graph.addEdge("Fairfields","Lakeside",calculTemps(stations.get(5),stations.get(11),lignes));
        graph.addEdge("Fairfields","Market Square",Double.MAX_VALUE);
        //G
        graph.addEdge("GrandCentral","Eastbourne West",calculTemps(stations.get(6),stations.get(4),lignes));
        graph.addEdge("GrandCentral","Fairfields",calculTemps(stations.get(6),stations.get(5),lignes));
        graph.addEdge("GrandCentral","King's Way",Double.MAX_VALUE);
        graph.addEdge("GrandCentral","Market Square",Double.MAX_VALUE);
        graph.addEdge("GrandCentral","Town Hall",calculTemps(stations.get(6),stations.get(19),lignes));
        graph.addEdge("GrandCentral","Southbank Place",Double.MAX_VALUE);
        //H
        graph.addEdge("High Street","Castle Hill",calculTemps(stations.get(7),stations.get(2),lignes));
        graph.addEdge("High Street","Lakeside",calculTemps(stations.get(7),stations.get(11),lignes));
        graph.addEdge("High Street","Northgate Shopping Centre",calculTemps(stations.get(7),stations.get(13),lignes));
        //I
        graph.addEdge("Ivy Lane","Eastbourne West",calculTemps(stations.get(8),stations.get(4),lignes));
        graph.addEdge("Ivy Lane","Oakwoods",calculTemps(stations.get(8),stations.get(14),lignes));
        //J
        graph.addEdge("Jubilee Place","King's Way",Double.MAX_VALUE);
        graph.addEdge("Jubilee Place","Parkside Place",calculTemps(stations.get(9),stations.get(15),lignes));
        //K
        graph.addEdge("King's Way","Dunham End",Double.MAX_VALUE);
        graph.addEdge("King's Way","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("King's Way","Jubilee Place",Double.MAX_VALUE);
        //L
        graph.addEdge("Lakeside","Fairfields",calculTemps(stations.get(11),stations.get(5),lignes));
        graph.addEdge("Lakeside","High Street",calculTemps(stations.get(11),stations.get(7),lignes));
        //M
        graph.addEdge("Market Square","Fairfields",Double.MAX_VALUE);
        graph.addEdge("Market Square","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("Market Square","Northgate Shopping Centre",Double.MAX_VALUE);
        graph.addEdge("Market Square","Victoria Docks",Double.MAX_VALUE);
        //N
        graph.addEdge("Northgate Shopping Centre","High Street",calculTemps(stations.get(13),stations.get(7),lignes));
        graph.addEdge("Northgate Shopping Centre","Market Square",Double.MAX_VALUE);
        graph.addEdge("Northgate Shopping Centre","Xenobiotics Research Centre",calculTemps(stations.get(13),stations.get(23),lignes));
        //O
        graph.addEdge("Oakwoods","Ivy Lane",calculTemps(stations.get(14),stations.get(8),lignes));
        graph.addEdge("Oakwoods","Queensbridge",calculTemps(stations.get(14),stations.get(16),lignes));
        //P
        graph.addEdge("Parkside Place","Jubilee Place",calculTemps(stations.get(15),stations.get(9),lignes));
        graph.addEdge("Parkside Place","York Road",calculTemps(stations.get(15),stations.get(24),lignes));
        //Q
        graph.addEdge("Queensbridge","Oakwoods",calculTemps(stations.get(16),stations.get(14),lignes));
        graph.addEdge("Queensbridge","Parkside Place",calculTemps(stations.get(16),stations.get(15),lignes));
        graph.addEdge("Queensbridge","Riverside",calculTemps(stations.get(16),stations.get(17),lignes));
        //R
        graph.addEdge("Riverside","Queensbridge",calculTemps(stations.get(17),stations.get(16),lignes));
        graph.addEdge("Riverside","York Road",calculTemps(stations.get(17),stations.get(24),lignes));
        //S
        graph.addEdge("Southbank Place","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("Southbank Place","King's Way",Double.MAX_VALUE);
        graph.addEdge("Southbank Place","Union Street",Double.MAX_VALUE);
        //T
        graph.addEdge("Town Hall","GrandCentral",calculTemps(stations.get(19),stations.get(6),lignes));
        graph.addEdge("Town Hall","Victoria Docks",calculTemps(stations.get(19),stations.get(21),lignes));
        //U
        graph.addEdge("Union Street","Southbank Place",Double.MAX_VALUE);
        graph.addEdge("Union Street","Waterfront",calculTemps(stations.get(20),stations.get(22),lignes));
        //V
        graph.addEdge("Victoria Docks","Market Square",Double.MAX_VALUE);
        graph.addEdge("Victoria Docks","Town Hall",calculTemps(stations.get(21),stations.get(19),lignes));
        graph.addEdge("Victoria Docks","Waterfront",calculTemps(stations.get(21),stations.get(22),lignes));
        graph.addEdge("Victoria Docks","Xenobiotics Research Centre",calculTemps(stations.get(21),stations.get(23),lignes));
        //W
        graph.addEdge("Waterfront","Union Street",calculTemps(stations.get(22),stations.get(20),lignes));
        graph.addEdge("Waterfront","Victoria Docks",calculTemps(stations.get(22),stations.get(21),lignes));
        //X
        graph.addEdge("Xenobiotics Research Centre","Northgate Shopping Centre",calculTemps(stations.get(23),stations.get(13),lignes));
        graph.addEdge("Xenobiotics Research Centre","Victoria Docks",calculTemps(stations.get(23),stations.get(21),lignes));
        //Y
        graph.addEdge("York Road","Parkside Place",calculTemps(stations.get(24),stations.get(15),lignes));
        graph.addEdge("York Road","Riverside",calculTemps(stations.get(24),stations.get(17),lignes));
        //Z
        graph.addEdge("Zephyr Close","Dunham End",calculTemps(stations.get(25),stations.get(3),lignes));


        return graph;
    }
/** 
 * Creation d'un graphe pour les utilisateurs ayant un handicap souhaitant prendre le chemin le moins chere pour un itinéraire .
 * @param stations : Liste des stations du reseau de Backenford.
 * @param lignes : Liste des lignes de transport du reseau de Backenford.
 * @param passager : le passager qui utilise le réseau de transport en commun.
 * @return Un graphe représentant le reseau de transport en commun de Brackenford pour un utilisateur atteint de handicap souhaitant avancer en suivant le chemin le moins chere.
 * */
    public static Graph<String> brackenfordHandPrix(Passager passager,List<Station> stations,List<Ligne> lignes){
        Graph<String> graph = new Graph<>(true, true);
        //A
        graph.addEdge("Ashford Road","Brookside Avenue",Double.MAX_VALUE);
        graph.addEdge("Ashford Road","Castle Hill",Double.MAX_VALUE);
        //B
        graph.addEdge("Brookside Avenue","Ashford Road",Double.MAX_VALUE);
        graph.addEdge("Brookside Avenue","Eastbourne West",calculPrix(passager,stations.get(1),stations.get(4),lignes));
        graph.addEdge("Brookside Avenue","Fairfields",calculPrix(passager,stations.get(1),stations.get(5),lignes));
        //C
        graph.addEdge("Castle Hill","Ashford Road",Double.MAX_VALUE); 
        graph.addEdge("Castle Hill","High Street",calculPrix(passager,stations.get(2),stations.get(7),lignes));
        //D
        graph.addEdge("Dunham End","Zephyr Close",calculPrix(passager,stations.get(3),stations.get(25),lignes));
        graph.addEdge("Dunham End","King's Way",Double.MAX_VALUE);
        //E
        graph.addEdge("Eastbourne West","Brookside Avenue",calculPrix(passager,stations.get(4),stations.get(1),lignes));
        graph.addEdge("Eastbourne West","Fairfields",calculPrix(passager,stations.get(4),stations.get(5),lignes));
        graph.addEdge("Eastbourne West","GrandCentral",calculPrix(passager,stations.get(4),stations.get(6),lignes));
        graph.addEdge("Eastbourne West","Ivy Lane",calculPrix(passager,stations.get(4),stations.get(8),lignes));
        //F
        graph.addEdge("Fairfields","Brookside Avenue",calculPrix(passager,stations.get(5),stations.get(1),lignes));
        graph.addEdge("Fairfields","Eastbourne West",calculPrix(passager,stations.get(5),stations.get(4),lignes));
        graph.addEdge("Fairfields","GrandCentral",calculPrix(passager,stations.get(5),stations.get(6),lignes));
        graph.addEdge("Fairfields","Lakeside",calculPrix(passager,stations.get(5),stations.get(11),lignes));
        graph.addEdge("Fairfields","Market Square",Double.MAX_VALUE);
        //G
        graph.addEdge("GrandCentral","Eastbourne West",calculPrix(passager,stations.get(6),stations.get(4),lignes));
        graph.addEdge("GrandCentral","Fairfields",calculPrix(passager,stations.get(6),stations.get(5),lignes));
        graph.addEdge("GrandCentral","King's Way",Double.MAX_VALUE);
        graph.addEdge("GrandCentral","Market Square",Double.MAX_VALUE);
        graph.addEdge("GrandCentral","Town Hall",calculPrix(passager,stations.get(6),stations.get(19),lignes));
        graph.addEdge("GrandCentral","Southbank Place",Double.MAX_VALUE);
        //H
        graph.addEdge("High Street","Castle Hill",calculPrix(passager,stations.get(7),stations.get(2),lignes));
        graph.addEdge("High Street","Lakeside",calculPrix(passager,stations.get(7),stations.get(11),lignes));
        graph.addEdge("High Street","Northgate Shopping Centre",calculPrix(passager,stations.get(7),stations.get(13),lignes));
        //I
        graph.addEdge("Ivy Lane","Eastbourne West",calculPrix(passager,stations.get(8),stations.get(4),lignes));
        graph.addEdge("Ivy Lane","Oakwoods",calculPrix(passager,stations.get(8),stations.get(14),lignes));
        //J
        graph.addEdge("Jubilee Place","King's Way",Double.MAX_VALUE);
        graph.addEdge("Jubilee Place","Parkside Place",calculPrix(passager,stations.get(9),stations.get(15),lignes));
        //K
        graph.addEdge("King's Way","Dunham End",Double.MAX_VALUE);
        graph.addEdge("King's Way","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("King's Way","Jubilee Place",Double.MAX_VALUE);
        //L
        graph.addEdge("Lakeside","Fairfields",calculPrix(passager,stations.get(11),stations.get(5),lignes));
        graph.addEdge("Lakeside","High Street",calculPrix(passager,stations.get(11),stations.get(7),lignes));
        //M
        graph.addEdge("Market Square","Fairfields",Double.MAX_VALUE);
        graph.addEdge("Market Square","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("Market Square","Northgate Shopping Centre",Double.MAX_VALUE);
        graph.addEdge("Market Square","Victoria Docks",Double.MAX_VALUE);
        //N
        graph.addEdge("Northgate Shopping Centre","High Street",calculPrix(passager,stations.get(13),stations.get(7),lignes));
        graph.addEdge("Northgate Shopping Centre","Market Square",Double.MAX_VALUE);
        graph.addEdge("Northgate Shopping Centre","Xenobiotics Research Centre",calculPrix(passager,stations.get(13),stations.get(23),lignes));
        //O
        graph.addEdge("Oakwoods","Ivy Lane",calculPrix(passager,stations.get(14),stations.get(8),lignes));
        graph.addEdge("Oakwoods","Queensbridge",calculPrix(passager,stations.get(14),stations.get(16),lignes));
        //P
        graph.addEdge("Parkside Place","Jubilee Place",calculPrix(passager,stations.get(15),stations.get(9),lignes));
        graph.addEdge("Parkside Place","York Road",calculPrix(passager,stations.get(15),stations.get(24),lignes));
        //Q
        graph.addEdge("Queensbridge","Oakwoods",calculPrix(passager,stations.get(16),stations.get(14),lignes));
        graph.addEdge("Queensbridge","Parkside Place",calculPrix(passager,stations.get(16),stations.get(15),lignes));
        graph.addEdge("Queensbridge","Riverside",calculPrix(passager,stations.get(16),stations.get(17),lignes));
        //R
        graph.addEdge("Riverside","Queensbridge",calculPrix(passager,stations.get(17),stations.get(16),lignes));
        graph.addEdge("Riverside","York Road",calculPrix(passager,stations.get(17),stations.get(24),lignes));
        //S
        graph.addEdge("Southbank Place","GrandCentral",Double.MAX_VALUE);
        graph.addEdge("Southbank Place","King's Way",Double.MAX_VALUE);
        graph.addEdge("Southbank Place","Union Street",Double.MAX_VALUE);
        //T
        graph.addEdge("Town Hall","GrandCentral",calculPrix(passager,stations.get(19),stations.get(6),lignes));
        graph.addEdge("Town Hall","Victoria Docks",calculPrix(passager,stations.get(19),stations.get(21),lignes));
        //U
        graph.addEdge("Union Street","Southbank Place",Double.MAX_VALUE);
        graph.addEdge("Union Street","Waterfront",calculPrix(passager,stations.get(20),stations.get(22),lignes));
        //V
        graph.addEdge("Victoria Docks","Market Square",Double.MAX_VALUE);
        graph.addEdge("Victoria Docks","Town Hall",calculPrix(passager,stations.get(21),stations.get(19),lignes));
        graph.addEdge("Victoria Docks","Waterfront",calculPrix(passager,stations.get(21),stations.get(22),lignes));
        graph.addEdge("Victoria Docks","Xenobiotics Research Centre",calculPrix(passager,stations.get(21),stations.get(23),lignes));
        //W
        graph.addEdge("Waterfront","Union Street",calculPrix(passager,stations.get(22),stations.get(20),lignes));
        graph.addEdge("Waterfront","Victoria Docks",calculPrix(passager,stations.get(22),stations.get(21),lignes));
        //X
        graph.addEdge("Xenobiotics Research Centre","Northgate Shopping Centre",calculPrix(passager,stations.get(23),stations.get(13),lignes));
        graph.addEdge("Xenobiotics Research Centre","Victoria Docks",calculPrix(passager,stations.get(23),stations.get(21),lignes));
        //Y
        graph.addEdge("York Road","Parkside Place",calculPrix(passager,stations.get(24),stations.get(15),lignes));
        graph.addEdge("York Road","Riverside",calculPrix(passager,stations.get(24),stations.get(17),lignes));
        //Z
        graph.addEdge("Zephyr Close","Dunham End",calculPrix(passager,stations.get(25),stations.get(3),lignes));


        return graph;
    }



    private static final double rayonTerre = 6364673; // Rayon moyen de la Terre en mètres utilisé pour le calcul de la distance
    public static final int deg = 0 ;
    public static final int min = 1 ;
    public static final int sec = 2 ;

    /**
     * Calcule la distance entre deux stations en utilisant la formule de Haversine.
     * @param debut Station de départ
     * @param arrive Station d'arrivée
     * @return Distance en mètres
     */
    public static double calculDistance(Station debut, Station arrive) {
        if (debut == null || arrive == null) {
            throw new IllegalArgumentException("Les stations ne doivent pas être null.");
        }

        double[] latDebut = debut.getLatitude(); 
        double[] lonDebut = debut.getLongitude();
        double[] latArrive = arrive.getLatitude();
        double[] lonArrive = arrive.getLongitude();

        if (latDebut == null || lonDebut == null || latArrive == null || lonArrive == null) {
            throw new IllegalArgumentException("Les coordonnées des stations ne doivent pas être nulles.");
        }

        // Conversion des coordonnées en radians
        double latitudeDebut = convertirEnRadians(latDebut);
        double longitudeDebut = convertirEnRadians(lonDebut);
        double latitudeArrive = convertirEnRadians(latArrive);
        double longitudeArrive = convertirEnRadians(lonArrive);

        // Calcul de la variation de latitude et de longitude
        double deltaLat = latitudeArrive - latitudeDebut;
        double deltaLon = longitudeArrive - longitudeDebut;

        // Formule du cours
        double a = Math.pow(Math.sin(deltaLat / 2), 2)+ Math.cos(latitudeDebut) * Math.cos(latitudeArrive) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return rayonTerre * c;
    }

    /**
     * Convertit un angle exprimé en degrés, minutes, secondes en radians.
     * @param valeurs Tableau contenant {degrés, minutes, secondes}
     * @return Valeur en radians
     */
    public static double convertirEnRadians(double[] valeurs) {
        if (valeurs == null || valeurs.length != 3) {
            throw new IllegalArgumentException("Le tableau des coordonnées doit contenir exactement 3 valeurs.");
        }

        double degres = valeurs[deg];
        double minutes = valeurs[min] / 60.0;
        double secondes = valeurs[sec] / 3600.0;

        return Math.toRadians(degres + minutes + secondes);
    }

    /**
     * Calcule le temps de trajet entre deux stations sur une même ligne en fonction de la vitesse de la ligne.
     * @param debut Station de départ
     * @param arrive Station d'arrivée
     * @param lignes Liste de toutes les lignes de transport
     * @return Temps en secondes
     */

    public static double calculTemps(Station debut, Station arrive, List<Ligne> lignes) {
        if (debut == null || arrive == null || lignes == null || lignes.isEmpty()) {
            throw new IllegalArgumentException("Les stations et la liste des lignes ne doivent pas être nulles ou vides.");
        }

        String nomDebut = debut.getNom();
        String nomArrive = arrive.getNom();

        Ligne ligneTrouvee = null;

        for (Ligne ligne : lignes) {
            boolean debutTrouve = Arrays.asList(ligne.getStations()).contains(nomDebut);
            boolean arriveTrouve = Arrays.asList(ligne.getStations()).contains(nomArrive);

            if (debutTrouve && arriveTrouve) {
                ligneTrouvee = ligne;
                break;
            }
        }

        if (ligneTrouvee == null) {
            return 0; // Retourne 0 si aucune ligne ne relie les deux stations
        }
        
        return ((calculDistance(debut, arrive) / ligneTrouvee.getVitesse())/60) +1;
    }








/**
 * Calcule le prix du trajet entre deux stations en fonction de la ligne utilisée.
 *
 * @param debut   La station de départ (ne doit pas être null).
 * @param arrive  La station d'arrivée (ne doit pas être null).
 * @param lignes  La liste des lignes disponibles (ne doit pas être null ou vide).
 * @return        Le prix du trajet en euros. Retourne 0 si aucune ligne ne relie les deux stations.
 * @throws IllegalArgumentException Si l'une des stations ou la liste des lignes est null ou vide.
 *
 */


public static double calculPrix(Passager passager,Station debut ,Station arrive, List<Ligne> lignes) {       

        if (debut == null || arrive == null || lignes == null || lignes.isEmpty() || passager == null) {
            throw new IllegalArgumentException("Les stations et la liste des lignes et le type de passager ne doivent pas être nulles ou vides.");
        }

        String nomDebut = debut.getNom();
        String nomArrive = arrive.getNom();
        Ligne ligneTrouvee = null;
        double prix = 0 ;
        double  coefPassager = 0 ;


        if(passager.categorie == Passager.Categorie.Regulier  ) {
            coefPassager = 1;
        }

        else if (passager.categorie == Passager.Categorie.Etudiant) {
                        coefPassager = 0.8;
        }
        else if (passager.categorie == Passager.Categorie.Senior ) { 
            coefPassager = 0.65;

        }

        else if (passager.categorie == Passager.Categorie.Handicape ) { 
            coefPassager = 0.5;

        }
        for (Ligne ligne : lignes) {
            boolean debutTrouve = Arrays.asList(ligne.getStations()).contains(nomDebut);
            boolean arriveTrouve = Arrays.asList(ligne.getStations()).contains(nomArrive);

            if (debutTrouve && arriveTrouve) {
                ligneTrouvee = ligne;
                break;
            }
        }

        if (ligneTrouvee == null) {
            return 0; // Retourne 0 si aucune ligne ne relie les deux stations
        }

        double multiplicationTarifaire = 0 ;

        if(ligneTrouvee.getType()== Ligne.Type.Tram) {
            multiplicationTarifaire = 1.0 ;
        }
        else if(ligneTrouvee.getType()== Ligne.Type.Bus) {
            multiplicationTarifaire = 0.8 ;
        }
        else if(ligneTrouvee.getType()== Ligne.Type.Metro) {
            multiplicationTarifaire = 1.2 ;

        }
        prix = 1.50*coefPassager + ((calculDistance(debut, arrive)/1000)*multiplicationTarifaire) ; 
        
        return prix;
    }


}