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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-11, null);
        ListNode dummyHead = dummy;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (pair1,pair2) -> {
                return pair1.element - pair2.element;
            }
        );

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
            pq.add(new Pair(lists[i].val, lists[i]));
        }

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            dummy.next = new ListNode(pair.element,null);
            dummy = dummy.next;

            if((pair.node.next) != null) {
                pq.add(new Pair(pair.node.next.val,pair.node.next));
            }
        }

        return dummyHead.next;

    }
}

// class Pair {
//     int element;
//     int arrNumber;
//     int index;

//     public Pair(int element,int arrNumber,int index) {
//         this.element = element;
//         this.arrNumber = arrNumber;
//         this.index = index;
//     }
// }
class Pair {
    int element;
    ListNode node;

    public Pair(int element,ListNode node) {
        this.element = element;
        this.node = node;
    }
}