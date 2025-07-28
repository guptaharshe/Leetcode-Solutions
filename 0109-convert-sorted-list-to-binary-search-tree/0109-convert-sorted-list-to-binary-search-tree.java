/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        // Step 1: Find middle using slow & fast
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;          // node before middle
            slow = slow.next;     // middle
            fast = fast.next.next;
        }

        // Cut the list at prev to form left sublist
        if (prev != null) prev.next = null;

        // Step 2: Make middle node the root
        TreeNode root = new TreeNode(slow.val);

        // Step 3: Recursively build left and right subtrees
        root.left = sortedListToBST(head == slow ? null : head);  // left half
        root.right = sortedListToBST(slow.next);                  // right half

        return root;
    }
}
