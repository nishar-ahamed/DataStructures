package com.datastructures.graph;

import java.util.LinkedList;

public class Graph1 {
    LinkedList<String>[] adjListArray;
    boolean undirected = true;
    int vertextCount;

    public Graph1(int size, String graphType) {
        adjListArray = new LinkedList[size];
        if (graphType.equals("directed")) {
            undirected = false;
        }
    }

    public void addVertex(String name) {
        adjListArray[vertextCount] = new LinkedList<>();
        adjListArray[vertextCount].add(name);
        vertextCount++;
    }

    public void addEdge(String src, String dest) {
        int srcIndex = indexFor(src);
        int destIndex = indexFor(dest);
        adjListArray[srcIndex].add(adjListArray[destIndex].getFirst());
        if (undirected) {
            adjListArray[destIndex].add(adjListArray[srcIndex].getFirst());
        }
    }

    private int indexFor(String name) {
        for (int i = 0; i < adjListArray.length; i++) {
            if (adjListArray[i].getFirst().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < adjListArray.length; i++) {
            System.out.print(adjListArray[i].getFirst());
            for (int j = 1; j < adjListArray[i].size(); j++) {
                System.out.print(" -> " + adjListArray[i].get(j));
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Graph1 graph1 = new Graph1(5, "directed");
        graph1.addVertex("State");
        graph1.addVertex("Avenel");
        graph1.addVertex("Elm");
        graph1.addVertex("Pocono");
        graph1.addVertex("William");

        graph1.addEdge("Avenel", "Pocono");
        graph1.addEdge("State", "Elm");
        graph1.addEdge("Elm", "Avenel");
        graph1.addEdge("Elm", "William");
        graph1.addEdge("William", "State");
        graph1.addEdge("William", "Pocono");
        graph1.addEdge("Pocono", "Elm");
        graph1.addEdge("State", "Avenel");

        graph1.print();
    }

}
