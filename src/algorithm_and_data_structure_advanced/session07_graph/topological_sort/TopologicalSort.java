package algorithm_and_data_structure_advanced.session07_graph.topological_sort;//Project: techbow

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Package: algorithm_and_data_structure_advanced.session07Graph.topological_sort
//ClassName: TopologicalSort
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-17 星期二 16:09
public class TopologicalSort {
    
    public List<Node> containsCycle(HashMap<Node, List<Node>> graph) {
        // corner case
        if (graph == null) {
            return null;
        }
        
        // general case
        LinkedList<Node> res = new LinkedList<>();
        for (Node start : graph.keySet()) {
            if (dfs(start, graph, res)) {
                throw new RuntimeException("graph has cycle");
            }
        }
        return res;
    }
    
    /** return true if finding a cycle from Vertex cur */
    private boolean dfs(Node cur, Map<Node, List<Node>> graph, LinkedList<Node> res) {
        if (cur.status == Status.VISITED) { // pruning
            return false;
        }
        
        if (cur.status == Status.VISITING) { // cycle
            return true;
        }
        
        cur.status = Status.VISITING;
        // res.add(cur); // part 1
        for (Node next : graph.get(cur)) {
            if (dfs(next, graph, res)) {
                return true;
            }
        }
        cur.status = Status.VISITED;
        res.addFirst(cur);// part 2
        /*
        必须用part2，不能用part1
        因为是一个图，所有的，比如C依赖于A和B，
        part2可以实现，所有A和B都必须在C之前加入
        part1不能，只能实现A或者B有一个在C之前，剩下的不能保证放在C之前
         */
        return false;
    }
    
}