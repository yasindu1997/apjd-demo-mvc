package view;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Customer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllFormController implements Initializable {
    @FXML
    private TableView<?> tblCustomers;

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
        ArrayList<Customer> customers = CustomerController.loadAllCustomer();

        for(Customer cus : customers){
            System.out.println(cus.getCid()+" "+cus.getName()+" "+cus.getTown());
        }
    }
}
