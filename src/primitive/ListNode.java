package primitive;

public class ListNode<E> {
    ListNode<E> prev;
    ListNode<E> next;
    E e;
    public ListNode(E e) {
        this.e = e;
    }

}
