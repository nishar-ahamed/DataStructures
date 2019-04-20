package com.datastructures.tree.splaytree;

public class SplayTree<T extends Comparable<T>> {
    private int size;
    private Node<T> rootNode;

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return this.rootNode == null;
    }

    public void insert(T data) {
        Node<T> tempNode = this.rootNode;
        Node<T> parentNode = null;
        while (tempNode != null) {
            parentNode = tempNode;
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightNode();
            } else {
                tempNode = tempNode.getLeftNode();
            }
        }
        tempNode = new Node<T>(data);
        tempNode.setParentNode(parentNode);

        if (parentNode == null) {
            this.rootNode = tempNode;
        } else if (parentNode.getData().compareTo(tempNode.getData()) < 0) {
            parentNode.setRightNode(tempNode);
        } else {
            parentNode.setLeftNode(tempNode);
        }
        splay(tempNode);
        this.size++;
    }

    public Node<T> find(T data) {
        Node<T> tempNode = this.rootNode;

        while (tempNode != null) {
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightNode();
            } else if (tempNode.getData().compareTo(data) > 0) {
                tempNode = tempNode.getLeftNode();
            } else {
                splay(tempNode);
                return tempNode;
            }
        }
        splay(tempNode);
        return null;
    }

    public void delete(T data) {
        Node<T> node = find(data);
        delete(node);
    }

    private void delete(Node<T> node) {
        if (node == null) {
            return;
        }
        splay(node);
        if ((node.getLeftNode() != null) && (node.getRightNode() != null)) {
            Node<T> min = node.getLeftNode();
            while (min.getRightNode() != null) {
                min = min.getRightNode();
            }

            min.setRightNode(node.getRightNode());
            node.getRightNode().setParentNode(min);
            node.getLeftNode().setParentNode(null);
            rootNode = node.getLeftNode();
        } else if (node.getRightNode() != null) {
            node.getRightNode().setParentNode(null);
            rootNode = node.getRightNode();
        } else if (node.getLeftNode() != null) {
            node.getLeftNode().setParentNode(null);
            rootNode = node.getLeftNode();
        } else {
            rootNode = null;
        }
        this.size--;
    }

    private void splay(Node<T> node) {
        if (node == null) return;
        while (node.getParentNode() != null) {
            //Zig Situation
            if (node.getParentNode().getParentNode() == null) {
                if (node.getParentNode().getLeftNode() == node) { // node is left child and grandparent is null
                    rightRotate(node.getParentNode());
                } else {    // node is right child and grandparent is null
                    leftRotate(node.getParentNode());
                }
                //Zig-Zig Situation
            } else if (node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) {//parent node is left child and child node is left child
                rightRotate(node.getParentNode().getParentNode());
                rightRotate(node.getParentNode());
            } else if (node.getParentNode().getRightNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {//parent node is right child and child node is right child
                leftRotate(node.getParentNode().getParentNode());
                leftRotate(node.getParentNode());
                //Zig-Zag Situation
            } else if (node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {//parent node is right child and child node in left child
                rightRotate(node.getParentNode());
                leftRotate(node.getParentNode());
            } else {//parent node is left child and child node in right child
                leftRotate(node.getParentNode());
                rightRotate(node.getParentNode());
            }
        }
    }

    private void rightRotate(Node<T> node) {
        System.out.println("Rotating right on Node: " + node);

        Node<T> tempLeftNode = node.getLeftNode();
        node.setLeftNode(tempLeftNode.getRightNode());

        if (node.getLeftNode() != null) {
            node.getLeftNode().setParentNode(node);
        }
        tempLeftNode.setParentNode(node.getParentNode());

        if (tempLeftNode.getParentNode() == null) {
            rootNode = tempLeftNode;
        } else if (node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempLeftNode);
        } else {
            node.getParentNode().setRightNode(tempLeftNode);
        }

        tempLeftNode.setRightNode(node);
        node.setParentNode(tempLeftNode);
    }

    private void leftRotate(Node<T> node) {
        System.out.println("Rotating left on Node: " + node);

        Node<T> tempRightNode = node.getRightNode();
        node.setRightNode(tempRightNode.getLeftNode());

        if (node.getRightNode() != null) {
            node.getRightNode().setParentNode(node);
        }
        tempRightNode.setParentNode(node.getParentNode());

        if (tempRightNode.getParentNode() == null) {
            rootNode = tempRightNode;
        } else if (node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempRightNode);
        } else {
            node.getParentNode().setRightNode(tempRightNode);
        }

        tempRightNode.setLeftNode(node);
        node.setParentNode(tempRightNode);
    }

    public T getMin() {
        if (!isEmpty())
            return getMin(rootNode);
        return null;
    }

    private T getMin(Node<T> node) {
        if (node.getLeftNode() != null)
            return getMin(node.getLeftNode());
        return node.getData();
    }

    public T getMax() {
        if (!isEmpty())
            return getMax(rootNode);
        return null;
    }

    private T getMax(Node<T> node) {
        if (node.getRightNode() != null)
            return getMin(node.getRightNode());
        return node.getData();
    }

    public void inOrderTraversal() {
        if (rootNode == null)
            return;

        inOrderTraversal(rootNode);
    }

    private void inOrderTraversal(Node node) {
        if (node.getLeftNode() != null)
            inOrderTraversal(node.getLeftNode());

        System.out.println(node);

        if (node.getRightNode() != null)
            inOrderTraversal(node.getRightNode());
    }

    public void printRoot() {
        System.out.println(this.rootNode);
    }

    public static void main(String[] args) {
        SplayTree<Integer> splayTree = new SplayTree<>();
        splayTree.insert(10);
        splayTree.insert(-5);
        splayTree.insert(0);
        splayTree.insert(20);
        splayTree.insert(30);

        splayTree.printRoot();

        splayTree.delete(30);

        splayTree.printRoot();

        System.out.println(splayTree.find(-5));
        System.out.println("Traverse : ");
        splayTree.inOrderTraversal();

    }
}
