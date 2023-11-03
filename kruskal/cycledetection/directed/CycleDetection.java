import Vertex; // Library tambahan

import java.util.Arrays;
import java.util.List;

public class CycleDetection<T> {

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> sourceVertex) {
        sourceVertex.setBeingVisited(true);
        for (Vertex<T> neighbor : sourceVertex.getNeighbors()) {
            if (neighbor.isBeingVisited() || !neighbor.isVisited() && hasCycle(neighbor)) {
                return true;
            }
        }
        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }

    public static void main(String[] args) {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        vertexA.addNeighbor(vertexB);
        vertexA.addNeighbor(vertexC);
        vertexB.addNeighbor(vertexC);
        vertexB.addNeighbor(vertexD);
        vertexB.addNeighbor(vertexE);
        vertexC.addNeighbor(vertexD);
        vertexD.addNeighbor(vertexE);
        vertexE.addNeighbor(vertexF);
        vertexF.addNeighbor(vertexD);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF);
        System.out.println(new CycleDetection<String>().hasCycle(graph)); // true
    }

}
