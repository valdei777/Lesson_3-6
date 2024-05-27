import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        // 4.Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм (что б узнать, заглавная ли буква,
        // используйте Character.isUpperCase(letter) )


        System.out.println("Введите предложение со СлОвАмИ в ВиДе ЗаБоРчИкА: ");

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        boolean flag = false;
         for (int i = words.length - 1; i >= 0; i--) {

             char[] letter = words[i].toCharArray();

             for(int j = 0; j < letter.length - 1; j++) {
                 if(Character.isUpperCase(letter[j])) {
                     if (Character.isUpperCase(letter[j + 1])) {
                         break;
                     }
                 } else {
                     if (Character.isLowerCase(letter[j + 1])) {
                         break;
                     }
                 }
                 if(j == letter.length - 2) {
                     flag = true;
                 }
             }

             if(flag == true) {
                 System.out.println(words[i]);
                 break;
             }

         }
    }
}

