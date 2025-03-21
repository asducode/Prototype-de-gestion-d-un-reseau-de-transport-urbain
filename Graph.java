import java.text.DecimalFormat;
import java.util.*;

/**
 * Générique classe qui utilise les HashMap pour stocker un graph en memoire.
 * Les instances de cette classe ont le même fonctionnalité que les graphes vus en TP de Structures de Données, mais
 * parce que la classe a été définie comme une classe générique, il est possible de stocker d'autre chose que des
 * entiers dans le graphe.
 * @param <Node> Le type de donnée d'être stocké dans le graphe
 * @author Richard WOODWARD
 * @version 1.0
 */
public class Graph<Node> {

    private static final DecimalFormat df = new DecimalFormat("0.0#");

    private static final Double POIDS_PAR_DEFAUT = 1.0;
    /**
     * Le HashMap qui stocke en memooire le graph. Les clés sont les sommets.
     * Pour chaque sommet les arêtes (pour les graphes non-orienté) ou les arcs sortants, sont stocké comme un HashMap
     * avec clé le prochain arête, et comme valeur une valeur réelle qui indique le poids.
     * (Par défaut ce poids sera égale à 1.0)
     */
    private final HashMap<Node, HashMap<Node,Double>> connections;

    private final boolean isDirected;

    private final boolean isWeighted;

    /**
     * Créer une instance de Graph.
     * @param isDirected true si graphe orienté, sinon false
     */
    public Graph(boolean isDirected) {
        this(isDirected, false);
    }

    /**
     * Créer une instance de Graph
     * @param isDirected true si graphe orienté, sinon false
     * @param isWeighted trus si graphe utilise le poids, sinon false
     */
    public Graph(boolean isDirected, boolean isWeighted) {
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.connections = new HashMap<>();
    }


    /**
     * Ajouter une arête pour un graph non orienté (donc dans les deux sens src -> dest et dest-> src, ou un arc entre src-> dest si le graph est orienté.
     * Si le sommet source, ou le sommet destination, ne sont pas encore stocké dans le graph, cette méthode les ajoute dans le graph.
     * @param src le sommet source
     * @param dest le sommet destination
     * @param poids le poids de la connection
     */
    public void addEdge(Node src, Node dest, Double poids) {
        addNode(src);
        addNode(dest);
        this.connections.get(src).put(dest,poids);
        if(!isDirected){
            this.connections.get(dest).put(src, poids);
        }
    }

    /**
     * Ajouter un sommet dans le graphe. Vérifier en premier si le sommet existe déjà.
     * @param node le sommet d'ajouter dans le graphe
     */
    public void addNode(Node node) {
        if(!connections.containsKey(node)) {
            this.connections.put(node, new HashMap<>());
        }
    }

    /**
     * Ajouter une arête pour un graph non orienté (donc dans les deux sens src -> dest et dest-> src, ou un arc entre src-> dest si le graph est orienté.
     * Si le sommet source, ou le sommet destination, ne sont pas encore stocké dans le graph, cette méthode les ajoute dans le graph. Cette méthode utilise le poids par défaut pour le poids.
     * @param src le sommet source
     * @param dest le sommet destination
     */
    public void addEdge(Node src, Node dest){
        this.addEdge(src, dest, POIDS_PAR_DEFAUT);
    }

