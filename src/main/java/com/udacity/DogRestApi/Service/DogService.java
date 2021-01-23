package com.udacity.DogRestApi.Service;

import com.udacity.DogRestApi.Entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long Id);

    List<String> retrieveDogNames();


}
