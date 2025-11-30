package Test;

public class Dog implements Animal {

    @Override
    public void sound(){
        System.out.println("Woof");
    }

    @Override
    public void eat(){
        System.out.println("Dog is eating");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.eat();
    }
}
