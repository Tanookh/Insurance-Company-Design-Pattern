package JavaFxController;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import client.ChatClient;
import client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Criteria;
import mainClasses.CriteriaApartment;
import mainClasses.CriteriaCar;
import mainClasses.CriteriaHealth;
import mainClasses.CriteriaLife;
import mainClasses.Insurance;
import mainClasses.OrCriteria;
import mainClasses.jsonread;

public class MainController {
	
	mainClasses.Singleton singletonLogger = mainClasses.Singleton.getInstance();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ViewPurchaseBtn;

	@FXML
	private Button CarInsBtn;
	

    @FXML
    private AnchorPane FirstMainAnchor;

	@FXML
	private Button ApartmentInsBtn;

	@FXML
	private Button LifeInsBtn;

	@FXML
	private Button HealthInsBtn;
	
    @FXML
    private Text jsonText;
    
    @FXML
    private Text jsonText1;
    
    @FXML
    private Text jsonText11;

	@FXML
	private ChoiceBox<String> SellChoiceBox;

	ObservableList<String> NewInsChoice = FXCollections.observableArrayList("Car Insurance", "Apartment Insurance",
			"Health Insurance", "Life Insurance");

	@FXML
	private Button CarInsGreenBtn;

	@FXML
	private Button ApartmentInsGreenBtn;

	@FXML
	private Button LifeInsGreenBtn;

	@FXML
	private Button HealthInsGreenBtn;

	@FXML
	private Button SellBtn;

	@FXML
	private Button QuestionMark;

	@FXML
	private Text QuestionMarkTxt;

	@FXML
	private AnchorPane NewInsAnchorPane;

	@FXML
	private AnchorPane ViewInsAnchorPane;

	@FXML
	private Text NewLifeInsTxt;

	@FXML
	private Text NewApartmentInsTxt;

	@FXML
	private Text NewHealthInsTxt;

	@FXML
	private Text NewCarInsTxt;

	@FXML
	private Button NewInsBackBtn;

	@FXML
	private Button SaveBtn;

	@FXML
	private Text RequiredFieldText;

	@FXML
	private Text NewInsFillReqFieldsText;

	@FXML
	private Text ChooseInsText;

	@FXML
	private Button ViewInsBackBtn;

	@FXML
	private TextField NewInsFullNameLbl;

	@FXML
	private TextField NewInsIDLbl;

	@FXML
	private TextField NewInsDateLbl;

	@FXML
	private Text DataSavedSuccessfullyText;

	@FXML
	private Text DataSavedFailedText;

	@FXML
	private TextField NewInsRemarksLbl;
	
    @FXML
    private Text CategoryTxt;

	@FXML
	private TableView<Insurance> ViewInsTable;

	@FXML
	private TableColumn<Insurance, String> ViewInsName;

	@FXML
	private TableColumn<Insurance, String> ViewInsID;

	@FXML
	private TableColumn<Insurance, String> ViewInsDate;

	@FXML
	private TableColumn<Insurance, String> ViewInsRemarks;

	@FXML
	private TableColumn<Insurance, String> ViewInsType;

	private int GreenCounter = 0;
	private ArrayList<String> GreenBtns = new ArrayList();

	@FXML
	void ApartmentInsBtnPressed(ActionEvent event) {
		ApartmentInsGreenBtn.setVisible(true);
		ApartmentInsBtn.setVisible(false);
		GreenBtns.add("Apartment");
		GreenCounter++;
	}

	@FXML
	void ApartmentInsGreenBtnPressed(ActionEvent event) {
		ApartmentInsGreenBtn.setVisible(false);
		ApartmentInsBtn.setVisible(true);
		GreenBtns.remove("Apartment");
		GreenCounter--;
	}

	@FXML
	void CarInsBtnPressed(ActionEvent event) {
		CarInsGreenBtn.setVisible(true);
		CarInsBtn.setVisible(false);
		GreenBtns.add("Car");
		GreenCounter++;
	}

