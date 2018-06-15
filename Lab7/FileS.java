import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileS extends Thread {
    private BufferedReader reader;
    private String word;

    public FileS(String fileName, String word) throws FileNotFoundException {
        super(fileName);
        this.reader = new BufferedReader(new FileReader(fileName));
        this.word = word;
        start();
    }

    @Override
    public void run() {
        try {
            while (reader.ready()) {
                String[] temp = reader.readLine().split(" ");
                for(String s : temp) {
                    if(s.contains(word)) {
                        new SearchResult(getName(), s, s.indexOf(word) + 1);
                    }
                }
            }
        } catch (IOException e) {

        }
    }
}
