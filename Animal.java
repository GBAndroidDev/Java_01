/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
        параметра каждому методу передается величина, означающая или длину препятствия (для
        бега и плавания), или высоту (для прыжков).
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот
        2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. При попытке животного выполнить одно из этих действий оно должно сообщить результат в
        консоль. (Например, dog1.run(150); -> результат: run: true).
        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
        может быть 400 м., у другой 600 м.*/

public class Animal {
    int run, swim;
    double jump;

    public boolean run(int run_value) {
        if (run_value > 0) return true;
        return false;
    }

    public boolean jump(double jump_value) {
        if (jump_value > 0) return true;
        return false;
    }

    public boolean swim(int swim_value) {
        if (swim_value > 0) return true;
        return false;
    }

    public Animal(int run, double jump, int swim) {
        this.run = run;
        this.jump = jump;
        this.swim = swim;
        System.out.println("run: " + run(this.run));
        System.out.println("jump: " + jump(this.jump));
        System.out.println("swim: " + swim(this.swim));
    }

}
