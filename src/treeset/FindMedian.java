package treeset;

import java.util.TreeSet;

public class FindMedian {
    class Cell implements Comparable<Cell>{
        int index, val;
        Cell(int idx, int v) {
            index = idx;
            val = v;
        }
        @Override
        public int compareTo(Cell other) {
            if (this.val != other.val) return Integer.compare(this.val, other.val);
            else return Integer.compare(this.index, other.index);
        }

    }
    TreeSet<Cell> treeSet;
    int size;
    Cell midSmall, midLarge;
    /** initialize your data structure here. */
    public FindMedian() {
        treeSet = new TreeSet<>();
        size = 0;
        midSmall = null;
        midLarge = null;
    }

    public void addNum(int num) {
        Cell cell = new Cell(size, num);
        treeSet.add(cell);
        updateMedian(cell);
        size++;
    }

    private void updateMedian(Cell cell) {
        if(size == 0) {
            midSmall = cell;
            midLarge = cell;
        } else if(size % 2 != 0) {
            if(cell.val == midSmall.val) {
                midLarge = cell;
            } else if(cell.val > midSmall.val) {
                midLarge = treeSet.higher(midSmall);
            } else {
                midSmall = treeSet.lower(midLarge);
            }
        } else {
            if(cell.val >= midLarge.val) {
                midSmall = midLarge;
            } else if(cell.val < midSmall.val){
                midLarge = midSmall;
            } else {
                midLarge = treeSet.higher(midSmall);
            }
        }
    }

    public double findMedian() {
        return (midSmall.val + midLarge.val) / 2.0;
    }
}
