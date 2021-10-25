package practicalStack;

//對於Stack而言，關鍵是棧頂在哪裡
//棧是一端入，同一端出；隊列是一端入，同一端出
//在此假設入隊的那端為棧頂

import java.util.LinkedList;
import java.util.Queue;

public class MyStack01 {
    private Queue<Integer> q;
    public MyStack01() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        q.add(x);
    }
    public boolean isEmpty() {
        return q.isEmpty();
    }
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        //除了最後一個元素，將q中的所有元素放入q2中
        while (q.size() > 1) {
            q2.add(q.remove());
        }
        //q中剩下的最後一個元素就是棧頂元素
        int ret = q.remove();
        //此時q2儲存了剩下的所有數據，將其賦值給q
        q = q2;
        return ret;
    }
    public int top() {
        int ret = this.pop();
        this.push(ret);
        return ret;
    }

}
