package com.datastructures.graph;

public class Graph {
    class Node {
        public int vertexIdx;
        public Node next;

        public Node(int vertexIdx, Node node) {
            this.vertexIdx = vertexIdx;
            this.next = node;
        }
    }

    class Vertex {
        String name;
        Node adjList;

        Vertex(String name, Node aNode) {
            this.name = name;
            this.adjList = aNode;
        }
    }

    Vertex[] arrayOfLists;
    int indexCounter;
    boolean undirected = true;

    public Graph(int vCount, String graphType) {
        if (graphType.equals("directed")) {
            undirected = false;
        }
        arrayOfLists = new Vertex[vCount];
    }

    public void addVertex(String vertexName) {
        arrayOfLists[indexCounter] = new Vertex(vertexName, null);
        indexCounter++;
    }

    public void addEdge(String srcVertexName, String destVertexName) {
        int srcVertexIdx = indexForName(srcVertexName);
        int destVertexIdx = indexForName(destVertexName);
        arrayOfLists[srcVertexIdx].adjList = new Node(destVertexIdx, arrayOfLists[srcVertexIdx].adjList);
        if (undirected) {
            arrayOfLists[destVertexIdx].adjList = new Node(srcVertexIdx, arrayOfLists[destVertexIdx].adjList);
        }
    }

    private int indexForName(String name) {
        for (int i = 0; i < arrayOfLists.length; i++) {
            if (arrayOfLists[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < arrayOfLists.length; i++) {
            System.out.print(arrayOfLists[i].name);
            Node aNode = arrayOfLists[i].adjList;
            while (aNode != null) {
                System.out.print("--> " + arrayOfLists[aNode.vertexIdx].name);
                aNode = aNode.next;
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5, "undirected");
        graph.addVertex("State");
        graph.addVertex("Avenel");
        graph.addVertex("Elm");
        graph.addVertex("Pocono");
        graph.addVertex("William");

        graph.addEdge("Avenel", "Pocono");
        graph.addEdge("State", "Elm");
        graph.addEdge("Elm", "Avenel");
        graph.addEdge("Elm", "William");
        graph.addEdge("William", "State");
        graph.addEdge("William", "Pocono");
        graph.addEdge("Pocono", "Elm");
        graph.addEdge("State", "Avenel");

        graph.print();
    }
}