	@FXML
	void CarInsGreenBtnPressed(ActionEvent event) {
		CarInsGreenBtn.setVisible(false);
		CarInsBtn.setVisible(true);
		GreenBtns.remove("Car");
		GreenCounter--;
	}

	@FXML
	void HealthInsBtnPressed(ActionEvent event) {
		HealthInsGreenBtn.setVisible(true);
		HealthInsBtn.setVisible(false);
		GreenBtns.add("Health");
		GreenCounter++;
	}

	@FXML
	void HealthInsGreenBtnPressed(ActionEvent event) {
		HealthInsGreenBtn.setVisible(false);
		HealthInsBtn.setVisible(true);
		GreenBtns.remove("Health");
		GreenCounter--;
	}

	@FXML
	void LifeInsBtnPressed(ActionEvent event) {
		LifeInsGreenBtn.setVisible(true);
		LifeInsBtn.setVisible(false);
		GreenBtns.add("Life");
		GreenCounter++;
	}

	@FXML
	void LifeInsGreenBtnPressed(ActionEvent event) {
		LifeInsGreenBtn.setVisible(false);
		LifeInsBtn.setVisible(true);
		GreenBtns.remove("Life");
		GreenCounter--;
	}

	@FXML
	void NewInsBackBtnPressed(ActionEvent event) throws IOException {
		NewInsAnchorPane.setVisible(false);
		singletonLogger.printBought();
		initialize();
	}

	private int QuestionMarkCount = 0;

	@FXML
	void QuestionMarkPressed(ActionEvent event) throws Exception {
		if (QuestionMarkCount == 0) {
			QuestionMarkTxt.setVisible(true);
			QuestionMarkCount = 1;
			return;
		}
		QuestionMarkTxt.setVisible(false);
		QuestionMarkCount = 0;
		return;
	}

	private int WhatSell = 0;

	@FXML
	void SellBtnPressed(ActionEvent event) {

		String NewInsShowText = SellChoiceBox.getValue();
		if (NewInsShowText == null) {
			ChooseInsText.setVisible(true);
			return;
		}
		NewInsAnchorPane.setVisible(true);
		if (NewInsShowText.equals("Car Insurance")) {
			NewCarInsTxt.setVisible(true);
			WhatSell = 1;
		} else if (NewInsShowText.equals("Apartment Insurance")) {
			NewApartmentInsTxt.setVisible(true);
			WhatSell = 2;
		} else if (NewInsShowText.equals("Health Insurance")) {
			NewHealthInsTxt.setVisible(true);
			WhatSell = 3;
		} else if (NewInsShowText.equals("Life Insurance")) {
			NewLifeInsTxt.setVisible(true);
			WhatSell = 4;
		}
		RequiredFieldText.setVisible(true);
	}

