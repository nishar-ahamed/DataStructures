package com.datastructures.tree.binarysearchtree;

public class TreeNode {
    private TreeNode leftNode;
    private TreeNode rightNode;
    int data;

    public TreeNode(int data) {
        this.leftNode = null;
        this.rightNode = null;
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(value);
            } else {
                leftNode.insert(value);
            }
        } else {
            if (rightNode == null) {
                rightNode = new TreeNode(value);
            } else {
                rightNode.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftNode != null) {
            leftNode.traverseInOrder();
        }
        System.out.print(data + " ");
        if (rightNode != null) {
            rightNode.traverseInOrder();
        }
    }

    public void traverPreOrder() {
        System.out.print(data + " ");
        if (leftNode != null) {
            leftNode.traverPreOrder();
        }
        if (rightNode != null) {
            rightNode.traverPreOrder();
        }
    }

    public void traversePostOrder() {
        if (leftNode != null) {
            leftNode.traversePostOrder();
        }
        if (rightNode != null) {
            rightNode.traversePostOrder();
        }
        System.out.print(data + " ");
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftNode != null) {
                return leftNode.get(value);
            }
        } else {
            if (rightNode != null) {
                return rightNode.get(value);
            }
        }
        return null;
    }

    public int min() {
        if (leftNode == null) {
            return data;
        } else {
            return leftNode.min();
        }
    }

    public int max() {
        if (rightNode == null) {
            return data;
        } else {
            return rightNode.max();
        }
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
