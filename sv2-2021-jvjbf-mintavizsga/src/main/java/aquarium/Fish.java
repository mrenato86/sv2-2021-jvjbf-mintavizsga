package aquarium;

public abstract class Fish {

    private final String name;
    private int weight;
    private final String color;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public void feed() {
        weight++;
    }

    public String getStatus() {
        return String.format("%s, weight: %d, color: %s, short-term memory loss: %s", name, weight, color, hasMemoryLoss());
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return false;
    }
}
