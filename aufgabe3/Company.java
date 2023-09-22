import java.util.ArrayList;

public class Company {
    private String name;

    private ArrayList<Worker> staffList = new ArrayList<>();

    public void employ(Worker newWorker) {
        if (staffList != null) {
            for (Worker worker : staffList) {
                if (newWorker == worker) {
                    System.out.println("Worker the same");
                    return;
                }
            }
        }
        staffList.add(newWorker);
    }

    public boolean dismiss(String ssnr) {
        int count = 0;
        for (Worker worker : staffList) {
            if (worker.getSocSecurityNr().equals(ssnr)) {
                System.out.println("Get'ya ass outta here!!!");
                staffList.remove(count);
                return true;
            }
            count++;
        }
        return false;
    }

    public void printWorkers(float salary) {
        for (Worker worker : staffList) {
            if (worker instanceof Employee) {
                if ( ((Employee) worker).getSalary() >= salary) {
                    worker.printInfo();
                }
            }
        }
    }

    public void printWorkers(boolean deptmtHeadsOnly) {
        for (Worker worker : staffList) {
            if (deptmtHeadsOnly) {
                if (worker instanceof DepartmentHead) {
                    worker.printInfo();
                }
            }
            else {
                worker.printInfo();
            }
        }
    }

    public Worker findWorker(String name) {
        for (Worker worker : staffList) {
            if (worker.getName().equals(name)) {
                return worker;
            }
        }
        return null;
    }


}
