import priorityqueue.MinHeap;

public class Benchmark {
    public static void main(String[] args) {
        //testMinHeap();
    }

    private static void testVerticalTraversal() {

    }

    private static void testMinHeap() {
        MinHeap minHeap = new MinHeap(new int[] {8, 6, 4, 3, 1});
        minHeap.offer(11);
        minHeap.offer(15);
        System.out.println(minHeap);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
