package woche12_jUnit_Methoden;

import java.util.ArrayList;

public class AddressFormatter {

	public ArrayList<String> splitLine(String in, int max) {
		final char[] splitCharacters = {' ', ',', '.', ';', ':', '/' };
		ArrayList<String> linesOut = new ArrayList<>();
		int posInString = 0;
		
		while (posInString < in.length()) {
			int breakPosition = posInString + max; 
	
	
			if (breakPosition >= in.length()) {
				linesOut.add(in.substring(posInString));
				posInString = breakPosition;
			} else { 
				boolean splitCharFound = false;
				int pos = breakPosition;
				while (pos > posInString && !splitCharFound) {
					splitCharFound = contains(splitCharacters, in.charAt(pos));
					if (!splitCharFound) pos--;
				}
				if (splitCharFound) {
					linesOut.add(in.substring(posInString, pos));
					posInString = pos + 1; 
				} else {
					linesOut.add(in.substring(posInString, breakPosition));
					posInString = breakPosition;
				}
			}
		}		
		return linesOut;
	}
	
	private boolean contains(char[] chars, char search) {
		for (char c : chars) {
			if (c == search) return true;
		}
		return false;
	}
}
