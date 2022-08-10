import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    static Scanner calc1 = new Scanner(in);
    static int result;
    static int a;
    static int b;
    static String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    static char znak;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        out.println("Введите выражение, разделяя каждый символ пробелами. Вы можете использовать арабские цифры от 1-10 или два римских числа: ");
        calc(calc1.nextLine());
    }
    public static String calc(String input) throws Exception {
        String[] string = input.split(" ");
        if (string.length > 3 ) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (string.length < 3){
            throw new Exception("Cтрока не является математической операцией");
        }
        znak = switch (string[1]) {
            case "+" -> '+';
            case "-" -> '-';
            case "*" -> '*';
            case "/" -> '/';
            default -> throw new Exception("Вы ввели неверный знак");
        };
        for (String s : roman)
            if (s.equals(string[0]) || s.equals(string[2])) {
                flag = true;
                break;
            }
        if (flag) {
            a = romanToNumber(string[0]);
            b = romanToNumber(string[2]);
            result = calculated(a, b);
            String resultRoman;
            if(result > 0) {
                resultRoman = convertNumToRoman(result);
            } else {throw new Exception("В римской системе нет отрицательных чисел");}
            out.println(resultRoman);
        } else {
            a = Integer.parseInt(string[0]);
            b = Integer.parseInt(string[2]);
            if (a <= 10 && b <= 10) {
                result = calculated(a, b);
                out.println(result);
            } else {
                throw new Exception("Можно использовать арабские числа только от 1 до 10");
            }
        }
        return input;
    }

    private static int romanToNumber(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Вы можете использовать римские цифры от I до X, либо используете разные системы счисления");
        };
    }
    public static  int calculated (int n1, int n2) throws Exception {
        int result;
        result = switch (znak) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> throw new Exception("Вы ввели неверный знак");
        };
        return result;
    }
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}