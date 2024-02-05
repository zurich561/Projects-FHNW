package woche10_Neue_Datenstruktur;

/**
 * For the curious, here is a subclass of SinglyLinkedList. This subclass
 * maintains a sorted list.
 * 
 * However: note that we have to disable the "add" method in the superclass,
 * because the user is no longer allowed to place elements in specific
 * positions. This is a sign that something is wrong with our class hierarchy.
 * 
 * How could you change the class hierarchy to fix this problem?
 */
public class SortedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

	/**
	 * Add method that places a new element in the correct, sorted position
	 */
	public void add(T data) {
		try {
			// Find correct position, then use superclass method
			super.add(getSortPosition(data), data);
		} catch (ListException e) {
			// There's always a valid position, ListException cannot occur
		}
	}

	/**
	 * Disable the add method from the superclass (see comments at the top of this
	 * class)
	 */
	@Override
	public void add(int pos, T data) throws ListException {
		throw new UnsupportedOperationException("can't add at a specific position in a sorted list");
	}

	private int getSortPosition(T data) {
		int position = 0;
		try {
			for (int i = 0; i < size(); i++) {
				if (get(i).compareTo(data) < 0) { // T implements Comparable<T>
					position++;
				}
			}
		} catch (ListException e) {
			// i is always between 0 and size(); no ListException can be thrown
		}
		return position;
	}
}
