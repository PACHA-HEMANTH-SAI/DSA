/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return preorder(root, subRoot);
    }

    public boolean preorder(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isIdentical(root, subRoot)) return true;
        if(preorder(root.left, subRoot)) return true;
        if(preorder(root.right, subRoot)) return true;

        return false;
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) return root == subRoot;

        return (root.val == subRoot.val) && (isIdentical(root.left, subRoot.left)) && (isIdentical(root.right, subRoot.right)); 
    }
}