package cn.edu.hfut.rbac.backend.entity;

public class Enterprise {
    private String enterpriseId;
    private String enterpriseName;
    private String enterpriseAddress;
    private String legalRepresentative;
    private String registeredCapital;

    @Override
    public String toString() {
        return "Enterprise{" +
                "enterpriseId='" + enterpriseId + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseAddress='" + enterpriseAddress + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", registeredCapital='" + registeredCapital + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", businessQualification='" + businessQualification + '\'' +
                ", numberOfEmployees='" + numberOfEmployees + '\'' +
                ", corporateWebsite='" + corporateWebsite + '\'' +
                ", telephone='" + telephone + '\'' +
                ", licenseInformation='" + licenseInformation + '\'' +
                '}';
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getBusinessQualification() {
        return businessQualification;
    }

    public void setBusinessQualification(String businessQualification) {
        this.businessQualification = businessQualification;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getCorporateWebsite() {
        return corporateWebsite;
    }

    public void setCorporateWebsite(String corporateWebsite) {
        this.corporateWebsite = corporateWebsite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLicenseInformation() {
        return licenseInformation;
    }

    public void setLicenseInformation(String licenseInformation) {
        this.licenseInformation = licenseInformation;
    }

    private String businessScope;
    private String businessQualification;
    private String numberOfEmployees;
    private String corporateWebsite;
    private String telephone;
    private String licenseInformation;
}
