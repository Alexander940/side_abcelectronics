package com.icesi.ABCElectronics.entity.mongo;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    @Id
    private Long id;
    private String [] child;
    private String birthDate;
    private String birthPlace;
    private String [] hobbies;
    private String [] sports;
    private CivilStatus civilStatus;
    private String [] interestCategories;
    private String otherInformation;

    public User(Long id, String[] child, String birthDate, String birthPlace, String[] hobbies, String[] sports, CivilStatus civilStatus, String[] interestCategories, String otherInformation) {
        this.id = id;
        this.child = child;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.hobbies = hobbies;
        this.sports = sports;
        this.civilStatus = civilStatus;
        this.interestCategories = interestCategories;
        this.otherInformation = otherInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getChild() {
        return child;
    }

    public void setChild(String[] child) {
        this.child = child;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String[] getSports() {
        return sports;
    }

    public void setSports(String[] sports) {
        this.sports = sports;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String[] getInterestCategories() {
        return interestCategories;
    }

    public void setInterestCategories(String[] interestCategories) {
        this.interestCategories = interestCategories;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
