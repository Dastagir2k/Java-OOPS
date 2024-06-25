package this_keyword;
import java.util.*;
class Father{
    char gender;
    int age;
    void print(char gender,int age){
        this.gender=gender;
        this.age=age;
    }
}


public class ThisKey {
    public static void main(String[] args) {
        Father f=new Father();
        f.print('M', 50);
        System.out.println(f.gender);
        System.out.println(f.age);
    }
}
