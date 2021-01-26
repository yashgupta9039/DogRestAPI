package com.udacity.DogRestApi.Mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogRestApi.Entity.Dog;
import com.udacity.DogRestApi.Exception.BreedNotFoundException;
import com.udacity.DogRestApi.Repository.DogRepository;
import com.udacity.DogRestApi.Exception.DogNotFoundException;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String Breed){

        boolean Deleted = false;
        Iterable<Dog> allDog = dogRepository.findAll();
        for (Dog d: allDog) {
            if(Breed.equals(d.getBreed())){
                dogRepository.delete(d);
                Deleted = true;
            }
        }
        if(!Deleted){
            throw new BreedNotFoundException("Breed Not Found", Breed);
        }
        return Deleted;
    }

    public Dog updateDogName(String newName, Long Id){
        Optional<Dog> optionalDog = dogRepository.findById(Id);
        if(optionalDog.isPresent())
        {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }
        else{
           throw new DogNotFoundException("Dog not found", Id);
        }
    }
}
