package CalulatorAR;


import java.util.Scanner;
public class Main {
    public static String calc(String input) {
        return input;
    }
        public static void main (String[]args){
            Converter converter = new Converter();
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};
            Scanner scn = new Scanner(System.in);
            System.out.println("Введите уравнение:");
            String exp = scn.nextLine();
            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++)
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            if (actionIndex == -1) {
                System.out.println("Некоректное выражение:");
                return;
            }
            String[] data = exp.split(regexActions[actionIndex]);
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;
                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if (a > 10) {
                    System.out.println("Ошибка номер десять!");
                    return;
                }
                if (b > 10) {
                    System.out.println("Ошибка номер десять!");
                    return;
                }
                int result = 0;
                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                }
                if (isRoman) {
                    if (result <= 0) {
                        System.out.println("В Риме нет отрицательных чисел");
                    } else {
                        System.out.println(converter.intToRoman(result));
                    }
                } else {
                    System.out.println(result);
                }
            } else {
                System.out.println("Числа должны быть в одном формате!");
            }

        }

}