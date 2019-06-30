package primitive;
/*
    Fixed size Queue implemented by circular array
 */
public class BoundedQueue {
    int head, tail, size;
    int[] array;
    BoundedQueue (int capacity) {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        array = new int[capacity];
    }

    public boolean offer(Integer value) {
        if (size == array.length) return false;
        array[tail] = value;
        tail = next(tail);
        size++;
        return true;
    }

    public Integer poll() {
        if(isEmpty()) return null;
        int res = array[head];
        head = next(head);
        size--;
        return res;
    }

    public Integer peek() {
        if(isEmpty()) return null;
        return array[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int next(int i) {
        return (i + 1) % array.length;
    }

}
