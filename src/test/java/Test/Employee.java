package Test;

public abstract class Employee {

    protected String name;
    protected  String id;
    protected String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }


    abstract void showEmpDetails();

}



