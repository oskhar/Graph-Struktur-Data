import java.util.Collection;
import java.util.List;

import static java.util.Comparator.comparingInt;

public record Prim<T>(List<Vertex<T>> graph) {

    public void run() {
        if (!graph.isEmpty()) graph.get(0).setVisited(true);
        while (graph.stream().anyMatch(vertex -> !vertex.isVisited())) {
            graph.stream().filter(Vertex::isVisited)
                    .map(Vertex::getNeighbors)
                    .flatMap(Collection::stream)
                    .filter(neighbor -> !neighbor.isVisited())
                    .min(comparingInt(n -> n.getEdge().getWeight()))
                    .ifPresent(candidate -> {
                        candidate.getVertex().setVisited(true);
                        candidate.getEdge().setIncluded(true);
                    });
        }
        graph.forEach(System.out::println);
    }

}
