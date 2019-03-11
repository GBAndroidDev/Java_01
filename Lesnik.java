package gb.Lesson05;

/*Представьте, что лесник пытается сосчитать сосны, ели и березы на участке леса. Он может обойти весь участок трижды,
сосчитав сначала только сосны, потом только ели и в третий раз только березы.

Конечно, более эффективно обойти лес только один раз, отмечая крестиками сосны на одной странице блокнота,
ели на другой и березы на третьей. Потом останется только сосчитать количество крестиков на каждой странице.
Аналогичная идея работает для подсчета схожих элементов в последовательности или наборе,
с использованием массива счетчиков (в качестве блокнота со страницами).

Дан массив длины M с числами в диапазоне 1 ... N, где N не больше 20. Вам нужно пройти по этому массиву
и сосчитать сколько раз встречается каждое число.
Пожалуйста, не используйте 20 отдельных переменных для счетчиков, а сделайте один массив из них.

Пример
входные данные:
1 2 3 2 3 1 1 1 1 3

ответ:
5 2 3


Входные данные для задачи


5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5 4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3 1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3 2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5 2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5 3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1 5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4
*/

import java.util.Arrays;
import java.util.HashMap;

public class Lesnik {
    public static String[][] treesCount;

    public static void main(String[] args) {
        String treesData = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5 4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3 1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3 2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5 2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5 3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1 5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4";
        String[] treesArray = treesData.split(" ");
        for (int i = 0; i < treesArray.length; i++) {
            if (i == 0) {
                treesCount = new String[][]{{treesArray[0], "1"}};
                //printArray(treesCount);
            } else {
                addNewTree(treesArray[i]);
            }
        }
        printArray(treesCount);
    }

    public static void addNewTree(String tree) {
        boolean flag = true;
        for (int i = 0; i < treesCount.length; i++) {
            if (tree.equals(treesCount[i][0])) {
                treesCount[i][1] = String.valueOf(Integer.parseInt(treesCount[i][1]) + 1);
                flag = false;
                break;
            }
        }
        if (flag) {
            treesCount = arrayCopy(treesCount,1);
            treesCount[treesCount.length - 1][0] = tree;
            treesCount[treesCount.length - 1][1] = "1";
            flag = true;
        }
        //printArray(treesCount);
    }

    public static String[][] arrayCopy(String[][] copyingArray, int addNewsCell) {
        String[][] newArray = new String[copyingArray.length + addNewsCell][copyingArray[0].length];
        for (int i = 0; i < copyingArray.length; i++) {
            for (int j = 0; j < copyingArray[0].length; j++) {
                newArray[i][j] = copyingArray[i][j];
            }
        }
        return newArray;
    }

    public static void printArray(String[][] printingArray) {
        for (int i = 0; i < printingArray.length; i++) {
            for (int j = 0; j < printingArray[0].length; j++) {
                System.out.print(printingArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
