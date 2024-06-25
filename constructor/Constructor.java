package constructor;
// Sample2 class with fields and a constructor
class Sample2 {
    // Fields (attributes) of the class
    int rollno;
    int age = 22;  // Default value assigned to age
    String name;

    // Constructor of the class
    Sample2() {
        // This message will be printed whenever an object of Sample2 is created
        System.out.println("hello it is working");
    }
}

public class Constructor {
    public static void main(String[] args) {
        // Creating first object of Sample2 class
        Sample2 obj = new Sample2();  // Constructor will be called and message will be printed
        // Creating second object of Sample2 class
        Sample2 obj2 = new Sample2(); // Constructor will be called again and message will be printed

        // Uncomment the lines below to print the values of the fields
        // System.out.println(obj.name); // Will print null as name is not initialized
        // System.out.println("hello");  // Will print "hello"
    }
}
