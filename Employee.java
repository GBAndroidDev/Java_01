package gb.Lesson05;

/*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        2. Конструктор класса должен заполнять эти поля при создании объекта.
        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в
        консоль.
        4. Создать массив из 5 сотрудников.
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "i vivan@mailbox.com" , "892312312",
        30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);
        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/

public class Employee {
    public int getAge() {
        return age;
    }

    private String name, position, email, telnumber;
    private int salary, age;

    public Employee(String name, String position, String email, String telnumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telnumber = telnumber;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployee() {
        System.out.println("Name: " + this.name);
        System.out.println("Position: " + this.position);
        System.out.println("Email: " + this.email);
        System.out.println("Tel.number: " + this.telnumber);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
    }

}

