package woche9_ListTesting_erweitern;

/**
 * This class represents data to be managed in a data structure. To allow
 * various kinds of tests (sorting, searching, etc.), an object of this class
 * has several kinds of attributes. Each attribute is set to a random value.
 * 
 * - ID: Integer, no duplicates, used for equals and compareTo
 * 
 * - Name: String, duplicates possible but rare
 * 
 * - Number: Integer, duplicates certain with any large data collection
 * 
 * - DataNumber: Double, duplicates very unlikely
 * 
 * - DataString: Alphabetic String, duplicates very unlikely
 */
public class SampleData implements Comparable<SampleData> {
	private static int nextID = 0;

	private final int ID;
	private String name;
	private int number;
	private double dataNumber;
	private String dataString;

	public SampleData() {
		this.ID = nextID++;
		this.name = generateName();
		this.number = (int) (Math.random() * 1000);
		this.dataNumber = Math.random();
		this.dataString = generateRandomString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}
	
	public String toString () {
		return "["+ this.ID + " | " + this.name + " | " + this.number + " | " + this.dataNumber + " | " + this.dataString + "]";
		
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof SampleData)) return false;
		SampleData d = (SampleData) o;
		return ID == d.ID;
	}

	@Override
	public int compareTo(SampleData d) {
		return Integer.compare(this.ID, d.ID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getDataNumber() {
		return dataNumber;
	}

	public void setDataNumber(double dataNumber) {
		this.dataNumber = dataNumber;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public int getID() {
		return ID;
	}

	/**
	 * Randomly generate a string consisting of letters, digits and spaces.
	 * To structure the data a bit, spaces are placed every 10 characters.
	 */
	private String generateRandomString() {
		final int NUM_SEGMENTS = 5;
		final int NUM_CHARS = 10;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < NUM_SEGMENTS; i++) {
			for (int j = 0; j < NUM_CHARS; j++) {
				int val = (int) (Math.random() * 62);
				if (val < 10) sb.append((char) ('0' + val));
				else if (val < 36) sb.append((char)( 'A' + val - 10));
				else sb.append((char)( 'a' + val - 36));
			}
			if (i < (NUM_SEGMENTS-1)) sb.append(' ');
		}
		return sb.toString();
	}

	/**
	 * Randomly pick three names and put them together
	 */
	private String generateName() {
		String fullName = FIRSTNAMES[(int) (Math.random() * FIRSTNAMES.length)];
		fullName += " " + FIRSTNAMES[(int) (Math.random() * FIRSTNAMES.length)];
		fullName += " " + LASTNAMES[(int) (Math.random() * LASTNAMES.length)];
		return fullName;
	}

	private static final String[] FIRSTNAMES = { "Aaron", "Abel", "Ace", "Adam", "Aja", "Alfie", "Ann", "Axel", "Beck",
			"Bern", "Beth", "Blair", "Blaire", "Blake", "Bray", "Cash", "Chip", "Claire", "Coe", "Dan", "David", "Dawn",
			"Dee", "Dex", "Drew", "Eli", "Elle", "Elon", "Eve", "Faye", "Finn", "Fox", "Gad", "Gail", "Gem", "Gia",
			"Grace", "Gwen", "Hale", "Hank", "Jade", "Jan", "Jane", "Jay", "Jean", "Joel", "John", "Jude", "Kane",
			"Kate", "Kim", "Knox", "Laird", "Lars", "Levi", "Liv", "Lou", "Luke", "Luna", "Madge", "Max", "Mills",
			"Milo", "Minka", "Noah", "Paige", "Parr", "Paul", "Pearl", "Penn", "Quinn", "Rain", "Reid", "Rex", "Rose",
			"Ruth", "Saul", "Seth", "Skye", "Sloan", "Star", "Sue", "Taft", "Tess", "Tia", "Uma", "Val", "Van", "Zane",
			"Zoe" };
	private static final String[] LASTNAMES = { "Adams", "Allen", "Alvarez", "Anderson", "Bailey", "Baker", "Bennet",
			"Brooks", "Brown", "Campbell", "Carter", "Castillo", "Chavez", "Clark", "Collins", "Cook", "Cooper", "Cox",
			"Cruz", "Davis", "Diaz", "Edwards", "Evans", "Flores", "Foster", "Garcia", "Gomez", "Gonzales", "Gray",
			"Green", "Gutierrez", "Hall", "Harris", "Hernandez", "Hill", "Howard", "Hughes", "Jackson", "James",
			"Jimenez", "Johnson", "Jones", "Kelly", "Kim", "King", "Lee", "Lewis", "Long", "Lopez", "Martin",
			"Martinez", "Mendoza", "Miller", "Mitchell", "Moore", "Morales", "Morgan", "Morris", "Murphy", "Myers",
			"Nelson", "Nguyen", "Ortiz", "Parker", "Patel", "Perez", "Peterson", "Phillips", "Price", "Ramirez",
			"Ramos", "Reed", "Reyes", "Richardson", "Rivera", "Roberts", "Robinson", "Rodriguez", "Rogers", "Ross",
			"Ruiz", "Sanchez", "Sanders", "Scott", "Smith", "Stewart", "Taylor", "Thomas", "Thompson", "Torres",
			"Turner", "Walker", "Ward", "Watson", "White", "Williams", "Wilson", "Wood", "Wright", "Young" };
}
