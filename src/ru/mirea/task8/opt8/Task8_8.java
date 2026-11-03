package ru.mirea.task8.opt8;


public class Task8_8 {

    public static boolean isPalindrome(String word, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }
        return isPalindrome(word, left + 1, right - 1);
    }
    public static void main(String[] args) {
        String[] words = {"level", "java", "racecar", "abcd"};

        for (String word : words) {
            String answer = isPalindrome(word, 0, word.length() - 1) ? "YES" : "NO";
            System.out.println(word + " - " + answer);
        }
    }
}
