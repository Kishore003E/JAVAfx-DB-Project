package com.example.demo1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OffDetails {
    private final StringProperty companyname;
    private final StringProperty jobrole;
    private final StringProperty salary;
    private final StringProperty experience;
    private final StringProperty skills;
    private final StringProperty location;

    public OffDetails(String companyname, String jobrole, String salary, String experience, String skills, String location) {
        this.companyname = new SimpleStringProperty(companyname);
        this.jobrole = new SimpleStringProperty(jobrole);
        this.salary = new SimpleStringProperty(salary);
        this.experience = new SimpleStringProperty(experience);
        this.skills = new SimpleStringProperty(skills);
        this.location = new SimpleStringProperty(location);
    }

    public final StringProperty companynameProperty() {
        return this.companyname;
    }

    public final String getcompanyname() {
        return this.companynameProperty().get();
    }

    public final void setcompanyname(final String companyname) {
        this.companynameProperty().set(companyname);
    }

    public final StringProperty jobroleProperty() {
        return this.jobrole;
    }

    public final String getjobrole() {
        return this.jobroleProperty().get();
    }

    public final void setJobrole(final String jobrole) {
        this.jobroleProperty().set(jobrole);
    }

    public final StringProperty salaryProperty() {
        return this.salary;
    }

    public final String getSalary() {
        return this.salaryProperty().get();
    }

    public final void setSalary(final String salary) {
        this.salaryProperty().set(salary);
    }

    public final StringProperty experienceProperty() {
        return this.experience;
    }

    public final String getExperience() {
        return this.experienceProperty().get();
    }

    public final void setExperience(final String experience) {
        this.experienceProperty().set(experience);
    }

    public final StringProperty skillsProperty() {
        return this.skills;
    }

    public final String getSkills() {
        return this.skillsProperty().get();
    }

    public final void setSkills(final String skills) {
        this.skillsProperty().set(skills);
    }

    public final StringProperty locationProperty() {
        return this.location;
    }

    public final String getLocation() {
        return this.locationProperty().get();
    }

    public final void setLocation(final String location) {
        this.locationProperty().set(location);
    }
}
