package datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    private HashMap<String, HashSet<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) return false;

        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
}
