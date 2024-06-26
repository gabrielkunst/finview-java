package main.java.com.gk.finview;

import main.java.com.gk.finview.lib.DB;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection connection = DB.getConnection();
            System.out.println("DB CONNECTED");


            connection.close();
            System.out.println("DB CLOSED");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}