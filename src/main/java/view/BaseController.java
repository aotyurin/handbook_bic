package main.java.view;

import javafx.fxml.FXML;
import main.java.service.OverloadDataService;

import java.sql.SQLException;

public class BaseController {


    @FXML
    private void overloadDataFromDbf() throws SQLException {
        OverloadDataService overloadDataService = new OverloadDataService();
        overloadDataService.overloadDataFromDbf();
    }
}
