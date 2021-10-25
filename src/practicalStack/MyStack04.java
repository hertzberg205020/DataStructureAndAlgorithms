package practicalStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack04 {
    private Queue<Integer> q;
    public MyStack04() {
        q = new LinkedList<>();
    }
    //若棧頂為對首，是否可以只用一個隊列就完成棧的實現
    //在MyStack03中，實現push的本質就是在隊首添加新元素x，其他元素沒有改變
    //但隊列僅能在隊尾添加新元素，所以才需要第二個隊列協助
    //但其實可以將新元素置於隊尾，之後將新元素調整至隊首位置
    //藉由將其他元素不斷出隊入隊size-1次操作完成
    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
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
