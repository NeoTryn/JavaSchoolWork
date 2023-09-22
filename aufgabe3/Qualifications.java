import java.util.ArrayList;

public interface Qualifications {
    public void attendTraining(String qualifications);

    public ArrayList<String> allQualifications();

    public boolean qualifiedFor(String qualification);
}
