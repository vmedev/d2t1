package org.example.menu;

import org.example.model.Animal;
import org.example.shelter.Shelter;

import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){
        // TODO:
        // Show menu in a loop
        // Read user input
        // Call correct 'Shelter' methods based on selected option
        int choosed = -1;

        while (choosed != 0) {
            printMenu();
            choosed = scanner.nextInt();
            switch (choosed) {
                case 1: {
                    printAnimalType();
                    int species = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Animal age :");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Animal name :");
                    String name = scanner.next();
                    scanner.nextLine();

                    Animal animal;
                    switch (type) {
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
                    shelter.addAnimal(animal);
                    break;
            }
                case 2: {
                    List<T> animals = shelter.getAllAnimals();
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                }
                case 3:
                    printAnimalType();
                    System.out.println("Enter your choice (number)");
                    choosed = scanner.nextInt();

                    List<T> animals = shelter.findBySpecies(choosed);

                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                case 4:
                    List<T> availableAnimals = shelter.findAvailableAnimals()
                    for (Animal animal : availableAnimals) {
                        System.out.println(animal);
                    }
                    break;
                case 5:

                    break;
            }
        }
    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }

    private void printAnimalType(){
        System.out.println("""
                1. Dog
                2. Cat
                3. Bird
        """)
    }
}
