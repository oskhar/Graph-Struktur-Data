import java.util.Arrays;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) {

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        Edge edgeAB = new Edge(4);
        Edge edgeAC = new Edge(4);
        Edge edgeBC = new Edge(2);
        Edge edgeCD = new Edge(3);
        Edge edgeCF = new Edge(4);
        Edge edgeCE = new Edge(2);
        Edge edgeDF = new Edge(3);
        Edge edgeEF = new Edge(3);

        vertexA.addNeighbor(vertexB, edgeAB);
        vertexA.addNeighbor(vertexC, edgeAC);

        vertexB.addNeighbor(vertexA, edgeAB);
        vertexB.addNeighbor(vertexC, edgeBC);

        vertexC.addNeighbor(vertexA, edgeAC);
        vertexC.addNeighbor(vertexB, edgeBC);
        vertexC.addNeighbor(vertexE, edgeCE);
        vertexC.addNeighbor(vertexD, edgeCD);
        vertexC.addNeighbor(vertexF, edgeCF);

        vertexD.addNeighbor(vertexC, edgeCD);
        vertexD.addNeighbor(vertexF, edgeDF);

        vertexE.addNeighbor(vertexC, edgeCE);
        vertexE.addNeighbor(vertexF, edgeEF);

        vertexF.addNeighbor(vertexD, edgeDF);
        vertexF.addNeighbor(vertexC, edgeCF);
        vertexF.addNeighbor(vertexE, edgeEF);

        new Prim<>(Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF)).run();

        Integer minimum = Stream.of(edgeAB, edgeAC, edgeBC, edgeCD, edgeCF, edgeCE, edgeDF, edgeEF)
                .filter(Edge::isIncluded).map(Edge::getWeight).reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);

    }


}
