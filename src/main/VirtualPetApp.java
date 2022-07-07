  package virtual_pet;

public class VirtualPetApp {

        //Interact with a VirtualPet object in this method
        private String name;
        private String typeOfPet;
        private int hunger;
        private int thirst;
        private int age;
        private String boyOrGirl;
        private boolean isSadBoi;

        public VirtualPetApp(String name, int i, int i1, int i2, String typeOfPet, boolean b) {
            this.name = name;
            this.typeOfPet = typeOfPet;
//            this.hunger = hunger;
//            this.thirst = thirst;
//            this.age = age;
//            this.boyOrGirl = boyOrGirl;
//            this.sadBoi = isSadBoi;
        }

        public VirtualPetApp(String name, String typeOfPet, int hunger, int thirst, int age, String boyOrGirl, boolean isSadBoi) {
            this.name = name;
            this.typeOfPet = typeOfPet;
            this.hunger = hunger;
            this.thirst = thirst;
            this.age = age;
            this.boyOrGirl = boyOrGirl;
            this.isSadBoi = isSadBoi;
            }

    public VirtualPetApp(String name, int hunger, int thirst, int age, String boyOrGirl, String boyOrGirl1, String typeOfPet) {
    }

    public VirtualPetApp() {
        
    }

    public String getName() {
            return name;
        }

            public String getTypeOfPet() {
            return typeOfPet;
        }

            public int getHunger() {
            return hunger;
        }

            public int getThirst() {
            return thirst;
        }

            public int getAge() {
            return age;
        }

            public String getBoyOrGirl() {
            return boyOrGirl;
        }

            public boolean getSadBoi() {
            return isSadBoi;
        }

            public void feedPet() {
            hunger -= 20;
        }

            public void giveSnugs() {
            isSadBoi = false;
        }

            public void giveWater() {
            thirst -= 20;
        }

            public void tick() {
            hunger += 50;
            thirst += 50;
            age += 2;
        }

            public void intLimiter() {
            if (hunger < 0) {
                hunger = 0;
            }
                
            if (thirst < 0) {
                    thirst = 0;
                }
                
            if (age < 0) {
                        age = 0;
                    }
        }

    public void Play() {
    }
}
