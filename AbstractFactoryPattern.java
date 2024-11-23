// Abstract Factory Pattern Example
public class AbstractFactoryPattern {

    // Step 1: Shape interface
    interface Shape {
        void draw();
    }

    // Circle class implementing Shape
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    // Rectangle class implementing Shape
    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    // Step 2: Abstract Factory for Shapes
    interface ShapeFactory {
        Shape createCircle();

        Shape createRectangle();
    }

    // RedShapeFactory creates red-themed shapes
    static class RedShapeFactory implements ShapeFactory {
        @Override
        public Shape createCircle() {
            return new RedCircle();
        }

        @Override
        public Shape createRectangle() {
            return new RedRectangle();
        }

        // Red Circle
        static class RedCircle extends Circle {
            @Override
            public void draw() {
                System.out.println("Drawing a Red Circle");
            }
        }

        // Red Rectangle
        static class RedRectangle extends Rectangle {
            @Override
            public void draw() {
                System.out.println("Drawing a Red Rectangle");
            }
        }
    }

    // BlueShapeFactory creates blue-themed shapes
    static class BlueShapeFactory implements ShapeFactory {
        @Override
        public Shape createCircle() {
            return new BlueCircle();
        }

        @Override
        public Shape createRectangle() {
            return new BlueRectangle();
        }

        // Blue Circle
        static class BlueCircle extends Circle {
            @Override
            public void draw() {
                System.out.println("Drawing a Blue Circle");
            }
        }

        // Blue Rectangle
        static class BlueRectangle extends Rectangle {
            @Override
            public void draw() {
                System.out.println("Drawing a Blue Rectangle");
            }
        }
    }

    // Step 3: FactoryProducer to get factories
    static class FactoryProducer {
        public static ShapeFactory getFactory(String color) {
            switch (color.toLowerCase()) {
                case "red":
                    return new RedShapeFactory();
                case "blue":
                    return new BlueShapeFactory();
                default:
                    throw new IllegalArgumentException("Unknown factory type: " + color);
            }
        }
    }

    // Main method to test Abstract Factory Pattern
    public static void main(String[] args) {
        // Get Red Shape Factory
        ShapeFactory redFactory = FactoryProducer.getFactory("red");
        Shape redCircle = redFactory.createCircle();
        Shape redRectangle = redFactory.createRectangle();
        redCircle.draw(); // Output: Drawing a Red Circle
        redRectangle.draw(); // Output: Drawing a Red Rectangle

        // Get Blue Shape Factory
        ShapeFactory blueFactory = FactoryProducer.getFactory("blue");
        Shape blueCircle = blueFactory.createCircle();
        Shape blueRectangle = blueFactory.createRectangle();
        blueCircle.draw(); // Output: Drawing a Blue Circle
        blueRectangle.draw(); // Output: Drawing a Blue Rectangle
    }
}
