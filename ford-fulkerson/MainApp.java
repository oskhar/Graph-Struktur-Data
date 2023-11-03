import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {

        Vertex<String> S = new Vertex<>("S");
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> T = new Vertex<>("T");

        S.setNeighbors(new HashMap<>(Map.of(A, 15, B, 12)));
        A.setNeighbors(new HashMap<>(Map.of(B, 10, C, 12, D, 1)));
        B.setNeighbors(new HashMap<>(Map.of(D, 14)));
        C.setNeighbors(new HashMap<>(Map.of(T, 25)));
        D.setNeighbors(new HashMap<>(Map.of(C, 10, T, 4)));

        System.out.print("The Max Flow is: ");
        System.out.println(new FordFulkerson<String>().run(S, T));

    }

}
