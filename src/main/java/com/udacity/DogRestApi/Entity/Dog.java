package com.udacity.DogRestApi.Entity;

import javax.persistence.*;

@Entity
public class Dog{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String Name;
    private String Breed;
    private String Origin;

    public Dog(long Id, String Name, String Breed, String Origin) {
        this.Id = Id;
        this.Name = Name;
        this.Breed = Breed;
        this.Origin = Origin;
    }

    public Dog() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }
}


