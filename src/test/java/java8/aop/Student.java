package java8.aop;

/**
 * 1/10/23 15:30
 * aiguoxin 
 * 说明:
 */
public class Student {
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    String name;


    public String hello(){
        return name;
    }
}
