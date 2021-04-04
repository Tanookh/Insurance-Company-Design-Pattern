package JavaFxController;

import javafx.stage.Stage;
import mainClasses.jsonread;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import client.ChatClient;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	
	mainClasses.Singleton singletonLogger = mainClasses.Singleton.getInstance();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button LoginBtn;

	@FXML
	private Text QuestionMarkText;

	@FXML
	private Text WrongInfoText;

	@FXML
	private Button QuestionMark;

	@FXML
	private TextField UsernameLbl;

	@FXML
	private TextField PasswordShowLbl;

	@FXML
	private PasswordField PasswordLbl;

	@FXML
	private Text jsonText;

	@FXML
	private Text FillAllFieldsTxt;

	@FXML
	private Text Call1900Pass;

	@FXML
	private Text Call1900Register;

	@FXML
	private Button ForgotPassTxt;

	@FXML
	private Button NotAUserHere;

	@FXML
	private Button PasswordEye;

	private int ShowPassCount = 0;

	@FXML
	void PasswordEyePressed(ActionEvent event) {
		if (ShowPassCount == 1) {
			PasswordLbl.setText(PasswordShowLbl.getText());
			PasswordShowLbl.setVisible(false);
			PasswordLbl.setVisible(true);
			ShowPassCount = 0;
			return;
		}
		PasswordShowLbl.setText(PasswordLbl.getText());
		PasswordLbl.setVisible(false);
		PasswordShowLbl.setVisible(true);
		ShowPassCount = 1;
		return;
	}

	private int ForgotPassCount = 0;

	@FXML
	void ForgotPassPressed(ActionEvent event) {
		if (ForgotPassCount == 0) {
			Call1900Pass.setVisible(true);
			ForgotPassCount = 1;
			return;
		}
		Call1900Pass.setVisible(false);
		ForgotPassCount = 0;
		return;
	}

	private int RegisterTxtCount = 0;

	@FXML
	void NotAUserHerePressed(ActionEvent event) {
		if (RegisterTxtCount == 0) {
			Call1900Register.setVisible(true);
			RegisterTxtCount = 1;
			return;
		}
		Call1900Register.setVisible(false);
		RegisterTxtCount = 0;
		return;
	}

	@FXML
	void LoginBtnPressed(ActionEvent event) throws Exception {
		QuestionMarkText.setVisible(false);
		WrongInfoText.setVisible(false);
		FillAllFieldsTxt.setVisible(false);
		String UserName = UsernameLbl.getText();
		String Password = PasswordLbl.getText();
		if (ShowPassCount == 1) {
			Password = PasswordShowLbl.getText();
		}
		if (UserName.trim().isEmpty() || Password.trim().isEmpty()) {
			FillAllFieldsTxt.setVisible(true);
			return;
		}
		String query = new String("checkUserExistance#" + UserName + "#" + Password);
		ClientUI.chat.accept(query);
		if (ChatClient.userExistance.equals("userDoesNotExist")) {
			WrongInfoText.setVisible(true);
			return;
		}
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Stage primaryStage = new Stage();
		AnchorPane root = loader.load(getClass().getResource("/JavaFx/Main.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Main Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private int QuestionMarkCount = 0;

	@FXML
	void QuestionMarkPressed(ActionEvent event) throws Exception {
		if (QuestionMarkCount == 0) {
			QuestionMarkText.setVisible(true);
			QuestionMarkCount = 1;
			return;
		}
		QuestionMarkText.setVisible(false);
		QuestionMarkCount = 0;
		return;
	}

	@FXML
	void initialize() throws FileNotFoundException {
		assert UsernameLbl != null : "fx:id=\"UsernameLbl\" was not injected: check your FXML file 'Login.fxml'.";
		assert PasswordShowLbl != null
				: "fx:id=\"PasswordShowLbl\" was not injected: check your FXML file 'Login.fxml'.";
		assert PasswordLbl != null : "fx:id=\"PasswordLbl\" was not injected: check your FXML file 'Login.fxml'.";
		assert LoginBtn != null : "fx:id=\"LoginBtn\" was not injected: check your FXML file 'Login.fxml'.";
		assert QuestionMarkText != null
				: "fx:id=\"QuestionMarkText\" was not injected: check your FXML file 'Login.fxml'.";
		assert WrongInfoText != null : "fx:id=\"WrongInfoText\" was not injected: check your FXML file 'Login.fxml'.";
		assert Call1900Pass != null : "fx:id=\"Call1900Pass\" was not injected: check your FXML file 'Login.fxml'.";
		assert Call1900Register != null
				: "fx:id=\"Call1900Register\" was not injected: check your FXML file 'Login.fxml'.";
		assert FillAllFieldsTxt != null
				: "fx:id=\"FillAllFieldsTxt\" was not injected: check your FXML file 'Login.fxml'.";
		assert QuestionMark != null : "fx:id=\"QuestionMark\" was not injected: check your FXML file 'Login.fxml'.";
		assert ForgotPassTxt != null : "fx:id=\"ForgotPassTxt\" was not injected: check your FXML file 'Login.fxml'.";
		assert NotAUserHere != null : "fx:id=\"NotAUserHere\" was not injected: check your FXML file 'Login.fxml'.";
		assert PasswordEye != null : "fx:id=\"PasswordEye\" was not injected: check your FXML file 'Login.fxml'.";
		jsonread.main(null);
		String JsonText = "Version " + jsonread.version + "\nDesigned & Developed by:\n" + jsonread.firstName.toString()
				+ " and " + jsonread.secondName.toString();
		jsonText.setText(JsonText);
		UsernameLbl.setText(jsonread.username);
		PasswordShowLbl.setText(jsonread.loginpassword);
		PasswordLbl.setText(jsonread.loginpassword);
		singletonLogger.addToFileStart();
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/JavaFx/Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}