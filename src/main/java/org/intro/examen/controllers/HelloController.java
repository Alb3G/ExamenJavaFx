package org.intro.examen.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.intro.examen.model.User;

import java.time.LocalDateTime;

/**
 * @author Alberto Guzman Moreno
 * Esta clase es el controlador y gestiona toda la logica e inicializacion
 * de la vista y sus elementos.
 */
public class HelloController {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> versionCol;
    @FXML
    private TableColumn<User, String> platformCol;
    @FXML
    private CheckBox adminCheckBox;
    @FXML
    private TableColumn<User, String> emailCol;
    @FXML
    private TableColumn<User, String> stampCol;
    @FXML
    private ChoiceBox<String> platformChoice;
    @FXML
    private TableColumn<User, String> adminCol;
    @FXML
    private Button addUsertbtn;
    @FXML
    private TextField emailInput;
    @FXML
    private Spinner<Integer> versionSpinner;
    @FXML
    private Button cleartableBtn;

    @FXML
    public void initialize() {
        setTableData();
    }
    /**
     * Este metodo sin parametros inicializa las columnas y elementos de la vista
     */
    private void setTableData() {
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        platformCol.setCellValueFactory(new PropertyValueFactory<>("platform"));
        adminCol.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
        versionCol.setCellValueFactory(new PropertyValueFactory<>("softwareVersion"));
        stampCol.setCellValueFactory(new PropertyValueFactory<>("stamp"));
        platformChoice.getItems().addAll("Windows", "Linux", "MacOS");
        platformChoice.setValue("Choose platform");
        versionSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1, 1));
        table.getSelectionModel().selectedItemProperty().addListener((_,_, newValue) -> {
            if(newValue != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User information");
                alert.setHeaderText("User information");
                alert.setContentText("Email: " + newValue.getEmail() + "\n" +
                        "Platform: " + newValue.getPlatform() + "\n" +
                        "Is Admin: " + newValue.getIsAdmin() + "\n" +
                        "Software Version: " + newValue.getSoftwareVersion() + "\n" +
                        "Stamp: " + newValue.getStamp());
                alert.showAndWait();
            }
        });
    }

    /**
     * This method adds a new user to the table
     * and validates the fields to not be empty
     * @param actionEvent
     */
    @FXML
    public void onAdd(ActionEvent actionEvent) {
        if(!emailInput.getText().isEmpty() && !platformChoice.getValue().isEmpty() && versionSpinner.getValue() != null && !platformChoice.getValue().equals("Choose platform")) {
            User user = new User();
            user.setEmail(emailInput.getText());
            user.setPlatform(platformChoice.getValue());
            user.setIsAdmin(adminCheckBox.isSelected());
            user.setSoftwareVersion(versionSpinner.getValue());
            user.setStamp(LocalDateTime.now().toString());
            table.getItems().add(user);
            // Hacemos clear de los fields
            emailInput.clear();
            platformChoice.setValue("");
            adminCheckBox.setSelected(false);
            versionSpinner.getValueFactory().setValue(1);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error occurred while adding user");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }
    }


    /**
     * This method clears the table
     * @param actionEvent not used
     */
    @FXML
    public void onClear(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to clear the table?");
        alert.setContentText("All the data will be lost");
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK) {
                table.getItems().clear();
            }
        });
    }
}