package com.datastructures.tree.redblacktree;

public class RedBlackTree {

    private Node root;

    public void insert(int data) {
        Node node = new Node(data);
        root = insert(root, node);
        balanceAfterInsertion(node);
    }

    private Node insert(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.getData() < root.getData()) {
            root.setLeftNode(insert(root.getLeftNode(), node));
            root.getLeftNode().setParent(root);
        } else if (node.getData() > root.getData()) {
            root.setRightNode(insert(root.getLeftNode(), node));
            root.getRightNode().setParent(root);
        }
        return root;
    }

    private void balanceAfterInsertion(Node node) {
    }

    private void rightRotate(Node node) {
        System.out.println("Rotating right on Node: " + node);

        Node tempLeftNode = node.getLeftNode();
        node.setLeftNode(tempLeftNode.getRightNode());

        if (node.getLeftNode() != null) {
            node.getLeftNode().setParent(node);
        }
        tempLeftNode.setParent(node.getParent());

        if (tempLeftNode.getParent() == null) {
            root = tempLeftNode;
        } else if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(tempLeftNode);
        } else {
            node.getParent().setRightNode(tempLeftNode);
        }

        tempLeftNode.setRightNode(node);
        node.setParent(tempLeftNode);
    }

    private void leftRotate(Node node) {
        System.out.println("Rotating left on Node: " + node);

        Node tempRightNode = node.getRightNode();
        node.setRightNode(tempRightNode.getLeftNode());

        if (node.getRightNode() != null) {
            node.getRightNode().setParent(node);
        }
        tempRightNode.setParent(node.getParent());

        if (tempRightNode.getParent() == null) {
            root = tempRightNode;
        } else if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(tempRightNode);
        } else {
            node.getParent().setRightNode(tempRightNode);
        }

        tempRightNode.setLeftNode(node);
        node.setParent(tempRightNode);
    }

    public void traverse() {
        if (root == null)
            return;

        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node.getLeftNode() != null)
            inOrderTraversal(node.getLeftNode());

        System.out.println(node);

        if (node.getRightNode() != null)
            inOrderTraversal(node.getRightNode());
    }

    public static void main(String[] args) {

    }
}
