package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
import controller.ItemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Customer;
import model.Item;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {
    @FXML
    private JFXComboBox cmbCustomer;

    @FXML
    private JFXComboBox cmbItem;

    @FXML
    private Label lblName;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblSalary;

    @FXML
    private Label lblItemQty;

    @FXML
    private JFXTextField txtQty;

    @FXML
    void onSelectCustomer(ActionEvent event) {
        Customer customer = CustomerController.searchCustomer((String) cmbCustomer.getValue());
        lblName.setText(customer.getName());
        lblSalary.setText(String.valueOf(customer.getSalary()));
    }

    @FXML
    void onSelectItem(ActionEvent event) {
        Item item = ItemController.searchItem((String) cmbItem.getValue());
        lblItemName.setText(item.getName());
        lblItemQty.setText(String.valueOf(item.getQty()));
    }

    @FXML
    void order(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCustomerIds();
        loadItemIds();
    }

    public void loadItemIds(){
        ArrayList<String> itemIds = ItemController.loadItemIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for(String id : itemIds){
            ids.add(id);
        }
        cmbItem.setItems(ids);
    }

    public void loadCustomerIds(){
        ArrayList<String> cusIds = CustomerController.loadCustomerIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for(String id : cusIds){
            ids.add(id);
        }
        cmbCustomer.setItems(ids);
    }
}
