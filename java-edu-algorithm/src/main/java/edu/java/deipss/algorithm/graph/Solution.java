package edu.java.deipss.algorithm.graph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(null == node){
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node newNode = new Node(node.val,new ArrayList<>());
        Map<Node,Node> map= new HashMap<>();
        map.put(node,newNode);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            for (Node neighbor : poll.neighbors) {
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(poll).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}