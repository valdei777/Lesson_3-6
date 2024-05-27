import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        // 2.Пользователь вводит массив чисел. Найдите первое четное число

        // 1 2 3 4 5 6 7 8 9 0

        System.out.println("Введите 10 чисел: ");

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(words).map(s -> Integer.parseInt(s)).toList();

        for(int i : numbers) {
            if(i % 2 == 0) {
                System.out.println(i);
                break;
            }
        }


    }
}
