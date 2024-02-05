package petData;

import woche3_Pet_Beispiel_erweitert.PetModel;

public class Pet {

    public enum Species {CAT, DOG, HORSE};
    public enum Gender {MALE, FEMALE};

    private final int ID;
    private Species species;
    private Gender gender;
    private String name;

    public Pet(Species species, Gender gender, String name) {
        this.ID = PetModel.getNextID();
        this.species = species;
        this.gender = gender;
        this.name = name;
    }

    public Pet(int ID, Species species, Gender gender, String name) {
        this.ID = ID;
        this.species = species;
        this.gender = gender;
        this.name = name;
    }

    // --- Getters and Setters ---

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }
}
