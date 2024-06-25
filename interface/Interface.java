// Define the first interface 'father'
interface father {
    // Abstract methods that must be implemented by any class that implements this interface
    void call();
    void talking();
}

// Define the second interface 'Mother'
interface Mother {
    // Abstract methods that must be implemented by any class that implements this interface
    void call();
    void talking();
}

// Class 'Son' implements both 'father' and 'Mother' interfaces
// This demonstrates multiple inheritance through interfaces
class Son implements father, Mother {
    // Implementing the 'call' method from both 'father' and 'Mother' interfaces
    @Override
    public void call() {
        System.out.println("Calling");
    }

    // Implementing the 'talking' method from both 'father' and 'Mother' interfaces
    @Override
    public void talking() {
        System.out.println("Talking");
    }
}

// Main class to test the implementation of interfaces and multiple inheritance
public class Interface {
    public static void main(String[] args) {
        // Creating an instance of the 'Son' class
        Son s = new Son();

        // Calling the 'call' method of the 'Son' class
        s.call();

        // Calling the 'talking' method of the 'Son' class
        s.talking();
    }
}
