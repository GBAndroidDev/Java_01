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

public class Main {
    public static void main(String[] args) {
        Employee person;
        person = new Employee("James","Java Senior Developer", "james@gmail.com", "+79887894565", 80000,34);
        person.getEmployee();
        System.out.println("------------------------");
        System.out.println("------------------------");

        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("James","Java Senior Developer", "james@gmail.com", "+79887894565", 80000,34);
        persArray[1] = new Employee("Josh Martin","Windows cleaner", "josh@gmail.com", "+79881234565", 80000,48);
        persArray[2] = new Employee("Mike","Client Manager", "mike@gmail.com", "+79887809876", 80000,24);
        persArray[3] = new Employee("George","CEO", "george@gmail.com", "+79887865432", 80000,43);
        persArray[4] = new Employee("Elena","Java Junior Developer", "elena@gmail.com", "+79858934565", 80000,42);

        for (Employee company_employee: persArray) {
            if (company_employee.getAge() > 40) {
                company_employee.getEmployee();
                System.out.println("------------------------");
            }
        }
    }
}
