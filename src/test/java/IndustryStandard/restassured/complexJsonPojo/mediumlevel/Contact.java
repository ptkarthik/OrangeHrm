package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

public class Contact {

    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
