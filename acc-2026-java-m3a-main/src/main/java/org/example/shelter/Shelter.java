package org.example.shelter;

import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        // TODO
        return animals;
    }

    public List<T> findBySpecies(String species){
        // TODO
        List<T> list = new ArrayList<>();
        for(T animal : animals){
            if (species.equals(animal.getSpecies())){
                list.add(animal);
            }
        }
        return list;
    }

    public List<T> findAvailableAnimals(){
        // TODO
        List<T> availableAnimals = new ArrayList<>();
        for(T animal : animals){
            if (animal.getAdoptionStatus() == AVAILABLE){
                availableAnimals.add(animal);
            }
        }
        return availableAnimals;
    }

    public void markAsAdopted(String id){
        // TODO
    }
}
