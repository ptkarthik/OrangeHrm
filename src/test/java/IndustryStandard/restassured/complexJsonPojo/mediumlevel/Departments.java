package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

import java.util.List;

public class Departments {
    private String name;
    private List<Employees> employees;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    private Manager manager;
}
