package org.example.menu;

import org.example.model.Animal;
import org.example.model.Dog;
import org.example.model.Cat;
import org.example.model.Bird;
import org.example.model.AnimalId;
import org.example.shelter.Shelter;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start() {
        int choosed = -1;

        while (choosed != 0) {
            printMenu();
            choosed = scanner.nextInt();
            scanner.nextLine();

            switch (choosed) {
                case 1: {
                    printAnimalType();
                    int species = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Animal age :");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Animal name :");
                    String name = scanner.nextLine();

                    Animal animal = null;
                    switch (species) {
                        case 1:
                            animal = new Dog(new AnimalId(), name, age);
                            break;
                        case 2:
                            animal = new Cat(new AnimalId(), name, age);
                            break;
                        case 3:
                            animal = new Bird(new AnimalId(), name, age);
                            break;
                        default:
                            System.out.println("Unknown type");
                            break;
                    }
                    if (animal != null) {
                        shelter.addAnimal(animal);
                    }
                    break;
                }
                case 2: {
                    List<Animal> animals = shelter.getAllAnimals();
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter species (Dog, Cat, Bird) :");
                    String species = scanner.nextLine();
                    List<Animal> animals = shelter.findBySpecies(species);
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                }
                case 4: {
                    List<Animal> availableAnimals = shelter.findAvailableAnimals();
                    for (Animal animal : availableAnimals) {
                        System.out.println(animal);
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter animal id :");
                    String id = scanner.nextLine();
                    shelter.markAsAdopted(id);
                    break;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }

    private void printAnimalType() {
        System.out.println("""
                1. Dog
                2. Cat
                3. Bird
                """);
    }
}