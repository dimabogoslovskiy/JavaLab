import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Laba2 {

    public static void main(String[] args) throws IOException {
        /*System.out.println("Задача 1");
        {
            double result = 1;
            boolean op = false;
            for(int i = 2; i <= 10000; i++) {
                if(op) {
                    result += 1.0/i;
                    op = false;
                }
                else {
                    result -= 1.0/i;
                    op = true;
                }
            }
            System.out.println(result);
        }
        System.out.println("Задача 2");
        {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "ноль");
            map.put(1, "один");
            map.put(2, "два");
            map.put(3, "три");
            map.put(4, "четыре");
            map.put(5, "пять");
            map.put(6, "шесть");
            map.put(7, "семь");
            map.put(8, "восемь");
            map.put(9, "девять");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ведите число 0 - 9");
            int n = Integer.parseInt(reader.readLine());
            if(n < 0 || n >= 10)
                System.out.println("Ошибка");
            else {
                for (Map.Entry<Integer, String> m : map.entrySet()) {
                    if (m.getKey() == n)
                        System.out.println(m.getValue());
                }
            }
        }*/
        System.out.println("Задача 3");
        {
            /*Map<Integer, String> map = new HashMap<>();
            map.put(0, "ноль");
            map.put(1, "один");
            map.put(2, "два");
            map.put(3, "три");
            map.put(4, "четыре");
            map.put(5, "пять");
            map.put(6, "шесть");
            map.put(7, "семь");
            map.put(8, "восемь");
            map.put(9, "девять");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ведите слово 0 - 9");
            String n = reader.readLine();
                for (Map.Entry<Integer, String> m : map.entrySet()) {
                    if (m.getValue().equals(n))
                        System.out.println(m.getKey());
                }*/
            String[][] mass = new String[10][2];
            for(int i = 0; i < 10; i++)
                mass[i][0] = String.valueOf(i);
            mass[0][1] = "ноль";
            mass[1][1] = "один";
            mass[2][1] = "два";
            mass[3][1] = "три";
            mass[4][1] = "четыре";
            mass[5][1] = "пять";
            mass[6][1] = "шесть";
            mass[7][1] = "семь";
            mass[8][1] = "восемь";
            mass[9][1] = "девять";
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            for(int i = 0; i < 10; i++) {
                if(str.equals(mass[i][1])) {
                    System.out.println(mass[i][0]);
                    break;
                }
            }
        }
        System.out.println("Задача 4");
        {
            int[] A = new int[25];
            for(int i = 0; i < A.length; i++) {
                A[i] = (int)(Math.random() * 100);
            }
            System.out.println(Arrays.toString(A));
            int min = mixX(A);
            int max = maxX(A);
            for(int i = 0; i < A.length; i++) {
                if(A[i] == min)
                    A[i] = max;
                else if(A[i] == max)
                    A[i] = min;
            }
            System.out.println(Arrays.toString(A));
            System.out.println(min);
            System.out.println(max);
        }
        System.out.println("Задача 5");
        {
            int[] A = new int[25];
            for(int i = 0; i < A.length; i++) {
                A[i] = (int)(Math.random() * 10);
            }
            System.out.println(Arrays.toString(A));
            Arrays.sort(A);
            System.out.println(Arrays.toString(A));
        }
        System.out.println("Задача 6");
        {
            int[] A = new int[20];
            for(int i = 0; i < A.length; i++) {
                A[i] = (int)(Math.random() * 10);
            }
            double s = 0;
            for(int i = 0; i < A.length; i++) {
                s += A[i];
            }
            System.out.println(Arrays.toString(A));
            System.out.println(s / A.length);
        }
        System.out.println("Задача 7");
        {
            int[] A = new int[30];
            for(int i = 0; i < A.length; i++) {
                A[i] = (int)(Math.random() * 10);
            }
            int sumChet = 0;
            int sumNechet = 0;
            for(int i = 0; i < A.length; i++) {
                if(A[i] % 2 == 0)
                    sumChet++;
                else {
                    sumNechet++;
                }
            }
            System.out.println(Arrays.toString(A));
            System.out.println(sumChet);
            System.out.println(sumNechet);
        }
        System.out.println("Задача 8");
        {
            int a[][] = new int[3][5];
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 5; j++) {
                    a[i][j] = (int)(Math.random() * 10);
                }
            }

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 5; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Задача 9");
        {
            System.out.println("Ведите 5 строк: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s1 = reader.readLine();
            String s2 = reader.readLine();
            String s3 = reader.readLine();
            String s4 = reader.readLine();
            String s5 = reader.readLine();
            if(s4.equals(s5))
                System.out.println(s1 + s2);
            else
                System.out.println(s1 + s3);
        }
    }

    public static int maxX(final int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(max < a[i])
                max = a[i];
        }
        return max;
    }

    public static int mixX(final int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(max > a[i])
                max = a[i];
        }
        return max;
    }
}
