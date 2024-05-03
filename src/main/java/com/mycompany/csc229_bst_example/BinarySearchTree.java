package com.mycompany.csc229_bst_example;
/*
 *
 * @author SabilMann
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root != null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }


    public Integer findHeight() {
        return findHeight(this.root);
    }

    private int findHeight(BstNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(findHeight(root.getLeft()), findHeight(root.getRight()));
        }
    }


    public int getDepth(BstNode node) {
        return getDepth(node, root, 0);
    }

    private int getDepth(BstNode node, BstNode current, int depth) {
        if (current == null) {
            return -1;
        }
        if (current == node) {
            return depth;
        }
        int left = getDepth(node, current.getLeft(), depth + 1);
        if (left != -1) {
            return left;
        }
        return getDepth(node, current.getRight(), depth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", this.root, false);
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData());
            // Recursively call to go deeper in the tree
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }

}
