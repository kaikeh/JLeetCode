/**
 *Question
 *Given a linked list, determine if it has a cycle in it.
 *Follow up:
 *Can you solve it without using extra space?
**/

//Solution
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p,q;
        p = head;
        q = head;
        while(p != null && q != null) {
            p = p.next;
            q = q.next;
            if(q != null)
                q = q.next;
            if(p!=null && q!=null && p==q)
                return true;
        }
        return false;
    }
}
