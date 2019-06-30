package primitive;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackWithSizeStack implements Stack {
    Deque<Integer> stack, minStack, sizeStack;

    public MinStackWithSizeStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        sizeStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
            sizeStack.push(stack.size());
        } else { // !minStack.isEmpty() && x >= min
            sizeStack.push(sizeStack.pop() + 1);
        }
    }

    public int pop() {
        int top = stack.pop();
        int size = sizeStack.pop();
        size--;
        if (sizeStack.isEmpty() || size != sizeStack.peek()) {
            sizeStack.push(size);
        } else if(top == minStack.peek()) {
            minStack.pop();
        }

        return top;
    }

    public int peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int getMin() {
        return minStack.peek();
    }
}
