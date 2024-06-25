package final_Keyword;
class Father{
    final int age=50;
    
    // final is the keyword it is constant we cannot override or update it
    final void print(){
        System.out.println("Father Class");
    }
    

}

class Son extends Father{
    int age=20;
    // Here we  Cannot override the final method from FatherJava void print()
    void printt(){
        System.out.println("Son Class");
    }
}

public class Finals {
    public static void main(String[] args) {
        Father obj1=new Father();
        obj1.print();
    }
}
