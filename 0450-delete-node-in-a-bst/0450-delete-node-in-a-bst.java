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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;                 // ✅ important null guard

        if (key < root.val) {                          // (key < root.val) is clearer
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // node to delete found
            if (root.left == null) return root.right;  // covers 0 or 1 child
            if (root.right == null) return root.left;

            // 2 children: replace with inorder successor
            TreeNode succ = min(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }

    private TreeNode min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
