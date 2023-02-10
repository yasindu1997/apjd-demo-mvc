package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
import controller.ItemController;
import controller.OrderController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Customer;
import model.Item;
import model.Order;

import java.net.URL;
import java.time.LocalDate;
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
    private TextField txtOderId;

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
        String qty = txtQty.getText();
        String oid = txtOderId.getText();
        String iid = (String)cmbItem.getValue();

        Order order = new Order();
        order.setOid(oid);
        order.setCid((String) cmbCustomer.getValue());
        order.setOrderDate(String.valueOf(LocalDate.now()));
        order.setQty(Integer.parseInt(qty));
        order.setIid(iid);

        boolean isPlacedOrder = OrderController.placeOrder(order);
        System.out.println(isPlacedOrder);
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
