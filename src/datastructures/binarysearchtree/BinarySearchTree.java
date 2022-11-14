package datastructures.binarysearchtree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return results;
    }

    public ArrayList<Integer> preOrderDFS() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node node) {
                results.add(node.value);
                if (node.left != null) {
                    new Traverse(node.left);
                }
                if (node.right != null) {
                    new Traverse(node.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> postOrderDFS() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node node) {
                if (node.left != null) {
                    new Traverse(node.left);
                }
                if (node.right != null) {
                    new Traverse(node.right);
                }
                results.add(node.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public void printAll() {
        printSubTree(root);
    }

    private void printSubTree(Node parent) {
        if (parent == null) {
            System.out.println("-");
            return;
        }
        printNode(parent);
        printSubTree(parent.left);
        printSubTree(parent.right);
    }

    private void printNode(Node node) {
        Integer leftValue;
        if (node.left == null) {
            leftValue = null;
        } else {
            leftValue = node.left.value;
        }
        Integer rightValue;
        if (node.right == null) {
            rightValue = null;
        } else {
            rightValue = node.right.value;
        }
        System.out.println(node.value + "(l=" + leftValue + ",r=" + rightValue + ")");
    }

    public void insert(int value) {
        //boolean result = insertToSubTreeWithRecursion(root, new Node(value));
        boolean result = insertSimple(value);
        System.out.println("insert " + value + " " + result);
    }

    private boolean insertSimple(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    private boolean insertToSubTreeWithRecursion(Node parent, Node newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }
        if (newNode.value == parent.value) return false;
        if (newNode.value < parent.value) {
            if (parent.left == null) {
                parent.left = newNode;
                return true;
            } else {
                return insertToSubTreeWithRecursion(parent.left, newNode);
            }
        } else {
            if (parent.right == null) {
                parent.right = newNode;
                return true;
            } else {
                return insertToSubTreeWithRecursion(parent.right, newNode);
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value == temp.value) return true;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}