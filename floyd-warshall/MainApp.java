import static FloydWarshall.INF; // Library tambahan

public class MainApp {

    public static void main(String[] args) throws Exception {

        int[][] weightsMatrix = {
                {0, 3, 2, INF, INF},
                {INF, 0, INF, 7, INF},
                {INF, INF, 0, INF, 4},
                {INF, INF, INF, 0, 6},
                {INF, 4, 5, INF, 0}
        };
        String[][] successorsMatrix = {
                {"-", "B", "C", "-", "-"},
                {"-", "-", "-", "D", "-"},
                {"-", "-", "-", "-", "E"},
                {"-", "-", "-", "-", "E"},
                {"-", "B", "C", "-", "-"}
        };
        new FloydWarshall(weightsMatrix, successorsMatrix).run();

    }

}
