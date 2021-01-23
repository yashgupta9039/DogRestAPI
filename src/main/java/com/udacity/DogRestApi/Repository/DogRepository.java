package com.udacity.DogRestApi.Repository;

import com.udacity.DogRestApi.Entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {

    @Query("select d.Id, d.Breed from Dog d where d.Id:=Id")
    String findBreedById(Long Id);

    @Query("select d.Id, d.Breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.Id, d.Name from Dog d")
    List<String> findAllName();


}
