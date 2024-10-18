package SOLID;
// Software entities should be open for extension but closed for modification. This means that you should be able to add new functionality without changing existing code.

// Step 1: Define the interface
interface Saver {
    void save(String data);
}
public class OpenClose {
    public static void main(String[] args) {
        // Create different saver objects
        Saver dbSaver = new DBSaver();
        Saver fileSaver = new FileSaver();
        Saver cloudSaver = new CloudSaver();

        // Use each saver to save data
        String data = "Important Data";
        
        dbSaver.save(data);       // Saving data to the database
        fileSaver.save(data);     // Saving data to a file
        cloudSaver.save(data);    // Saving data to the cloud
    }
}
// Step 2: Create a class that saves to a database
class DBSaver implements Saver {
    @Override
    public void save(String data) {
        // Simulating saving data to a database
        System.out.println("Saving data to the database: " + data);
    }
}

// Step 3: Create a class that saves to a file
class FileSaver implements Saver {
    @Override
    public void save(String data) {
        // Simulating saving data to a file
        System.out.println("Saving data to a file: " + data);
    }
}

// Step 4: Add new saver types without modifying existing classes
// For example, adding CloudSaver:
class CloudSaver implements Saver {
    @Override
    public void save(String data) {
        // Simulating saving data to a cloud storage
        System.out.println("Saving data to the cloud: " + data);
    }
}

// Step 5: Demonstrate in the main class
