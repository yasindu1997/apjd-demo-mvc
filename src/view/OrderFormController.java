package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderFormController {
    @FXML
    private JFXComboBox<?> cmbCustomer;

    @FXML
    private JFXComboBox<?> cmbItem;

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

    }

    @FXML
    void onSelectItem(ActionEvent event) {

    }

    @FXML
    void order(ActionEvent event) {

    }
}
