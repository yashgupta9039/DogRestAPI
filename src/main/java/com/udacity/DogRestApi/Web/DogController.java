package com.udacity.DogRestApi.Web;

import com.udacity.DogRestApi.Entity.Dog;
import com.udacity.DogRestApi.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/Dog")
    public ResponseEntity<List<Dog>> getListofAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/Dog/Breed")
    public ResponseEntity<List<String>> getListofDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/Dog/{Id}/Breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long Id) {
        String string = dogService.retrieveDogBreedById(Id);
        return new ResponseEntity<String>(string, HttpStatus.OK);
    }

    @GetMapping("/Dog/Name")
    private ResponseEntity<List<String>> getListofDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
