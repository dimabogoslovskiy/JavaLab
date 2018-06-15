import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Laba7 {

    public static void main(String[] args) throws IOException, InterruptedException {
        /*System.out.println("2.1");
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Пропорциональных последовательности чисел желаете ввести");
            System.out.println("Для завершения ведите \"end\"");
            long a = Long.parseLong(reader.readLine());
            long b = Long.parseLong(reader.readLine());
            for(; a<=b; a++)
                new Prostora(a);
            reader.readLine();
        }*/
        System.out.println("2.2");
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите подстроку: ");
            String str = reader.readLine();
            for(String s : args)
                new FileS(s, str);
            reader.readLine();
        }
        /*System.out.println("2.3");
        {
            for(String s : args)
                new Chet(s);
            Thread.sleep(1000);
        }*/
    }
}
