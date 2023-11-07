public class MainApp {

    public static void main(String[] args) throws Exception {
        int[][] weightsMatrix = {
            {0, 3, 2, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 7, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 4},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 6},
            {Integer.MAX_VALUE, 4, 5, Integer.MAX_VALUE, 0}
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
