package primitive;

public class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E get(int index) throws Exception {
        return search(index).e;
    }

    // Append new Element at the tail
    public void add(E e) {
        this.size++;
        // First Element
        if(head == null && tail == null) {
            head = new ListNode<>(e);
            tail = head;
            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
            return;
        }
        // Create New Node
        ListNode<E> newTail = new ListNode<>(e);
        // Connect newTail, tail and head
        tail.next = newTail;
        newTail.prev = tail;
        newTail.next = head;
        head.prev = newTail;
        // Update Tail
        tail = newTail;
    }

    public void remove(int index) throws Exception {
        ListNode<E> target = search(index);
        this.size--;
        // Delete Node
        // Only one node left
        if (target == head && head == tail) {
            head = null;
            tail = null;
            return;
        }

        target.prev.next = target.next;
        target.next.prev = target.prev;

        if(target == head) head = target.next;
        if(target == tail) tail = target.prev;
    }

    public void set(int index, E e) throws Exception {
        ListNode<E> target = search(index);
        target.e = e;
    }

    private ListNode<E> search(int index) throws Exception {
        if(index < 0 || index > this.size - 1) {
            throw new Exception();
        }
        int i = 0;
        ListNode<E> res = head;
        while(i < index) {
            res = res.next;
            i++;
        }
        return res;
    }


}
