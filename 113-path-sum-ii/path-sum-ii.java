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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        pathWithSum(root, targetSum, 0, l, ans);
        return ans;
    }

    public void pathWithSum(TreeNode root, int targetSum, int val, List<Integer> l, List<List<Integer>> ans) {
        if(root == null) return;

        val = val + root.val;
        l.add(root.val);

        if(root.left == null && root.right == null) {
            if(targetSum == val) {
                ans.add(new ArrayList<>(l));
            }
            l.remove(l.size() - 1);
            return;
        }

        pathWithSum(root.left, targetSum, val, l, ans);
        pathWithSum(root.right, targetSum, val, l, ans);

        l.remove(l.size() - 1);
    }
}