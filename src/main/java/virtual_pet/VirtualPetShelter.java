package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    ArrayList<OrganicPet> organicPetStorage = new ArrayList<OrganicPet>();
    ArrayList<RoboticPet> roboticPetStorage = new ArrayList<RoboticPet>();
    ArrayList<VirtualPetApp>  petStorage = new ArrayList<VirtualPetApp>();

    public void addCurrentPetsToShelter() {
        RoboticDog pet1 = new RoboticDog("Bodhi");
        OrganicDog pet2 = new OrganicDog("Tucker");
        RoboticCat pet3 = new RoboticCat("Murphy");
        OrganicCat pet4 = new OrganicCat("Mac");
        roboticPetStorage.add(pet1);
        organicPetStorage.add(pet2);
        roboticPetStorage.add(pet3);
        organicPetStorage.add(pet4);
    }

    public void resetShelter () {
        organicPetStorage.removeAll(organicPetStorage);
        roboticPetStorage.removeAll(roboticPetStorage);
    }

//    public void currentlyInShelter(VirtualPetApp pet) {
//        petStorage.add(new VirtualPetApp());
//    }

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
    }
}
