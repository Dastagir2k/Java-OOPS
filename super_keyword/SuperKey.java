package super_keyword;

// Define a class named Father
class Father{
    // Declare a final instance variable 'age' with an initial value of 50
    final int age = 50;

    // Declare a final method 'print' that prints a message
    final void print() {
        System.out.println("Father Class");
    }
}

// Define a class named Son that extends Father
class Son extends Father {
    // Declare an instance variable 'age' with an initial value of 20
    int age = 20;

    // Define a method 'printt' to demonstrate the use of the 'super' keyword
    void printt() {
        // Use the 'super' keyword to access the 'age' variable from the superclass Father
        System.out.println(super.age); // This will print 50, the value of 'age' in the Father class
    }
}

// Define the main class
public class SuperKey {
    public static void main(String[] args) {
        // Create an instance of the Son class
        Son obj1 = new Son();

        // Call the 'printt' method on the instance of Son
        obj1.printt(); // This will output 50, demonstrating the use of 'super' to access the superclass variable
    }
}
