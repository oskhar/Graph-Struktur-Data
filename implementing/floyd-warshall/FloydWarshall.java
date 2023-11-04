import java.util.stream.IntStream;

public class FloydWarshall {

    private final int nbrOfVertices;
    private final int[][] weightsMatrix;
    private final String[][] successorsMatrix;
    public final static int INF = Integer.MAX_VALUE;

    public FloydWarshall(int[][] weightsMatrix, String[][] successorsMatrix) {
        this.weightsMatrix = weightsMatrix;
        this.successorsMatrix = successorsMatrix;
        nbrOfVertices = weightsMatrix[0].length;
    }

    public void run() throws Exception {
        IntStream.range(0, nbrOfVertices).forEach(intermediate ->
                IntStream.range(0, nbrOfVertices).forEach(start ->
                        IntStream.range(0, nbrOfVertices).forEach(end -> {
                            int weight = getWeightViaInterNode(weightsMatrix, start, intermediate, end);
                            if (weight < weightsMatrix[start][end]) {
                                weightsMatrix[start][end] = weight;
                                successorsMatrix[start][end] = successorsMatrix[start][intermediate];
                            }
                        })
                )
        );
        for (int i = 0; i < nbrOfVertices; i++) {
            if (weightsMatrix[i][i] < 0) {
                throw new Exception("Graph has a negative cycle!!");
            }
        }
        print(weightsMatrix);
        print(successorsMatrix);
    }

    private int getWeightViaInterNode(int[][] matrix, int start, int intermediate, int end) {
        return matrix[start][intermediate] == INF || matrix[intermediate][end] == INF
                ? INF : matrix[start][intermediate] + matrix[intermediate][end];
    }

    public void print(int[][] matrix) {
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] == INF ? "∞  " : matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }

    public void print(String[][] matrix) {
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }

}