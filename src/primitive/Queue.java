package primitive;

public class Queue {
    ListNode<Integer> head;
    ListNode<Integer> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void offer(Integer val) {
        ListNode<Integer> newHead = new ListNode<>(val);
        if(head == null) {
            head = newHead;
            tail = head;
        } else {
            tail.next = newHead;
            tail = tail.next;
        }
    }

    public Integer poll() {
        // empty queue
        if (head == null) return null;
        ListNode<Integer> res = head;
        head = head.next;
        // only one left
        if(head == null) {
            tail = null;
        }
        res.next = null;
        return res.e;
    }

    public Integer peek() {
        if(head == null) return null;
        return head.e;
    }
}
