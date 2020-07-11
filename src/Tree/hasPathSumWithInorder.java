/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) return false;
        Stack<Pair<TreeNode, Integer>> s = new Stack();
        //cur指针用来将节点入栈
        TreeNode cur = root;

        while(!s.isEmpty() || cur != null) {
            while(cur != null) {
                sum = sum - cur.val;
                
                s.push(new Pair(cur, sum));
                cur = cur.left;
            }
            Pair<TreeNode, Integer> pair  = s.pop();

            TreeNode node = pair.getKey();
            sum = pair.getValue();
            
            if(node.left == null && node.right == null && sum == 0) return true;

            if(node.right != null) 
                cur = node.right;
        }
        return false;
        
    }
}