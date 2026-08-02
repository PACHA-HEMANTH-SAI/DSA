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
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return ans;
    }

    public int lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return 0;

        int self = 0;

        if(root.val == p.val || root.val == q.val) {
            self = 1;
        }

        int l = lca(root.left, p, q);
        int r = lca(root.right, p, q);

        if((l + r + self) == 2 && ans == null) ans = root;

        return (self + l + r);
    }
}