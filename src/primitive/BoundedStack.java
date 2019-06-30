package primitive;

public class BoundedStack {
    int top;
    int[] array;

    public BoundedStack(int capcity) {
        this.array = new int[capcity];
        this.top = -1;
    }

    public Integer top() {
        return top == - 1 ? null : array[top];
    }

    public Integer pop() {
        return top == -1 ? null : array[top--];
    }

    public boolean push(Integer value) {
        if (top == array.length - 1) return false;
        array[++top] = value;
        return true;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
