package SOLID;

//Derived classes should be substitutable for their base classes without altering the correctness of the program.
// The Liskov Substitution Principle (LSP) states that objects of a derived class should be able to replace objects of the base class without affecting the correctness of the program. This means that subclasses should behave in such a way that they can be used in place of their parent class without introducing errors.


class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Crow extends Bird {
    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }
}

public class liskovSubstitution {
    public static void main(String[] args) {
        Bird bird = new Sparrow();  // Liskov Substitution Principle holds as Sparrow is substituting for Bird
        bird.fly(); // Works fine

        bird = new Crow();
        bird.fly();
    }
}