	@FXML
	void SaveBtnPressed(ActionEvent event) throws IOException {
		NewInsFillReqFieldsText.setVisible(false);
		DataSavedSuccessfullyText.setVisible(false);
		DataSavedFailedText.setVisible(false);
		String FullName = NewInsFullNameLbl.getText();
		String ID = NewInsIDLbl.getText();
		String Date = NewInsDateLbl.getText();
		String Remarks = NewInsRemarksLbl.getText();
		String InsuranceType = new String();
		switch (WhatSell) {
		case 1:
			InsuranceType = "Car";
			break;
		case 2:
			InsuranceType = "Apartment";
			break;
		case 3:
			InsuranceType = "Health";
			break;
		case 4:
			InsuranceType = "Life";
			break;
		}
		if (FullName == null || ID == null || Date == null || NewInsFullNameLbl.getText().trim().isEmpty()
				|| NewInsIDLbl.getText().trim().isEmpty() || NewInsDateLbl.getText().trim().isEmpty()) {
			NewInsFillReqFieldsText.setVisible(true);
			return;
		}
		if (Remarks == null || NewInsRemarksLbl.getText().trim().isEmpty()) {
			Remarks = "No remarks";
		}
		String query = new String(
				"SaveInsuranceData#" + FullName + "#" + ID + "#" + Date + "#" + Remarks + "#" + InsuranceType);
		ClientUI.chat.accept(query);
		query = new String(
				"GetSpecificInsuranceData#" + FullName + "#" + ID + "#" + Date + "#" + Remarks + "#" + InsuranceType);
		ClientUI.chat.accept(query);
		if (ChatClient.DataSaved.equals("true")) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
			singletonLogger.newInsurance.add("User sold " + FullName + " " + InsuranceType + " insurance on " + date);
			singletonLogger.printBought();
			StringBuilder sb = new StringBuilder();
			sb.append(FullName + ",");
			sb.append(ID + ",");
			sb.append(Date + ",");
			sb.append(Remarks + ",");
			sb.append(InsuranceType);
			sb.append("\n");
			singletonLogger.addToFile(sb);
			//singletonLogger.addToFile(FullName + ", " + ID + ", " + Date + ", " + Remarks + ", " + InsuranceType + "\n");
			//singletonLogger.addToFile(sb);
			DataSavedSuccessfullyText.setVisible(true);
			NewInsFullNameLbl.setText(null);
			NewInsIDLbl.setText(null);
			NewInsDateLbl.setText(null);
			NewInsRemarksLbl.setText(null);
			return;
		}
		DataSavedFailedText.setVisible(true);
		NewInsFullNameLbl.setText(null);
		NewInsIDLbl.setText(null);
		NewInsDateLbl.setText(null);
		NewInsRemarksLbl.setText(null);
		return;
	}

	@FXML
	void ViewInsBackBtnPressed(ActionEvent event) throws IOException {
		ViewInsAnchorPane.setVisible(false);
		singletonLogger.printBought();
		initialize();
	}

	@FXML
	void ViewPurchaseBtnPressed(ActionEvent event) throws IOException {
		CategoryTxt.setVisible(false);
		if (GreenCounter == 0) {
			CategoryTxt.setVisible(true);
			return;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		singletonLogger.newInsurance.add("User viewd the " + GreenBtns.toString() + " insurances on " + date);
		singletonLogger.printBought();
		ViewInsAnchorPane.setVisible(true);
		ViewInsName.setCellValueFactory(new PropertyValueFactory<Insurance, String>("Name"));
		ViewInsID.setCellValueFactory(new PropertyValueFactory<Insurance, String>("ID"));
		ViewInsDate.setCellValueFactory(new PropertyValueFactory<Insurance, String>("Date"));
		ViewInsRemarks.setCellValueFactory(new PropertyValueFactory<Insurance, String>("Remarks"));
		ViewInsType.setCellValueFactory(new PropertyValueFactory<Insurance, String>("Type"));
		parseInsuranceList();
	}

	@SuppressWarnings("unchecked")
	private void parseInsuranceList() {
		String query = new String("getData");
		ClientUI.chat.accept(query);
		List<Insurance> ShowThisTable = new ArrayList<Insurance>();
		Criteria CarInsurance = new CriteriaCar();
		List<Insurance> CarInsurances = CarInsurance.meetCriteria(ChatClient.InsuranceList);
		Criteria ApartmentInsurance = new CriteriaApartment();
		List<Insurance> ApartmentInsurances = ApartmentInsurance.meetCriteria(ChatClient.InsuranceList);
		Criteria HealthInsurance = new CriteriaHealth();
		List<Insurance> HealthInsurances = HealthInsurance.meetCriteria(ChatClient.InsuranceList);
		Criteria LifeInsurance = new CriteriaLife();
		List<Insurance> LifeInsurances = LifeInsurance.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrApartment = new OrCriteria(CarInsurance, ApartmentInsurance);
		List<Insurance> CarOrApartmentInsurances = CarOrApartment.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrHealth = new OrCriteria(CarInsurance, HealthInsurance);
		List<Insurance> CarOrHealthInsurances = CarOrHealth.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrLife = new OrCriteria(CarInsurance, LifeInsurance);
		List<Insurance> CarOrLifeInsurances = CarOrLife.meetCriteria(ChatClient.InsuranceList);
		Criteria ApartmentOrHealth = new OrCriteria(ApartmentInsurance, HealthInsurance);
		List<Insurance> ApartmentOrHealthInsurances = ApartmentOrHealth.meetCriteria(ChatClient.InsuranceList);
		Criteria ApartmentOrLife = new OrCriteria(ApartmentInsurance, LifeInsurance);
		List<Insurance> ApartmentOrLifeInsurances = ApartmentOrLife.meetCriteria(ChatClient.InsuranceList);
		Criteria HealthOrLife = new OrCriteria(HealthInsurance, LifeInsurance);
		List<Insurance> HealthOrLifeInsurances = HealthOrLife.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrApartmentOrHealth = new OrCriteria(CarOrApartment, HealthInsurance);
		List<Insurance> CarOrApartmentOrHealthInsurances = CarOrApartmentOrHealth
				.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrApartmentOrLife = new OrCriteria(CarOrApartment, LifeInsurance);
		List<Insurance> CarOrApartmentOrLifeInsurances = CarOrApartmentOrLife.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrHealthOrLife = new OrCriteria(CarOrHealth, LifeInsurance);
		List<Insurance> CarOrHealthOrLifeInsurances = CarOrHealthOrLife.meetCriteria(ChatClient.InsuranceList);
		Criteria ApartmentOrHealthOrLife = new OrCriteria(ApartmentOrHealth, LifeInsurance);
		List<Insurance> ApartmentOrHealthOrLifeInsurances = ApartmentOrHealthOrLife
				.meetCriteria(ChatClient.InsuranceList);
		Criteria CarOrApartmentOrHealthOrLife = new OrCriteria(CarOrApartmentOrHealth, LifeInsurance);
		List<Insurance> CarOrApartmentOrHealthOrLifeInsurances = CarOrApartmentOrHealthOrLife
				.meetCriteria(ChatClient.InsuranceList);
		if (GreenCounter == 1) {
			if (GreenBtns.contains("Car")) {
				ShowThisTable = CarInsurances;
			} else if (GreenBtns.contains("Apartment")) {
				ShowThisTable = ApartmentInsurances;
			} else if (GreenBtns.contains("Health")) {
				ShowThisTable = HealthInsurances;
			} else if (GreenBtns.contains("Life")) {
				ShowThisTable = LifeInsurances;
			}
		} else if (GreenCounter == 2) {
			if (GreenBtns.contains("Car") && GreenBtns.contains("Apartment")) {
				ShowThisTable = CarOrApartmentInsurances;
			} else if (GreenBtns.contains("Car") && GreenBtns.contains("Health")) {
				ShowThisTable = CarOrHealthInsurances;
			} else if (GreenBtns.contains("Car") && GreenBtns.contains("Life")) {
				ShowThisTable = CarOrLifeInsurances;
			} else if (GreenBtns.contains("Apartment") && GreenBtns.contains("Health")) {
				ShowThisTable = ApartmentOrHealthInsurances;
			} else if (GreenBtns.contains("Apartment") && GreenBtns.contains("Life")) {
				ShowThisTable = ApartmentOrLifeInsurances;
			} else if (GreenBtns.contains("Health") && GreenBtns.contains("Life")) {
				ShowThisTable = HealthOrLifeInsurances;
			}
		} else if (GreenCounter == 3) {
			if (GreenBtns.contains("Car") && GreenBtns.contains("Apartment") && GreenBtns.contains("Health")) {
				ShowThisTable = CarOrApartmentOrHealthInsurances;
			} else if (GreenBtns.contains("Car") && GreenBtns.contains("Apartment") && GreenBtns.contains("Life")) {
				ShowThisTable = CarOrApartmentOrLifeInsurances;
			} else if (GreenBtns.contains("Car") && GreenBtns.contains("Health") && GreenBtns.contains("Life")) {
				ShowThisTable = CarOrHealthOrLifeInsurances;
			} else if (GreenBtns.contains("Apartment") && GreenBtns.contains("Health") && GreenBtns.contains("Life")) {
				ShowThisTable = ApartmentOrHealthOrLifeInsurances;
			}
		} else if (GreenCounter == 4) {
			ShowThisTable = CarOrApartmentOrHealthOrLifeInsurances;
		}

		for (Insurance insuranceLoop : ShowThisTable) {
			System.out.println(insuranceLoop.getName() + " " + insuranceLoop.getType());
		}
		
		ArrayList<Insurance> AllInsuranceArrayList = new ArrayList<Insurance>();
		AllInsuranceArrayList = (ArrayList<Insurance>) ShowThisTable;
		
		ViewInsTable.getItems().setAll(AllInsuranceArrayList);

//		for (Insurance insurance : AllInsuranceArrayList) {
//			ViewInsTable.setItems((ObservableList<Insurance>) insurance);
//		}
	}

	@FXML
	void initialize() {
		assert ViewPurchaseBtn != null
				: "fx:id=\"ViewPurchaseBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert CarInsBtn != null : "fx:id=\"CarInsBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert ApartmentInsBtn != null
				: "fx:id=\"ApartmentInsBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert LifeInsBtn != null : "fx:id=\"LifeInsBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert HealthInsBtn != null : "fx:id=\"HealthInsBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert SellChoiceBox != null : "fx:id=\"SellChoiceBox\" was not injected: check your FXML file 'Main.fxml'.";
		assert CarInsGreenBtn != null : "fx:id=\"CarInsGreenBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert ApartmentInsGreenBtn != null
				: "fx:id=\"ApartmentInsGreenBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert LifeInsGreenBtn != null
				: "fx:id=\"LifeInsGreenBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert HealthInsGreenBtn != null
				: "fx:id=\"HealthInsGreenBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert SellBtn != null : "fx:id=\"SellBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert QuestionMark != null : "fx:id=\"QuestionMark\" was not injected: check your FXML file 'Main.fxml'.";
		assert QuestionMarkTxt != null
				: "fx:id=\"QuestionMarkPressed\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewInsAnchorPane != null
				: "fx:id=\"NewInsAnchorPane\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewLifeInsTxt != null : "fx:id=\"NewLifeInsTxt\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewApartmentInsTxt != null
				: "fx:id=\"NewApartmentInsTxt\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewHealthInsTxt != null
				: "fx:id=\"NewHealthInsTxt\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewCarInsTxt != null : "fx:id=\"NewCarInsTxt\" was not injected: check your FXML file 'Main.fxml'.";
		assert NewInsBackBtn != null : "fx:id=\"NewInsBackBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert SaveBtn != null : "fx:id=\"SaveBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert ViewInsBackBtn != null : "fx:id=\"ViewInsBackBtn\" was not injected: check your FXML file 'Main.fxml'.";
		assert ViewInsAnchorPane != null
				: "fx:id=\"ViewInsAnchorPane\" was not injected: check your FXML file 'Main.fxml'.";
		jsonread.main(null);
		String JsonText = "Version " + jsonread.version + "\nDesigned & Developed by:\n" + jsonread.firstName.toString() + " and " + jsonread.secondName.toString();
		jsonText.setText(JsonText);
		jsonText1.setText(JsonText);
		jsonText11.setText(JsonText);
		SellChoiceBox.setValue(null);
		SellChoiceBox.setItems(NewInsChoice);
		NewCarInsTxt.setVisible(false);
		NewApartmentInsTxt.setVisible(false);
		NewHealthInsTxt.setVisible(false);
		NewLifeInsTxt.setVisible(false);
		ChooseInsText.setVisible(false);
		RequiredFieldText.setVisible(false);
		NewInsFillReqFieldsText.setVisible(false);
		WhatSell = 0;
		DataSavedSuccessfullyText.setVisible(false);
		DataSavedFailedText.setVisible(false);
		NewInsFullNameLbl.setText(null);
		NewInsIDLbl.setText(null);
		NewInsDateLbl.setText(null);
		NewInsRemarksLbl.setText(null);
		CategoryTxt.setVisible(false);
	}
}
