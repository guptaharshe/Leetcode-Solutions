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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    // Validate subtree rooted at 'node' with range (min, max)
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        
        // If node violates the min/max constraints, return false
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        
        // Recursively check left subtree and right subtree with updated ranges
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
