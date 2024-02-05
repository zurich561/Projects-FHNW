package woche4_5_Pet_Beispiel_Datei;

import javafx.event.ActionEvent;
import petData.Pet;
import petData.Pet.Gender;
import petData.Pet.Species;

public class PetController {
	private PetView view;
	private PetModel model;

	public PetController(PetModel model, PetView view) {
		this.model = model;
		this.view = view;
		
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);
		
		view.arrayCount.setText(model.getSizeOfArray());
		
		view.btnDelete.disableProperty().bind(view.arrayCount.textProperty().isEqualTo("0"));
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
		
		view.arrayCount.setText(model.getSizeOfArray());
		
		view.arraySwitchLeft.setOnAction(Event -> {
			model.previousPet();
			updateView(model.getPet());
		});
		
		view.arraySwitchRight.setOnAction(Event -> {
			model.nextPet();
			updateView(model.getPet());
		});
	}
	
	private void save(ActionEvent e) {
		Species species = view.cmbSpecies.getValue();
		Gender gender = view.cmbGender.getValue();
		String name = view.txtName.getText();
		
		if (species != null && gender != null && name != null && name.length() > 0) {
			model.savePet(species, gender, name);
			updateView(model.getPet());
			view.arrayCount.setText(model.getSizeOfArray());
			
		}
		
		model.savePetsIntoFile();
	}
	
	private void delete(ActionEvent e) {
		//Pet currentPet = model.getCurrentPet();
		model.deletePet();
		view.arrayCount.setText(model.getSizeOfArray());
		updateView(model.getLastPetInArray());
		model.petProperty().set(model.getLastPetInArray());
		model.savePetsIntoFile();
	}
	
	private void updateView(Pet pet) {
		if (pet != null) {
			view.lblDataID.setText(Integer.toString(pet.getID()));
			view.lblDataName.setText(pet.getName());
			view.lblDataSpecies.setText(pet.getSpecies().toString());
			view.lblDataGender.setText(pet.getGender().toString());
			
		} else {
			view.lblDataID.setText("");
			view.lblDataName.setText("");
			view.lblDataSpecies.setText("");
			view.lblDataGender.setText("");
		}
	}
}
