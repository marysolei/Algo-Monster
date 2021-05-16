/*Given a binary tree, return its level order traversal. 
Input is the root node of the tree. The output should be a list of lists of integers,
 with the ith list containing the values of nodes on level i, from left to right.
*/


import java.util.*;

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

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            //make a queue for bfs    
            Queue<Node<Integer>> q = new ArrayDeque<>();
            q.add(root);
            //check if q has elements
            while(!q.isEmpty()) {
                List<Integer> path = new ArrayList<>();
                int size = q.size();
                for (int i=0; i< size; i++) {
                    
                    Node<Integer> currentNode = q.poll();
                    path.add(currentNode.val);
                    if (currentNode.left != null) q.add(currentNode.left);
                    if (currentNode.right != null) q.add(currentNode.right);
                }
                result.add(path);
                
            }
        return result;
        
        }
    

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<List<Integer>> res = levelOrderTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

