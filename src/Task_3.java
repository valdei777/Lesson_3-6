import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        // 3.Найдите первое чётное число в массиве, которое больше 100

        // 1 2 3 4 5 6 7 8 9 1000 1002

        System.out.println("Введите 10 чисел: ");

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(words).map(s -> Integer.parseInt(s)).toList();

        for(int i : numbers) {
            if(i % 2 == 0) {
                if(i > 100) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
