package SOLID;
//Clients should not be forced to implement interfaces they do not use. It's better to create smaller, specific interfaces.
//interface segrigation principal
//if we had worker interface than worker should have to implemented everything, but robots dont eat
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}

public class isp {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        human.work();
        human.eat();

        robot.work();
        // robot does not need to eat!
    }
}
