import java.util.ArrayList;

public abstract class Worker implements Qualifications{
    public static final float STD_WEEKLY_HOURS = 38.5f;
    private String name;
    protected ArrayList<String> kenntnisse = new ArrayList<>();
    private String socSecurityNr;
    public abstract float calcSalary();

    public Worker(String name, String socSecurityNr) {
        setName(name);
        setSocSecurityNr(socSecurityNr);
    }
    @Override
    public String toString() {
         return name + ", Sozialversicherungsnum. " + socSecurityNr + ", verdient " + calcSalary() + "€";
    }

    public void printInfo() {
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
        else {
            throw new RuntimeException("Name null!");
        }
    }

    public String getSocSecurityNr() {
        return socSecurityNr;
    }

    public void setSocSecurityNr(String socSecurityNr) {
        if (socSecurityNr != null) {
            this.socSecurityNr = socSecurityNr;
        }
        else {
            throw new RuntimeException("SocSecurityNr null!");
        }
    }

    @Override
    public ArrayList<String> allQualifications() {
        return kenntnisse;
    }

    @Override
    public void attendTraining(String qualifications) {
        kenntnisse.add(qualifications);
    }

    @Override
    public boolean qualifiedFor(String qualification) {
        for (String quali : kenntnisse) {
            if (qualification.equals(quali)) {
                return true;
            }
        }
        return false;
    }
}
