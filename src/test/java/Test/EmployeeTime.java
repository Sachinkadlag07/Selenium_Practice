package Test;

public class EmployeeTime extends Employee {

    String time ;

    public EmployeeTime(String name , String id, String department,String time){
        super(name,id,department);
        this.time = time;
    }


    @Override
    void showEmpDetails() {
        System.out.println("Employee Details "+name+" "+id+" "+department+" "+time);
    }

    public static void main(String[] args) {
    EmployeeTime empTime = new EmployeeTime("sachin", "A001","QA","9am-6pm");
        empTime.showEmpDetails();
    }
}
