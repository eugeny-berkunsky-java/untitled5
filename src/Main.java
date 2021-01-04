import containingObjects.hr.Department;
import containingObjects.hr.Employee;
import containingObjects.hr.HR;

public class Main {

    public static void main(String[] args) {
        Department dept = new Department("CS", 10);
        Employee e = new Employee("Ivan", "123");
        dept.addEmployee(e);
        dept.addEmployee(new Employee("Petr", "222"));
        System.out.println(dept);
        HR hr = new HR(10, 10);
        hr.addDepartment("TTT", 10);
        hr.addDepartment("UUU", 10);
        Department ttt = hr.getDepartmentByName("TTU");
        System.out.println(ttt);
        hr.addEmployee(e, "TTT");
    }
}
