package view;

import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.*;

public class UpdateFormController {
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

        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            PreparedStatement stm = connection.prepareStatement("update customer set name=?,town=?,Salary=? where cid=?");

            stm.setObject(1,name);
            stm.setObject(2,town);
            stm.setObject(3,salary);
            stm.setObject(4,id);

            int result = stm.executeUpdate();

            if(result==1){
                clear();
            }

            System.out.println(result);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
