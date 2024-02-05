package oneTimePad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OneTimePadModel {

    private static String KEY = "Ressource/DefinedKey.txt";
    private String currentKey;
    private int keyPosition = 0;

    //Diese Methode generiert den nötigen Key zur Verschlüsselung der Nachricht.
    public String generateDefinedKey (int keyLength) throws IOException {
        StringBuilder key = new StringBuilder();

        try (FileReader fileReader = new FileReader(KEY);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int c;
            int count = 0;

            while (count < keyPosition && (c = bufferedReader.read()) != -1) {

            	//Hier werden Umlaute und Sonderzeichen ausgelassen und 1:1 in die verschlüsselte bzw. entschlüsselte Nachricht eingefügt.
                if (c == 'ä' || c == 'ö' || c == 'ü' || c == '«' || c == '»' || c == '…') {
                    continue;
                }
                count++;
            }

            // Lies jetzt die nächsten keyLength Zeichen
            while ((c = bufferedReader.read()) != -1 && count < keyLength + keyPosition) {

                if (c == 'ä' || c == 'ö' || c == 'ü' || c == '«' || c == '»' || c == '…') {
                    continue;
                }
                key.append((char) c);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Der aktuelle Key wird in currentKey zwischengespeichert
        this.currentKey = key.toString();
        return this.currentKey;
    }


    private char getKeyChar(int position) {
        return currentKey.charAt(position % currentKey.length());
    }


    //Der zuletzt genutzte Key wird zurückgegeben
    public String getCurrentKey() {
    	return this.currentKey;
    }

    //Methode zur Verschlüsselung
    public String encryptTxt(String txtStandard, String keyDefined) {
        if (this.currentKey == null || this.currentKey.isEmpty()) {
            return "Schlüssel nicht definiert";
        }

        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < txtStandard.length(); i++) {
            char messageChar = txtStandard.charAt(i);
            char keyChar = getKeyChar(keyPosition++);


          //Zeilenumbruch wird ignoriert und wieder eingefügt
            if (messageChar == '\n') {
                encryptedMessage.append(messageChar);
                continue;
            }

          //Umlaute werden umgewandelt
            if (messageChar == 'ä' || messageChar == 'ö' || messageChar == 'ü' || messageChar == '«' || messageChar == '»' || messageChar == '…') {
                if (messageChar == 'ä') {
					messageChar = 'a';
				} else if (messageChar == 'ö') {
					messageChar = 'o';
				} else if (messageChar == 'ü') {
					messageChar = 'u';
				} else {
                	encryptedMessage.append(messageChar);
                	continue;
                }
            }

            //Numerischer Wert des Zeichens minus 0x20
            int messageValue = messageChar - 0x20;
            int keyValue = keyChar - 0x20;
            // Die oberen zwei Werte addieren und Modulo 95 anwenden
            int encryptedValue = (messageValue + keyValue) % 95;
            // Wert in ein Zeichen umwandeln, indem wir 0x20 dazu addieren
            char encryptedChar = (char) (encryptedValue + 0x20);
            encryptedMessage.append(encryptedChar);
        }

        return encryptedMessage.toString();
    }

  //Methode zur Entschlüsselung
    public String decryptTxt(String encryptedMessage, String key) {
        if (encryptedMessage.isEmpty() || this.currentKey.isEmpty() || encryptedMessage.length() != this.currentKey.length()) {
            return "Ungültige Eingabe";
        }

        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char encryptedChar = encryptedMessage.charAt(i);
            char keyChar = getKeyChar(keyPosition++);

            if ((encryptedChar == '\n') || encryptedChar == '«' || encryptedChar == '»' || encryptedChar == '…') {
                decryptedMessage.append(encryptedChar);
                continue;
            }

            //Numerischer Wert des Zeichens minus 0x20
            int encryptedValue = encryptedChar - 0x20;
            int keyValue = keyChar - 0x20;

            //Den verschlüsselten Wert subtrahieren und sicherstellen, dass er nicht negativ ist
            int decryptedValue = (encryptedValue - keyValue + 95) % 95;

            //Wert in ein Zeichen umwandeln, indem wir 0x20 dazu addieren
            char decryptedChar = (char) (decryptedValue + 0x20);

            decryptedMessage.append(decryptedChar);
        }

        return decryptedMessage.toString();
    }
}
