package virtual_pet;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);

        while (playAgain) {
            introduction(petShelter);
            int careChoice = input.nextInt();
            input.nextLine();
            playerChoice(petShelter, input, careChoice);
            tickAll(petShelter);

            while (winConditions(petShelter)) {
                scoreboard(petShelter);
                userChoices();
                careChoice = input.nextInt();
                playerChoice(petShelter, input, careChoice);
                tickAll(petShelter);
            }

            petShelter.resetShelter();
            playAgain = isPlayAgain(input);

        }
    }

    private static boolean isPlayAgain(Scanner input) {
//        line 340
        System.out.println("Would you like to play again? Y/N ");
        String yesOrNo = input.nextLine();
        if (yesOrNo.equalsIgnoreCase("Y")) {
            return true;
        }

        else {
            return false;
        }
    }


    //    -------------------------------------INTERACTION CHOICES------------------------------------------------
    private static void userChoices() {
//        line 76
        System.out.println("(1) Let's play!");
        System.out.println("(2) They look thirsty. Let's give them some water!");
        System.out.println("(3) Their tummy is a grumblin'. Let's give them some food!");
        System.out.println("(4) They look so sleepy. Let's let them rest for a bit!");
        System.out.println("(5) They have so much energy! Let's take them on a nice walk!");
        System.out.println("(6) Uh oh... Their crates look a little dirty. Let's get those cleaned out!");
        System.out.println("(7) Our robotic pets need some repairs. Let's get them all fixed up!");
        System.out.println("(8) We've got a new pet! Let's get them admitted to the shelter!");
        System.out.println("(9) HIP HIP HOORAY! Once of the pets has found their FURever home <3<3<3 Let's get them adopted out to their new family!");
    }

    private static void playerChoice(VirtualPetShelter petShelter, Scanner input, int careChoice) {
//        line 89
        switch (careChoice) {
            case 1:
                playWithPet(petShelter, input);
                break;
            case 2:
                waterPet(petShelter, input);
                break;
            case 3:
                feedPet(petShelter, input);
                break;
            case 4:
                restPets(petShelter);
                break;
            case 5:
                walkPets(petShelter);
                break;
            case 6:
                cleanCrates(petShelter);
                break;
            case 7:
                repairRoboticPets(petShelter);
                break;
            case 8:
                admitNewPet(petShelter, input);
                break;
            case 9:
                adoptPetOut(petShelter, input);
                break;

        }
    }

//----------------------------------------------------------------END CHOICES---------------

    //------------------------ADOPT
    private static void adoptPetOut(VirtualPetShelter petShelter, Scanner input) {
        System.out.println("We are so happy to hear you found a FURever friend at the shelter today! Which of our adorable pets will you be adopting?");
        while (true) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getDescription());
            }

            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getDescription());
            }

            String petToAdopt = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                if (shelterPet.getName().equalsIgnoreCase(petToAdopt)) {
                    foundPet = true;
                    petShelter.organicPetStorage.removeIf(pet -> pet.getName().equalsIgnoreCase(petToAdopt));
                    System.out.println("We couldn't be happier that " + petToAdopt + " has found their FURever home, and we can't wait to hear about all the wonderful adventures you'll share! <3");
                    break;
                }
            }
            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
                if (shelterPet.getName().equalsIgnoreCase(petToAdopt)) {
                    foundPet = true;
                    petShelter.roboticPetStorage.removeIf(pet -> pet.getName().equalsIgnoreCase(petToAdopt));
                    System.out.println("We couldn't be happier that " + petToAdopt + " has found their FURever home, and we can't wait to hear about all the wonderful adventures you'll share! <3");
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that pet is not available for adoption today. Please choose from any of our other adorable pets! :) ");
            } else {
                break;
            }
        }
    }
