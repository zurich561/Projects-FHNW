package woche10_Neue_Datenstruktur;

public class ListException extends Exception {
	enum ListErrorCode { PositionTooSmall, PositionTooLarge; }

	public ListException(ListErrorCode error) {
		super(error.toString());
	}
}