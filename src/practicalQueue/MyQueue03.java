package practicalQueue;

import java.util.Stack;

public class MyQueue03 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;
    public MyQueue03() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //只把 stack 的元素扔到 stack2 一次。
    //下次再调用 pop，如果发现 stack2 不为空，就直接拿 stack2 栈顶的元素就好了。
    //使用这个思路，我们的 stack2 不能是 pop 里的一个临时变量了
    //而需要成为整个 MyQueue 的成员变量
    public void push(int x) {
        if(isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int peek() {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }
}
