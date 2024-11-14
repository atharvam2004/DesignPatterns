package decoartor;

public class PizzaDecoratorPattern {
    public static void main(String[] args) {
        // Start with a base pizza
        Pizza myPizza = new ThinCrustPizza();
        
        // Add toppings
        myPizza = new CheeseTopping(myPizza);
        myPizza = new OlivesTopping(myPizza);

        // Print the final pizza details
        System.out.println("Description: " + myPizza.getDescription());
        System.out.println("Total Cost: " + myPizza.getCost());
    }
}
