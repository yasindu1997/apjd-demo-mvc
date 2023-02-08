package controller;

import model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderController {
    public static boolean placeOrder(Order order, String qty, String iid){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            //quary ekk dunna gmn execute karana feature eka disable kara
            connection.setAutoCommit(false);

            PreparedStatement stm = connection.prepareStatement("insert into orders values(?,?,?)");

            stm.setObject(1,order.getOid());
            stm.setObject(2,order.getOrderDate());
            stm.setObject(3,order.getCid());

            int orderAdded = stm.executeUpdate();

            if(orderAdded>0){
                PreparedStatement stm2 = connection.prepareStatement("update item set qty=? where iid=?");

                stm2.setObject(1,Integer.parseInt(qty));
                stm2.setObject(2,iid);

                int itemUpdate = stm2.executeUpdate();

                if(itemUpdate>0){
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
                connection.rollback();
                connection.setAutoCommit(true);
            }
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
