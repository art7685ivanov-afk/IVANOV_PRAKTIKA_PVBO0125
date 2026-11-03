package ru.mirea.task13.opt6;
import java.io.*;
import java.util.*;

public class Task13_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        try {
            List<String> words = readWordsFromFile(fileName);
            String result = getLine(words);
            System.out.println("Результат: " + result);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static List<String> readWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            for (String word : parts) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        reader.close();
        return words;
    }

    public static String getLine(List<String> words) {
        if (words.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        List<String> remaining = new ArrayList<>(words);

        // Пробуем начать с каждого слова
        for (int i = 0; i < remaining.size(); i++) {
            List<String> tempRemaining = new ArrayList<>(remaining);
            String startWord = tempRemaining.remove(i);
            result.setLength(0);
            result.append(startWord);

            if (buildChain(result, tempRemaining)) {
                return result.toString();
            }
        }

        return "Невозможно построить цепочку";
    }

    private static boolean buildChain(StringBuilder chain, List<String> remaining) {
        if (remaining.isEmpty()) {
            return true;
        }

        String lastWord = chain.toString().trim();
        char lastChar = Character.toLowerCase(lastWord.charAt(lastWord.length() - 1));

        for (int i = 0; i < remaining.size(); i++) {
            String word = remaining.get(i);
            char firstChar = Character.toLowerCase(word.charAt(0));

            if (firstChar == lastChar) {
                chain.append(" ").append(word);
                remaining.remove(i);

                if (buildChain(chain, remaining)) {
                    return true;
                }

                // Backtrack
                chain.delete(chain.length() - word.length() - 1, chain.length());
                remaining.add(i, word);
            }
        }

        return false;
    }
}