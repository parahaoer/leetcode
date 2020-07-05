/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
    栈用来存储树中的节点。
    入栈是存储节点，出栈是遍历节点
 */
 
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack();
        stack.push(new Pair(root, sum - root.val));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int remain = pair.getValue();
            if(node.left == null && node.right == null && remain == 0) return true;

            if(node.right != null) {
                
                stack.push(new Pair<TreeNode, Integer>(node.right, remain - node.right.val));

            }

            if(node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, remain - node.left.val));
            }
        }

        return false;
    }
}
