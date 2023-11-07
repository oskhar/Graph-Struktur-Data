import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.getNeighbors().addAll(List.of(v1, v5, v6));
        v1.getNeighbors().addAll(List.of(v3, v4, v5));
        v4.getNeighbors().addAll(List.of(v2, v6));
        v6.getNeighbors().add(v0);

        new BreadthFirstSearch<>(v0).traverse();

    }

}