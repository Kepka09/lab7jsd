package org.example;

public class ChocolateBar extends Sweet {
    private String type; // e.g., dark, milk, white
    private boolean hasNuts;

    public ChocolateBar(String name, double weight, double chocolateContent, String type, boolean hasNuts) {
        super(name, weight, chocolateContent);
        this.type = type;
        this.hasNuts = hasNuts;
    }

    public String getType() {
        return type;
    }

    public boolean hasNuts() {
        return hasNuts;
    }

    @Override
    public String toString() {
        return "ChocolateBar{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", chocolateContent=" + getChocolateContent() +
                ", type='" + type + '\'' +
                ", hasNuts=" + hasNuts +
                '}';
    }
}