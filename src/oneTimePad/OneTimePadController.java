package oneTimePad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyEvent;

public class OneTimePadController implements EventHandler<ActionEvent> {
	private static final EventHandler<? super KeyEvent> Event = null;

	private OneTimePadModel model;
	private OneTimePadView view;

	public OneTimePadController(OneTimePadView view, OneTimePadModel model) throws Exception {

		this.view = view;

		//encryptButton verstecken, wenn txtMessage leer
		view.encryptDecryptButton.setVisible(false);
		view.txtInputUser.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (newValue.isEmpty()) {
		    	view.encryptDecryptButton.setVisible(false);
		    } else {
		    	view.encryptDecryptButton.setVisible(true);
		    }
		});

		//encrypt Button verstecken, wenn encryptCode generiert ist
		view.ecryptDecryptMessage.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (newValue.isEmpty()) {
		    } else {
		        view.encryptDecryptButton.setVisible(false);
		    }
		});

		//TextFeld deaktivieren, wenn Code generiert wurde
		view.ecryptDecryptMessage.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (newValue.isEmpty()) {
		        view.txtInputUser.setEditable(true);
		    } else {
		    	view.txtInputUser.setEditable(false);
		    }
		});

		//Button Stil, je nachdem welcher Modus gewählt wurde
		view.modeLabel.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals("Verschlüsselung")) { view.questionButtonEncrypt.getStyleClass().add("stylePressedButton");
														view.questionButtonDecrypt.getStyleClass().remove("stylePressedButton");
			}
			else if (newValue.equals("Entschlüsselung")) { view.questionButtonDecrypt.getStyleClass().add("stylePressedButton");
															view.questionButtonEncrypt.getStyleClass().remove("stylePressedButton");
			}
			else {view.questionButtonDecrypt.getStyleClass().remove("stylePressedButton");
					view.questionButtonEncrypt.getStyleClass().remove("stylePressedButton");
			}
		});

		//deleteAll Button verstecken bzw. anzeigen, wenn ecryptDecryptMessage leer bzw. befüllt ist.
		view.deleteAll.setVisible(false);
		view.ecryptDecryptMessage.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (newValue.isEmpty()) {
		        view.deleteAll.setVisible(false);
		        view.txtInputUser.setVisible(false);
		    } else {
		        view.deleteAll.setVisible(true);
		    }
		});

		//CopyCode Button anzeigen, wenn Nachricht erfolgreich ver- oder entschlüsselt wurde
		view.copyCode.setVisible(false);
		view.ecryptDecryptMessage.setVisible(false);
		view.ecryptDecryptMessage.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (newValue.isEmpty()) {
		        view.copyCode.setVisible(false);

		    } else {
		        view.copyCode.setVisible(true);

		        view.ecryptDecryptMessage.setVisible(true);
		    }
		});

		//Ver- bzw. Entschlüsselungs-Button anzeigen, wenn txtInputUser befüllt ist.
		view.encryptDecryptButton.setOnAction( Event -> {
			String input = view.txtInputUser.getText();
			String keyDefined = null;
			String mode = view.modeLabel.getText();
			if ("Verschlüsselung".equals(mode)) {
				try {
					keyDefined = model.generateDefinedKey(view.txtInputUser.getLength());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!input.isEmpty()) {
					view.encryptDecryptButton.setDisable(false);
					view.ecryptDecryptMessage.appendText(model.encryptTxt(input, keyDefined));
				}
			} else {
				try {
					keyDefined = model.getCurrentKey();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!input.isEmpty()) {
					view.encryptDecryptButton.setDisable(false);
					view.ecryptDecryptMessage.appendText(model.decryptTxt(input, keyDefined));
				}
			}
		});

		//Aktiviert Modus zur Verschlüsselung
		view.questionButtonEncrypt.setOnAction( Event -> {
			view.txtInputUser.setVisible(true);
			view.modeLabel.setText("Verschlüsselung");

		});

		//Aktiviert Modus zur Entschlüsselung
		view.questionButtonDecrypt.setOnAction( Event -> {
			view.txtInputUser.setVisible(true);
			view.modeLabel.setText("Entschlüsselung");

		});

		//Kopiert den Inhalt der ver- oder entschlüsselten Nachricht in die Zwischenablage
        view.copyCode.setOnAction( Event -> {
            String textToCopy = view.ecryptDecryptMessage.getText();
            view.copyCode.getStyleClass().add("copyCodeButtonPressed");
            view.copyCode.setText("Text wurde in die Zwischenablage kopiert.");
            view.copyCode.setDisable(true);
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(textToCopy);
            clipboard.setContent(content);
            System.out.println("Text wurde in die Zwischenablage kopiert.");
        });

        //Setzt das UI wieder zurück
		view.deleteAll.setOnAction( Event -> {
			view.txtInputUser.setText("");
			view.ecryptDecryptMessage.setText("");
			view.modeLabel.setText("Modus auswählen:");
			view.ecryptDecryptMessage.setVisible(false);
			view.copyCode.getStyleClass().remove("copyCodeButtonPressed");
			view.copyCode.setText("Copy");
			view.copyCode.setDisable(false);
		});

	}

	//Events jeweils direkt erfasst
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}





}
