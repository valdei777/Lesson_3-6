public class Task_5 {
    public static void main(String[] args) {
        // 5.Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 (пример такого числа -875)


        int x = 1;

        while(true) {
            int sum = 0;
            String str = String.valueOf(x);
            char[] digit = str.toCharArray();
            for (char i : digit) {
                sum += Integer.parseInt(String.valueOf(i));
            }
            if(sum >= 20) {
                System.out.println(x);
                break;
            } else {
                System.out.println(x);
                x++;
            }

        }
    }
}
