package algorithm_and_data_structure_basic.session17_综合演练2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session17
//ClassName: FindFirstNonRepeatingCharacter
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-04-29 星期四 11:26
public class FindFirstNonRepeatingWord {
    
    /*
    key is Character, Node is corresponding Node
    case 1: <Word, Node> -- unique word and its Node
    case 2: <Word, Null> -- word that appeared more than once
    case 3: wordToNode does not contain the word, means this word never appeared previously
     */
    Map<String, Node> wordToNode;
    DoubleLinkedList list;
    
    public List<String> inputStreamOfWord(List<String> words) { // 假装这个List<String> words是stream
        if (words.size() == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        wordToNode = new HashMap<>();
        list = new DoubleLinkedList();
        for (String word : words) {
            String noRepeat = addOneWordAndFindFirstNonRepeatingWord(word);
            res.add(noRepeat);
        }
        return res;
    }
    
    // T(n) = O(1)
    private String addOneWordAndFindFirstNonRepeatingWord(String word) {
        if (!wordToNode.containsKey(word)) { // not contains
            Node cur = new Node(word);
            wordToNode.put(word, cur);
            list.addTail(cur);
        } else if (wordToNode.get(word).word != null) { // contains and not repeat
            list.remove(wordToNode.get(word));
            wordToNode.put(word, new Node(null)); // put value to null表示这个值是重复的
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
    
    private static class DoubleLinkedList {
        
        Node head;
        Node tail;
        int size;
        
        public DoubleLinkedList() {
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