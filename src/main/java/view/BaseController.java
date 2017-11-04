package main.java.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.Main;
import main.java.dto.BnkSeekDto;
import main.java.dto.ParticipantSettlementDto;
import main.java.dto.RegionDto;
import main.java.service.BnkSeekService;
import main.java.service.OverloadDataService;
import main.java.service.ParticipantSettlementService;
import main.java.service.RegionService;
import main.java.util.DateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseController {
    private OverloadDataService overloadDataService;
    private BnkSeekService bnkSeekService;
    private RegionService regionService;
    private ParticipantSettlementService participantSettlementService;

    private ObservableList<BnkSeekDto> masterData = FXCollections.observableArrayList();
    private ObservableList<BnkSeekDto> filteredData = FXCollections.observableArrayList();

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

    //region FilterField
    @FXML
    private TextField bicFilterField;
    @FXML
    private ComboBox<String> rgnNameFilterComboBox;
    @FXML
    private ComboBox<String> pznNameFilterComboBox;
    //endregion

    //region ctr
    public BaseController() {
        this.overloadDataService = new OverloadDataService();
        this.bnkSeekService = new BnkSeekService();
        this.regionService = new RegionService();
        this.participantSettlementService = new ParticipantSettlementService();
    }
    //endregion


    //region Button
    @FXML
    private void btnOverloadDataFromDbf() throws SQLException {
        Dialogs.DialogResponse dialogResponse = Dialogs.showConfirmDialog(new Stage(), "Вы действительно хотите загрузить данные? \n" +
                "Ранее загруженные данные будут удалены.", "", "Внимание!", Dialogs.DialogOptions.YES_NO);
        if (dialogResponse == Dialogs.DialogResponse.YES) {
            overloadDataService.overloadDataFromDbf();

            initialize();
        }
    }

    @FXML
    private void btnEditBnkSeek(ActionEvent event) {
        BnkSeekDto selectedItem = bnkSeekTable.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            Dialogs.showWarningDialog(new Stage(), "Не выделено ни одной записи!", "Внимание!");
        } else {
            handleDialogModule(selectedItem);
        }
    }

    @FXML
    private void btnAddBnkSeek() {
        handleDialogModule(null);
    }

    @FXML
    private void btnDeleteBnkSeek() {
        int selectedIndex = bnkSeekTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Dialogs.DialogResponse dialogResponse = Dialogs.showConfirmDialog(new Stage(), "Вы действительно хотите удалить запись?", "",
                    "Внимание!", Dialogs.DialogOptions.YES_NO);
            if (dialogResponse == Dialogs.DialogResponse.YES) {
                BnkSeekDto selectedItem = bnkSeekTable.getSelectionModel().getSelectedItem();
                bnkSeekTable.getItems().remove(selectedIndex);
                bnkSeekTable.getSelectionModel().clearSelection();

                this.bnkSeekService.deleteById(selectedItem.newnumProperty().get());
            }
        } else {
            Dialogs.showWarningDialog(new Stage(), "Не выделено ни одной записи!", "Удаление не возможно", "Внимание!");
        }
    }
    //endregion

    @FXML
    private void rgnNameFilterComboBoxOnChange(ActionEvent event) {
        updateFilteredData();
    }

    @FXML
    private void pznNameFilterComboBoxOnChange(ActionEvent event) {
        updateFilteredData();
    }

    @FXML
    private void initialize() {
        System.out.println("initialize baseView");

        initData();

        fillTable();

        fillTableColumn();

        fillLabel(null);

        addListener();
    }

    private void initData() {
        List<BnkSeekDto> bnkSeekDtoList = this.bnkSeekService.getBnkSeekList();
        masterData.addAll(bnkSeekDtoList);
        filteredData.addAll(masterData);

        List<RegionDto> regionList = this.regionService.getRegionList();
        for (RegionDto regionDto : regionList) {
            this.rgnNameFilterComboBox.getItems().add(regionDto.getName());
        }

        List<ParticipantSettlementDto> settlementDtoList = this.participantSettlementService.getParticipantSettlementList();
        for (ParticipantSettlementDto settlementDto : settlementDtoList) {
            this.pznNameFilterComboBox.getItems().add(settlementDto.getName());
        }
    }

    private void fillTable() {
        this.bnkSeekTable.setItems(masterData);
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

    private void addListener() {
        this.bnkSeekTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BnkSeekDto>() {
            @Override
            public void changed(ObservableValue<? extends BnkSeekDto> observableValue, BnkSeekDto bnkSeekDto, BnkSeekDto t1) {
                fillLabel(t1);
            }
        });

        this.masterData.addListener(new ListChangeListener<BnkSeekDto>() {
            @Override
            public void onChanged(Change<? extends BnkSeekDto> change) {
                updateFilteredData();
            }
        });

        this.bicFilterField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                updateFilteredData();
            }
        });
    }


    private void updateFilteredData() {
        filteredData.clear();

        ArrayList<BnkSeekDto> dtoTmpList = new ArrayList<>();
        dtoTmpList.addAll(masterData);

        String bicItem = this.bicFilterField.getText();
        String rgnNameItem = this.rgnNameFilterComboBox.getSelectionModel().getSelectedItem();
        String pznNameItem = this.pznNameFilterComboBox.getSelectionModel().getSelectedItem();

        if ((bicItem != null || !bicItem.isEmpty()) || rgnNameItem != null || pznNameItem != null) {
            for (int i = dtoTmpList.size() - 1; i >= 0; i--) {
                if (!dtoTmpList.get(i).newnumProperty().get().toLowerCase().contains(bicItem.toLowerCase())) {
                    dtoTmpList.remove(i);
                }
            }
            for (int i = dtoTmpList.size() - 1; i >= 0; i--) {
                if (rgnNameItem != null && dtoTmpList.get(i).getRgnName() != null && !dtoTmpList.get(i).getRgnName().contains(rgnNameItem)) {
                    dtoTmpList.remove(i);
                }
            }
            for (int i = dtoTmpList.size() - 1; i >= 0; i--) {
                if (pznNameItem != null && dtoTmpList.get(i).getPznName() != null && !dtoTmpList.get(i).getPznName().contains(pznNameItem)) {
                    dtoTmpList.remove(i);
                }
            }
        }

        filteredData.addAll(dtoTmpList);
        this.bnkSeekTable.setItems(filteredData);
    }

    private void handleDialogModule(BnkSeekDto selectedItem) {
        BnkSeekDto tmpBnkSeekDto = showEditDialog(selectedItem);
        if (tmpBnkSeekDto != null) {
            this.bnkSeekTable.getSelectionModel().select(tmpBnkSeekDto);
            this.bnkSeekService.edit(tmpBnkSeekDto);

            initialize();
        }
    }

    private BnkSeekDto showEditDialog(BnkSeekDto selectedItem) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/EditDialog.fxml"));
            Parent parent = (Parent) fxmlLoader.load();

            Stage modalStage = new Stage();
            modalStage.setTitle("Редактирование справочника БИК");
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(parent);
            modalStage.setScene(scene);

            EditDialogController editDialogController = (EditDialogController) fxmlLoader.getController();
            editDialogController.initCtrl(selectedItem);
            editDialogController.setDialogStage(modalStage);

            modalStage.showAndWait();

            return editDialogController.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
