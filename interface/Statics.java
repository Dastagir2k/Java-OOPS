
class Fatherr{

    // Declare a static variable 'age' with an initial value of 50
    static int age = 50;

    // Declare an instance variable 'gender' with an initial value 'M'
    char gender = 'M';

    // Define a method to print a message
    void print() {
        System.out.println(" Father Class");
    }
}

// Define a class named Daughter that extends Fatherr
class Daughter extends Fatherr{
    
    // Uncommenting the below line will declare an instance variable 'age' for Daughter
    // int age = 22;

    // Declare an instance variable 'gender' with an initial value 'F'
    char gender = 'F';

    // Override the print method to print a different message
    void print() {
        System.out.println(" Daughter Class");
    }
}

// Define the main class
public class Statics {
    public static void main(String[] args) {
        // Access the static variable 'age' from the Daughter class and set its value to 30
        Daughter.age = 30;

        // Print the static variable 'age' from the Fatherr class
        System.out.println(Fatherr.age); // Output will be 30 because static variables are shared

        // Print the static variable 'age' from the Daughter class
        System.out.println(Daughter.age); // Output will also be 30 for the same reason

        // Uncommenting the below line will print " helloooooooooo"
        // System.out.println(" helloooooooooo");
    }
}
