package woche3_Pet_Beispiel_erweitert;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import petData.Pet;

public class PetModel {
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();
	
	private final static ObservableList<Pet> pets = FXCollections.observableArrayList();
	
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		petProperty.set(new Pet(species, gender, name));
		this.pets.addAll(getPet());
	}
	
	public void deletePet() {
		//petProperty.set(null);
		pets.remove(getIndexCurrentPet());
	}
	
	public void previousPet() {
		int currentPosition = getIndexCurrentPet();
		if(currentPosition != 0) {
			petProperty.set(pets.get(currentPosition -1));
		}
	}
	
	public void nextPet() {
		int currentPosition = getIndexCurrentPet();
		if(currentPosition != (pets.size() -1)) {
			petProperty.set(pets.get(currentPosition +1));
		}
	}
	
	public Pet getPet() {
		return petProperty.get();
	}
	
	public String getSizeOfArray() {
		Integer a = pets.size();
		String b = a.toString();
		return b;
	}
	
	public SimpleObjectProperty<Pet> petProperty() {
		return petProperty;
	}
	
	public void petIntoArray (Pet a) {
		pets.add(a);
	}
	
	public Pet getCurrentPet () {
		return petProperty.get();
	}
	
	public int getIndexCurrentPet() {
		int currentPets = pets.indexOf(getCurrentPet());
		return currentPets;
	}
	
	public Integer getArraySize () {
		return pets.size();
	}
	
	public Pet getPetInArray(int i) {
		Pet currentPet = pets.get(i);
		return currentPet;
	}
	
	public Pet showPet () {
		return pets.get(pets.size());
	}

	public static int getNextID() {
		return pets.size()+1;
	}
	
	public Pet getLastPetInArray () {
		int petsLength = pets.size();
		return pets.get(petsLength - 1);
	}
}
