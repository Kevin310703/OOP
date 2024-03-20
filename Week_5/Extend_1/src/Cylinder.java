public class Cylinder extends Circle {
    private double height;

    /**
     * Constructor.
     * */

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    /**
     * Getter and Setter.
     * */

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * getHeight();
    }

    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }

    public double getArea() {
        return 2 * PI * getRadius() * (getRadius() + getHeight());
    }


}
