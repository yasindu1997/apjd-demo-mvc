package controller;

import model.Customer;

import java.sql.*;

public class CustomerController {

    //for add customer
    public static boolean addCustomer(){
        return false;
    }

    //for update customer
    public static boolean updateCustomer(Customer customer){
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            PreparedStatement stm = connection.prepareStatement("update customer set name=?,town=?,Salary=? where cid=?");

            stm.setObject(1,customer.getName());
            stm.setObject(2,customer.getTown());
            stm.setObject(3,customer.getSalary());
            stm.setObject(4,customer.getCid());

            int result = stm.executeUpdate();

            if(result>0){
                return true;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //for delete customer
    public static boolean deleteCustomer(){
        return false;
    }

    //for search customer
    public static Customer searchCustomer(String id){
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            PreparedStatement stm = connection.prepareStatement("select * from customer where cid=?");

            stm.setObject(1,id);

            ResultSet result = stm.executeQuery();

            //helu customer
            Customer customer = new Customer();

            if(result.next()){
                customer.setCid(result.getString(1));
                customer.setName(result.getString(2));
                customer.setTown(result.getString(3));
                customer.setSalary(result.getDouble(4));

                return customer;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
