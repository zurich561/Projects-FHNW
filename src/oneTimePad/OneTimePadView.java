package oneTimePad;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OneTimePadView {
	protected Stage stage;
	protected OneTimePadModel model;

	protected Label questionLabel;
	protected Button questionButtonDecrypt;
	protected Button questionButtonEncrypt;
	protected Label title;
	protected Label titleTxtMessage;
	protected Label titleDecryptedTxtMessage;
	protected TextArea decryptedTxtMessage;
	protected Label titleEncryptCode;
	protected TextArea txtInputUser;
	protected Button encryptDecryptButton;
	protected TextArea ecryptDecryptMessage;
	protected Button copyCode;
	protected Button deleteAll;
	protected Image logo;
	protected Label modeLabel;

	protected Integer WIDTH = 600;
	protected Integer HEIGTH = 500;
	protected Integer WIDTHTEXT = WIDTH;


	public OneTimePadView(Stage stage, OneTimePadModel model) {

		this.stage = stage;
		this.model = model;

		BorderPane root = new BorderPane();
		root.setPrefSize(WIDTH, HEIGTH);

		GridPane topGrid = new GridPane();
		topGrid.setId("topGrid");
		root.setTop(topGrid);
		ColumnConstraints column1 = new ColumnConstraints(); //TEST 1
		column1.setPercentWidth(100);
		topGrid.getColumnConstraints().add(column1);

		GridPane gridCenter = new GridPane();
		root.setCenter(gridCenter);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(100);
		gridCenter.getColumnConstraints().add(column2);

		GridPane bottomGrid = new GridPane();
		root.setBottom(bottomGrid);
		ColumnConstraints column = new ColumnConstraints();
		column.setPercentWidth(100);
		bottomGrid.getColumnConstraints().add(column);

		Image logo = new Image(getClass().getResource("/oneTimePad/LogoSalentoSento.png").toExternalForm());
		ImageView logoView = new ImageView(logo);
		Integer imageWidth = 400;
		logoView.setFitHeight(imageWidth * 0.35026965);
		logoView.setFitWidth(imageWidth);
		GridPane.setHalignment(logoView, javafx.geometry.HPos.CENTER);
		topGrid.add(logoView, 0, 0);

		modeLabel = new Label("Modus auswählen:");
		GridPane.setHalignment(modeLabel, javafx.geometry.HPos.CENTER);
		modeLabel.setId("modeLabel");
		topGrid.add(modeLabel, 0, 1);

		HBox buttonHBox = new HBox();
		buttonHBox.setAlignment(Pos.CENTER);
		buttonHBox.setPadding(new Insets(20, 20, 20, 20));
		GridPane.setHalignment(buttonHBox, javafx.geometry.HPos.CENTER);
		topGrid.add(buttonHBox, 0, 3);

		Image encryptButtonImage = new Image(getClass().getResource("/oneTimePad/LockClosed.png").toExternalForm());
		ImageView encryptButtonView = new ImageView(encryptButtonImage);
		encryptButtonView.setFitHeight(30);
		encryptButtonView.setFitWidth(30);
		questionButtonEncrypt = new Button();
		questionButtonEncrypt.setId("questionButtonEncrypt");
		questionButtonEncrypt.setGraphic(encryptButtonView);
		double spacingEncryptButton = 5;
		GridPane.setMargin(questionButtonEncrypt, new javafx.geometry.Insets(0, spacingEncryptButton, 0, spacingEncryptButton));
		buttonHBox.getChildren().add(questionButtonEncrypt);

		Image decryptButtonImage = new Image(getClass().getResource("/oneTimePad/LockOpen.png").toExternalForm());
		ImageView decryptButtonView = new ImageView(decryptButtonImage);
		decryptButtonView.setFitHeight(30);
		decryptButtonView.setFitWidth(30);
		questionButtonDecrypt = new Button();
		questionButtonDecrypt.setId("questionButtonDecrypt");
		questionButtonDecrypt.setGraphic(decryptButtonView);
		double spacingDecryptButton = 5;
		GridPane.setMargin(questionButtonDecrypt, new javafx.geometry.Insets(0, spacingDecryptButton, 0, spacingDecryptButton));
		buttonHBox.getChildren().add(questionButtonDecrypt);

		txtInputUser = new TextArea();
		txtInputUser.setMinHeight(30);
		txtInputUser.setVisible(false);
		GridPane.setHalignment(txtInputUser, javafx.geometry.HPos.CENTER);
		double spacingTxtInputUser = 5;
		GridPane.setMargin(txtInputUser, new javafx.geometry.Insets(0, spacingTxtInputUser, 0, spacingTxtInputUser));
		gridCenter.add(txtInputUser, 0, 1);

		encryptDecryptButton = new Button();
		encryptDecryptButton.setText("Weiter");
		double spacing = 5;
		GridPane.setMargin(encryptDecryptButton, new javafx.geometry.Insets(spacing, spacing, spacing, spacing));
		gridCenter.add(encryptDecryptButton, 0, 2);

		ecryptDecryptMessage = new TextArea();
		ecryptDecryptMessage.setId("encryptionCodeTxtField");
		ecryptDecryptMessage.setEditable(false);
		double spacingEcryptDecryptMessage = 5;
		GridPane.setMargin(ecryptDecryptMessage, new javafx.geometry.Insets(0, spacingEcryptDecryptMessage, 0, spacingEcryptDecryptMessage));
		gridCenter.add(ecryptDecryptMessage, 0, 4);

		copyCode = new Button();
		copyCode.setText("Copy");
		copyCode.setId("copyCodeButton");
        double spacing1 = 5;
        GridPane.setMargin(copyCode, new javafx.geometry.Insets(spacing1, spacing1, spacing1, spacing1));
        gridCenter.add(copyCode, 0, 5);

		deleteAll = new Button();
		deleteAll.setText("Fertig");
		deleteAll.setMinWidth(80);
        double spacingDeletAll = 5;
		bottomGrid.add(deleteAll, 0, 0);
		deleteAll.setId("deleteAllButton");
        GridPane.setMargin(deleteAll, new javafx.geometry.Insets(0, 0, spacingDeletAll, 0));
		GridPane.setHalignment(deleteAll, javafx.geometry.HPos.CENTER);



		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("/oneTimePad/oneTimePad.css").toExternalForm());
		stage.setTitle("One Time Pad Verschlüsselung");
		stage.setScene(scene);


	}

	public void start() {
		stage.show();

	}

}
