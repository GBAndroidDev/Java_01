package gb.education;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //guessNumber();
        guessWord();
    }

    //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
    //попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
    //указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    //выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void guessNumber() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Угадай число от 0 до 9.");
            int n = 3;
            Random rand = new Random();
            int randNum = rand.nextInt (10);
            for (int i = 1; i <= n; i++) {
                System.out.print("Попытка " + i + ": ");
                int num = scanner.nextInt();
                if (num == randNum) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (i == n) {
                    System.out.println("Игра окончена. Вы не справились.");
                } else if (randNum > num) {
                    System.out.println("Загаданое чилсло больше.");
                } else if (randNum < num) {
                    System.out.println("Загаданое чилсло меньше.");
                }
            }
            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет: ");
            int exitGame = scanner.nextInt();
            if (exitGame == 0) {
                System.out.println("Спасибо за игру. Пока!");
                flag = false;
            }
        }
        scanner.close();
        System.out.println();
    }

    //2 * Создать массив из слов
    //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    //"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    //"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
    //слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно можно пользоваться:
    //String str = "apple";
    //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово.
    //Используем только маленькие буквы.
    public static void guessWord() {
        System.out.println("Угадай слово.");
        boolean flag = true;
        int i = 0, strMaxLength = 0, k = 0;
        String yourWord, guessStr = "", maxGuessStr = "", resMaxGuessStr = "";
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);

        /*for (i = 1; i < words[0].length() - 1; i++) {
            System.out.print(words[0].charAt(i) + " ");
        }*/
        System.out.println("Я (ПК) знаю несколько овощей и фруктов. Я загадал одно. Попробуй угадать. ");
        Random rand = new Random();
        int randNum = rand.nextInt(words.length - 1);
        guessStr = "pea";//words[randNum];
        System.out.println(guessStr);
        do {
            i++;
            System.out.print("Ваш вариант (" + i + "): ");
            yourWord = scanner.next();
            if (yourWord.equals(guessStr)) {
                flag = false;
            } else {
                System.out.println(getFindStrPart(yourWord,guessStr));
            }


            if (!flag) {
                System.out.println("Вы угадали. Молодец!");
            }

        } while (flag);
        scanner.close();
    }

    public static String getFindStrPart(String userStr, String pcStr) {
        String result = "";
        String inSearchLine, matchStr;
        boolean whoLonger = true; // true длинее строка пользователя; false - длинее загаданная строка.
        int userWordLength = userStr.length();
        int pcWordLength = pcStr.length();
        if (userWordLength > pcWordLength) {
            inSearchLine = userStr;
            matchStr = pcStr;
        } else {
            inSearchLine = pcStr;
            matchStr = userStr;
            whoLonger = false;
        }
        String tmpStr = "" + matchStr;
        int i = 0;
        boolean flag = true;
        while (flag) {
            if (inSearchLine.indexOf(matchStr.substring(i,matchStr.length())) != -1) {
                result = changdeChars(inSearchLine, i,matchStr.length() - 1, whoLonger);
                break;
            }
            if (inSearchLine.indexOf(matchStr.substring(0,matchStr.length() - i)) != -1) {
                result = changdeChars(inSearchLine,0,matchStr.length() - 1 - i, whoLonger);
                break;
            }
            if (i > inSearchLine.length()) {
                flag = false;
            }
            i++;
        }

        return result;
    }

    public static String changdeChars(String str, int begin, int end, boolean flag) {
        StringBuilder newStr = new StringBuilder();
        if (flag) {
            for (int i = 0; i < str.length(); i++) {
                if (i >= begin && i <= end) {
                    newStr.append(str.charAt(i));
                } else {
                    newStr.append("#");
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i < begin || i > end) {
                    newStr.append(str.charAt(i));
                } else {
                    newStr.append("#");
                }
            }
        }
        return newStr.toString();
    }

}
