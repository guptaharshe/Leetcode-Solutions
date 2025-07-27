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
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(isSame(root,subRoot)){
                return true;
            }
        }
        boolean leftans=isSubtree(root.left,subRoot);
        boolean rightans=isSubtree(root.right,subRoot);
        return leftans || rightans;
        
    }

    public boolean isSame(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null ||  n1.val!=n2.val){
            return false;
        }
        return isSame(n1.left,n2.left) && isSame(n1.right,n2.right);
    }
}