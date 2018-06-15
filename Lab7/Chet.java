import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chet extends Thread {
    private BufferedReader reader;
    private List<String> list = new ArrayList<>();

    public Chet(String fileName) throws FileNotFoundException {
        super(fileName);
        reader = new BufferedReader(new FileReader(fileName));
        start();
    }

    @Override
    public void run() {
        try {
            while (reader.ready()) {
                String[] temp = reader.readLine().split(" ");
                Collections.addAll(list, temp);
            }
            for(int i = 1; i < list.size(); i += 2) {
                System.out.println("Файл: " + getName() + " слово: " + list.get(i));
            }
        } catch (IOException e) {

        }
    }
}
