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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = head;
        int count = 0;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        int[] arr = new int[count];

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        int ind = 0;
        while(prev != null) {
            if(stack.isEmpty()) {
                stack.push(prev.val);
            }else {
                while(!stack.isEmpty() && stack.peek() <= prev.val) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    arr[ind++] = 0;
                    stack.push(prev.val);
                }

                else {
                    arr[ind++] = stack.peek();
                    stack.push(prev.val);
                }
            }
            prev = prev.next;
        }

        int low = 0;
        int high = count - 2;

        while(low < high) {
            int t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
            low++;
            high--;
        }

        return arr;
    }
}