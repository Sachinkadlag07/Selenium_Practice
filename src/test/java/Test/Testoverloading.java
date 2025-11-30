package Test;

public class Testoverloading {

   public class A {

        void m1(){
            System.out.println("m1 A");
        }
    }

   public class B extends A {

        void m1()

        {
            System.out.println ("m1 B overriden");
        }

        void m2 ()

        {
            System.out.println ("m2 B");
        }


    }

    public static void main(String[] args) {
       // B b = new B();
        // a.m1();
        // a.m2();

    }
}


