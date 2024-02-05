package woche4_5_Pet_Beispiel_Datei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import petData.Pet;
import petData.Pet.Gender;
import petData.Pet.Species;

public class PetModel {
	
	private static String PETS_FILE = "petsDataStorage.txt";
	private static String SEPARATOR = ";"; // Separator for "split"
	
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();
	
	private final static ObservableList<Pet> pets = FXCollections.observableArrayList();
	
	//METHODEN FÜR IMPLEMENTATION DOKUMENT
	public void loadPets() {
		File petsFile = new File(PETS_FILE);
		try (Reader inReader = new FileReader(petsFile)) {
			BufferedReader in = new BufferedReader(inReader);

			String line = in.readLine();
			while (line != null) {
				Pet pet = readPet(line);
				pets.add(pet);
				line = in.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Pet readPet(String line) {
		String[] attributes = line.split(SEPARATOR);
		int ID = Integer.parseInt(attributes[0]);
		String speciesString = attributes[1];
	    Species species = Species.valueOf(speciesString);
		String genderString = attributes[2];
	    Gender gender = Gender.valueOf(genderString);
	    String name = attributes[3];
		Pet pet = new Pet(ID, species, gender, name);
		//pet.setName(name);
		return pet;
	}
	
	public void savePetsIntoFile() {
		File petsFile = new File(PETS_FILE);
		try (Writer out = new FileWriter(petsFile)) {
			for (Pet pet : pets) {
				String line = writePet(pet);
				out.write(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String writePet(Pet pet) {
		String line = pet.getID() + SEPARATOR + pet.getSpecies() + SEPARATOR + pet.getGender() + SEPARATOR + pet.getName() + "\n";
		return line;
	}

	
	//DAS VORHERIGE ODER NACHFOLGENDE PET AUSWÄHLEN
	public void previousPet() {
		int currentPosition = getIndexCurrentPet();
		if(currentPosition > 0) {
			petProperty.set(pets.get(currentPosition -1));
		}
		else {System.out.println("Weiter zurück geht nicht!");
		}
		
	}
	
	public void nextPet() {
		int currentPosition = getIndexCurrentPet();
		if(currentPosition != (pets.size() -1)) {
			petProperty.set(pets.get(currentPosition +1));
		}
	}
	
	//WEITERE METHODEN
	
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		 int id = getNextID();
		petProperty.set(new Pet(id, species, gender, name));
		pets.addAll(getPet());
	}
	
	public Pet getPet() {
		return petProperty.get();
	}
	
	public void deletePet() {
		//petProperty.set(null);
		pets.remove(getIndexCurrentPet());
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
