package practicalStack;

//將隊首定義為棧頂

import java.util.LinkedList;
import java.util.Queue;

public class MyStack03 {
    private Queue<Integer> q;
    public MyStack03() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        Queue<Integer> q2 = new LinkedList<>();

        q2.add(x);
        while (!q.isEmpty()) {
            q2.add(q.remove());
        }
        q = q2;
    }
    public boolean isEmpty() {
        return q.isEmpty();
    }
    public int top() {
        return q.peek();
    }
    public int pop() {
        return q.remove();
    }
}
