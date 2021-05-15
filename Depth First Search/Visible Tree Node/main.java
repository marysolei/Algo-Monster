/* In a binary tree, a node is considered "visible" if no node on the root-to-itself path has a greater value. The root is always "visible" since there are no other nodes between the root and itself. Given a binary tree, count the number of "visible" nodes.
*/

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

    public static int visibleTreeNode(Node<Integer> root) {
       
       //check edge cases 
        if (root == null) return 0;
        return helper(root, Integer.MIN_VALUE);
    }
    
    public static int helper( Node<Integer> root, int maxSoFar) {
         
        if (root == null) return 0;
        int cnt =0; 
        if (root.val >= maxSoFar) cnt++;
        cnt += helper(root.left, Math.max(root.val, maxSoFar));
        cnt += helper(root.right, Math.max(root.val, maxSoFar));
        return cnt;
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
        int res = visibleTreeNode(root);
        System.out.println(res);
    }
}
