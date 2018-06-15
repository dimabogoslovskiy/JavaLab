import java.io.*;
import java.util.*;

public class CollectionMy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /System.out.println("4.1");
        {
            Stack<String> stack = new Stack<>();
            BufferedReader inReader = new BufferedReader(new FileReader("stacks.txt"));
            while (inReader.ready()) {
                stack.push(inReader.readLine());
            }
            inReader.close();
            BufferedWriter outWrite = new BufferedWriter(new FileWriter("stacks.txt"));
            while (!stack.empty())
                outWrite.write(stack.pop() + "\n");
            outWrite.flush();
            outWrite.close();
            reader.readLine();
        }
        System.out.println("4.2");
        {
            Map<Integer, Integer> mapA = new HashMap<>();
            Map<Integer, Integer> mapB = new HashMap<>();
            System.out.print("Введите степень многочлена: ");
            int spet = Integer.parseInt(reader.readLine());
            System.out.print("A(x): a0 ");
            for(int i = 1; i <= spet; i++)
                System.out.print("+ a" + i + "*x^" + i + " ");
            System.out.println();
            for(int i = 0; i <= spet; i++) {
                System.out.print("a" + i + " = ");
                mapA.put(i, Integer.parseInt(reader.readLine()));
            }
            System.out.print("A(x) = " + mapA.get(0));
            for(int i = 1; i <= spet; i++) {
                System.out.print(" + " + mapA.get(i) + "x^" + i + " ");
            }
            System.out.println();

            System.out.print("B(x): b0 ");
            for(int i = 1; i <= spet; i++)
                System.out.print("+ b" + i + "*x^" + i + " ");
            System.out.println();
            for(int i = 0; i <= spet; i++) {
                System.out.print("b" + i + " = ");
                mapB.put(i, Integer.parseInt(reader.readLine()));
            }
            System.out.print("B(x) = " + mapB.get(0));
            for(int i = 1; i <= spet; i++) {
                System.out.print(" + " + mapB.get(i) + "x^" + i + " ");
            }
            System.out.println();
            System.out.print("Сумма многочленов равна: " + (mapA.get(0) + mapB.get(0)));
            for(int i = 1; i <= spet; i++)
                System.out.print(" + " + (mapA.get(i) + mapB.get(i)) + "x^" + i);
            System.out.println();

            Map<Integer, Integer> mapC = new TreeMap<>();
            for(int i = 0; i <= spet; i++) {
                for(int j = 0; j <= spet; j++) {
                    if(mapC.containsKey(i + j))
                        mapC.put(i + j, mapC.get(i + j) + (mapA.get(i) * mapB.get(j)));
                    else
                        mapC.put(i + j, mapA.get(i) * mapB.get(j));
                }
            }

            StringBuilder builder = new StringBuilder();
            for(Map.Entry<Integer, Integer> map : mapC.entrySet())
                builder.append(map.getValue()).append("x^").append(map.getKey()).append(" + ");
            System.out.println(builder.toString().substring(0, builder.toString().length() - 2));
            reader.readLine();
        }
        System.out.println("4.3");
        {
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            for(int i = 0; i < 10; i++)
                stack1.push(String.valueOf(i));
            for(int i = 10; i < 20; i++)
                stack2.push(String.valueOf(i));

            for(String s : stack1)
                System.out.print(s + " ");
            System.out.println();
            for(String s : stack2)
                System.out.print(s + " ");


            List<String> list = new ArrayList<>();
            while (!stack1.empty())
                list.add(stack1.pop());
            while (!stack2.empty())
                stack1.push(stack2.pop());
            for(int i = 0; i < list.size(); i++)
                stack2.push(list.get(i));

            System.out.println();
            for(String s : stack1)
                System.out.print(s + " ");
            System.out.println();
            for(String s : stack2)
                System.out.print(s + " ");
            reader.readLine();
        }
        System.out.println("4.4");
        {
            BufferedReader inReader = new BufferedReader(new FileReader("stacks.txt"));
            List<String> list = new ArrayList<>();
            while (inReader.ready())
                list.add(inReader.readLine().toLowerCase());
            System.out.print("Введите слово: ");
            String str = reader.readLine();
            if(list.contains(str.toLowerCase()))
                System.out.println("Слово содержится в списке " + str);
            reader.readLine();
        }
    }
}
