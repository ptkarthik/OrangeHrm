package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

import java.util.List;

public class Employees {
private String name;
private String employee_ID;
private List<Projects> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String position;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    private Contact contact;

    public Employees(String name, String employee_id, String position, Contact contact) {
        this.name = name;
        employee_ID = employee_id;
        this.position = position;
        this.contact = contact;
    }
}
