package org.example;

public class GummyCandy extends Sweet {
    private String shape; // e.g., bears, worms
    private String color;

    public GummyCandy(String name, double weight, double chocolateContent, String shape, String color) {
        super(name, weight, chocolateContent);
        this.shape = shape;
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "GummyCandy{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", chocolateContent=" + getChocolateContent() +
                ", shape='" + shape + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}