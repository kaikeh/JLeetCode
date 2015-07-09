/**
 *Question
 *Given a linked list, remove the nth node from the end of list and return its head.
 *For example,
 *Given linked list: 1->2->3->4->5, and n = 2.
 *After removing the second node from the end, the linked list becomes 1->2->3->5.
 *Note:
 *Given n will always be valid.
 *Try to do this in one pass.
**/

//Solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead, pBack;
        pHead = head;
        pBack = head;
        for(int i = 0; i<n; i++)
            pHead = pHead.next;
        if(pHead == null)
        	return pBack.next;
        while(pHead.next != null) {
        	pBack = pBack.next;
        	pHead = pHead.next;
        }
        if(pBack == pHead)
        	return pBack.next;
        else
        	pBack.next = pBack.next.next;
        return head;
    }
}
