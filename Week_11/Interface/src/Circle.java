public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    /**
     * Constructor.
     * */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Getter and Setter.
     * */
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Caculate area of circle.
     * */
    @Override
    public double getArea() {
        return PI * this.getRadius() * this.getRadius();
    }

    /**
     * Caculate perimeter of circle.
     * */
    @Override
    public double getPerimeter() {
        return 2 * PI * this.getRadius();
    }

    /**
     * getInfo method.
     * */
    @Override
    public String getInfo() {
        return "Circle[("
                + String.format("%.2f", center.getPointX()) + ","
                + String.format("%.2f", center.getPointY()) + "),"
                + "r=" + String.format("%.2f", this.getRadius()) + "]";
    }
}
