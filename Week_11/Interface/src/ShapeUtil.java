import java.util.List;

public class ShapeUtil {
    /**
     * printInfo method.
     * */
    public String printInfo(List<GeometricObject> shapes) {
        StringBuilder result = new StringBuilder();
        result.append("Circle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result.append(shape.getInfo()).append("\n");
            }
        }
        result.append("Triangle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                result.append(shape.getInfo()).append("\n");
            }
        }
        return result.toString();
    }
}