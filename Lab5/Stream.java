import java.io.*;

/**
 * @author vlad
 */
public class Stream {
    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double mass[][] = new double[361][2];
        one("sin.txt");
        two(mass, "sin.txt", "input.txt");
        three(mass, "sin2.dat");
        four(mass, "sin.txt");
    }

    /**
     *Создаем файл и заполняем его углами синуса
     *
     * @param fileName имя файла в который будут записаны синусы углов
     * @throws FileNotFoundException файл не найдет
     */
    public static void one(String fileName) throws FileNotFoundException {
        System.out.println("2.1");
        {
            PrintWriter writer = new PrintWriter(new File(fileName));
            for(int i = 0; i <= 360; i++) {
                writer.write(String.valueOf(i) + " ");
                writer.write(String.valueOf(Math.sin(i)) + "\n");
            }
            writer.flush();
            System.out.println("Запись OK!");
            writer.close();
        }
    }

    /**
     * Создаем массив и выводим угол из файла input.txt
     *
     * @param mass массив всех углов синусов
     * @param fileNameOne имя файла откуда читать
     * @param fileNameTwo имя файла с углом
     * @throws IOException ошибка при чтении из файла
     */
    public static void two(double mass[][], String fileNameOne, String fileNameTwo) throws IOException {
        System.out.println("2.2");
        {
            BufferedReader inReader = new BufferedReader(new FileReader(fileNameOne));
            int a = 0;
            while (inReader.ready()) {
                int b = 0;
                String[] temp = inReader.readLine().split(" ");
                mass[a][b++] = Integer.parseInt(temp[0]);
                mass[a++][b] = Double.parseDouble(temp[1]);
            }
            inReader = new BufferedReader(new FileReader(fileNameTwo));
            int number = Integer.parseInt(inReader.readLine());
            System.out.println(mass[number][0] + " " + mass[number][1]);
            inReader.close();
        }
    }

    /**
     * Сериализуем массив
     *
     * @param mass массив для записи
     * @param fileSin файл для сериализации
     * @throws IOException ошибка при чтении из файла или записи
     * @throws ClassNotFoundException класс не найден
     */
    public static void three(double mass[][], String fileSin) throws IOException, ClassNotFoundException {
        System.out.println("2.3");
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileSin));
            out.writeObject(mass);
            out.flush();
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileSin));
            double[][] newMass = (double[][]) in.readObject();
            in.close();
            for(int i = 0; i < 361; i++) {
                for(int j = 0; j < 2; j++) {
                    System.out.print(newMass[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Некторые проверки
     *
     * @param mass массив для экспериментов
     * @param fileName файл
     * @throws IOException ошибка при чтении или записи
     */
    public static void four(double mass[][], String fileName) throws IOException {
        System.out.println("2.4");
        {
            BufferedReader inReader = new BufferedReader(new FileReader(fileName));
            int count = 0;
            while (inReader.ready()) {
                if(inReader.readLine().length() % 2 == 0)
                    count++;
            }
            System.out.println("Количество четных строк: " + count);
            count = 0;
            for(int i = 0; i < 361; i++) {
                if(mass[i][1] < Math.round(mass[i][1]))
                    count++;
            }
            System.out.println("Количество чисел, у которых дробные части превышают 0,5: " + count);
        }
    }
}
