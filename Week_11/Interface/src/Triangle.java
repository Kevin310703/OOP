public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Constructor have exception.
     * */
    public Triangle(Point p1, Point p2, Point p3) {
        // Check for duplicate points
        if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
            throw new RuntimeException("Two or more points are the same.");
        }

        // Check for collinear points
        if (isCollinear(p1, p2, p3)) {
            throw new RuntimeException("Points are collinear.");
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * Getter p1, p2, p3.
     * */
    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    /**
     * Tinh dien tich tam giac can.
     * */
    @Override
    public double getArea() {
        return Math.abs((p1.getPointX() * (p2.getPointY() - p3.getPointY())
                + p2.getPointX() * (p3.getPointY() - p1.getPointY())
                + p3.getPointX() * (p1.getPointY() - p2.getPointY())) / 2.0);
    }

    /**
     * Tinh chu vi tam gia can.
     * */
    @Override
    public double getPerimeter() {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        return side1 + side2 + side3;
    }

    /**
     * getInfo method.
     * */
    @Override
    public String getInfo() {
        return "Triangle["
                + "(" + String.format("%.2f", p1.getPointX()) + ","
                + String.format("%.2f", p1.getPointY()) + "),"
                + "(" + String.format("%.2f", p2.getPointX()) + ","
                + String.format("%.2f", p2.getPointY()) + "),"
                + "(" + String.format("%.2f", p3.getPointX()) + ","
                + String.format("%.2f", p3.getPointY()) + ")]";
    }

    /**
     * Method to check if three points are collinear.
     * */
    private boolean isCollinear(Point p1, Point p2, Point p3) {
        return (p2.getPointY() - p1.getPointY()) * (p3.getPointX() - p2.getPointX())
                == (p3.getPointY() - p2.getPointY()) * (p2.getPointX() - p1.getPointX());
    }
}