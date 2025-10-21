/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (!head || k == 1) return head;

        // Dummy node for easier head handling
        ListNode dummy(0);
        dummy.next = head;
        ListNode* prevGroupEnd = &dummy;

        // Count total nodes
        int len = 0;
        ListNode* temp = head;
        while (temp) {
            len++;
            temp = temp->next;
        }

        // Reverse in groups of k
        while (len >= k) {
            ListNode* curr = prevGroupEnd->next;
            ListNode* nextNode = curr->next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr->next = nextNode->next;
                nextNode->next = prevGroupEnd->next;
                prevGroupEnd->next = nextNode;
                nextNode = curr->next;
            }

            prevGroupEnd = curr;
            len -= k;
        }

        return dummy.next;
    }
};
