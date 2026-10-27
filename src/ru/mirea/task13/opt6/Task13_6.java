package ru.mirea.task13.opt6;

public class Task13_6 {
    public static void main(String[] args) {
        String[] words = {"apple", "elephant", "tiger", "rabbit", "tree"};
        System.out.println("Результат: " + buildChain(words));
    }

    public static String buildChain(String[] words) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[words.length];

        sb.append(words[0]).append(" ");
        used[0] = true;
        char lastChar = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (!used[j] && Character.toLowerCase(words[j].charAt(0)) == Character.toLowerCase(lastChar)) {
                    sb.append(words[j]).append(" ");
                    used[j] = true;
                    lastChar = words[j].charAt(words[j].length() - 1);
                    break;
                }
            }
        }
        return sb.toString().trim();
    }
}