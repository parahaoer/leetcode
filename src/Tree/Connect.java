/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            Node temp = null;

            /**
                for循环中会添加左右节点到 队列，所以当遍历完for循环（一层节点），队列不会空。
             */

            for(int i=0; i<size; i++) {
                temp = q.poll();
                temp.next = q.peek();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            temp.next = null;
        }
        return root;
    }
}