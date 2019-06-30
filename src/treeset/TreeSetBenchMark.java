package treeset;

public class TreeSetBenchMark {
    public static void main(String[] args) {
        FindMedian finder = new FindMedian();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }
}
