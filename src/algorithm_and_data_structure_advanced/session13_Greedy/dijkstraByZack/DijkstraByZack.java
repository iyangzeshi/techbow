package algorithm_and_data_structure_advanced.session13_Greedy.dijkstraByZack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DijkstraByZack {
  public static void main(String[] args) {
    // create
    //
    // https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif
    MyGraphNodeDijkstra<Integer> node1 = new MyGraphNodeDijkstra<Integer>(1);
    MyGraphNodeDijkstra<Integer> node2 = new MyGraphNodeDijkstra<Integer>(2);
    MyGraphNodeDijkstra<Integer> node3 = new MyGraphNodeDijkstra<Integer>(3);
    MyGraphNodeDijkstra<Integer> node4 = new MyGraphNodeDijkstra<Integer>(4);
    MyGraphNodeDijkstra<Integer> node5 = new MyGraphNodeDijkstra<Integer>(5);
    MyGraphNodeDijkstra<Integer> node6 = new MyGraphNodeDijkstra<Integer>(6);
    node1.addNeighbor(node2, 7);
    node1.addNeighbor(node3, 9);
    node1.addNeighbor(node6, 14);
    node2.addNeighbor(node1, 7);
    node2.addNeighbor(node3, 10);
    node2.addNeighbor(node4, 15);
    node3.addNeighbor(node1, 9);
    node3.addNeighbor(node2, 10);
    node3.addNeighbor(node4, 11);
    node3.addNeighbor(node6, 2);
    node4.addNeighbor(node2, 15);
    node4.addNeighbor(node3, 11);
    node4.addNeighbor(node5, 6);
    node5.addNeighbor(node4, 6);
    node5.addNeighbor(node6, 9);
    node6.addNeighbor(node1, 14);
    node6.addNeighbor(node3, 2);
    node6.addNeighbor(node5, 9);
    // calculate
    Set<MyGraphNodeDijkstra<Integer>> result = dijistra(node1);
    // output
    for (MyGraphNodeDijkstra<Integer> r0 : result) {
      System.out.print("node 1 => node ");
      System.out.print(r0.value);
      System.out.print(":");
      for (MyGraphNodeDijkstra<Integer> r1 : r0.path) {
        System.out.print(" ");
        System.out.print(r1.value);
        System.out.print(" -");
      }
      System.out.print(" (");
      System.out.print(r0.distance);
      System.out.println(")");
    }
  }

  private static Set<MyGraphNodeDijkstra<Integer>> dijistra(MyGraphNodeDijkstra<Integer> node) {
    MyHeap<MyGraphNodeDijkstra<Integer>> heap = new MyHeap<>();
    MyGraphNodeDijkstra<Integer> cur = null;
    Set<MyGraphNodeDijkstra<Integer>> result = new HashSet<>();
    // BFS
    node.distance = 0;
    node.path = new LinkedList<>();
    node.path.add(node);
    heap.offer(node);
    while (!heap.isEmpty()) {
      cur = heap.poll();
      // iterate neighbor
      for (MyGraphNodeDijkstra<Integer> n : cur.neighborList.keySet()) {
        if (compareDouble(n.distance, Double.MAX_VALUE) == -1) {
          // Node has been visited, skip.
          continue;
        }
        double newDistance = cur.distance + cur.neighborList.get(n);
        if (compareDouble(newDistance, n.distance) == -1) {
          // update distance and path
          n.distance = newDistance;
          n.path = new LinkedList<>(cur.path);
          n.path.add(n);
        }
        // poll or update
        heap.update(n);
      }
      // add to result
      result.add(cur);
    }
    return result;
  }

  private static int compareDouble(double a, double b) {
    final double TOLERANCE = 0.000001;
    double delta = a - b;
    if (delta < -TOLERANCE) {
      return -1;
    }
    if (delta > TOLERANCE) {
      return 1;
    }
    return 0;
  }

  private static class MyGraphNodeDijkstra<V> implements Comparable<MyGraphNodeDijkstra<V>> {
    final static double DEFAULT_WEIGHT = 1.0;

    private V value;
    private Map<MyGraphNodeDijkstra<V>, Double> neighborList;
    private double distance;
    private List<MyGraphNodeDijkstra<V>> path;

    @Override
    public int compareTo(MyGraphNodeDijkstra<V> o) {
      return compareDouble(distance, o.distance);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (this == obj) {
        return true;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      MyGraphNodeDijkstra<V> o = (MyGraphNodeDijkstra<V>) obj;
      return value.equals(o.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    private MyGraphNodeDijkstra(V v) {
      value = v;
      neighborList = new HashMap<>();
      distance = Double.MAX_VALUE;
      path = null;
    }

    // @SuppressWarnings("unused");
    private void addNeighbor(MyGraphNodeDijkstra<V> node) {
      addNeighbor(node, DEFAULT_WEIGHT);
    }

    private void addNeighbor(MyGraphNodeDijkstra<V> node, double weight) {
      neighborList.put(node, weight);
    }
  }
}
