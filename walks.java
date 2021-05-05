import java.util.Random;

public class walks {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 2, 1},
            {2, 1, 2, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 0}
        };

        System.out.println();
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println();

        walk(matrix);
        trail(matrix);
        path(matrix);
        closedWalk(matrix);
        circuit(matrix);
        cycle(matrix);
    }

    public static int[][] createMatricx(int mtx[][]) {

        int matrix[][] = new int [mtx.length][mtx.length];
        
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                matrix[i][j] = mtx [i][j];
            }
        }
        return matrix;
    }

    // Open walk-A walk is said to be an open walk if the starting and ending vertices are different
    // i.e. the origin vertex and terminal vertex are different.
    public static void walk(int[][] mtrx) {
        System.out.print("Open Walk: ");
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        int next = rand.nextInt(4) + 1;
        System.out.print(origin);

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;

        while (next != origin) {
            if (mtrx[current-1][next-1] > 0) {
                System.out.print(" -> " + next);
                current = next;
            }
            next = rand.nextInt(4) + 1;
        }
        System.out.println();
    }

    //Trail is an open walk in which no edge is repeated.
    //Vertex can be repeated
    public static void trail(int[][] mtrx) {

        System.out.print("Trail: ");
        int[][] visited = createMatricx(mtrx);
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        int next = rand.nextInt(4) + 1;
        System.out.print(origin);

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;

        while (next != origin) {
            if (visited[current-1][next-1] > 0) {
                visited[current-1][next-1] -= 1;
                System.out.print(" -> " + next);
                current = next;
            }
            next = rand.nextInt(4) + 1;
        }
        System.out.println();
    }

    //It is a trail in which neither vertices nor edges are repeated
    //i.e. if we traverse a graph such that we do not repeat a vertex and nor we repeat an edge.
    //As path is also a trail, thus it is also an open walk.
    //Vertex not repeated. Edge not repeated
    public static void path(int[][] mtrx) {

        System.out.print("Path: ");
        int[][] visited = createMatricx(mtrx);
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        int next = rand.nextInt(4) + 1;
        System.out.print(origin);

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;

        for(int i=0; i<visited.length; i++){
            visited[i][origin-1] = 0;
        }

        while (next != origin) {
            if (visited[current-1][next-1] > 0) {
                for(int i=0; i<visited.length; i++){
                    visited[i][next-1] = 0;
                }
                System.out.print(" -> " + next);
                current = next;
            }
            next = rand.nextInt(4) + 1;
        }
        System.out.println();
    }

    //A walk is said to be a closed walk if the starting and ending vertices are identical
    //Vertex can be repeated.Edges can be repeated
    public static void closedWalk(int[][] mtrx) {

        System.out.print("Closed Walk: ");
        int[][] visited = mtrx;
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        int next = rand.nextInt(4) + 1;
        System.out.print(origin);

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;
        boolean startEnd = false;

        while (!startEnd) {
            if (visited[current-1][next-1] > 0) {
                System.out.print(" -> " + next);
                current = next;
            }
            if (next == origin){
                startEnd = true;
            }
            next = rand.nextInt(4) + 1;
        }
        System.out.println();
    }

    //Traversing a graph such that not an edge is repeated but vertex can be repeated and it is closed also i.e. it is a closed trail.
    //Vertex can be repeated. Edge not repeated
    public static void circuit(int[][] mtrx) {

        System.out.print("Circuit: ");
        int[][] visited = createMatricx(mtrx);
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        System.out.print(origin);
        int next = rand.nextInt(4) + 1;

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;
        boolean startEnd = false;

        while (!startEnd) {
            if (visited[current-1][next-1] > 0) {
                visited[current-1][next-1] -= 1;
                System.out.print(" -> " + next);
                current = next;
            }
            if (next == origin){
                startEnd = true;
            }
            next = rand.nextInt(4) + 1;
        }  
        System.out.println();  
    }

    //Traversing a graph such that we do not repeat a vertex nor we repeat a edge but the starting and ending vertex must be same
    //i.e. we can repeat starting and ending vertex only then we get a cycle.
    //Vertex not repeated. Edge not repeated.
    public static void cycle(int[][] mtrx) {
        System.out.print("Cycle: ");
        int[][] visited = createMatricx(mtrx);
        Random rand = new Random();
        int origin = rand.nextInt(4) + 1;
        int next = rand.nextInt(4) + 1;
        System.out.print(origin);

        while (next == origin){
            next = rand.nextInt(4) + 1;
        }

        int current = origin;

        while (next != origin) {
            if (visited[current-1][next-1] > 0) {
                for(int i=0; i<visited.length; i++){
                    visited[i][next-1] = 0;
                }
                System.out.print(" -> " + next);
                current = next;
            }
            next = rand.nextInt(4) + 1;
        }System.out.print(" -> " + next);
        System.out.println();
    }
}