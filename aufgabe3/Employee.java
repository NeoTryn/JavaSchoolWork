import java.util.ArrayList;

public class Employee extends Worker{
    protected float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee(String name, String socSecurityNr, float salary) {
        super(name, socSecurityNr);
        setSalary(salary);
    }

    public Employee() {
        super("John Doe", "694201337");
        setSalary(1500.0f);
    }

    @Override
    public float calcSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + salary;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
