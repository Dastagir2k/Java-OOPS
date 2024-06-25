// Abstract class Computer that contains both abstract and non-abstract methods
abstract class Computer {
    // Abstract method Turnoff, which must be implemented by any subclass
    abstract void Turnoff();

    // Non-abstract method TurnOn with a concrete implementation
    void TurnOn() {
        System.out.println("Turning On");
    }
}

// HP class extends the abstract Computer class and provides implementation for the abstract method Turnoff
class HP extends Computer {
    @Override
    void Turnoff() {
        System.out.println("Turning off");
    }
}

// Dell class extends the abstract Computer class and provides implementation for the abstract method Turnoff
class Dell extends Computer {
    @Override
    void Turnoff() {
        System.out.println("Turning off");
    }
}

// Main class to test the functionality of the abstract class and its subclasses
public class Abstract {
    public static void main(String[] args) {
        // Create an instance of HP class
        HP obj1 = new HP();
        // Call the implemented Turnoff method
        obj1.Turnoff();
        // Call the inherited TurnOn method
        obj1.TurnOn();

        // Create an instance of Dell class
        Dell obj2 = new Dell();
        // Call the implemented Turnoff method
        obj2.Turnoff();
        // Call the inherited TurnOn method
        obj2.TurnOn();
    }
}
