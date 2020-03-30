package com.sheridan.jobpill.Models;

public class JobApplication {

    private String applicantId;
    private String applicantName;
    private String applicantIntro;
    private String applicantPhone;
    private String applicantCity;
    private String applicantPhoto;
    private String applicationDate;
    private String status;

    public JobApplication() {
    }

    public JobApplication(String applicantId, String applicantName, String applicantIntro, String applicantPhone, String applicantCity, String applicantPhoto, String applicationDate, String status) {
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.applicantIntro = applicantIntro;
        this.applicantPhone = applicantPhone;
        this.applicantCity = applicantCity;
        this.applicantPhoto = applicantPhoto;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantIntro() {
        return applicantIntro;
    }

    public void setApplicantIntro(String applicantIntro) {
        this.applicantIntro = applicantIntro;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantCity() {
        return applicantCity;
    }

    public void setApplicantCity(String applicantCity) {
        this.applicantCity = applicantCity;
    }

    public String getApplicantPhoto() {
        return applicantPhoto;
    }

    public void setApplicantPhoto(String applicantPhoto) {
        this.applicantPhoto = applicantPhoto;
    }


    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicantId='" + applicantId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", applicantIntro='" + applicantIntro + '\'' +
                ", applicantPhone='" + applicantPhone + '\'' +
                ", applicantCity='" + applicantCity + '\'' +
                ", applicantPhoto='" + applicantPhoto + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
