package java_coding_question;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseAStringMain {
    private ReverseAStringMain() {}
    public static void reverseAString1(String words) {
        String ret = "";
        for(int i = words.length()-1; i >= 0; i--) {
            ret = ret + words.charAt(i);
        }
        System.out.println(ret);
    }
    public static void reverseAString2(String words) {
        reverseAString2(words, words.length()-1);
    }
    private static void reverseAString2(String words, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(words.charAt(index));
        reverseAString2(words, index-1);
    }
    public static String reverseAStringR(String words) {
        if(words.length() == 1)
            return words;
        return words.charAt(words.length()-1) + reverseAStringR(words.substring(0, words.length()-1));
    }
    public static String reverseAString3(String words) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < words.length(); i++) {
            stack.push(words.charAt(i));
        }
        String res = "";
        for(int i = 0; i < words.length(); i++) {
            res = res + stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseAString3("Total"));
        // StringBuffer中有實例方法.reverse()，翻轉字串
        String blogName = "java2blog";
        StringBuffer sb = new StringBuffer(blogName);
        System.out.println("Reverse of java2blog is: " + sb.reverse());
    }
}
