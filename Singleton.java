public class Singleton {
    // Step 1: Create a private static instance of the class
    private static Singleton instance;

    // Step 2: Private constructor to prevent instantiation
    private Singleton() {
        // Optional: Prevent reflection attacks
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Step 3: Public static method to provide access to the instance
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello, this is the Singleton instance!");
    }
}
