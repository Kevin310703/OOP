import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * Constructor.
     * */

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /**
     * Getter and Setter.
     * */

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * distance method.
     * */
    public double distance(Point newPoint) {
        double deltaX = newPoint.getPointX() - this.pointX;
        double deltaY = newPoint.getPointY() - this.pointY;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
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

        Point point = (Point) o;
        return Double.compare(point.pointX, pointX) == 0
                && Double.compare(point.pointY, pointY) == 0;
    }

    /**
     * hashCode method.
     * */
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    /**
     * toString method.
     * */
    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}
