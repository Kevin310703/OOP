public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3, 5);
        System.out.println("Volume of the cylinder: " + cylinder.getVolume());
        System.out.println("Area of the cylinder: " + cylinder.getArea());
        System.out.println(cylinder.toString());
    }
}