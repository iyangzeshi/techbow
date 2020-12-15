package algorithm_and_data_structure_advanced.session13_Greedy.dijkstra;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DijkstraAlgorithmTest {
    List<Vertex> nodes;
    List<Edge> edges;

    
    public void test1() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        //check form location loc1 to loc11
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));

        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(7));

        int shortest = dijkstra.getShortestDistance(nodes.get(7));
        System.out.println(shortest);

        // assertNotNull(path);
        assertTrue(path.size() > 0);
        
        System.out.println("Shortest path: " + path);

    }


    private void addLane(String laneId, int sourceLoNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLoNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}