package gb.education;

public class Main {
    public static void main (String[] args) {

        System.out.println("Java 1 - Урок 2");

        recursiveArray();
        fillArray();
        task3();
        task4();
        task5();
        System.out.println(task6(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        task7(new int[] {1,2,3,4,5}, 2);
    }

    //вывод массива (не относится к ДЗ)
    public static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    //вывод массива (не относится к ДЗ)
    public static void printArray(int[][] myArray) {
        for(int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
    //0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void recursiveArray() {
        System.out.println("Задача 2:");
        int sourceArray[] = {1,1,0,0,1,0,1,1,0,0};
        printArray(sourceArray);
        for (int i = 0; i < sourceArray.length; i++) {

            if (sourceArray[i] == 1) {
                sourceArray[i] = 0;
            } else if (sourceArray[i] == 0) {
                sourceArray[i] = 1;
            }
        }
        printArray(sourceArray);
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    //значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        System.out.println("Задача 2:");
        int myArray[] = new int[8];
        int k = 0;
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = k;
            k += 3;
        }
        printArray(myArray);
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    //умножить на 2;
    public static void task3() {
        System.out.println("Задача 3:");
        int myArray[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(myArray);
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < 6) {
                myArray[i] = myArray[i] * 2;
            }
        }
        printArray(myArray);
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void task4() {
        System.out.println("Задача 4:");
        int SIZE_X = 5;
        int SIZE_Y = 5;
        int myArray[][] = new int[SIZE_X][SIZE_Y];
        for (int i = 0; i < SIZE_X; i++) {
                myArray[i][i] = 1;
                myArray[i][SIZE_Y - i - 1] = 1;
        }
        printArray(myArray);
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
    //помощи интернета);
    public static void task5() {
        System.out.println("Задача 5:");
        int myArray[] = {1,5,-4,8,12};
        printArray(myArray);
        int min = 0, max = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < min) {
                min = myArray[i];
            }
            if (myArray[i] > max) {
                max = myArray[i];
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    //** Написать метод, в который передается не пустой одномерный целочисленный массив,
    //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
    //2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean task6(int myArray[]) {
        System.out.println("Задача 6:");
        boolean res = false;
        int leftSum, rightSum , k, j;
        int equalityPosition = 1; //позиция коретки
        for (int i = 0; i < myArray.length; i++) {
            equalityPosition++;
            leftSum = 0;
            rightSum = 0;
            for (k = 0; k <= i; k++) {
                leftSum += myArray[k];
            }
            //System.out.print("Сумма слева: " + leftSum + ", ");
            for (j = i+1; j < myArray.length; j++) {
                rightSum += myArray[j];
            }
            //System.out.println("сумма справа: " + rightSum + ".");
            if (rightSum == leftSum) {
                System.out.println("Место равенстава в массиве: " + equalityPosition + "-й элемент.");
                res = true;
                break;
            }
        }
        return res;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
    //положительным, или отрицательным), при этом метод должен сместить все элементы
    //массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
    //массивами.
    public static void task7(int myArray[], int n) {
        System.out.println("Задача 7:");
        int cacheValue;

        if (n > 0) {
            for (int j = 1; j <= n; j++) {
                cacheValue = myArray[myArray.length-1];
                for (int i = myArray.length - 1; i >= 0; i--) {

                    if (i > 0) {
                        myArray[i] = myArray[i-1];
                    } else {
                        myArray[0] = cacheValue;
                    }

                }
                //printArray(myArray);
            }
            printArray(myArray);
        } else if (n < 0) {
            for (int j = 1; j <= n*(-1); j++) {
                cacheValue = myArray[0];
                for (int i = 0; i < myArray.length ; i++) {

                    if (i + 1 < myArray.length) {
                        myArray[i] = myArray[i+1];
                    } else {
                        myArray[i] = cacheValue;
                    }

                }
                //printArray(myArray);
            }
            printArray(myArray);
        } else {
            printArray(myArray);
        }
    }
}
