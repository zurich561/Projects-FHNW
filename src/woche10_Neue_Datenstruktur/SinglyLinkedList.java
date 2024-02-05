package woche10_Neue_Datenstruktur;

import woche10_Neue_Datenstruktur.ListException.ListErrorCode;

public class SinglyLinkedList<T> {
    private ListElement<T> head = null;

    public void add(int position, T data) throws ListException {
        ListElement<T> newNode = new ListElement<>(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else if (position > 0) {
            insertNodeAtPosition(position, newNode);
        } else {
            throw new ListException(ListErrorCode.PositionTooSmall);
        }
    }
    
	public T get(int position) throws ListException {
		if (position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		ListElement<T> cursor = head;
		for (int pos = 0; pos < position; pos++) {
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			cursor = cursor.next;
		}
		if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
		return cursor.getData();
	}

    private void insertNodeAtPosition(int position, ListElement<T> newNode) throws ListException {
        ListElement<T> current = head;

        for (int pos = 1; pos < position; pos++) {
            if (current == null) throw new ListException(ListErrorCode.PositionTooSmall);
            current = current.next;
        }

        if (current == null) throw new ListException(ListErrorCode.PositionTooSmall);

        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean contains(T element) {
        ListElement<T> current = head;

        while (current != null) {
            if (element == null) {
                if (current.getData() == null) {
                    return true;
                }
            } else {
                if (element.equals(current.getData())) {
                    return true;
                }
            }
            current = current.next;
        }

        return false;
    }

    public T remove(int position) throws ListException {
        if (position == 0) {
            return removeFirstNode();
        } else if (position > 0) {
            return removeNodeAtPosition(position);
        } else {
            throw new ListException(ListErrorCode.PositionTooSmall);
        }
    }

    private T removeFirstNode() throws ListException {
        if (head == null) throw new ListException(ListErrorCode.PositionTooLarge);

        T data = head.getData();
        head = head.next;
        return data;
    }

    private T removeNodeAtPosition(int position) throws ListException {
        ListElement<T> current = head;

        for (int pos = 1; pos < position; pos++) {
            if (current == null) throw new ListException(ListErrorCode.PositionTooLarge);
            current = current.next;
        }

        if (current == null || current.next == null) throw new ListException(ListErrorCode.PositionTooLarge);

        T data = current.next.getData();
        current.next = current.next.next;
        return data;
    }

    public int size() {
        int count = 0;
        ListElement<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
