package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

public class Projects {
    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private String duration;

    public Projects(String name, String role, String duration) {
        this.name = name;
        this.role = role;
        this.duration = duration;
    }
}
