import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private Map<Vertex<T>, Integer> neighbors = new HashMap<>();

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

    public Map<Vertex<T>, Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor, int weight) {
        neighbors.put(neighbor, weight);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", visited=" + visited +
                ", neighbors=" + neighbors +
                '}';
    }
}