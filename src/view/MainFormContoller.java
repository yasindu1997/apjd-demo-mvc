package view;

import controller.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class MainFormContoller {

    @FXML
    private AnchorPane root;


    @FXML
    void onAdd(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("AddForm.fxml"));

            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onDelete(ActionEvent event) {

    }

    @FXML
    void onUpdate(ActionEvent event) {
        try {
            //load update fxml
            Parent view = FXMLLoader.load(this.getClass().getResource("UpdateForm.fxml"));

            //catch main stage / primary stage
            Stage primaryStage = (Stage) root.getScene().getWindow();

            //create a scene
            Scene scene = new Scene(view);

            //set scene to the stage
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void loadAll(ActionEvent event) {
        ArrayList<Customer> customers = CustomerController.loadAllCustomer();

        for(Customer cus : customers){
            System.out.println(cus.getCid()+" "+cus.getName()+" "+cus.getTown());
        }
    }
}
