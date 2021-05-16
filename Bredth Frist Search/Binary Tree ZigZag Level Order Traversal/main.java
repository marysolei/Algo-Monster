// Given a binary tree, return its level order traversal but alternate 
//left to right order


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

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        
        //expected result format
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //bfs throught the tree
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        int level =0;
        
        //go throught the queue
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            
            for (int i=0; i< size; i++){
                Node<Integer> curr = queue.poll();
                if (level %2 ==0) {
                    path.add(curr.val);
                }else {
                   path.add(0, curr.val);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right!= null) queue.add(curr.right);
            
            }
            level++;
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
        List<List<Integer>> res = zigZagTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

