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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        paths(root, ans, l);

        return ans;
    }

    public void paths(TreeNode root, ArrayList<String> ans, ArrayList<Integer> l) {
        if(root == null) {
            return;
        }

        l.add((root.val));

        if(root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer("");
            for(var i : l) {
                sb.append(i + "->");
            }
            ans.add(sb.toString().substring(0, sb.length() - 2));
            l.remove(l.size() - 1);
            return;
        }

        paths(root.left, ans, l);
        paths(root.right, ans, l);

        l.remove(l.size() - 1);
    }
}