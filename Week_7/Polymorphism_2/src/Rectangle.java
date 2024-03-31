import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;
    private static final double EPSILON = 0.001;

    /**
     * Constructor 1.
     * */

    public Rectangle() {}

    /**
     * Constructor 2.
     * */

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor 3.
     * */

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor 4.
     * */

    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    /**
     * Getter and Setter.
     * */
    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String getKey() {
        return "Rectangle[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY() + "),"
                + "width=" + width + ",length=" + length + "]";
    }

    /**
     * equals method.
     * */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;
        return Math.abs(rectangle.width - width) < EPSILON
                && Math.abs(rectangle.length - length) < EPSILON
                && Objects.equals(topLeft, rectangle.topLeft);
    }

    /**
     * hashCode method.
     * */
    public int hashCode() {
        return Objects.hash(super.hashCode(), topLeft, width, length);
    }

    /**
     * toString method.
     * */
    public String toString() {
        return "Rectangle[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY() + "),"
                + "width=" + getWidth() + ","
                + "length=" + getLength() + ","
                + "color=" + super.getColor() + ","
                + "filled=" + super.isFilled() + "]";
    }
}
