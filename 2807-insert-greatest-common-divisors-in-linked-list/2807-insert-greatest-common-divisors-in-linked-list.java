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
   // Helper function to calculate the GCD of two integers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;

        // Traverse the list while there are at least two nodes to compare
        while (current != null && current.next != null) {
            // Calculate GCD of the current node and the next node
            int gcdValue = gcd(current.val, current.next.val);

            // Create a new node with the GCD value
            ListNode newNode = new ListNode(gcdValue);

            // Insert the new node between current and next
            newNode.next = current.next;
            current.next = newNode;

            // Move to the next pair (skip the newly inserted node)
            current = newNode.next;
        }

        // Return the modified linked list
        return head;
    }
}