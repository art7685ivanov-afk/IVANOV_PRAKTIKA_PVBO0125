package ru.mirea.task2.opt9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Poker {

    private static final String[] SUITS = {"♠", "♥", "♦", "♣"};
    private static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + suit);  // например "A♠", "10♥", "K♦"
            }
        }

        Collections.shuffle(deck);

        System.out.print("Введите количество игроков: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Количество игроков должно быть положительным.");
            sc.close();
            return;
        }
        if (n * 5 > deck.size()) {
            System.out.println("Недостаточно карт в колоде для " + n + " игроков. "
                    + "Максимум: " + (deck.size() / 5) + " игроков.");
            sc.close();
            return;
        }

        int index = 0;
        for (int player = 1; player <= n; player++) {
            System.out.println("Игрок " + player + ":");
            for (int card = 0; card < 5; card++) {
                System.out.println("  " + deck.get(index));
                index++;
            }
            System.out.println();
        }

        sc.close();
    }
}
