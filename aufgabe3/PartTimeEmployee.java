public class PartTimeEmployee extends Employee{
    private static final float MIN_PARTTIME_HOURS = 10.0f;
    private static final float MAX_PARTTIME_HOURS = 30.0f;
    private float weeklyHours;

    public PartTimeEmployee(String name, String socSecurityNr, float salary, float WeeklyHours) {
        super(name, socSecurityNr, salary);
        setWeeklyHours(weeklyHours);
    }

    public float getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(float weeklyHours) {
        if (weeklyHours > 7.0f * 24.0f) {
            throw new RuntimeException("Weekly hours too high!");
        }
        else {
            this.weeklyHours = weeklyHours;
        }
    }

    public float calcSalary() {
        return salary * weeklyHours / STD_WEEKLY_HOURS;
    }

    @Override
    public String toString() {
        return super.toString() + ", weeklyHours: " + weeklyHours;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
