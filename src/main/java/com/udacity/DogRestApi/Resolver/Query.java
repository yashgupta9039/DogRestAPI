package com.udacity.DogRestApi.Resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogRestApi.Entity.Dog;
import com.udacity.DogRestApi.Repository.DogRepository;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDog(){
        return dogRepository.findAll();
    }

    public List<String> findDogBreeds(){
        return dogRepository.findAllBreed();
    }

    public String findDogBreedById(Long Id){
        return dogRepository.findBreedById(Id);
    }

    public List<String> findAllDogNames(){
        return dogRepository.findAllName();
    }
}
