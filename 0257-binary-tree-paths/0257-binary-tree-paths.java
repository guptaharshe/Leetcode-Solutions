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
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Build current path
        if (path.isEmpty()) {
            path = "" + node.val;
        } else {
            path += "->" + node.val;
        }

        // If it's a leaf, add to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Recur for left and right subtrees
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}
