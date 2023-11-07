public class MainApp {

    public static void main(String[] args) {

        Vertex<String> S = new Vertex<>("S");
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> T = new Vertex<>("T");

        S.addNeighbor(A, 15);
        S.addNeighbor(B, 12);
        A.addNeighbor(B, 10);
        A.addNeighbor(C, 12);
        A.addNeighbor(D, 1);
        B.addNeighbor(D, 14);
        C.addNeighbor(T, 25);
        D.addNeighbor(C, 10);
        D.addNeighbor(T, 4);

        System.out.print("The Max Flow is: ");
        System.out.println(new FordFulkerson<String>().run(S, T));

    }
}
