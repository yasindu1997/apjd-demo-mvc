package controller;

import model.Customer;
import model.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemController {
    public static ArrayList<String> loadItemIds(){
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            PreparedStatement stm = connection.prepareStatement("select iid from item");

            ResultSet result = stm.executeQuery();

            ArrayList<String> itemIds = new ArrayList<>();

            while(result.next()){
                itemIds.add(result.getString(1));
            }

            return itemIds;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Item searchItem(String id){
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","yasindu@ijse");

            PreparedStatement stm = connection.prepareStatement("select * from item where iid=?");

            stm.setObject(1,id);

            ResultSet result = stm.executeQuery();

            //helu item
            Item item = new Item();

            if(result.next()){
                item.setIid(result.getString(1));
                item.setName(result.getString(2));
                item.setQty(result.getInt(3));

                return item;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
