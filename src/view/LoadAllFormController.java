package view;

import controller.CustomerController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllFormController implements Initializable {
    @FXML
    private TableView<Customer> tblCustomers;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTown;

    @FXML
    private TableColumn<?, ?> colSalary;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //column initialize
       tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
       tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
       tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("town"));
       tblCustomers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("salary"));

       //get customer list from controller
        ArrayList<Customer> customers = CustomerController.loadAllCustomer();

        //set data to the fx table
        tblCustomers.setItems(FXCollections.observableArrayList(customers));

    }
}
