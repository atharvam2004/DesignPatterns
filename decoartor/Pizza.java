// PizzaDecoratorPattern.java
package decoartor;

// Pizza Interface
public abstract class Pizza {
    abstract String getDescription();
    abstract double getCost();
}

// Concrete Pizza Bases
class ThinCrustPizza extends Pizza {
    @Override
    public String getDescription() {
        return "Thin Crust Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}

class ThickCrustPizza extends Pizza {
    @Override
    public String getDescription() {
        return "Thick Crust Pizza";
    }

    @Override
    public double getCost() {
        return 250.00;
    }
}

// Abstract Topping Decorator (No `super` usage)
abstract class ToppingDecorator extends Pizza {
    protected Pizza pizza; // Reference to the pizza being decorated
}

// Concrete Topping Decorators
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        this.pizza = pizza; // Assign pizza directly without super
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.00;
    }
}

class OlivesTopping extends ToppingDecorator {
    public OlivesTopping(Pizza pizza) {
        this.pizza = pizza; // Assign pizza directly without super
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.00;
    }
}
