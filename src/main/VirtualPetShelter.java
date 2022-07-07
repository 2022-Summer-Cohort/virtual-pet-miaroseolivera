package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    ArrayList<VirtualPetApp>  petStorage = new ArrayList<VirtualPetApp>();

    public void currentlyInShelter(VirtualPetApp pet) {
        petStorage.add(new VirtualPetApp(pet.getName(), pet.getHunger(), pet.getThirst(), pet.getAge(), pet.getBoyOrGirl(), pet.getBoyOrGirl(), pet.getTypeOfPet()));
    }

    public ArrayList<VirtualPetApp> givePetStats() {
        return petStorage;
    }

    public String giveName() {
        for (VirtualPetApp findName : petStorage) {
            return findName.getName();
        }
        return null;
    }

    public void feedAllPets() {
        for (VirtualPetApp petsAreHungry : petStorage) {
            petsAreHungry.feedPet();
        }
        System.out.println("You feed all of the pets in your shelter!");
    }

    public void waterAllPets() {
        for (VirtualPetApp petsAreThirsty : petStorage) {
            petsAreThirsty.giveWater();
        }
        System.out.println("You give all the pets in the shelter some water!");
    }

    public void allPetsAreSnuggly() {
        for (VirtualPetApp petsAreSnuggly : petStorage) {
            petsAreSnuggly.giveSnugs();
        }
        System.out.println("You give all the pets some snugs :)");
    }

    public void newPet(String newPetName, String typeOfNewPet) {
        petStorage.add(new VirtualPetApp(newPetName, 50, 50 ,50 , typeOfNewPet, false));
    }

    public void adoptNewPet(String newPetToAdopt) {
        petStorage.removeIf(pet -> pet.getName().equalsIgnoreCase(newPetToAdopt));
    }

    public void tickAll() {
        for (VirtualPetApp turnTick : petStorage) {
            turnTick.tick();
        }
    }

    public void allPetStatLimiter() {
        for (VirtualPetApp statNormalize : petStorage) {
            statNormalize.intLimiter();
        }
    }

    public void Play() {
    }
}