    /**
     * Produire une chaîne de caractère qui liste ligen par ligne pour chaque sommet les sommets connecté directement par les arcs ou arêtes sortants
     * @return String représentant le graphe
     */
    public String representation(){
        StringBuilder sb = new StringBuilder();
        if(this.isDirected){
            sb.append("digraph G {\n");
        }else{
            sb.append("graph G {\n");
        }
        sb.append("\tnumber Nodes = " + this.connections.size() + "\n");
        for(Node key : this.connections.keySet()){
            sb.append("\t" + key + " -> ");
            if(this.connections.get(key).isEmpty()){
                sb.append("[]");
            }
            else{
                for(Map.Entry<Node,Double> entry : this.connections.get(key).entrySet()){
                    sb.append(entry.getKey());
                    if(isWeighted){
                        sb.append("(");
                        sb.append(df.format(entry.getValue()));
                        sb.append(")");
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Retourne le nombre de sommets dans le graphe
     * @return int représentant le nombre de sommets dans le graphe
     */
    public int getNumberNodes(){
        return this.connections.size();
    }

    /**
     * Retourne si le graphe est orienté ou pas
     * @return true si orienté, sinon false
     */
    public boolean isDirected(){
        return this.isDirected;
    }

    /**
     * Retourne si le graphe doit utiliser les poids
     * @return true si oui, sinon false
     */
    public boolean isWeighted(){
        return this.isWeighted;
    }

    /**
     * Calcule et retourne le nombre d'arcs entrant pour un sommet
     * @param node le sommet
     * @return int représentant le nombre d'arcs entrant
     */
    public int numberIncomingEdges(Node node){
        if(!this.connections.containsKey(node)){
            return 0;
        }
        int count = 0;
        for(Node key : this.connections.keySet()){
            if(this.connections.get(key).containsKey(node)){
                count++;
            }
        }
        return count;
    }

    /**
     * Calcule et retourne le nombre d'arcs sortant pour un sommet
     * @param node le sommet
     * @return int représentant le nombre d'arcs sortant
     */

    public int numberOutgoingEdges(Node node){
        if(!this.connections.containsKey(node)){
            return 0;
        }
        return this.connections.get(node).size();
    }

    /**
     * Retourne une vecteur qui contient tout les sommets sources
     * @return un ArrayList qui contient les sommets dites source
     */
    public ArrayList<Node> getSourceNodes(){
        ArrayList<Node> sourceNodes = new ArrayList<>();
        for(Node key : this.connections.keySet()){
            if(numberIncomingEdges(key)==0){
                sourceNodes.add(key);
            }
        }
        return sourceNodes;
    }


    /**
     * Retourne une vecteur qui contient tout les sommets puits
     * @return un ArrayList qui contient les sommets dites puits
     */
    public ArrayList<Node> getSinkNodes(){
        ArrayList<Node> sinkNodes = new ArrayList<>();
        for(Node key : this.connections.keySet()){
            if(numberOutgoingEdges(key)==0){
                sinkNodes.add(key);
            }
        }
        return sinkNodes;
    }

    /**
     * Méthode qui performe un parcours par profondeur sur le graph
     * @param node le sommet courrant
     * @param visited un ArrayList qui contient les sommets déjà visités
     */
    public void depthFirstTraversal(Node node, ArrayList<Node> visited){
        visited.add(node);
        for(Node neighbour : this.connections.get(node).keySet()){
            if(!visited.contains(neighbour)){
                depthFirstTraversal(neighbour, visited);
            }
        }
    }

    /**
     * Retourne si le sommet 'arrivalNode' est atteignable à partir du sommet 'departureNode'
     * @param departureNode le sommet de départure
     * @param arrivalNode le sommet qu'on veut atteindre
     * @return true si c'est possible de l'atteindre, sinon false
     */
    public boolean isNodeReachable(Node departureNode, Node arrivalNode){
        ArrayList<Node> visited = new ArrayList<>();
        depthFirstTraversal(departureNode, visited);
        return visited.contains(arrivalNode);
    }

    /**
     * Retourne si le graphe contient au moins un circuit
     * @return true si au moin un circuit est trouvé, sinon false
     */
    public boolean hasCycle(){
        boolean hasCycle = false;
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        Iterator<Node> secondaryIterator = this.connections.keySet().iterator();
        while(primaryIterator.hasNext() && !hasCycle){
            Node primaryNode = primaryIterator.next();
            while(secondaryIterator.hasNext() && !hasCycle){
                Node secondaryNode = secondaryIterator.next();
                if(!primaryNode.equals(secondaryNode) && isNodeReachable(primaryNode, secondaryNode) && isNodeReachable(secondaryNode, primaryNode)){
                    hasCycle = true;
                }
            }
        }
        return hasCycle;
    }

    /**
     * Retourne si un graph non-orienté est connexe.
     * @return true is le graph est connexe, sinon false
     * @throws UnsupportedOperationException si le graphe est orienté
     */
    public boolean isConnected(){
        if(isDirected){
            throw new UnsupportedOperationException("Cannot use isConnected() on a directed graph.");
        }
        boolean isConnected = false;
        ArrayList<Node> visited = new ArrayList<>();
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        if(primaryIterator.hasNext()){
            Node primaryNode = primaryIterator.next();
            this.depthFirstTraversal(primaryNode, visited);
            isConnected = true;
            Iterator<Node> secondaryIterator = this.connections.keySet().iterator();
            while(secondaryIterator.hasNext() && isConnected){
                Node secondaryNode = secondaryIterator.next();
                isConnected = visited.contains(secondaryNode);
            }
        }
        return isConnected;
    }

    /**
     * Retourne si un graph orienté est fortement connexe.
     * @return true is le graph est fortement connexe, sinon false
     * @throws UnsupportedOperationException si le graphe est non-orienté
     */
    public boolean isStronglyConnected(){
        if(!isDirected){
            throw new UnsupportedOperationException("Cannot use isStronglyConnected() on an undirected graph.");
        }
        boolean isStronglyConnected = true;
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        Iterator<Node> secondaryIterator = this.connections.keySet().iterator();
        while(primaryIterator.hasNext() && isStronglyConnected){
            Node primaryNode = primaryIterator.next();
            while(secondaryIterator.hasNext() && isStronglyConnected){
                Node secondaryNode = secondaryIterator.next();
                isStronglyConnected = this.isNodeReachable(primaryNode, secondaryNode) && this.isNodeReachable(secondaryNode, primaryNode);
            }
        }
        return isStronglyConnected;
    }

    /**
     * Retourne le nombre de composants connexes dans un graphe non-orienté
     * @return le nombre de composants connexes
     * @throws UnsupportedOperationException si le graphe est orienté
     */
    public int numberConnectedComposants(){
        if(isDirected){
            throw new UnsupportedOperationException("Cannot use numberConnectedComposants() on an undirected graph.");
        }
        ArrayList<Node> visited = new ArrayList<>();
        int numberConnectedComposants = 0;
        for (Node primaryNode : this.connections.keySet()) {
            if (!visited.contains(primaryNode)) {
                this.depthFirstTraversal(primaryNode, visited);
                numberConnectedComposants++;
            }
        }
        for(Node primaryNode : this.connections.keySet()){
            if(numberIncomingEdges(primaryNode)==0 && numberOutgoingEdges(primaryNode)==0){
                numberConnectedComposants--;
            }
        }
        return numberConnectedComposants;
    }

    /**
     * Retourne si le grpahe est resistant de la suppression d'un sommet
     * @return true si le graphe est resistant, sinon faux
     */
    public boolean isResilient(){
        boolean isResilient = true;
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        while(primaryIterator.hasNext() && isResilient){
            Iterator<Node> secondaryIterator = this.connections.keySet().iterator();
            Node primaryNode = primaryIterator.next();
            while(secondaryIterator.hasNext() && isResilient){
                 Node secondaryNode = secondaryIterator.next();
                if(connections.get(primaryNode).containsKey(secondaryNode)){
                    Double weightPrimarySecondary = connections.get(primaryNode).remove(secondaryNode);
                    Double weightSecondaryPrimary = connections.get(secondaryNode).remove(primaryNode);
                    isResilient = isConnected();
                    connections.get(primaryNode).put(secondaryNode, weightPrimarySecondary);
                    connections.get(secondaryNode).put(primaryNode, weightSecondaryPrimary);
                }
            }
        }
        return isResilient;
    }

    /**
     * Méthode qui duplique cette graph, en supprimant un sommet
     * @param node le sommet de supprimet
     * @return une copie de ce graphe, avec le sommet supprimé
     */
    Graph<Node> duplicateAndDeleteNode(Node node){
        Graph<Node> temporaryGraph = new Graph<>(this.isDirected, this.isWeighted);
        for(Node primaryNode : this.connections.keySet()){
            if(!primaryNode.equals(node)){
                temporaryGraph.connections.put(primaryNode, new HashMap<>());
            }
        }
        for(HashMap.Entry<Node,HashMap<Node,Double>> sourceEntry : this.connections.entrySet()){
            Node sourceNode = sourceEntry.getKey();
            if(sourceNode.equals(node)){
                continue;
            }
            HashMap<Node,Double> destinations = sourceEntry.getValue();
            for(HashMap.Entry<Node,Double> destinationEntry : destinations.entrySet()){
                Node destinationNode = destinationEntry.getKey();
                if(destinationNode.equals(node)){
                    continue;
                }
                Double weight = destinationEntry.getValue();
                temporaryGraph.connections.get(sourceNode).put(destinationNode, weight);
            }
        }
        return temporaryGraph;
    }

    /**
     * Retourne si le graphe est connexe-résistant
     * @return true si le graphe est connexe-résistant, sinon false
     */
    public boolean isResistantToEdgeRemoval(){
        boolean isResistantToEdgeRemoval = true;
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        Graph<Node> temporaryGraph;
        while(primaryIterator.hasNext() && isResistantToEdgeRemoval){
            temporaryGraph = this.duplicateAndDeleteNode(primaryIterator.next());
            isResistantToEdgeRemoval = temporaryGraph.isConnected();
        }
        return isResistantToEdgeRemoval;
    }

    /**
     * Calcule les valeurs Ford, pour ce graph, en les stockant dans un HashMap
     * @param startNode le donde de départure
     * @return HashMap qui contient les valeurs Ford
     */
   public HashMap<Node,Double> fordValues(Node startNode){
        HashMap<Node,Double> weights = new HashMap<>();
        for(Node node : this.connections.keySet()){
            weights.put(node,Double.POSITIVE_INFINITY);
        }
        weights.replace(startNode, 0.0);
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        boolean backtrack = false;
        while(primaryIterator.hasNext()){
            Node primaryNode = primaryIterator.next();
            backtrack = false;
            Iterator<Node> secondaryIterator = this.connections.keySet().iterator();
            while(secondaryIterator.hasNext() && !backtrack){
                Node secondaryNode = secondaryIterator.next();
                if(connections.containsKey(primaryNode) && connections.get(primaryNode).containsKey(secondaryNode)){
                    Double weight = connections.get(primaryNode).get(secondaryNode);
                    if(weights.get(primaryNode)!= Double.POSITIVE_INFINITY && weights.get(secondaryNode) > weights.get(primaryNode)+ weight){
                        weights.put(secondaryNode, weights.get(primaryNode)+ weight);
                        backtrack = true;
                    }
                }
            }
            if(backtrack){
                primaryIterator = connections.keySet().iterator();
            }
        }
        return weights;
   }

    /**
     * Créer un duplicate de ce graph
     * @return une nouvelle instance de Graph qui est identique de cette instance
     */
   public Graph<Node> duplicate(){
        Graph<Node> duplicate = new Graph<>(this.isDirected, this.isWeighted);
        for(Node node : this.connections.keySet()){
            duplicate.connections.put(node, new HashMap<>());
            for(Map.Entry<Node,Double> entry : this.connections.get(node).entrySet()){
                duplicate.connections.get(node).put(entry.getKey(), entry.getValue());
            }
        }
        return duplicate;
   }

    /**
     * Calcule  et retourne les floyd values pour ce graph
     * @return un Graph qui contient les floyd values
     */
   public Graph<Node> floydValues(){
        Graph<Node> copy = this.duplicate();
        for(Node node : this.connections.keySet()){
            copy.connections.get(node).put(node, 0.0);
        }
        for(Node k : this.connections.keySet()){
            for(Node i : this.connections.keySet()){
                for(Node j : this.connections.keySet()){
                    Double ijDistance = copy.connections.get(i).getOrDefault(j, Double.POSITIVE_INFINITY);
                    Double ikDistance = copy.connections.get(i).getOrDefault(k, Double.POSITIVE_INFINITY);
                    Double kjDistance = copy.connections.get(k).getOrDefault(j, Double.POSITIVE_INFINITY);
                    if(ikDistance != Double.POSITIVE_INFINITY && kjDistance != Double.POSITIVE_INFINITY && ikDistance + kjDistance < ijDistance){
                        copy.connections.get(i).put(j, ikDistance + kjDistance);
                    }
                }
            }
        }

        return copy;
   }

    /**
     * Calcule et retourne le diamètre de ce graph
     * @return une valeur réelle qui contient le diamètre de ce graph
     */
   public Double diameter(){
        double diameter = 0;
        Graph<Node> floyd = floydValues();
        for(Node primaryNode : this.connections.keySet()){
            for(Node secondaryNode : this.connections.keySet()){
                if(floyd.connections.get(primaryNode).getOrDefault(secondaryNode, Double.NEGATIVE_INFINITY) > diameter ){
                    diameter = floyd.connections.get(primaryNode).get(secondaryNode);
                }
            }
        }
        return diameter;
   }

    /**
     * Implémentation de l'algorithme qui permet de remonter d'un sommet en arrière
     * @param arrivalNode sommet d'arrivée
     * @param fordValues les valeurs ford déjà calculé
     * @return le sommet en arrière
     */
   Node findDepartNode(Node arrivalNode, Map<Node,Double> fordValues){
        Node found = null;
        Iterator<Node> primaryIterator = this.connections.keySet().iterator();
        while(primaryIterator.hasNext() && found == null){
            Node primaryNode = primaryIterator.next();
            if(connections.get(primaryNode).containsKey(arrivalNode) && fordValues.get(primaryNode)!= Double.POSITIVE_INFINITY && fordValues.get(primaryNode)+this.connections.get(primaryNode).get(arrivalNode)==fordValues.get(arrivalNode)){
                found = primaryNode;
            }
        }
        return found;
   }

    /**
     * Créer un Vecteur qui contient les sommets dans le chemin le plus court
     * @param departureNode le sommet de départ
     * @param arrivalNode le sommet d'arrivée
     * @return un ArrayList qui contient les sommets sur le chemin entre sommet de départ et le sommet d'arrivee.
     */
   ArrayList<Node> pathFollowed (Node departureNode, Node arrivalNode){
        ArrayList<Node> path = new ArrayList<>();
       HashMap<Node, Double> fordValues = this.fordValues(departureNode);
       Node node;
       if(fordValues.get(arrivalNode)== Double.POSITIVE_INFINITY){
           return null;
       }
       do{
           node = findDepartNode(arrivalNode, fordValues);
           path.add(arrivalNode);
           arrivalNode = node;
       }while(node != departureNode);
       path.add(departureNode);
       Collections.reverse(path);
       return path;
   }

}