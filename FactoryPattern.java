// Factory Pattern Example
public class FactoryPattern {

    // Shape interface
    interface Shape {
        void draw();
    }

    // Circle class implementing Shape interface
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    // Rectangle class implementing Shape interface
    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    // Factory method to get a shape
    public static Shape getShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }

    // Main method to test the Factory Pattern
    public static void main(String[] args) {
        Shape circle = getShape("circle");
        circle.draw(); // Output: Drawing a Circle

        Shape rectangle = getShape("rectangle");
        rectangle.draw(); // Output: Drawing a Rectangle

        // Uncommenting the following line will throw an exception
        // Shape unknown = ShapeFactory.getShape("triangle");
    }
}
