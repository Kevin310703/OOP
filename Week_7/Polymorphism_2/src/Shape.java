public abstract class Shape {
    protected String color;
    protected boolean filled;

    /**
     * Constructor.
     * */

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Getter and Setter.
     * */

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String getKey();

    public String toString() {
        return "Shape[color=" + getColor() + ", "
                + "filled=" + isFilled() + "]";
    }
}