//---------------------------END ADOPT

    //-------------------------ADMIT
    private static void admitNewPet(VirtualPetShelter petShelter, Scanner input) {
        System.out.println("In order to admit an animal, please provide the following information as it is requested.");
        System.out.print("Animal Name: ");

        String admittedAnimalName = input.nextLine();

        System.out.print("Brief description: ");

        String admittedAnimalDescription = input.nextLine();

        System.out.print("Is your pet Robotic or Organic? ");

        String admittedAnimalType = input.nextLine();

        if (admittedAnimalType.equalsIgnoreCase("Robotic")) {
            System.out.print("Is your pet a Dog or a Cat? ");
            String admittedAnimalSpecies = input.nextLine();
            if (admittedAnimalSpecies.equalsIgnoreCase("Dog")) {
                RoboticDog newDog = new RoboticDog(admittedAnimalName, admittedAnimalDescription, 50, 50, 50);
                petShelter.roboticPetStorage.add(newDog);
            } else if (admittedAnimalSpecies.equalsIgnoreCase("Cat")) {
                RoboticCat newCat = new RoboticCat(admittedAnimalName, admittedAnimalDescription, 50, 50, 50);
                petShelter.roboticPetStorage.add(newCat);
            }
        }
        if (admittedAnimalType.equalsIgnoreCase("Organic")) {
            System.out.print("Is your pet a Dog or a Cat? ");
            String admittedAnimalSpecies = input.nextLine();
            if (admittedAnimalSpecies.equalsIgnoreCase("Dog")) {
                OrganicDog newDog = new OrganicDog(admittedAnimalName, admittedAnimalDescription, 50, 50, 50, 50, 50, 50);
                petShelter.organicPetStorage.add(newDog);
            } else if (admittedAnimalSpecies.equalsIgnoreCase("Cat")) {
                OrganicCat newCat = new OrganicCat(admittedAnimalName, admittedAnimalDescription, 50, 50, 50, 50, 50, 50);
                petShelter.organicPetStorage.add(newCat);
            }
        }
        System.out.println("Thank you for admitting " + admittedAnimalName);
    }
//----------------------END ADMIT

    //-----------------------------------TICK
    private static void tickAll(VirtualPetShelter petShelter) {
//        line 330
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.tick();
        }

        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.tick();
        }
    }
//---------------------------------END TICK

    //---------------------REPAIRS
    private static void repairRoboticPets(VirtualPetShelter petShelter) {
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.maintenance();
        }
        System.out.println("Good as new! Thanks for helping with the robotic pets' repairs! <3");
    }
//-------------------END REPAIRS

    //---------------CLEAN
    private static void cleanCrates(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.cleanCages();
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.cleanCages();
        }
        System.out.println("Thanks for tidying up the pets' cages! They appreciate it very much! <3");
    }
//----------------END CLEAN

    //-------------------------WALK
    private static void walkPets(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            if (shelterPet instanceof OrganicDog) {
                ((OrganicDog) shelterPet).walk();
            }
        }

        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            if (shelterPet instanceof RoboticDog) {
                ((RoboticDog) shelterPet).walk();
            }
        }
        System.out.println("Thanks for taking the pets on a walk and getting them out of the shelter for a bit! <3");
    }
//--------------------END WALK

    //----------------------REST
    private static void restPets(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.sleep();
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.charge();
        }
        System.out.println("They were so sleepy! Thanks for helping the pets get some much needed rest! <3");
    }
//-------------------END REST

    //-------------------FEED
    private static void feedPet(VirtualPetShelter petShelter, Scanner input) {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet needs food?");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getTypeOfPet());
            }
            input.nextLine();
            String feedPet = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(feedPet)) {
                    pet.eat();
                    foundPet = true;
                    System.out.println("Thanks for giving this thirsty pet some water! <3");
                    petNotPlayedWith = false;
                    break;
                }
            }

            if (!foundPet) {
                System.out.println("It doesn't look like that pet is here. Try choosing one of the pets in the shelter: ");
            } else {
                break;
            }
        }
    }
