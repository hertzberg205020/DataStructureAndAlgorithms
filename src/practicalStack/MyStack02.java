package practicalStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack02 {
    private Queue<Integer> q;
    //紀錄追蹤棧頂元素
    private int top;
    public void push(int x) {
        q.add(x);
        top = x;
    }
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while (q.size() > 1) {
            top = q.peek();
            q2.add(q.remove());
        }
        int ret = q.remove();
        q = q2;
        return ret;
    }
    public boolean isEmpty() {
        return q.isEmpty();
    }
    public int top() {
        return top;
    }

}
