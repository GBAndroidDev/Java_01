package gb.education;

import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        //String inputStr = "3 d +  6 - 7 * 8  / 2";
        //String inputStr = "3 +  6 - 7 * 8  / 2";
        String inputStr = inputValues();
        if (checkNumber(splitArray(inputStr))) {
            System.out.println("Результат вычисления: " + mathMagic(splitArray(inputStr)));
        }
    }

    public static String[] splitArray(String str) {
        String[] tmpRes = str.split(" ");
        return cleanArray(tmpRes);
    }

    public static String[] cleanArray(String[] myArray) {
        int count = 0;
        for (String tmpStr: myArray) {
            if (!tmpStr.isEmpty()) {
                count++;
            }
        }
        String[] res = new String[count];
        count = 0;
        for (String tmpStr: myArray) {
            if (!tmpStr.isEmpty()) {
                res[count] = tmpStr;
                count++;
            }
        }
        return res;
    }

    public static boolean checkNumber(String[] checkArray) {
        String errorMessage = "Вы допустили ошибку при вводе.";
        if (checkArray.length == 0) {
            System.out.println(errorMessage);
            return false;
        }
        for (String str: checkArray) {
            if (!str.equals("*") && !str.equals("+") && !str.equals("/") && !str.equals("-")) {
                try {
                    double num = Double.parseDouble(str);
                } catch (Exception e) {
                    System.out.println(errorMessage);
                    return false;
                }
            }
        }
        return true;
    }

    public static String inputValues() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String[] mathOperation(String[] valuesArray, String operator) {
        double res = 0;
        int i = 0;
        while (i < valuesArray.length) {
            if (valuesArray[i].equals(operator)) {
                switch (operator) {
                    case "*":
                        res = Double.parseDouble(valuesArray[i - 1]) * Double.parseDouble(valuesArray[i + 1]);
                        break;
                    case "/":
                        res = Double.parseDouble(valuesArray[i - 1]) / Double.parseDouble(valuesArray[i + 1]);
                        break;
                    case "+":
                        res = Double.parseDouble(valuesArray[i - 1]) + Double.parseDouble(valuesArray[i + 1]);
                        break;
                    case "-":
                        res = Double.parseDouble(valuesArray[i - 1]) - Double.parseDouble(valuesArray[i + 1]);
                }
                valuesArray[i] = Double.toString(res);
                valuesArray[i - 1] = "";
                valuesArray[i + 1] = "";
                valuesArray = cleanArray(valuesArray);
                i = i - 2;
            }
            i++;
        }
        return valuesArray;
    }

    public static String mathMagic(String[] valuesArray) {
        String[] resValues;
        resValues = mathOperation(valuesArray,"*");
        //System.out.println(Arrays.toString(resValues));
        resValues = mathOperation(resValues,"/");
        //System.out.println(Arrays.toString(resValues));
        resValues = mathOperation(resValues,"-");
        //System.out.println(Arrays.toString(resValues));
        resValues = mathOperation(resValues,"+");
        //System.out.println(Arrays.toString(resValues));

        return resValues[0];
    }

}
