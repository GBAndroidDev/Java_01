public class Cat {
    private String name;
    private int appetite;
    private boolean full;
    public Cat(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }
    public void eat(Plate p) {
        if (appetite > p.getFood()) {
            System.out.println("Еды больше нет или кот слишком прожорлив.");
        } else {
            if (!full) {
                p.decreaseFood(appetite);
                full = true;
            }
        }

    }
    public void info() {
        if (full) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }
}
