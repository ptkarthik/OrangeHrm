package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

import java.util.List;

public class Company {
    private String name;
    private String location;
    private List<Departments> departments;

    public Company(String name, String location, List<Departments> departments) {
        this.name = name;
        this.location = location;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }
}
