
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GameLogical {

    private static GameVisualization gameVisualization;
    private static char POINT_USER = 'X';
    private static char POINT_PC = 'O';
    private static char POINT_DEFAULT = '.';

    public static int SIZE_FIELD_X = 3;
    public static int SIZE_FIELD_Y = 3;
    public static int WIN_SIZE = 3;

    public static boolean flag = true;

    public static char[][] getGameField() {
        return gameField;
    }

    public static char[][] gameField = new char[SIZE_FIELD_Y][SIZE_FIELD_X];

    GameLogical() {
        fillGameFields();
    }

    boolean drawChecking() {
        for (int i = 0; i < SIZE_FIELD_Y; i++) {
            for (int j = 0; j < SIZE_FIELD_X; j++) {
                if (gameField[i][j] == '.') return true;
            }
        }
        return false;
    }

    public void startGame() {
        printGameField();
        if (!drawChecking()) {
            flag = false;
            System.out.println("Победила дружба!");
        }
            if (flag) {
                userStep();
                printGameField();
                flag = checkWin(POINT_USER);
            }
            if (flag) {
                pcStep();
                printGameField();
                flag = checkWin(POINT_PC);
            }
    }

    public void startGame(int x, int y) {
        printGameField();
        boolean flag = true;

            if (flag) {
                userStep(x, y);
                printGameField();
                flag = checkWin(POINT_USER);
                if (!flag) System.out.println("Вы победили!");
            }
            if (flag) {
                pcStep();
                printGameField();
                flag = checkWin(POINT_PC);
                if (!flag) System.out.println("ПК победил!");
            }
    }

    // начало игры - заполняем поля
    private void fillGameFields() {
        for (int i = 0; i < SIZE_FIELD_Y; i++) {
            for (int j = 0; j < SIZE_FIELD_X; j++) {
                setGameField(j, i, POINT_DEFAULT);
            }
        }
    }

    // установка элемента - ход
    protected boolean setGameField(int x, int y, char symb) {
        if (enableToStep(x, y)) {
            gameField[y][x] = symb;
            return true;
        }
        return false;
    }

    // получение элемента массива
    private char getGameField(int x, int y) {
        return gameField[y][x];
    }

    // вывод массива в консоль
    private void printGameField() {
        for (int i = 0; i < SIZE_FIELD_Y; i++) {
            for (int j = 0; j < SIZE_FIELD_X; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // ход пользователя
    private void userStep() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int userX = 0, userY = 0;
        while (true) {
            try {
                userX = Integer.parseInt(reader.readLine());
                userY = Integer.parseInt(reader.readLine());
            } catch (Exception e) {}

            if (getGameField(userX, userY) == '.') {
                setGameField(userX, userY, POINT_USER);
                break;
            }
        }
    }

    // ход пользователя
    private void userStep(int x, int y) {
        while (true) {
            if (getGameField(x, y) == '.') {
                setGameField(x, y, POINT_USER);
                break;
            }
        }
    }

    // ход ПК
    private void pcStep() {
        boolean needStep = true;
        for (int i = 0; i < SIZE_FIELD_Y; i++) {
            for (int j = 0; j < SIZE_FIELD_X; j++) {
                if (needStep) {
                    needStep = pcStepDiagDownLine(j, i, POINT_USER);
                }
                if (needStep) {
                    needStep = pcStepDiagUpLine(j, i, POINT_USER);
                }
                if (needStep) {
                    needStep = pcStepHorizontalLine(j, i, POINT_USER);
                }
                if (needStep) {
                    needStep = pcStepVerticalLine(j, i, POINT_USER);
                }
            }
        }

        while (needStep) {
            Random random = new Random();
            int i = random.nextInt(SIZE_FIELD_Y) + 1;
            int j = random.nextInt(SIZE_FIELD_X) + 1;
            if (enableToStep(j, i)) {
                setGameField(j, i, POINT_PC);
                needStep = false;
            }
        }
    }

    private boolean enableToStep(int x, int y) {
        try {
            if (gameField[y][x] != POINT_PC && gameField[y][x] != POINT_USER && x >= 0 && y >= 0 && x < SIZE_FIELD_X && y < SIZE_FIELD_Y) {
                return true;
            }
        } catch (Exception e) {}
        return false;
    }

    private boolean pcStepDiagDownLine(int x, int y, char symb) {
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; i++, j++) {
            if (gameField[i][j] == symb) {
                k++;
                if (k >= WIN_SIZE - 1) {
                    if (setGameField(j + 1, i + 1, POINT_PC)) {
                        return false;
                    }
                    if (setGameField(j - WIN_SIZE +1, i - WIN_SIZE + 1, POINT_PC)) {
                        return false;
                    }
                }
            } else {
                k = 0;
            }
        }
        return true;
    }

    private boolean pcStepDiagUpLine(int x, int y, char symb) {
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j >=0 ; i++, j--) {
            if (gameField[i][j] == symb) {
                k++;
                if (k >= WIN_SIZE - 1) {
                    if (setGameField(j - 1, i + 1, POINT_PC)) {
                        return false;
                    }
                    if (setGameField(j + WIN_SIZE - 1, i - WIN_SIZE + 1, POINT_PC)) {
                        return false;
                    }
                }
            } else {
                k = 0;
            }
        }
        return true;
    }

    private boolean pcStepHorizontalLine(int x, int y, char symb) {
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; j++) {
            if (gameField[i][j] == symb) {
                k++;
                if (k >= WIN_SIZE - 1) {
                    if (setGameField(j + 1, i, POINT_PC)) {
                        return false;
                    }
                    if (setGameField(j - WIN_SIZE + 1, i, POINT_PC)) {
                        return false;
                    }
                }
            } else {
                k = 0;
            }
        }
        return true;
    }

    private boolean pcStepVerticalLine(int x, int y, char symb) {
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; i++) {
            if (gameField[i][j] == symb) {
                k++;
                if (k >= WIN_SIZE - 1) {
                    if (setGameField(j, i + 1, POINT_PC)) {
                        return false;
                    }
                    if (setGameField(j, i - WIN_SIZE + 1, POINT_PC)) {
                        return false;
                    }
                }
            } else {
                k = 0;
            }
        }
        return true;
    }

    // проверка линии на "победу"
    private int checkDiagDownLine(int x, int y, char symb) {
        int max = 0;
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; i++, j++) {
            if (gameField[i][j] == symb) {
                k++;
            } else {
                if (k > max) {
                    max = k;
                }
                k = 0;
            }
        }
        if (k > max) {
            max = k;
        }
        return max;
    }

    // проверка линии на "победу"
    private int checkDiagUpLine(int x, int y, char symb) {
        int max = 0;
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j >= 0; i++, j--) {
            if (gameField[i][j] == symb) {
                k++;
            } else {
                if (k > max) {
                    max = k;
                }
                k = 0;
            }
        }
        if (k > max) {
            max = k;
        }
        return max;
    }

    // проверка линии на "победу"
    private int checkHorizontalLine(int x, int y, char symb) {
        int max = 0;
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; j++) {
            if (gameField[i][j] == symb) {
                k++;
            } else {
                if (k > max) {
                    max = k;
                }
                k = 0;
            }
        }
        if (k > max) {
            max = k;
        }
        return max;
    }

    // проверка линии на "победу"
    private int checkVerticalLine(int x, int y, char symb) {
        int max = 0;
        int k = 0;
        for (int i = y, j = x; i < SIZE_FIELD_Y && j < SIZE_FIELD_X; i++) {
            if (gameField[i][j] == symb) {
                k++;
            } else {
                if (k > max) {
                    max = k;
                }
                k = 0;
            }
        }
        if (k > max) {
            max = k;
        }
        return max;
    }

    private boolean checkWin(char symb) {
        for (int i = 0; i < SIZE_FIELD_Y; i++) {
            for (int j = 0; j < SIZE_FIELD_X; j++) {
                if (checkDiagDownLine(j,i,symb) >= WIN_SIZE) {
                    return false;
                }
                if (checkDiagUpLine(j,i,symb) >= WIN_SIZE) {
                    return false;
                }
                if (checkHorizontalLine(j,i,symb) >= WIN_SIZE) {
                    return false;
                }
                if (checkVerticalLine(j,i,symb) >= WIN_SIZE) {
                    return false;
                }
                //System.out.print(checkDiagDownLine(j,i,POINT_USER) + " ");
            }
        }
        return true;
    }
}
