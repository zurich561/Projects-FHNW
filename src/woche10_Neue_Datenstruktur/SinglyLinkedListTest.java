package woche10_Neue_Datenstruktur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
	private SinglyLinkedList<String> myList;

	/**
	 * This method is run before each individual test-method. In this case, we reset
	 * the test-list to a new, empty list each time
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myList = new SinglyLinkedList<>();
	}

	@Test
	public void testIllegalAddUpperBound() throws ListException {
		assertThrows(ListException.class, () -> {
			myList.add(1, "one");
		});
	}

	@Test
	public void testIllegalAddLowerBound() throws ListException {
		assertThrows(ListException.class, () -> {
			myList.add(-1, "one");
		});
	}

	@Test
	public void testAddFirst() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);
		final String second = "second";

		// when
		myList.add(0, second);

		// then
		assertEquals(second, myList.get(0));
		assertEquals(first, myList.get(1));
	}

	@Test
	public void testAddLast() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);

		final String second = "second";

		// when
		myList.add(1, second);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(second, myList.get(1));
	}

	@Test
	public void testAddNull() throws Exception {
		// when
		myList.add(0, null);

		// then
		assertNull(myList.get(0));
		assertEquals(1, myList.size());
	}

	@Test
	public void testAddAtPos() throws Exception {
		// given

		final String first = "first";
		final String second = "second";

		// when
		myList.add(0, first);
		myList.add(1, second);

		final String newSecond = "newSecond";
		myList.add(1, newSecond);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(newSecond, myList.get(1));
		assertEquals(second, myList.get(2));
	}

	@Test
	public void testIllegalRemoveUpperBound() throws Exception {

		assertThrows(ListException.class, () -> {
			myList.remove(0);
		});
	}

	@Test
	public void testIllegalRemoveLowerBound() throws Exception {
		assertThrows(ListException.class, () -> {
			myList.remove(-1);
		});
	}

	@Test
	public void testRemove() throws Exception {
		myList.add(0, "one");
		final String two = "two";
		myList.add(1, two);
		myList.remove(0);
		assertEquals(1, myList.size());
		assertSame(two, myList.get(0));
		myList.remove(0);
		//assertTrue(myList.isEmpty());
	}

	@Test
	public void testIllegalGetUpperBound() throws Exception {
		assertThrows(ListException.class, () -> {
			myList.get(0);
		});
	}

	@Test
	public void testIllegalGetLowerBound() throws Exception {
		assertThrows(ListException.class, () -> {
			myList.get(-1);
		});
	}

	/*@Test
	public void testIsEmpty() throws Exception {
		assertTrue(myList.isEmpty());
		myList.add(0, "value");
		assertFalse(myList.isEmpty());
		myList.remove(0);
		assertTrue(myList.isEmpty());
	}*/

	@Test
	public void testContains() throws Exception {
		final String value = "value";
		assertFalse(myList.contains(value));
		myList.add(0, "otherValue");
		assertFalse(myList.contains(value));
		myList.add(0, value);
		assertTrue(myList.contains(value));
		assertFalse(myList.contains(null));
		myList.add(0, null);
		assertTrue(myList.contains(null));
	}

	@Test
	public void testSize() throws Exception {
		assertEquals(0, myList.size());
		myList.add(0, "value");
		assertEquals(1, myList.size());
		myList.remove(0);
		assertEquals(0, myList.size());
	}
}
