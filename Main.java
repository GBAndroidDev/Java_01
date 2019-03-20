/*1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
наполовину сыт ( это сделано для упрощения логики программы ).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.*/

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Barsik" ,5,false);
        Plate plate = new Plate(100);
        plate.info();

        cat.eat(plate);
        plate.info();

        Cat cat2 = new Cat("Murzik" ,100,false);
        cat2.eat(plate);
        plate.info();

        System.out.println("============================");
        Cat cats[] = new Cat[5];

        plate.addFood(5); //Добавили еды в тарелку.
        plate.info();
        
        cats[0] = new Cat("Gosha",50,false);
        cats[1] = new Cat("Vaska",35,false);
        cats[2] = new Cat("Pushok",18,false);
        cats[3] = new Cat("Kompot",44,false);
        cats[4] = new Cat("Kotesha",4,false);

        for (Cat catItem: cats) {
            catItem.eat(plate);
            plate.info();
            catItem.info();
            System.out.println("-------------------");
        }

    }
}
