package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    public VirtualPetShelter(ArrayList<VirtualPetApp> petStorage, ArrayList<OrganicPet> organicPetStorage, ArrayList<RoboticPet> roboticPetStorage) {
        this.petStorage = petStorage;
        this.organicPetStorage = organicPetStorage;
        this.roboticPetStorage = roboticPetStorage;
    }

    ArrayList<VirtualPetApp>  petStorage = new ArrayList<VirtualPetApp>();

    public VirtualPetShelter() {

    }


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
    }

    ArrayList<OrganicPet> organicPetStorage = new ArrayList<OrganicPet>();
    ArrayList<RoboticPet> roboticPetStorage = new ArrayList<RoboticPet>();

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
}
