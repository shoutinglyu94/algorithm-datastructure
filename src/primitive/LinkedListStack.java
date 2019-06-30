package primitive;

import primitive.ListNode;

public class LinkedListStack {
    // Singly LinkedList
    private ListNode<Integer> head;

    public LinkedListStack() {
        head = null;
    }

    public Integer pop() {
        if(head == null) return null;
        ListNode<Integer> top = head;
        head = head.next;
        top.next = null;
        return top.e;
    }

    public void push(Integer value) {
        ListNode<Integer> newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public Integer top() {
        if(head == null) return null;
        return head.e;
    }

}
