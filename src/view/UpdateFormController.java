package view;

import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.sql.*;

public class UpdateFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSeachId;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTown;

    @FXML
    private TextField txtSalary;

    @FXML
    void search(ActionEvent event) {
        String cusId = txtSeachId.getText();

        Customer customer = CustomerController.searchCustomer(cusId);
        txtId.setText(customer.getCid());
        txtName.setText(customer.getName());
        txtTown.setText(customer.getTown());
        txtSalary.setText(Double.toString(customer.getSalary()));
    }

    public void clear(){
        txtId.setText("");
        txtName.setText("");
        txtTown.setText("");
        txtSalary.setText("");

    }

    @FXML
    void update(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String town = txtTown.getText();
        double salary = Double.parseDouble(txtSalary.getText()); //"25000" ---> 25000

        Customer customer = new Customer();
        customer.setCid(id);
        customer.setName(name);
        customer.setTown(town);
        customer.setSalary(salary);

        boolean isUpdated = CustomerController.updateCustomer(customer);

        if(isUpdated){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Customer Updated");
            a.show();
            clear();
        }
    }

    @FXML
    void onBack(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MainForm.fxml"));

            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
