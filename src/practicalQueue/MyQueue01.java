package practicalQueue;

import java.util.Stack;

public class MyQueue01 {
    private Stack<Integer> stack;
    public MyQueue01() {
        stack = new Stack<>();
    }
    //隊首(出隊的那一端)為棧頂
    // Removes the element from in front of queue and returns that element.
    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }
    // Removes the element from in front of queue and returns that element.
    public int pop() {
        return stack.pop();
    }
    //Returns whether the queue is empty.
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    //Get the front element.
    public int peek() {
        return stack.peek();
    }
}
