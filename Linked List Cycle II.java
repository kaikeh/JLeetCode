/**
 *Question
 *Given a linked list, return the node where the cycle begins.
 *If there is no cycle, return null.
 *Follow up:
 *Can you solve it without using extra space?
**/

//Solution
//Tip:Tow Pionters
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
    public ListNode detectCycle(ListNode head) {
        ListNode p,q,r;
        int len1, len2, len3;
        p = head;
        q = head;
        r = head;
        len1 = len2 = len3 = 0;
        
        //detect if there is a cycle
        while(p != null && q != null) {
            p = p.next;
            q = q.next;
            if(q != null)
                q = q.next;
            if(p!=null && q!=null && p==q)
                break;
        }
        if(p==null || q==null)
            return null;
        q = p.next;
        while(q != p) {
            q = q.next;
            len1++;
        }
        q = p.next;
        while(r != p) {
            r = r.next;
            len2++;
        }
        r = head;
        if(len1 >= len2) {
            len3 = len1 - len2;
            while(len3 != 0) {
                q = q.next;
                len3--;
            }
        }
        else {
            len3 = len2 - len1;
            while(len3 != 0) {
                r = r.next;
                len3--;
            }
        }
        while(r != q) {
            r = r.next;
            q = q.next;
        }
        return r;
    }
}
