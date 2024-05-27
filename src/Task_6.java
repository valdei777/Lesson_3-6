public class Task_6 {
    public static void main(String[] args) {
        // 6.Выведите все даты невисокосного года. В январе 31 день, феврале -28, далее чередуется -в марте 31,
        // в апреле 30...

        String[] month = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        for(int i = 0; i < month.length; i++){
            if(i % 2 == 0) {
                if(i == 0) {
                    printDay( 31 ,month[i]);
                } else {
                    printDay(30, month[i]);
                }
            } else {
                if(i == 1) {
                    printDay( 28 ,month[i]);
                } else {
                    printDay( 31 ,month[i]);
                }
            }
        }
    }

    public static void printDay(int endDay, String moth){
        for(int i = 1; i <= endDay; i++) {
            System.out.println(moth + " " + i);
        }

    }
}
