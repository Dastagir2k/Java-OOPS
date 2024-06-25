package inheritance;
//static int age=5;
class Animal{
    static String name="balaji";
    static  void display(){
        name="srini";
//        static int age=5;
        System.out.println("Gelelel");

    }

    private int legs=4;
    void eat(){
        System.out.println(name);
        System.out.println(name);
        System.out.println("I am eating");
    }
}

class Lion extends Animal {
   
}

public class Inheritance {
    public static void main(String[] args) {
//        Lion obj=new Lion();
//        System.out.println(obj.legs);
//        System.out.println(Animal.name);
//        Animal.display();
//        obj.eat();
//        System.out.println(age);
        Animal a=new Animal();
        a.eat();
    }
}
