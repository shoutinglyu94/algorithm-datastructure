package primitive;

public class LinkedListBenchmark {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
            list.set(i, i + 10);
            System.out.println(list.get(i));
        }
        for(int i = 0; i < 10; i++) {
            list.remove(0);
        }
        System.out.println(list.isEmpty());

    }
}
