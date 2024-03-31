import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Layer {
    private List<Shape> shapes;

    public Layer() {
        shapes = new ArrayList<>();
    }

    /**
     * addShape method.
     * */
    public void addShape(Shape shape) {
        if (shapes != null) {
            shapes.add(shape);
        } else {
            // If shapes is null
            System.out.println("Error: shapes list is null.");
        }
    }

    /**
     * removeCircles method.
     * */
    public void removeCircles() {
        if (shapes != null) {
            shapes.removeIf(shape -> shape instanceof Circle);
        } else {
            // If shapes is null
            System.out.println("Error: shapes list is null.");
        }
    }

    /**
     * getInfo method.
     * */
    public String getInfo() {
        StringBuilder info = new StringBuilder("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(shape.toString()).append("\n");
        }
        return info.toString();
    }

    /**
     * removeDuplicates method.
     * */
    public void removeDuplicates() {
        if (shapes != null) {
            HashSet<String> uniqueShapes = new HashSet<>();
            List<Shape> result = new ArrayList<>();
            for (Shape currentShape : shapes) {
                String key = currentShape.getKey();
                if (!uniqueShapes.contains(key)) {
                    uniqueShapes.add(key);
                    result.add(currentShape);
                }
            }
            shapes = result;
        } else {
            System.out.println("Error: shapes list is null.");
        }
    }
}