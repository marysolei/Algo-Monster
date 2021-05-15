/*Max depth of a binary tree is the longest root-to-leaf path. Given a binary tree, find its max depth.*/

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

class Solution {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int treeMaxDepth(Node<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(treeMaxDepth(root.left)+1, treeMaxDepth(root.right)+1);
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
        scanner.close();
        int res = treeMaxDepth(root);
        System.out.println(res);
    }
}
