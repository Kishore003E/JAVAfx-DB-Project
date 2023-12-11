package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Label welcomeText1;

    @FXML
    private Label welcomeText2;

    @FXML
    private Label welcomeText3;

    @FXML
    private Label welcomeText4;

    public void onApplyClicked()
    {
        String txt="Applied Successfully...";
        welcomeText4.setText(txt);
    }

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField mobno;

    @FXML
    private TextField cmpname;

    @FXML
    private TextField username;

    @FXML
    private TextField password123;

    @FXML
    private TextField lusername;

    @FXML
    private TextField lpassword;

    @FXML
    private TextField compname;

    @FXML
    private TextField jrole;

    @FXML
    private TextField salrang;

    @FXML
    private TextField experi;

    @FXML
    private TextField skill;

    @FXML
    private TextField loca;

    @FXML
    private TextField ename;

    @FXML
    private TextField eemail;

    @FXML
    private TextField emobno;

    @FXML
    private TextField eworkstatus;

    @FXML
    private TextField eusername;

    @FXML
    private TextField epassword123;

    @FXML
    private TextField erusername;

    @FXML
    private TextField epassword;
    public void onButtonclicked() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("Thirdpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,600);
        Stage s = new Stage();
        s.setTitle("Employee Credentials");
        s.setScene(scene);
        s.show();
    }

    public void onHelloButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("Secondpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Employer Credentials");
        s.setScene(scene);
        s.show();
    }

    public void OnSignUpClicked() throws IOException
    {
        String newname = name.getText();
        String newemail = email.getText();
        String newmobno = mobno.getText();
        String newcmp = cmpname.getText();
        String newuser = username.getText();
        String newpass = password123.getText();

        String txt="Registered Successfully...";
        welcomeText.setText(txt);
        saveToDatabase(newname, newemail, newmobno, newcmp, newuser, newpass);
    }

    public void onLoginClicked() throws IOException
    {
        String nname = lusername.getText();
        String npass = lpassword.getText();
        saveTologin(nname, npass);
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("Fourthpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Employer Credentials");
        s.setScene(scene);
        s.show();
    }

    @FXML
    public void onAddClicked()
    {
        String cname = compname.getText();
        String crole = jrole.getText();
        String csalrang = salrang.getText();
        String cexperi = experi.getText();
        String cskill = skill.getText();
        String cloca = loca.getText();

        String txt="Added Successfully...";
        welcomeText1.setText(txt);
        saveToAdd(cname, crole, csalrang, cexperi, cskill, cloca);
    }

    @FXML
    public void onRemoveClicked()
    {
        String companyNameToRemove = compname.getText();

        // Call the method to delete the row from the database
        deleteFromDatabase(companyNameToRemove);

        // Optionally, update the UI or display a message indicating successful deletion
        String txt = "Row deleted successfully...";
        welcomeText3.setText(txt);
    }

    private void deleteFromDatabase(String companyName) {
        String sql = "DELETE FROM off_details WHERE companyname = ?";

        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, companyName);

            // Execute the DELETE SQL statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully");
            } else {
                System.out.println("No rows deleted. Row not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void oneLoginClicked() throws IOException {
        String ername = erusername.getText();
        String erpass = epassword.getText();
        saveToerlogin(ername, erpass);
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("sixthpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Employee Credentials");
        s.setScene(scene);
        s.show();
    }

    @FXML
    public void oneSignUpClicked()
    {
        String eprname = ename.getText();
        String epremail = eemail.getText();
        String eprmobno = emobno.getText();
        String eprcmp = eworkstatus.getText();
        String epruser = eusername.getText();
        String eprpass = epassword123.getText();

        String txt="Registered Successfully...";
        welcomeText2.setText(txt);
        saveToerSignup(eprname, epremail, eprmobno, eprcmp, epruser, eprpass);
    }


    private void saveToDatabase(String name, String email, String mobileno, String companyname, String username, String password) {
        String sql = "INSERT INTO employer_reg (name, email, mobileno, companyname, username, password) VALUES (?, ?, ?, ?, ?, ?)";


        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobileno);
            preparedStatement.setString(4, companyname);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveTologin(String username, String password) {
        String sql = "INSERT INTO employer_log (username, password) VALUES (?, ?)";


        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void saveToAdd(String companyname, String jobrole, String salary, String experience, String skills, String location) {
        String sql = "INSERT INTO off_details (companyname, jobrole, salary, experience, skills, location) VALUES (?, ?, ?, ?, ?, ?)";


        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, companyname);
            preparedStatement.setString(2, jobrole);
            preparedStatement.setString(3, salary);
            preparedStatement.setString(4, experience);
            preparedStatement.setString(5, skills);
            preparedStatement.setString(6, location);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void saveToerlogin(String username, String password) {
        String sql = "INSERT INTO employee_log (username, password) VALUES (?, ?)";


        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveToerSignup(String name, String email, String mobileno, String workstatus, String username, String password) {
        String sql = "INSERT INTO employee_reg (name, email, mobileno, workstatus, username, password) VALUES (?, ?, ?, ?, ?, ?)";


        try (Connection connection = com.example.demo.DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobileno);
            preparedStatement.setString(4, workstatus);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private TableView<OffDetails> tableView;

    @FXML
    private TableColumn<OffDetails, String> companynameColumn;


    @FXML
    private TableColumn<OffDetails, String> jobroleColumn;

    @FXML
    private TableColumn<OffDetails, String> salaryColumn;

    @FXML
    private TableColumn<OffDetails, String> experienceColumn;

    @FXML
    private TableColumn<OffDetails, String> skillsColumn;

    @FXML
    private TableColumn<OffDetails, String> locationColumn;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void initialize() {
        // Initialize the columns

        // Fetch data from the database and populate the TableView
        populateTableView();
    }

    public void populateTableView() {
        try {
            connect = com.example.demo.DatabaseConnector.getConnection();

            String sql = "SELECT * FROM off_details";

            prepare = connect.prepareStatement(sql);

            result = prepare.executeQuery();

            ObservableList<OffDetails> dataObservableList = FXCollections.observableArrayList();

            // Iterate through the result set and populate the data list
            while (result.next()) {
                OffDetails dataObject = new OffDetails(
                        result.getString("companyname"),
                        result.getString("jobrole"),
                        result.getString("salary"),
                        result.getString("experience"),
                        result.getString("skills"),
                        result.getString("location")
                );
                dataObservableList.add(dataObject);
            }

            // Close the result set and statement
            result.close();
            prepare.close();

            // Set the items to the TableView
            tableView.setItems(dataObservableList);
            companynameColumn.setCellValueFactory(f->f.getValue().companynameProperty());
            jobroleColumn.setCellValueFactory(f->f.getValue().jobroleProperty());
            salaryColumn.setCellValueFactory(f->f.getValue().salaryProperty());
            experienceColumn.setCellValueFactory(f->f.getValue().experienceProperty());
            skillsColumn.setCellValueFactory(f->f.getValue().skillsProperty());
            locationColumn.setCellValueFactory(f->f.getValue().locationProperty());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