//------------------END FEED

    //--------------------PLAY
    private static void playWithPet(VirtualPetShelter petShelter, Scanner input) {
//        line 21
        boolean petNotPlayedWith = true;
        System.out.println("Please choose a pet to play with!");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getDescription());
            }

            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getDescription());
            }

            String playWithPet = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(playWithPet)) {
                    pet.play();
                    foundPet = true;
                    System.out.println("Thanks for giving this pet some extra lovin' <3");
                    petNotPlayedWith = false;
                    break;
                }
            }

            for (RoboticPet pet : petShelter.roboticPetStorage) {
                if (pet.getName().equalsIgnoreCase(playWithPet)) {
                    pet.play();
                    foundPet = true;
                    System.out.println("Thanks for giving this pet some extra lovin' <3");
                    petNotPlayedWith = false;
                    break;
                }
            }

            if (!foundPet) {
                System.out.println("It doesn't look like that pet is here. Try choosing one of the pets in the shelter: ");
            } else {
                break;
            }
        }
    }
//----------------------------END PLAY

    //-----------------------------WATER
    private static void waterPet(VirtualPetShelter petShelter, Scanner input) {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet is thirsty?");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getTypeOfPet());
            }
            String waterPet = input.nextLine();
            boolean foundPet = false;

            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(waterPet)) {
                    pet.drink();
                    foundPet = true;
                    System.out.println("Oops! That might have been too much water!");
                    petNotPlayedWith = false;
                    break;
                }
            }

            if (!foundPet) {
                System.out.println("It doesn't look like that pet is here. Try choosing one of the pets in the shelter: ");
            }

            else {
                break;
            }
        }
    }

//--------------------------END WATER

    //----------------------------------------------END CHOICES--------------------------------------------
    private static boolean winConditions(VirtualPetShelter petShelter) {
//        line 350
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            if (shelterPet.getHunger() >= 100 || shelterPet.getThirst() >= 100 || shelterPet.getTiredness() >= 100 || shelterPet.getBoredom() >= 100 || shelterPet.getCleanliness() <= 100 || shelterPet.getBathroom() >= 100) {
                System.out.println("Oh, no! Your pet, " + shelterPet.getName() + ", has died. :(");
                return false;
            }
        }

        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            if (shelterPet.getConditionLevel() <= 0 || shelterPet.getBattLevel() <= 0 || shelterPet.getCleanliness() <= 0) {
                System.out.println("Oh, no! Your pet, " + shelterPet.getName() + ", has died. :(");
                return false;
            }
        }

        if (petShelter.organicPetStorage.size() <= 0 && petShelter.roboticPetStorage.size() <= 0) {
            System.out.println("CONGRATULATIONS!!! All of the pets ar Virtual Pet Shelter have found their loving FURever homes! Thank you for all of your help! <3");
            return false;
        }
        return true;
    }


    //-------------------------------GAME INTRO--------------------------------------------------------------------
    private static void introduction(VirtualPetShelter petShelter) {
//        line 27
        System.out.println("Howdy, friend! Welcome, and thanks for stopping by the Virtual Pet Shelter! Please choose a pet to interact with :) ");
        System.out.println("These are all of the pets currently in the shelter: ");
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + " : " + shelterPet.getTypeOfPet);
            }

            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            System.out.println(shelterPet.getName() + " : " + shelterPet.getTypeOfPet);
            }

        System.out.println("Pet Stats: ");
        scoreboard(petShelter);

        System.out.println("What would you like to do with your pet?");
        userChoices();
    }
    //-----------------------------END INTRO----------------------------------------------------------------------

    // -----------------------------SCOREBOARD---------------------------------------------------------------------
    private static void scoreboard(VirtualPetShelter petShelter) {
//        fixing scoreboard right now

    }
    //----------------------END SCOREBOARD--------------------------------------------------------------------------
}

