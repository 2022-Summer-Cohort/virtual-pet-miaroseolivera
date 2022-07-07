package virtual_pet;

public class VirtualPet implements Ticks {

    private String name;
    private String typeOfPet;
    public int cleanliness;

    public VirtualPet(String name, String typeOfPet, int cleanliness) {
        this.name = name;
        this.typeOfPet = typeOfPet;
        this.cleanliness = cleanliness;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfPet() {
        return typeOfPet;
    }

    public void cleanCages() {
       cleanliness += 10;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    @Override
    public void tick() {
        cleanliness -= 5;
        if (cleanliness > 100) {
            cleanliness = 100;
        }
    }
}
