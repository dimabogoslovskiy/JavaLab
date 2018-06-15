import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Rectangle rectangle1 = new Rectangle(0, 1, 5, -2);
        Rectangle rectangle2 = new Rectangle(4, -2);
        Rectangle rectangle3 = new Rectangle();
        System.out.println(rectangle1.toString());
        System.out.println(rectangle2.toString());
        System.out.println(rectangle3.toString());
        System.out.println();

        rectangle1.move(-1, 0);
        rectangle2.move(1, 1);
        rectangle3.move(3, 3);
        System.out.println(rectangle1.toString());
        System.out.println(rectangle2.toString());
        System.out.println(rectangle3.toString());
        System.out.println();

        System.out.println(Rectangle.minSquare(rectangle1, rectangle2));
        System.out.println();

        ColoredRect coloredRect = new ColoredRect(0, 1, 5, -2);
        System.out.println(coloredRect.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        coloredRect.draw(reader.readLine(), reader.readLine());
    }
}
