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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return calculateSum(root, 0);

    }

    public int calculateSum(TreeNode root, int val) {
        if(root == null) return 0;
        val = val * (int) Math.pow(10, noOfDigits(root.val)) + root.val;
        if(root.left == null && root.right == null) return val;
        return calculateSum(root.left, val) + calculateSum(root.right, val);
    }

    public int noOfDigits(int val) {
        if(val == 0) return 1;
        int c = 0;
        while(val != 0) {
            c++;
            val /= 10;
        }

        return c;
    }
}