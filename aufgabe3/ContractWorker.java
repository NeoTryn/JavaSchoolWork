import java.util.ArrayList;

public class ContractWorker extends Worker{
    private float monthlyHours;
    private float hourlyWage;

    public ContractWorker(String name, String socSecurityNr, float monthlyHours, float hourlyWage) {
        super(name, socSecurityNr);
        setMonthlyHours(monthlyHours);
        setHourlyWage(hourlyWage);
    }

    public float getMonthlyHours() {
        return monthlyHours;
    }

    public void setMonthlyHours(float monthlyHours) {
        if (monthlyHours > 7.0f * 30.0f * 24.0f) {
            throw new RuntimeException("Monthly hours too high!");
        }
        else {
            this.monthlyHours = monthlyHours;
        }
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public float calcSalary() {
        return monthlyHours * hourlyWage;
    }

    @Override
    public String toString() {
        return super.toString() + ", monthlyHours: " + monthlyHours + ", hourlyWage: " + hourlyWage;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
