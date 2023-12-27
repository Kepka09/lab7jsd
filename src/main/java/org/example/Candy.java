package org.example;

public class Candy extends Sweet {
    private String flavor;
    private boolean isHard;

    public Candy(String name, double weight, double chocolateContent, String flavor, boolean isHard) {
        super(name, weight, chocolateContent);
        this.flavor = flavor;
        this.isHard = isHard;
    }

    public String getFlavor() {
        return flavor;
    }

    public boolean isHard() {
        return isHard;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", chocolateContent=" + getChocolateContent() +
                ", flavor='" + flavor + '\'' +
                ", isHard=" + isHard +
                '}';
    }
}