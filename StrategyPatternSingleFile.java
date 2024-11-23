//Make Inner Classes static
//Making the inner classes static removes their dependency on an instance of
// the enclosing class. This allows you to instantiate them directly in the main() method.


//OR


// StrategyPatternSingleFile strategy = new StrategyPatternSingleFile();
// Vehicle sportsCar = strategy.new Sports(); // This is required for non-static inner classes

public class StrategyPatternSingleFile {

    // Strategy interface
    interface DriveStrategy {
        void drive();
    }

    // Concrete strategy for normal driving
    static class NormalDrive implements DriveStrategy {
        @Override
        public void drive() {
            System.out.println("Driving normally...");
        }
    }

    // Concrete strategy for special driving
    static class SpecialDrive implements DriveStrategy {
        @Override
        public void drive() {
            System.out.println("Driving with special mode...");
        }
    }

    // Abstract Vehicle class
    static class Vehicle {
        private DriveStrategy driveStrategy;

        // Constructor to initialize driving strategy
        public Vehicle(DriveStrategy driveStrategy) {
            this.driveStrategy = driveStrategy;
        }

        // Perform the driving action
        public void performDrive() {
            driveStrategy.drive();
        }
    }

    // Sports vehicle uses SpecialDrive
    static class Sports extends Vehicle {
        public Sports() {
            super(new SpecialDrive());
        }
    }

    // Passenger vehicle uses NormalDrive
    static class Passenger extends Vehicle {
        public Passenger() {
            super(new NormalDrive());
        }
    }

    // Goods vehicle uses NormalDrive
    static class Goods extends Vehicle {
        public Goods() {
            super(new NormalDrive());
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Vehicle sportsCar = new Sports();
        sportsCar.performDrive(); // Output: Driving with special mode...

        Vehicle passengerCar = new Passenger();
        passengerCar.performDrive(); // Output: Driving normally...

        Vehicle goodsTruck = new Goods();
        goodsTruck.performDrive(); // Output: Driving normally...
    }
}
