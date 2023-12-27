package org.example;

public class Main {
    public static void main(String[] args) {
        SweetLinkedList<ChocolateBar> chocolates = new SweetLinkedList<>();
        chocolates.add(new ChocolateBar("Milka", 0.1, 40, "Milk", false));
        chocolates.add(new ChocolateBar("Dark Delight", 0.1, 85, "dark", false));

        System.out.println("Шоколадні батончики:");
        for (ChocolateBar chocolate : chocolates) {
            System.out.println(chocolate);
        }

        SweetLinkedList<Candy> candies = new SweetLinkedList<>();
        candies.add(new Candy("Lemon Drop", 0.02, 0, "Lemon", true));
        candies.add(new Candy("Raffaello", 0.05, 30, "Coconut", false));

        System.out.println("\nЦукерки:");
        for (Candy candy : candies) {
            System.out.println(candy);
        }

        SweetLinkedList<GummyCandy> gummyCandies = new SweetLinkedList<>();
        gummyCandies.add(new GummyCandy("Green Gummy Bears", 0.05, 0, "Bears", "Green"));
        gummyCandies.add(new GummyCandy("Red Gummy Worms", 0.1, 0, "Worms", "Red"));

        System.out.println("\nЖелейки:");
        for (GummyCandy gummyCandy : gummyCandies) {
            System.out.println(gummyCandy);
        }

    }
}
