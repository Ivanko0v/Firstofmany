package CalulatorAR;


import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static String calc(String input) {
        return input;
    }

    public static void main(String[] args) throws IOException {
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
            try {
                if (actionIndex == -1) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException s) {
                System.out.println("Не верный знак операции");
                return;
            }

            String[] data = exp.split(regexActions[actionIndex]);
            try {
            if(data.length !=2) {
                throw new IOException();}
            } catch(IOException e){
                    System.out.println("Выражения должно быть два");
                    return;
                }
            try {
                if (converter.isRoman(data[0]) != converter.isRoman(data[1])) {
                    throw new IllegalArgumentException();}
                } catch(IllegalArgumentException v){
                System.out.println("Числа должны быть в одном формате!");
            }
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

                try {
                    if ((a > 10) || (b > 10)) {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка номер десять");
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
                    try {
                        if (result <= 0) {
                            throw new NullPointerException();
                        }
                    } catch (NullPointerException e) {
                        System.out.println("В Риме нет отрицалельных чисел!");
                        return;
                    }

                    System.out.println(converter.intToRoman(result));

                } else {
                    System.out.println(result);
                }
            }

        }

    }
