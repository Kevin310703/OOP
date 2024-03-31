import java.util.Objects;

public class Square extends Rectangle {
    private static final double EPSILON = 0.001;

    /**
     * Constructor.
     * */
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double side) {
        super.setLength(length);
        super.setWidth(length);
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

        Square square = (Square) o;
        return Math.abs(square.width - width) < EPSILON
                && Math.abs(square.length - length) < EPSILON
                && Objects.equals(topLeft, square.topLeft);
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
        return "Square[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY() + "),"
                + "side=" + getSide() + ","
                + "color=" + super.getColor() + ","
                + "filled=" + super.isFilled() + "]";
    }
}
