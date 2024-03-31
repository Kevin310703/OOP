import java.util.Objects;

public class Circle extends Shape {
    protected Point center;
    protected double radius;
    private static final double EPSILON = 0.001;

    /**
     * Constructor.
     * */
    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Constructor full parameter.
     * */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
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


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getKey() {
        return "Circle[center=(" + center.getPointX() + "," + center.getPointY() + "),"
                + "radius=" + radius + "]";
    }

    /**
     * toString method.
     * */
    public String toString() {
        return "Circle[center=(" + center.getPointX() + "," + center.getPointY() + "),"
                + "radius=" + radius + ","
                + "color=" + super.getColor() + ","
                + "filled=" + super.isFilled() + "]";
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

        Circle circle = (Circle) o;
        return Math.abs(circle.radius - radius) < EPSILON
                && Objects.equals(center, circle.center);
    }

    /**
     * hashCode method.
     * */
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius);
    }
}
