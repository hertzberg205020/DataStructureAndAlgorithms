package java_coding_question;

import java.util.Arrays;
import java.util.Locale;

// How to check if two Strings are Anagrams in Java
// Anagrams mean if two Strings have the same characters but in a different order.
// For example: Angel and Angle are anagrams
public class StringAnagram {
    public static boolean isAnagramUsingArraySort(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        String sortedWord = sortChars(word);
        String sortedAnagram = sortChars(anagram);
        return sortedWord.equals(sortedAnagram);
    }
    private static String sortChars(String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        Arrays.sort(wordArr);
        return String.valueOf(wordArr);
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        // ÅcÓÃ×ÖÔªÓ‹”µÆ÷
        int[] counter = new int[26];
        char c1, c2;
        for(int i = 0; i < str1.length(); i++) {
            c1 = str1.toLowerCase().charAt(i);
            counter[c1 - 'a']++;
            c2 = str2.toLowerCase().charAt(i);
            counter[c2 - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Angle","nAgle"));
        System.out.println(isAnagramUsingArraySort("Angle","nAgle"));
    }
}
