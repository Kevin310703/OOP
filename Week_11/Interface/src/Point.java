public class Point {
    private double pointX;
    private double pointY;

    /**
     * Constructor.
     * */
    public Point(double x, double y) {
        this.pointX = x;
        this.pointY = y;
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
     * Ham tinh khoang cach.
     * */
    public double distance(Point other) {
        double deltaX = this.pointX - other.getPointX();
        double deltaY = this.pointY - other.getPointY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
