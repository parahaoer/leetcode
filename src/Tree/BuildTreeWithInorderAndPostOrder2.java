/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BuildTreeWithInorderAndPostOrder2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildTree(inorder, 0, len, postorder, 0, len);

    }

    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart >= inend || poststart >= postend) {
            return null;
        }

        int rootval = postorder[postend - 1];
        int index = 0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);
        root.left = buildTree(inorder, instart, index, postorder, poststart, poststart + index - instart);
        // 不好解释
        root.right = buildTree(inorder, index + 1, inend, postorder, poststart + index - instart, postend-1);
        return root;

    }

    public static void main(String[] args) {
       int[] inorder = {9,3,15,20,7};
       int[] postorder = {9,15,7,20,3};
       BuildTreeWithInorderAndPostOrder2 buildTreeWithInorderAndPostOrder2 = new BuildTreeWithInorderAndPostOrder2();
       buildTreeWithInorderAndPostOrder2.buildTree(inorder, postorder);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}