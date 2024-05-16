import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private List<Neighbor<T>> neighbors = new LinkedList<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Neighbor<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<T> vertex, Edge edge) {
        neighbors.add(new Neighbor<>(vertex, edge));
    }

    @Override
    public String toString() {
        return "Vertex " + data + " -> " + neighbors.stream()
                .filter(n -> n.getVertex().isVisited() && n.getEdge().isIncluded())
                .map(n -> n.getVertex().getData() + "|" + n.getEdge().getWeight())
                .collect(Collectors.joining(" - "));
    }
}