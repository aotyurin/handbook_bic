package main.java.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import main.java.dto.BnkSeekDto;
import main.java.service.BnkSeekService;
import main.java.service.OverloadDataService;
import main.java.util.DateUtil;

import java.sql.SQLException;
import java.util.List;

public class BaseController {
    //region Table
    @FXML
    private TableView<BnkSeekDto> bnkSeekTable;
    @FXML
    private TableColumn<BnkSeekDto, String> namepColumn;
    @FXML
    private TableColumn<BnkSeekDto, String> newnumColumn;
    //endregion

    //region Label
    @FXML
    private Label realLabel;
    @FXML
    private Label pznNameLabel;
    @FXML
    private Label uerNameLabel;
    @FXML
    private Label rgnNameLabel;
    @FXML
    private Label indLabel;
    @FXML
    private Label tnpNameLabel;
    @FXML
    private Label nnpLabel;
    @FXML
    private Label adrLabel;
    @FXML
    private Label rkcLabel;
    @FXML
    private Label telefonLabel;
    @FXML
    private Label regnLabel;
    @FXML
    private Label okpoLabel;
    @FXML
    private Label dt_izmLabel;
    @FXML
    private Label ksnpLabel;
    @FXML
    private Label date_inLabel;
    @FXML
    private Label date_chLabel;
    //endregion

    //region Button
    @FXML
    private void overloadDataFromDbf() throws SQLException {
        OverloadDataService overloadDataService = new OverloadDataService();
        overloadDataService.overloadDataFromDbf();

        initialize();
    }

    //endregion

    @FXML
    private void initialize() {
        System.out.println("initialize baseView");

        fillTable();

        fillTableColumn();

        fillLabel(null);

        // add listen for selection changes in table
        this.bnkSeekTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BnkSeekDto>() {
            @Override
            public void changed(ObservableValue<? extends BnkSeekDto> observableValue, BnkSeekDto bnkSeekDto, BnkSeekDto t1) {
                fillLabel(t1);
            }
        });
    }

    private void fillTable() {
        ObservableList<BnkSeekDto> bnkSeekData = FXCollections.observableArrayList();
        BnkSeekService bnkSeekService = new BnkSeekService();
        List<BnkSeekDto> bnkSeekDtoList = bnkSeekService.getBnkSeekList();
        bnkSeekData.addAll(bnkSeekDtoList);
        this.bnkSeekTable.setItems(bnkSeekData);
    }

    private void fillTableColumn() {
        this.namepColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BnkSeekDto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BnkSeekDto, String> bnkSeekDtoStringCellDataFeatures) {
                return bnkSeekDtoStringCellDataFeatures.getValue().namepProperty();
            }
        });

        this.newnumColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BnkSeekDto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BnkSeekDto, String> bnkSeekDtoStringCellDataFeatures) {
                return bnkSeekDtoStringCellDataFeatures.getValue().newnumProperty();
            }
        });
    }

    private void fillLabel(BnkSeekDto bnkSeekDto) {
        if (bnkSeekDto != null) {
            this.realLabel.setText(bnkSeekDto.getReal());
            this.pznNameLabel.setText(bnkSeekDto.getPznName());
            this.uerNameLabel.setText(bnkSeekDto.getUerName());
            this.rgnNameLabel.setText(bnkSeekDto.getRgnName());
            this.indLabel.setText(bnkSeekDto.getInd());
            this.tnpNameLabel.setText(bnkSeekDto.getTnpName());
            this.nnpLabel.setText(bnkSeekDto.getNnp());
            this.adrLabel.setText(bnkSeekDto.getAdr());
            this.rkcLabel.setText(bnkSeekDto.getRkc());
            this.telefonLabel.setText(bnkSeekDto.getTelefon());
            this.regnLabel.setText(bnkSeekDto.getRegn());
            this.okpoLabel.setText(bnkSeekDto.getOkpo());
            this.dt_izmLabel.setText(DateUtil.format(bnkSeekDto.getDt_izm()));
            this.ksnpLabel.setText(bnkSeekDto.getKsnp());
            this.date_inLabel.setText(DateUtil.format(bnkSeekDto.getDate_in()));
            this.date_chLabel.setText(DateUtil.format(bnkSeekDto.getDate_ch()));
        } else {
            this.realLabel.setText("");
            this.pznNameLabel.setText("");
            this.uerNameLabel.setText("");
            this.rgnNameLabel.setText("");
            this.indLabel.setText("");
            this.tnpNameLabel.setText("");
            this.nnpLabel.setText("");
            this.adrLabel.setText("");
            this.rkcLabel.setText("");
            this.telefonLabel.setText("");
            this.regnLabel.setText("");
            this.okpoLabel.setText("");
            this.dt_izmLabel.setText("");
            this.ksnpLabel.setText("");
            this.date_inLabel.setText("");
            this.date_chLabel.setText("");
        }
    }

}
