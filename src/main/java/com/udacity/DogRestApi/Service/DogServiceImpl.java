package com.udacity.DogRestApi.Service;


import com.udacity.DogRestApi.Entity.Dog;
import com.udacity.DogRestApi.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    public String retrieveDogBreedById(Long Id) {
         Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(Id));
         String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
         return breed;
    }

    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }
}
