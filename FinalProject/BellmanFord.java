package ShortestPath;

import java.util.Scanner;

public class BellmanFord {
    // Implement BellmanFOrd Algorithm with adjacency matrix

    private int distances[];
    private int vertices;
    public static final int MAX_VALUE = Integer.MAX_VALUE;

    public BellmanFord(int vertices) {
        this.vertices = vertices;
        distances = new int[vertices + 1];
    }

    public void BellmanFordEvaluation(int source, int graph[][]) {
        // Initialize all the distance to infinity
        for (int i = 1; i <= vertices; i++) {
            distances[i] = MAX_VALUE;
        }

        distances[source] = 0;
        // just vertices - 1 repetitions to update the distance between two vertices
        for (int j = 1; j <= vertices - 1; j++) {
            for (int src = 1; src <= vertices; src++) {
                for (int des = 1; des <= vertices; des++) {
                    // check of the edge between vertex_Src and vertex_Des
                    if (graph[src][des] != 0) {
                        // check if distance needs an update or not
                        if (distances[des] > distances[src] + graph[src][des])
                            distances[des] = distances[src] + graph[src][des];
                    }
                }
            }
        }
        // check for negative weight cycles
        for (int src = 1; src <= vertices; src++) {
            for (int des = 1; des <= vertices; des++) {
                if (graph[src][des] != 0) {
                    if (distances[des] > distances[src] + graph[src][des])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
        // print shortest path from source vertex to another vertex
        for (int vertex = 1; vertex <= vertices; vertex++) {
            System.out.println("distance of source  " + source + " to " + vertex + " is " + distances[vertex]);
        }
    }

    public static void main(String[] args) {
        int vertices = 0;
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        vertices = sc.nextInt();
        int graph[][] = new int[vertices + 1][vertices + 1];
        System.out.println("Enter the adjacency matrix");
        for (int src = 1; src <= vertices; src++) {
            for (int des = 1; des <= vertices; des++) {
                graph[src][des] = sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex");
        // denoted source vertex is 1
        source = sc.nextInt();

        BellmanFord bel = new BellmanFord(vertices);
        bel.BellmanFordEvaluation(source, graph);
        // Enter the number of vertices
        // 6
        // Enter the adjacency matrix
        // 0 4 0 0 -1 0
        // 0 0 -1 0 -2 0
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 0 0 0 -5 0 3
        // 0 0 0 0 0 0
        // Enter the source vertex
        // 1
    }
}