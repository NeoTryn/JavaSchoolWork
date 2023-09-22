public class DepartmentHead extends Employee{
    private static final float LEAD_EXTRA = 100.0f;

    private int headCount;

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public DepartmentHead(String name, String socSecurityNr, float salary, int headCount) {
        super(name, socSecurityNr, salary);
        setHeadCount(headCount);
    }

    public float calcSalary() {
        return salary + headCount * LEAD_EXTRA;
    }

    @Override
    public String toString() {
        return super.toString() + ", headCount: " + headCount;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
