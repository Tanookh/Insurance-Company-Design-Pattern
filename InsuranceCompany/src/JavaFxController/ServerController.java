package JavaFxController;

import Server.ServerUI;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainClasses.jsonread;
import serverController.mysqlConnection;

public class ServerController {

	public static Connection conn = null;

	@FXML
	private ResourceBundle resources;

    @FXML
    private AnchorPane ServerAnchor;
    
	@FXML
	private URL location;

	@FXML
	private TextField PortLbl;

	@FXML
	private Button RegConnectBtn;

	@FXML
	private Button GreenConnectBtn;

    @FXML
    private Button QuestionMark;
    
    @FXML
    private Text jsonText;

	@FXML
	private Text QuestionMarkText;

	@FXML
	private Button ExitBtn;

	@FXML
	private TextField DataBaseLbl;

	@FXML
	private TextField ServerLbl;

	@FXML
	private TextField PasswordLbl;

	@FXML
	private Text WrongInfoText;

	@FXML
	void ExitBtnPressed(ActionEvent event) throws Exception {
		System.exit(0);
	}

	@FXML
	void RegConnectBtnPressed(ActionEvent event) throws Exception {
		String port, password, name, server;
		port = PortLbl.getText();
		name = DataBaseLbl.getText();
		server = ServerLbl.getText();
		password = PasswordLbl.getText();
		if (port.trim().isEmpty() || password.trim().isEmpty() || name.trim().isEmpty() || server.trim().isEmpty()) {
			WrongInfoText.setVisible(true);
			QuestionMarkText.setVisible(false);
		} else {
			WrongInfoText.setVisible(false);
			QuestionMarkText.setVisible(false);
			ServerUI.runServer(port);
			if ((conn = mysqlConnection.connector(port, name, server, password)) != null) {
				GreenConnectBtn.setVisible(true);
				RegConnectBtn.setVisible(false);
			}
		}
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
        assert ServerAnchor != null : "fx:id=\"ServerAnchor\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert PortLbl != null : "fx:id=\"PortLbl\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert RegConnectBtn != null : "fx:id=\"RegConnectBtn\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert GreenConnectBtn != null : "fx:id=\"GreenConnectBtn\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert QuestionMarkText != null : "fx:id=\"QuestionMarkText\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert ExitBtn != null : "fx:id=\"ExitBtn\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert DataBaseLbl != null : "fx:id=\"DataBaseLbl\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert ServerLbl != null : "fx:id=\"ServerLbl\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert PasswordLbl != null : "fx:id=\"PasswordLbl\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert WrongInfoText != null : "fx:id=\"WrongInfoText\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert QuestionMark != null : "fx:id=\"QuestionMark\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        assert jsonText != null : "fx:id=\"jsonText\" was not injected: check your FXML file 'ServerConnect.fxml'.";
        jsonread.main(null);
        String JsonText = "Version " + jsonread.version + "\nDesigned & Developed by:\n" + jsonread.firstName.toString() + " and " + jsonread.secondName.toString();
		jsonText.setText(JsonText);
		PortLbl.setText(jsonread.port);
		DataBaseLbl.setText(jsonread.name);
		ServerLbl.setText(jsonread.server);
		PasswordLbl.setText(jsonread.password);
	}

	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/JavaFx/ServerConnect.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
