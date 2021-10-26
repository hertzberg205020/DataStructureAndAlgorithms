package java_coding_question;

import java.util.HashSet;
import java.util.Set;

public class StringAllUniqueCharMain {
    public static boolean hasAllUniqueChars(String word) {
        Set<Character> set = new HashSet<>();
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(!set.contains(c)) {
                set.add(c);
            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean hasAllUniqueChars2(String word) {
        // 宣告boolean陣列判斷字源是否有重複
        boolean[] characters = new boolean[26];
        for(int i = 0; i < word.length(); i++) {
            if(!characters[word.toLowerCase().charAt(i) - 'a'])
                characters[word.toLowerCase().charAt(i) - 'a'] = true;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("java2blog has all unique chars : "+ hasAllUniqueChars2("java2blog"));
        System.out.println("Apple has all unique chars : "+ hasAllUniqueChars2("apple"));
        System.out.println("index has all unique chars : "+ hasAllUniqueChars2("index"));
        System.out.println("world has all unique chars : "+ hasAllUniqueChars2("world"));
    }
}
