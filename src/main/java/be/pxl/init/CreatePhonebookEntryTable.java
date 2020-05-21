package be.pxl.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePhonebookEntryTable {

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb?useSSL=false", "pxl", "student");
            Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE PhoneBookEntry (id INTEGER NOT NULL AUTO_INCREMENT, firstName TEXT, lastName Text, phoneNumber Text, PRIMARY KEY (id))");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
