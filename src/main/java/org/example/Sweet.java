package org.example;


public abstract class Sweet {
    private String name;
    private double weight;
    private double chocolateContent; // Вміст шоколаду у відсотках

    public Sweet(String name, double weight, double chocolateContent) {
        if (weight < 0) {
            throw new IllegalArgumentException("Вага не може бути від’ємною");
        }
        if (chocolateContent < 0 || chocolateContent > 100) {
            throw new IllegalArgumentException("Вміст шоколаду має бути від 0 до 100");
        }
        this.name = name;
        this.weight = weight;
        this.chocolateContent = chocolateContent;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getChocolateContent() {
        return chocolateContent;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", chocolateContent=" + chocolateContent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sweet sweet = (Sweet) o;

        if (Double.compare(sweet.weight, weight) != 0) return false;
        if (Double.compare(sweet.chocolateContent, chocolateContent) != 0) return false;
        return name != null ? name.equals(sweet.name) : sweet.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(chocolateContent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
