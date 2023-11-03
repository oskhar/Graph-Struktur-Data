import java.util.LinkedList;
import java.util.Queue;

public record BreadthFirstSearch<T>(Vertex<T> startVertex) {

    public void traverse() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbors());
            }
        }
    }

}
