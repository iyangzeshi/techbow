package algorithm_and_data_structure_basic.session17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session17
//ClassName: FindFirstNonRepeatingCharacter
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-04-29 星期四 11:26
public class FindFirstNonRepeatingCharacter {
    
    /*
    key is Character, Node is corresponding Node
    if Node just appeared once
     */
    Map<String, Node> wordToNode;
    DoubleList list;
    
    public String firstNonRepeatingWord(List<String> words) {
        if (words.size() == 0) {
            return null;
        }
        
        wordToNode = new HashMap<>();
        list = new DoubleList();
    
        for (String word : words) {
            if (!wordToNode.containsKey(word)) {
                Node cur = new Node(word);
                wordToNode.put(word, cur);
                list.addTail(cur);
            } else if (wordToNode.get(word).word != null) {
                list.remove(wordToNode.get(word));
                wordToNode.put(word, new Node(null)); // put value to null表示这个值是重复的
            }
        }
        return list.head.next.word;
    }
    
    private static class Node {
        
        String word;
        Node prev;
        Node next;
        
        public Node() {
        }
        
        
        public Node(String word) {
            this.word = word;
        }
        
    }
    
    private static class DoubleList {
        
        Node head;
        Node tail;
        int size;
        
        public DoubleList() {
            head = new Node("-1");
            tail = new Node("-1");
            head.next = tail;
            tail.prev = head;
        }
        
        private void addTail(Node node) {
            if (tail == null) { // 你上面就没有用到add(null)的地方
                return;
            }
            node.next = tail;
            node.prev = tail.prev;
            node.prev.next = node;
            tail.prev = node;
            size++;
        }
        
        private void remove(Node node) {
            if (node == null) {
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            size--;
        }
        
    }
}