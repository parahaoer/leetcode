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
    /**
        对于左子树，中序遍历和后序遍历的起点位置不相关。后序遍历的终点位置根据左子树的长度推算出，跟中序遍历的终点位置没有直接关系
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length ==0 || postorder.length == 0) return null;
        
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        
        if(inend < instart || postend < poststart) return null;
        int rootval = postorder[postend];
        int rootid = getId(inorder, rootval);

        TreeNode root = new TreeNode(rootval);

        TreeNode left = buildTree(inorder, postorder, instart, rootid-1, poststart, poststart-instart + rootid-1);
        TreeNode right = buildTree(inorder, postorder, rootid+1, inend, poststart-instart + rootid,postend-1);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public int getId(int[] nums, int target) {
                
        for(int i=0; i<nums.length; i++) {
                        
            if(nums[i] == target) {
                
                return i;  
            } 
        }
        return -1;
    }
}
