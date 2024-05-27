import java.util.Arrays;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        // 1.Пользователь вводит 10 слов в массив. Найдите первое слово, в котором есть две гласные буквы подряд

        // Пользователь вводит Пользователь вводит Пользователь вводит Пользователь вводит Пользователь вводит

        System.out.println("Введите 10 слов: ");
        char[] vowel = {'а', 'о', 'у', 'е', 'и', 'ю', 'я', 'э', 'ы', 'ё'};

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        for (String i : words) {
            char[] liters = i.toCharArray();
            int x = 0;
            for (int z = 0; z < liters.length; z++) {
                for (char g : vowel) {
                    if (liters[z] == g) {
                        for (char l : vowel) {
                            if (liters.length > z + 1) {
                                if (liters[z + 1] == l) {
                                    x = 1;
                                }
                            }
                        }
                    }
                }
            }
            if (x == 1) {

                System.out.print(i);

                break;
            }
        }

    }
}
