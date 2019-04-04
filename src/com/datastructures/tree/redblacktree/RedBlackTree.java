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
            root.setRightNode(insert(root.getRightNode(), node));
            root.getRightNode().setParent(root);
        }
        return root;
    }

    private void balanceAfterInsertion(Node node) {
        Node parentNode = null;
        Node grandParentNode = null;

        while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {
            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();
            if (parentNode == grandParentNode.getLeftNode()) {
                Node uncle = grandParentNode.getRightNode();
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {

                    if (node == parentNode.getRightNode()) {
                        leftRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    rightRotate(grandParentNode);
                    NodeColor temColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(temColor);
                    node = parentNode;
                }

            } else {
                Node uncle = grandParentNode.getLeftNode();
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    if (node == parentNode.getLeftNode()) {
                        rightRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    leftRotate(grandParentNode);
                    NodeColor temColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(temColor);
                    node = parentNode;
                }
            }
        }
        if (root.getColor() == NodeColor.RED) {
            root.setColor(NodeColor.BLACK);
        }
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
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(15);
        rbt.insert(13);
    }
}
