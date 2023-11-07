import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private final List<Vertex<T>> neighbors = new ArrayList<>();

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

    public List<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor) {
        neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertex{data=").append(data);
        sb.append(", visited=").append(visited);
        sb.append(", neighbors=[");
        for (Vertex<T> neighbor : neighbors) {
            sb.append(neighbor.getData()).append(", ");
        }
        if (!neighbors.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]}");
        return sb.toString();
    }
}
