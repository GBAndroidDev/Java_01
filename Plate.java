public class Plate {
    public int getFood() {
        return food;
    }

    private int food;

    public void addFood(int food) {
        this.food += food;
    }

    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        }
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}
