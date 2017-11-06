package main.java.bd.register;

import main.java.bd.JdbcTemplate;
import org.sqlite.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplateSqlite extends JdbcTemplate {
    @Override
    protected void registerConnection() throws ClassNotFoundException, SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection("jdbc:sqlite:hb_bic.db");
    }

}
