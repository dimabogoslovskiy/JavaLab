
public class ColoredRect extends DrawRect {
    private String inColor;

    public ColoredRect(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public ColoredRect(int width, int height) {
        super(width, height);
    }

    public void draw(String outColor, String inColor) {
        super.draw(outColor);
        this.inColor = inColor;
        System.out.println("внутренность – " + inColor);
    }
}
