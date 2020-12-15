package algorithm_and_data_structure_advanced.session01_BFS.template.最短路径;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session01BFS.template.最短路径
//ClassName: BFSTemplate
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 20:47
public class BFSTemplate<Type> {
    public void bfs(Type root) {
        Set<Type> visited = new HashSet<>();
        Queue<Type> queue = new LinkedList<>(); // buffer
        queue.offer(root);
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Type cur = queue.poll();
                Type next = convert(cur);
                if (visited.contains(next)) {
                // if (condition -> visited) {
                    queue.offer(next);
                }
            }
            minLen++;
        }
    }

    private Type convert(Type cur) {
        return null;
    }

}
