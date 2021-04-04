# InsuranceCompanyDesignPattern
This is a small project with an interface that was made to test 3 designs patterns: 

1)	Filter design pattern : in the mainClasses package, and it’s implementaion is in the MainController in the parseInsuranceList function. We used ApartmentCriteria, CarCriteria, HealthCriteria, LifeCriteria and OrCriteria which all implemets the interface Criteria.

2)	Singleton design pattern : in the mainClasses package, and it’s inilaization is in LoginController and it’s implementaion is in MainController. We used it to save the actions and the Logger to an array and then to write it in a file.

3)	Data Access Object design pattern : I used the DAO design pattern to provides some specific data operations without exposing details of the database.

 First please make a new folder in C:\ and name it “ParisData” (C:\PairsData). 
Copy the input.json file to the folder. 

Open MySQL and open “insurancecompany.sql” file that is attached, copy the commands and paste them into MySQL and run it.
Try to run either the ServerUI or the ClientUI, incase of an “Error: JavaFX runtime components are missing, and are required to run this application“, copy the the “javafx-sdk-11.0.2” folder to the ParisData folder, open “Run Configurations” in eclipse go to “Java Application” and add “--module-path "C:\ParisData\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml” to both ClientUI and ServerUI in the “Arguments” tab in “VM arguments” and press apply.

*No tests were made - only Design patterns practice
