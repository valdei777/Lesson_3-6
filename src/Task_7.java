import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_7 {
    public static void main(String[] args) {
        // 7.Сохраняйте снимки NASA с1 января того момента, пока в поле Explanation нет слова “Earth”
        String[] dates = generatorDate();

        for (String date : dates) {
            String page = downloadPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2022-"+ date);

            int startIndexExplanation = page.indexOf("explanation") + 14;
            int endIndexExplanation = page.indexOf("hdurl") - 3;
            String explanation = page.substring(startIndexExplanation, endIndexExplanation);

            int urlBegin = page.lastIndexOf("url") + 6;
            int urlEnd = page.lastIndexOf("}") - 1;
            String url = page.substring(urlBegin, urlEnd);

            if (explanation.contains("Earth ")) {
                System.out.println(explanation);
                System.exit(0);
            } else {
                saveFile(url, date);
                System.out.println(url);
            }
        }
    }

    public static String[] generatorDate () {

        StringBuilder temp = new StringBuilder();

        for(int i = 1; i < 13; i++) {
            String[] day;
            if(i % 2 == 0) {
                if(i == 2) {
                    day = getDay( 28);
                } else {
                    day = getDay(31);
                }
            } else {
                if(i == 1) {
                    day = getDay( 31);
                } else {
                    day = getDay( 30);
                }
            }

            for (String j : day) {
                if (i < 10) {
                    temp.append("0" + i + "-" + j + " ");
                } else {
                    temp.append(i + "-" + j + " ");

                }
            }
        }

        String temp1 = temp.toString();

        String[] date = temp1.split(" ");


        return date;
    }

    public static String[] getDay(int endDay){
        String[] x = new String[endDay];
        for(int i = 0; i <= endDay - 1; i++) {
            if(i < 9) {
                x[i] = "0" + (i + 1);
            } else {
                x[i] = String.valueOf((i + 1));
            }
        }
        return x;
    }

    public static void saveFile (String url, String name){
        try (InputStream stream = new URL(url).openStream()) {
            Files.copy(stream, Paths.get(name + ".jpg"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String downloadPage (String url){
        StringBuilder page = new StringBuilder();
        String line;


        try {
            URLConnection connection = new URL(url).openConnection();
            try (InputStream is = connection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while((line = br.readLine()) != null) {
                    page.append(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return page.toString();
    }
}
