package main.java.bd.register;

import main.java.bd.JdbcTemplate;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplateOdbc extends JdbcTemplate {
    @Override
    protected void registerConnection() throws ClassNotFoundException, SQLException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = DriverManager.getConnection("jdbc:odbc:base1");
    }

}
