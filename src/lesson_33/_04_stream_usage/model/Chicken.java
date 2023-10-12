package lesson_33._04_stream_usage.model;

public class Chicken {
    private String name;
    private int weight;

    public Chicken(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chicken chicken = (Chicken) o;

        if (weight != chicken.weight) return false;
        return name != null ? name.equals(chicken.name) : chicken.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
