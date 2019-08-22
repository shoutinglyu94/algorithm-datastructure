package priorityqueue;

import java.util.Arrays;

public class MinHeap {
    int[] array;
    int size;
    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    public MinHeap(int cap) {
        // vap > 0
        this.array = new int[cap];
        size = 0;
    }

    private void heapify() {
        for(int i = (size - 2) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void offer(int val) {
        if(size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = val;
        percolateUp(size);
        size++;
    }

    public Integer poll() {
        if(isEmpty()) return null;
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public Integer peek() {
        if(isEmpty()) return null;
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void percolateUp(int i) {
        while(i > 0) {
            int p = (i - 1) / 2;
            if(array[p] > array[i]) {
                swap(i, p);
                i = p;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int i) {
        while(i <= (size - 2) / 2) {
            int left= i * 2 + 1;
            int right = i * 2 + 2;
            int min = i;
            if(left < size && array[left] < array[min]) {
                min = left;
            }
            if(right < size && array[right] < array[min]) {
                min = right;
            }
            if(min == i) {
                break;
            }
            swap(i, min);
            i = min;
        }
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int num : array) {
            sb.append(num).append(", ");
        }

        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
