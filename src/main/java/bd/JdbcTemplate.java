package main.java.bd;

import main.java.bd.preparedParams.PreparedParams;
import main.java.bd.preparedParams.PreparedParamsSetter;

import java.sql.*;

public abstract class JdbcTemplate {
    protected Connection connection = null;
    private Statement statement = null;


    public JdbcTemplate() {
        try {
            registerConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected abstract void registerConnection() throws ClassNotFoundException, SQLException;

    @Override
    protected void finalize() throws Throwable {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        super.finalize();
    }

    public void executeUpdate(String sql) {
        executeUpdate(sql, null);
    }

    public void executeUpdate(String sql, PreparedParamsSetter preparedParamsSetter) {
        try {
            String sql2 = replaceParam(sql, preparedParamsSetter);
            run(sql2);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        return executeQuery(sql, null);
    }

    public ResultSet executeQuery(String sql, PreparedParamsSetter preparedParamsSetter) {
        try {
            String sql2 = replaceParam(sql, preparedParamsSetter);
            return runResultSet(sql2);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    private void run(String sql2) throws SQLException {
        if (connection == null) {
            throw new RuntimeException("Не создано подключение к бд.");
        }
        statement.executeUpdate(sql2);
    }

    private ResultSet runResultSet(String sql2) throws SQLException {
        if (connection == null) {
            throw new RuntimeException("Не создано подключение к бд.");
        }
        return statement.executeQuery(sql2);
    }

    private String replaceParam(String sql, PreparedParamsSetter preparedParamsSetter) {
        if (preparedParamsSetter == null) {
            return sql;
        }

        for (PreparedParams preparedParams : preparedParamsSetter.getPreparedParamsList()) {
            sql = sql.replace(":" + preparedParams.getName(), preparedParams.getValue());
        }
        return sql;
    }


}
