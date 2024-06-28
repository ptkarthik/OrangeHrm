package IndustryStandard.restassured.complexJsonPojo.mediumlevel;

public class CompanyRoot {
    private Company company;

    public CompanyRoot(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
