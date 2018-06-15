import java.util.Objects;

/**
* Класс Прямоугольник - базовый класс для прямоугольников
* @author Дима Богословский
 */
public class Rectangle implements Moveble{
    /**
     * Координаты левого верхнего угла
     */
    private int x1;
    private int y1;
    /**
     * Координат правого нижнего угла
     */
    private int x2;
    private int y2;
    /**
     * Устанавливает значения поля
     * @param x1 - задает значение по x
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * Конструктор принимает 4 параметра целого типа и присваивает их значения полям (x1, y1), (x2, y2)
     * @param x1 - координта х для левого верхнего угла
     * @param y1 - координта y для левого верхнего угла
     * @param x2 - координта х для правого нижнего угла
     * @param y2 - координта y для правого нижнего угла
     */
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Конструктор принимает 2 параметра целого типа – ширину и высоту прямоугольника,
     * а левый верхний угол прямоугольника помещает в координату (0,0)
     * @param width - ширина
     * @param height - высота
     */
    public Rectangle(int width, int height) {
        this(0,0, width, height);
    }

    /**
     * Конструктор не принимает никаких параметров – создает вырожденный прямоугольник с координатами углов (0,0) и (0,0)
     */
    public Rectangle() {
       this(0,0,0,0);
    }

    /**
     * Перемещающийся прямоугольник
     * @param dx - по х
     * @param dy - по y
     */
    @Override
    public void move(int dx, int dy) {
        this.x1 += dx; this.y1 += dy;
        this.x2 += dx; this.y2 += dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return x1 == rectangle.x1 &&
                y1 == rectangle.y1 &&
                x2 == rectangle.x2 &&
                y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x1, y1, x2, y2);
    }

    /**
     * Метод сравнивает два прямоугольника
     * @param rectangle1 - прямоугольник 1
     * @param rectangle2
     * @return меньший из прямоугольников
     */
    public static Rectangle minSquare(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.square() < rectangle2.square() ? rectangle1 : rectangle2;
    }

    private int square() {
        return Math.abs(this.x2 - this.x1) * Math.abs(this.y2 - this.y1);
    }

    /**
     *
     * @return состояние экземпляра прямоугольника (значение полей)
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Левый верхний угол: (").append(this.x1).append(", ").append(this.y1).append(")\n")
                .append("Правый нижный угол: (").append(this.x2).append(", ").append(this.y2).append(")");

        return builder.toString();
    }
}
