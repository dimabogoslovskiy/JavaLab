public class SearchResult extends Thread {
    private String fileName;
    private int index;
    private String word;

    public SearchResult(String fileName, String word, int index) {
        this.fileName = fileName;
        this.word = word;
        this.index = index;
        start();
    }

    @Override
    public void run() {
        System.out.println("Имя файла: " + fileName + " слово: " + word + " индекс вхождения: " + index);
    }
}
