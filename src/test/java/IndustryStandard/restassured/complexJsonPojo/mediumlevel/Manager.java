package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

public class Manager {
    private String name;
    private String emp_id;
    private Contact contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Manager(String name, String emp_id, Contact contact) {
        this.name = name;
        this.emp_id = emp_id;
        this.contact = contact;
    }
}
