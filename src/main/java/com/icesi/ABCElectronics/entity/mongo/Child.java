package com.icesi.ABCElectronics.entity.mongo;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Child")
public class Child {

    @Id
    private Long id;
    private String birthDate;
    private Gender gender;
    private String study;
    private VideoGame videoGame;

    public Child(Long id, String birthDate, Gender gender, String study, VideoGame videoGame) {
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
        this.study = study;
        this.videoGame = videoGame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame) {
        this.videoGame = videoGame;
    }
}
