package ShortestPath;

public class DijkstraAlgorithm {

    // Implement Dijkstra Algorithm with adjacency matrix

    // get the vertex with minimum distance and isVisited is false
    public int getMinimumVertex(boolean[] isVisited, int[] key) {
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < key.length; i++) {
            if (isVisited[i] == false && minKey > key[i]) {
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public void dijkstra_GetMinDistances(int[][] graph, int sourceVertex) {
        boolean[] isVisited = new boolean[graph.length];
        int[] distance = new int[graph.length];
        int INFINITY = Integer.MAX_VALUE;

        // Initialize all the distance to infinity
        for (int i = 0; i < graph.length; i++) {
            distance[i] = INFINITY;
        }

        // start from the vertex 0
        distance[sourceVertex] = 0;

        for (int i = 0; i < graph.length; i++) {
            // get the vertex with the minimum distance
            int src = getMinimumVertex(isVisited, distance);
            // iterate through all the adjacent vertices of above vertex and update the distance
            for (int des = 0; des < graph.length; des++) {
                // check of the edge between vertex_Src and vertex_Des != 0 and
                // check if this vertex 'vertex_Des' isVisited
                if (graph[src][des] != 0 && isVisited[des] == false) {    
                    // check if distance needs an update or not
                    int newKey = graph[src][des] + distance[src];
                    if (newKey < distance[des])
                    distance[des] = newKey;
                }
            }
            isVisited[src] = true;
        }
        // print shortest path tree
        printDijkstra(sourceVertex, distance);
    }

    public void printDijkstra(int sourceVertex, int[] key) {
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i < key.length; i++) {
            System.out.println("Distance of source " + sourceVertex + " to " + i + " is: " + key[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { 
            { 0, 4, 0, 0, 5 }, 
            { 4, 0, 1, 2, 0 }, 
            { 0, 1, 0, 0, 0 }, 
            { 0, 2, 6, 0, 1 },
            { 5, 0, 0, 1, 0 } 
        };
        DijkstraAlgorithm dij = new DijkstraAlgorithm();
        dij.dijkstra_GetMinDistances(graph, 0);
    }
}