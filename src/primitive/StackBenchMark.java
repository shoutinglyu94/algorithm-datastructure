package primitive;

public class StackBenchMark {

    public static void main(String[] args) {
        MinStackWithSizeStack stack = new MinStackWithSizeStack();
        stack.push(3);
        stack.push(1);
        stack.push(-7);
        stack.push(-6);
        stack.push(-8);
        stack.push(-8);
        System.out.println(stack.getMin());
        while(!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println(stack.getMin());
    }
}
