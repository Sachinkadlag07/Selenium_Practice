package Test;

public class cat implements Animal {

    @Override
    public void sound() {
        System.out.println("Meow");
    }

    @Override
    public void eat(){
        System.out.println("cat is eating");


}

    public static void main(String[] args) {
        cat cat = new cat();
        cat.eat();
        cat.sound();
        System.out.println(cat.age);


    }


    }



