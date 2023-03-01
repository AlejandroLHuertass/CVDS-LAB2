package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.Triangle;
import edu.eci.cvds.patterns.shapes.concrete.Quadrilateral;
import edu.eci.cvds.patterns.shapes.concrete.Pentagon;
import edu.eci.cvds.patterns.shapes.concrete.Hexagon;
import javax.management.PersistentMBean;

public class ShapeFactory {
    public static Shape create (RegularShapeType type) {
        switch (type) {
            case Hexagon:
                return new Hexagon();
            case Pentagon:
                return new Pentagon();
            case Quadrilateral:
                return new Quadrilateral();
            case Triangle:
                return new Triangle();
            default:
                throw new IllegalArgumentException();
        }
    }
}