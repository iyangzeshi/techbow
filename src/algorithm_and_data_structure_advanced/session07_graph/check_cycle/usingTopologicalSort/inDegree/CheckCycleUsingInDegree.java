package algorithm_and_data_structure_advanced.session07_graph.check_cycle.usingTopologicalSort.inDegree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session07_graph.check_cycle.usingTopologicalSort
// .inDegree
//ClassName: CheckCycleUsingIndegree
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2024-03-01 星期五 01:17
public class CheckCycleUsingInDegree {
    
    /*
    find the number of vertex in graph as NumberOfVertices
    build graph, key: cur, value: List of following vertex
    
    BFS traverse all the vertex whose inDegree = 0
    
    check whether exists vertex whose inDegree ≠ 0
    if exist vertex inDegree ≠ 0, there may be some cycles
    if not exist vertex inDegree ≠ 0, there is no cycle
     */
    public boolean containsCycle(Map<Vertex, List<Vertex>> graph) {
        // corner case
        if (graph == null) {
            return false;
        }
        
        // general case
        int numberOfVertices = graph.keySet().size();
        int count = 0;
        Queue<Vertex> queue = new LinkedList<>();
        
        // step 1: add all the vertex with inDegree = 0
        for (Vertex vertex : graph.keySet()) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        
        // step 2: BFS to traverse the all the node
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            count++;
            if (graph.containsKey(cur)) {
                List<Vertex> nexts = graph.get(cur);
                for (Vertex next: nexts) {
                    next.inDegree--;
                    if (next.inDegree == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numberOfVertices;
    }
    
     /*
    find the number of vertex in graph as NumberOfVertices
    build graph, key: cur, value: List of following vertex
    
    BFS traverse all the vertex whose inDegree = 0 and record the vertex order as path
    
    check whether exists vertex whose inDegree ≠ 0
    if exist vertex inDegree ≠ 0, there may be some cycles
    if not exist vertex inDegree ≠ 0, there is no cycle
     */
    
    public List<Vertex> containsCycleAndBuildPath(Map<Vertex, List<Vertex>> graph) {
        // corner case
        if (graph == null) {
            return null;
        }
        
        // general case
        int numberOfVertices = graph.keySet().size();
        int count = 0;
        Queue<Vertex> queue = new LinkedList<>();
        
        // step 1: add all the vertex with inDegree = 0
        for (Vertex vertex : graph.keySet()) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        
        // step 2: BFS to traverse the all the node and record path
        List<Vertex> res = new ArrayList<>(); // change between previous method and this one
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            res.add(cur); // change between previous method and this one
            count++;
            if (graph.containsKey(cur)) {
                List<Vertex> nexts = graph.get(cur);
                for (Vertex next: nexts) {
                    next.inDegree--;
                    if (next.inDegree == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numberOfVertices ? res : null; // change between previous method and this one
    }

}