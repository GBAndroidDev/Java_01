import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int SIZE_X = 5;
    private static int SIZE_Y = 5;
    private static int SIZE_WIN = 3;
    private static char USER_DOT = 'X';
    private static char AI_DOT = 'O';
    private static char EMPTY_DOT = '*';
    private static char[][] myTicTacToe = new char[SIZE_Y][SIZE_X];
    private static Random rand = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static int STEP_COUNT = 0;

    private static void fillFields() {
        for (int i = 0; i < SIZE_Y ; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                setDot(j,i,EMPTY_DOT);
            }
        }
    }

    private static void setDot(int x, int y, char symb) {
        myTicTacToe[y][x] = symb;
    }

    private static void printTicTacToe() {
        for (int i = 0; i <= SIZE_Y; i++) {
            System.out.print(i + " ");
            for (int j = 0; j <= SIZE_X; j++) {
                if (i > 0 && j > 0) {
                    System.out.print(myTicTacToe[i - 1][j - 1] + " ");
                }
                if (i == 0 && j > 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean checkField(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE_X || y >= SIZE_Y) {
            return false;
        }
        return (myTicTacToe[y][x] == EMPTY_DOT);
    }

    private static void playerStep() {
        int max = (SIZE_X > SIZE_Y) ? SIZE_X : SIZE_Y;
        System.out.println("Ваш ход. Введите X Y (от 1 до " + max + "): ");
        int x, y;
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkField(x, y));
        setDot(x, y, USER_DOT);
        STEP_COUNT++;
    }

    private static void aiStep() {
        System.out.println("Ход ПК:");
        int x, y;
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!checkField(x, y));
        setDot(x, y, AI_DOT);

    }

    private static boolean isDraw() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (myTicTacToe[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkDULine(char symb) {
        int checkDULine = 0;
        boolean flag = false;
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (SIZE_Y - i - 1 == j && myTicTacToe[i][j] == symb) {
                    flag = true;
                } else {
                    flag = false;
                    checkDULine = 0;
                }
                if (flag) {
                    checkDULine++;
                }
                if (checkDULine >= SIZE_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkUDLine(char symb) {
        int checkUDLine = 0;
        boolean flag = false;
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (i == j && myTicTacToe[i][j] == symb) {
                    flag = true;
                } else {
                    flag = false;
                    checkUDLine = 0;
                }
                if (flag) {
                    checkUDLine++;
                }
                if (checkUDLine >= SIZE_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHLine(char symb) {
        int checkHLine = 0;
        boolean flag = false;
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (myTicTacToe[i][j] == symb) {
                    flag = true;
                } else {
                    flag = false;
                    checkHLine = 0;
                }
                if (flag) {
                    checkHLine++;
                }
                if (checkHLine >= SIZE_WIN) {
                    return true;
                }
            }
            checkHLine = 0;
        }
        return false;
    }

    private static boolean checkVLine(char symb) {
        int checkVLine = 0;
        boolean flag = false;
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (myTicTacToe[j][i] == symb) {
                    flag = true;
                } else {
                    flag = false;
                    checkVLine = 0;
                }
                if (flag) {
                    checkVLine++;
                }
                if (checkVLine >= SIZE_WIN) {
                    return true;
                }
            }
            checkVLine = 0;
        }
        return false;
    }

    private static boolean checkWin(char symb) {
        if (checkDULine(symb) || checkUDLine(symb) || checkHLine(symb) || checkVLine(symb)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        fillFields();
        printTicTacToe();

        while (true) {
            playerStep();
            printTicTacToe();
            if (checkWin(USER_DOT)) {
                System.out.println("Player win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Dead heat.");
                break;
            }
            aiStep();
            printTicTacToe();
            if (checkWin(AI_DOT)) {
                System.out.println("PC win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Dead heat.");
                break;
            }
        }
    }
}