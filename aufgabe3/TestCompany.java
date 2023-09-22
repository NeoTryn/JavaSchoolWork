public class TestCompany {
    public static void main(String[] args) {
        Company company = new Company();
        Employee employee = new Employee("Manfred Knon", "244564653", 69.0f);
        ContractWorker contractWorker = new ContractWorker("Rahman Habibuah", "69420", 3.12f, 0.02f);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Kornel der hs", "wixxa", 0.0f, 24.0f * 7.0f);
        DepartmentHead departmentHead = new DepartmentHead("Damajan Stanojlovic", "666", 69420.0f, 70);

        company.employ(employee);
        company.employ(contractWorker);
        company.employ(contractWorker);
        company.employ(partTimeEmployee);
        company.employ(departmentHead);

        company.printWorkers(1.0f); // Sry Kornel (jk)

        company.printWorkers(true);

        company.printWorkers(false);

        company.dismiss("wixxa"); // Endlich ist kornel gone

        company.printWorkers(false);

        System.out.println(company.findWorker("Kornel der hs")); // Hoffentlich false

        System.out.println(company.findWorker("Manfred Knon")); // Hoffentlich true

        company.findWorker("Manfred Knon").attendTraining("Besseren Code schreiben");

        if (company.findWorker("Manfred Knon").qualifiedFor("Besseren Code schreiben")) {
            System.out.println("It worked!");
        }
        else {
            System.err.println("Hat nicht funktioniert");
        }
    }
}
