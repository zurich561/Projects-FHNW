package woche12_jUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import woche12_jUnit_Methoden.WebAddressValidator;


class PortNumberTest {
	private WebAddressValidator wav = new WebAddressValidator();
	
	//String Test
	@Test
	void mitBuchstaben() {
		assertFalse(wav.isValidPortNumber(null));
		assertFalse(wav.isValidPortNumber(""));
		assertFalse(wav.isValidPortNumber("hallo"));
		assertFalse(wav.isValidPortNumber("hallo123"));
	}	
	
	//IntegerTest	
	@Test
	void zahlen() {
		assertFalse(wav.isValidPortNumber("-1"));
		assertFalse(wav.isValidPortNumber("0"));
		assertTrue(wav.isValidPortNumber("1"));
		assertTrue(wav.isValidPortNumber("100"));
	}

}
