
public class DrawRect extends Rectangle {
    private String outColor;

    public DrawRect(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public DrawRect(int width, int height) {
        super(width, height);
    }

    public void draw(String outColor) {
        this.outColor = outColor;
        System.out.println("Граница цвета: " + outColor);
    }
}
