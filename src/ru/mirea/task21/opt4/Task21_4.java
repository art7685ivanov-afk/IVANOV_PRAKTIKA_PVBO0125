package ru.mirea.task21.opt4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Task21_4 {
    public static List<String> listDirectory(String path) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(path))) {
            return stream.map(Path::toString).sorted().toList();
        }
    }

    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : ".";
        try {
            List<String> entries = listDirectory(path);
            System.out.println("Всего элементов: " + entries.size());
            entries.stream().limit(5).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать каталог: " + e.getMessage());
        }
    }
}
