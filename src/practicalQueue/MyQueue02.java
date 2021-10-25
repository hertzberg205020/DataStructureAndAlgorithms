package practicalQueue;

import java.util.Stack;

public class MyQueue02 {
    private Stack<Integer> stack;
    private int front;
    public MyQueue02() {
        stack = new Stack<>();
    }
    //以棧頂為隊尾
    public void push(int x) {
        if (stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }
    public int pop() {
        Stack<Integer> stack2 = new Stack<>();
        while (stack.size() > 1) {
            front = stack.peek();
            stack2.push(stack.pop());
        }
        int ret = stack.pop();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return ret;
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int peek() {
        return front;
    }
}
