package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelter {

    ArrayList<VirtualPetApplication>  petStorage = new ArrayList<VirtualPetApplication>();

    public void currentlyInShelter(VirtualPetApplication pet) {
        petStorage.add(new VirtualPetApplication(pet.getName(), pet.getHunger(), pet.getThirst(), pet.getAge(), pet.getBoyOrGirl(), pet.getBoyOrGirl(), pet.getTypeOfPet()));
    }

    public ArrayList<VirtualPetApplication> givePetStats() {
        return petStorage;
    }

    public String giveName() {
        for (VirtualPetApplication findName : petStorage) {
            return findName.getName();
        }
        return null;
    }

    public void feedAllPets() {
        for (VirtualPetApplication petsAreHungry : petStorage) {
            petsAreHungry.feedPet();
        }
        System.out.println("You feed all of the pets in your shelter!");
    }

    public void waterAllPets() {
        for (VirtualPetApplication petsAreThirsty : petStorage) {
            petsAreThirsty.giveWater();
        }
        System.out.println("You give all the pets in the shelter some water!");
    }

    public void allPetsAreSnuggly() {
        for (VirtualPetApplication petsAreSnuggly : petStorage) {
            petsAreSnuggly.giveSnugs();
        }
    }
}
