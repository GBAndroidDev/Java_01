package gb.education;

import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        //String inputStr = "3 d +  6 - 7 * 8  / 2";
        //String inputStr = "53 - ( 2 + 8 ) + 2 / ( 7 -  8 )";
        String inputStr = inputValues();
        if (checkNumber(splitArray(inputStr))) {
            //System.out.println("Результат вычисления: " + mathMagic(splitArray(inputStr)));
            System.out.println("Результат вычисления: " + calcWithPriority(splitArray(inputStr)));
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
        //System.out.println(Arrays.toString(res));
        return res;
    }

    public static boolean checkNumber(String[] checkArray) {
        String errorMessage = "Вы допустили ошибку при вводе.";
        if (checkArray.length == 0) {
            System.out.println(errorMessage);
            return false;
        }
        /*String[] skipChars = {"*","/","+","-","(",")"};
        for (String str: checkArray) {
            for (String symb: skipChars) {
                if (!str.equals(symb)) {
                    try {
                        double num = Double.parseDouble(str);
                    } catch (Exception e) {
                        System.out.println(errorMessage);
                        return false;
                    }
                }
            }
        }*/
        return true;
    }

    public static String inputValues() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String[] mathOperation(String[] valuesArray, String operator) {
        double res = 0;
        int i = 0;
        //System.out.println(Arrays.toString(valuesArray));
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
                        if (i > 0) {
                            res = Double.parseDouble(valuesArray[i - 1]) - Double.parseDouble(valuesArray[i + 1]);
                        } else {
                            res = Double.parseDouble(valuesArray[i + 1]) * (-1);
                        }
                }
                valuesArray[i] = Double.toString(res);
                if (i > 0) {
                    valuesArray[i - 1] = "";
                }
                valuesArray[i + 1] = "";
                valuesArray = cleanArray(valuesArray);
                if (i > 0) {
                    i = i - 2;
                }
            }
            i++;
        }
        return valuesArray;
    }

    public static String calcWithPriority(String[] splittedArray) {
        int copyBegin = -1;
        int copyEnd = -1;
        String[] valuesForPriorityCalulate;
        for (int i = 0; i < splittedArray.length; i++) {
            if (splittedArray[i].equals("(")) {
                copyBegin = i;
            }
            if (splittedArray[i].equals(")")) {
                copyEnd = i;
            }
            if (copyBegin >= 0 && copyEnd >= 0) {
                valuesForPriorityCalulate = new String[copyEnd - copyBegin - 1];
                int k = 0;
                for (int j = copyBegin + 1; j < copyEnd; j++) {
                    valuesForPriorityCalulate[k] = splittedArray[j];
                    splittedArray[j] = "";
                    k++;
                }
                System.out.println("Priority array: " + Arrays.toString(valuesForPriorityCalulate));
                splittedArray[copyEnd] = "";
                splittedArray[copyBegin] = mathMagic(valuesForPriorityCalulate);
                copyBegin = -1;
                copyEnd = -1;
            }
        }
        return mathMagic(splittedArray);
    }

    public static String mathMagic(String[] valuesArray) {
        String[] resValues;
        resValues = mathOperation(valuesArray,"*");
        //System.out.println(Arrays.toString(resValues));
        resValues = mathOperation(resValues,"/");
        //System.out.println(Arrays.toString(resValues));
        //System.out.println(Arrays.toString(valuesArray));
        resValues = mathOperation(resValues,"-");
        //System.out.println(Arrays.toString(resValues));
        resValues = mathOperation(resValues,"+");
        //System.out.println(Arrays.toString(resValues));

        return resValues[0];
    }

}
