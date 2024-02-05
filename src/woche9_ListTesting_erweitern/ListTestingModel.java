package woche9_ListTesting_erweitern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ListTestingModel {
	protected enum LIST_TYPES {ArrayList, LinkedList, TreeSet, HashSet};
	protected enum OPERATION_CHOICES {Add, Search};
	
	private List<SampleData> list;
	private Set<SampleData> set;
	
	/**
	 * Run the defined test, returning the total elapsed time in seconds
	 * @param amountOfData The amount of elements to add to the list
	 * @param listType The type of list to use
	 * @param whereChoice Where to insert the elements in the list
	 * @return the elapsed time in seconds, as a float
	 */
	
	public float runTest(Integer amountOfData, LIST_TYPES listType, OPERATION_CHOICES operationChoice) {
		// Create the data objects in an array
		SampleData[] data = createData(amountOfData);
		
		
		if (listType == LIST_TYPES.ArrayList || listType == LIST_TYPES.LinkedList) {
		list = createList(amountOfData, listType);
		}
		else {set = createSet(amountOfData, listType);
		}
		
		
		// Perform the test
		long startTime = System.currentTimeMillis();
		
		if (listType == LIST_TYPES.ArrayList || listType == LIST_TYPES.LinkedList) {
			addDataToList(data, list, operationChoice);
			System.out.print(amountOfData.toString() + " ");
		}
		else { 
			addDataToSet(data, set, operationChoice); 
			System.out.print(amountOfData.toString() + " ");
		}
		
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) / 1000.0f;
	}

	private SampleData[] createData(Integer amountOfData) {
		SampleData[] data = new SampleData[amountOfData];
		for (int i = 0; i < amountOfData; i++) data[i] = new SampleData();
		return data;
	}
	
	private List<SampleData> createList(Integer amountOfData, LIST_TYPES listType) {
		// Create an empty list of the desired type
		List<SampleData> list = null;
		if (listType == LIST_TYPES.ArrayList)
			list = new ArrayList<>();
		else if (listType == LIST_TYPES.LinkedList)
			list = new LinkedList<>();	
		return list;
	}
	
	private Set<SampleData> createSet(Integer amountOfData, LIST_TYPES listType) {
		// Create an empty list of the desired type
		Set<SampleData> set = null;
		if (listType == LIST_TYPES.TreeSet)
			set = new TreeSet<>();
		else if (listType == LIST_TYPES.HashSet)
			set = new HashSet<>();
		return set;
	}
	
	private void addDataToList(SampleData[] data, List<SampleData> list, OPERATION_CHOICES operationChoices) {
		
		for (SampleData element : data) {
			list.add(element);
		}
		
		if (operationChoices == OPERATION_CHOICES.Search) { 
				SampleData randomObject = getRandomElement(data);
				Boolean isContain = list.contains(randomObject);	
				System.out.println("Objekt in Liste gefunden: " + isContain + '\n');
				System.out.print(randomObject.toString());
		}
	}
	
	
	private void addDataToSet(SampleData[] data, Set<SampleData> set, OPERATION_CHOICES operationChoices) {	
		
		for (SampleData element : data) {
			set.add(element);
		}
			
		if (operationChoices == OPERATION_CHOICES.Search) { 
			SampleData randomObject = getRandomElement(data);
			Boolean isContain = set.contains(randomObject);		
			System.out.println("Objekt in Set gefunden: " + isContain + '\n');
			System.out.print(randomObject.toString());
		}
	}
	
	
    private SampleData getRandomElement(SampleData[] data) {
        
        if (data == null || data.length == 0) {
            return null;
        }

        //Zufälligen Index generieren
        Random random = new Random();
        int randomIndex = random.nextInt(data.length);

        //Zufälliges Element abrufen
        return data[randomIndex];
    }
	
}
 