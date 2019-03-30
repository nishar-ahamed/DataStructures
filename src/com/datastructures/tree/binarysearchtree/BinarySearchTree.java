package com.datastructures.tree.binarysearchtree;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traverPreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public void traverseLevelOrder() {
        int height = height();
        for (int i = 1; i <= height; i++) {
            printLevel(root,i);
            System.out.println();
        }
    }

    private void printLevel(TreeNode node, int level){
        if (node == null){
            return;
        }
        if (level == 1) {
            System.out.print(node.getData()+" ");
        }else if (level > 1) {
            printLevel(node.getLeftNode(),level-1);
            printLevel(node.getRightNode(),level-1);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeNode, int value) {
        if (subtreeNode == null) {
            return subtreeNode;
        }
        if (value < subtreeNode.getData()) {
            subtreeNode.setLeftNode(delete(subtreeNode.getLeftNode(), value));
        } else if (value > subtreeNode.getData()) {
            subtreeNode.setRightNode(delete(subtreeNode.getRightNode(), value));
        } else {
            // if node tobe deleted have 0 or 1 child
            if (subtreeNode.getLeftNode() == null) {
                return subtreeNode.getRightNode();
            } else if (subtreeNode.getRightNode() == null) {
                return subtreeNode.getLeftNode();
            }

            //if node tobe deleted have 2 child

            //Replace the value of node tobe deleted with smallest value from right subtree
            subtreeNode.setData(subtreeNode.getRightNode().min());
            //delete the smallest value from right subtree
            subtreeNode.setRightNode(delete(subtreeNode.getRightNode(), subtreeNode.getData()));
        }
        return subtreeNode;
    }

    public int min() {
        if (root != null) {
            return root.min();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int max() {
        if (root != null) {
            return root.max();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.getLeftNode());
        int rightHeight = height(node.getRightNode());
        if (leftHeight > rightHeight) {
            return (leftHeight + 1);
        } else {
            return (rightHeight + 1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(27);
        bst.insert(15);
        bst.insert(22);
        bst.insert(26);
        bst.insert(30);
        bst.insert(17);
        bst.insert(29);
        bst.insert(32);
        //bst.traverseInOrder();
        System.out.println();
        System.out.println(bst.get(22));
        System.out.println(bst.get(44));
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());
        //bst.delete(15);
        //bst.delete(25);
        bst.traverseInOrder();
        System.out.println();
        bst.traversePreOrder();
        System.out.println();
        bst.traversePostOrder();
        System.out.println();
        System.out.println("height: "+bst.height());
        System.out.println();
        bst.traverseLevelOrder();
    }
}
