/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []

*/

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
class Solution {
    public ListNode reverseList(ListNode head) {
        //assign three Listnodes prev, current, temp
        ListNode temp = head;
        ListNode curr = null;
        ListNode prev = null;
        while (temp != null) {
            // these two nodes move two nodes backwards
            prev = curr;
            curr = temp;
            
            temp = curr.next;
            curr.next = prev;
        }
        return curr;
    }
}
