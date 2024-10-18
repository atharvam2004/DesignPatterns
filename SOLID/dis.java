package SOLID;
//class should depend on interface rahter than concrete class
//dependancy inversion principal

interface Keyboard {
    void type();
}

class WiredKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing with wired keyboard");
    }
}

class WirelessKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing with wireless keyboard");
    }
}

class Computer {
    private Keyboard keyboard;//taken interface rather than concrete class so we can pass any class wired or wireless

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void startTyping() {
        keyboard.type();
    }
}

public class dis {
    public static void main(String[] args) {
        Keyboard wiredKeyboard = new WiredKeyboard();
        Computer pc = new Computer(wiredKeyboard);
        pc.startTyping(); // Typing with wired keyboard

        Keyboard wirelessKeyboard = new WirelessKeyboard();
        Computer laptop = new Computer(wirelessKeyboard);
        laptop.startTyping(); // Typing with wireless keyboard
    }
}
