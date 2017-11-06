package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.dto.*;
import main.java.service.*;
import main.java.util.DateUtil;

import java.text.ParseException;
import java.util.List;


public class EditDialogController {
    private BnkSeekService bnkSeekService;
    private RegionService regionService;
    private ParticipantSettlementService participantSettlementService;
    private ElectParticipantService electParticipantService;
    private TypeLocalityService typeLocalityService;

    private Stage dialogStage;
    private BnkSeekDto bnkSeek;

    @FXML
    private TextField namepField;
    @FXML
    private TextField newnumField;
    @FXML
    public TextField realField;
    @FXML
    public TextField indField;

    @FXML
    public TextField nnpField;
    @FXML
    public TextField adrField;
    @FXML
    public TextField rkcField;
    @FXML
    public TextField telefonField;
    @FXML
    public TextField regnField;
    @FXML
    public TextField okpoField;
    @FXML
    public TextField dt_izmField;
    @FXML
    public TextField ksnpField;
    @FXML
    public TextField date_inField;
    @FXML
    public TextField date_chField;

    @FXML
    public ComboBox<String> pznNameComboBox;
    @FXML
    public ComboBox<String> uerNameComboBox;
    @FXML
    public ComboBox<String> rgnNameComboBox;
    @FXML
    public ComboBox<String> tnpNameComboBox;


    public EditDialogController() {
        this.bnkSeekService = new BnkSeekService();
        this.regionService = new RegionService();
        this.participantSettlementService = new ParticipantSettlementService();
        this.electParticipantService = new ElectParticipantService();
        this.typeLocalityService = new TypeLocalityService();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void initCtrl(BnkSeekDto bnkSeekDto) {
        this.bnkSeek = bnkSeekDto;

        fillField(this.bnkSeek);
        fillComboBox();
        selectedComboBox(this.bnkSeek);
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void btnOk() {
        if (isInputValid()) {
            BnkSeekDto tmp = this.bnkSeek;
            this.bnkSeek = new BnkSeekDto(tmp.getReal(),
                    this.pznNameComboBox.getSelectionModel().getSelectedItem(), this.uerNameComboBox.getSelectionModel().getSelectedItem(),
                    this.rgnNameComboBox.getSelectionModel().getSelectedItem(), tmp.getInd(), this.tnpNameComboBox.getSelectionModel().getSelectedItem(),
                    tmp.getNnp(), tmp.getAdr(), tmp.getRkc(), tmp.namepProperty().get(), tmp.newnumProperty().get(), tmp.getTelefon(),
                    tmp.getRegn(), tmp.getOkpo(), tmp.getDt_izm(), tmp.getKsnp(), tmp.getDate_in(), tmp.getDate_ch());

            dialogStage.close();
        }
    }

    @FXML
    private void btnCancel() {
        this.bnkSeek = null;
        dialogStage.close();
    }


    private boolean isInputValid() {
        StringBuilder msg = new StringBuilder();

        if (this.newnumField.getText() == null || this.newnumField.getText().length() == 0) {
            msg.append("Обязательное поле 'БИК' не заполнено! \n");
        } else {
            try {
                Integer.parseInt(this.newnumField.getText());

                List<BnkSeekDto> bnkSeekList = bnkSeekService.getBnkSeekList();
                for (BnkSeekDto bnkSeekDto : bnkSeekList) {
                    if ((this.bnkSeek == null & this.newnumField.getText().equals(bnkSeekDto.newnumProperty().get()) ||
                            (this.bnkSeek != null & this.newnumField.getText().equals(bnkSeekDto.newnumProperty().get()) & !this.namepField.getText().equals(bnkSeekDto.namepProperty().get())))) {
                        msg.append("БИК " + this.newnumField.getText() + " уже присвоен другому участнику расчетов! \n");
                    }
                }
            } catch (NumberFormatException ignore) {
                msg.append("В поле 'БИК' значение не является числом! \n");
            }
        }
        try {
            if (DateUtil.parse(this.dt_izmField.getText()) == null) {
                msg.append("Обязательное поле 'Дата последнего изменения записи' не заполнено! \n");
            }
        } catch (ParseException ignore) {
            msg.append("В поле 'Дата последнего изменения записи' значение не является датой. Формат: " + DateUtil.getFormat() + "! \n");
        }
        try {
            if (DateUtil.parse(this.date_inField.getText()) == null) {
                msg.append("Обязательное поле 'Дата включения информации об участнике расчетов в ЭБД' не заполнено! \n");
            }
        } catch (ParseException ignore) {
            msg.append("В поле 'Дата включения информации об участнике расчетов в ЭБД' значение не является датой. Формат: " + DateUtil.getFormat() + "! \n");
        }
        try {
            DateUtil.parse(this.date_chField.getText());
        } catch (ParseException ignore) {
            msg.append("В поле 'Дата контроля' значение не является датой. Формат: " + DateUtil.getFormat() + "! \n");
        }
        if (this.pznNameComboBox.getSelectionModel().getSelectedItem() == null) {
            msg.append("Значение из списка 'Тип участника расчетов' не выбрано! \n");
        }
        if (this.uerNameComboBox.getSelectionModel().getSelectedItem() == null) {
            msg.append("Значение из списка 'Тип участника системы электронных расчетов' не выбрано! \n");
        }
        if (this.rgnNameComboBox.getSelectionModel().getSelectedItem() == null) {
            msg.append("Значение из списка 'Регион' не выбрано! \n");
        }
        if (this.tnpNameComboBox.getSelectionModel().getSelectedItem() == null) {
            msg.append("Значение из списка 'Тип населенного пункта' не выбрано! \n");
        }


        if (msg.length() == 0) {
            return true;
        } else {
            Dialogs.showErrorDialog(new Stage(), msg.toString(), "Ошибки валидации", "Внимание!");

            return false;
        }
    }

    private void fillField(BnkSeekDto bnkSeekDto) {
        if (bnkSeekDto != null) {
            this.namepField.setText(bnkSeekDto.namepProperty().get());
            this.newnumField.setText(bnkSeekDto.newnumProperty().get());
            this.realField.setText(bnkSeekDto.getReal());
            this.indField.setText(bnkSeekDto.getInd());
            this.nnpField.setText(bnkSeekDto.getNnp());
            this.adrField.setText(bnkSeekDto.getAdr());
            this.rkcField.setText(bnkSeekDto.getRkc());
            this.telefonField.setText(bnkSeekDto.getTelefon());
            this.regnField.setText(bnkSeekDto.getRegn());
            this.okpoField.setText(bnkSeekDto.getOkpo());
            this.dt_izmField.setText(DateUtil.format(bnkSeekDto.getDt_izm()));
            this.ksnpField.setText(bnkSeekDto.getKsnp());
            this.date_inField.setText(DateUtil.format(bnkSeekDto.getDate_in()));
            this.date_chField.setText(DateUtil.format(bnkSeekDto.getDate_ch()));
        } else {
            this.namepField.setText("");
            this.newnumField.setText("");
            this.realField.setText("");
            this.indField.setText("");
            this.nnpField.setText("");
            this.adrField.setText("");
            this.rkcField.setText("");
            this.telefonField.setText("");
            this.regnField.setText("");
            this.okpoField.setText("");
            this.dt_izmField.setText("");
            this.ksnpField.setText("");
            this.date_inField.setText("");
            this.date_chField.setText("");
        }
    }

    private void fillComboBox() {
        List<ParticipantSettlementDto> participantSettlementList = participantSettlementService.getParticipantSettlementList();
        for (ParticipantSettlementDto settlementDto : participantSettlementList) {
            this.pznNameComboBox.getItems().add(settlementDto.getName());
        }
        List<ElectParticipantDto> electParticipantDtoList = electParticipantService.getElectParticipantList();
        for (ElectParticipantDto participantDto : electParticipantDtoList) {
            this.uerNameComboBox.getItems().add(participantDto.getName());
        }
        List<RegionDto> regionDtoList = regionService.getRegionList();
        for (RegionDto regionDto : regionDtoList) {
            this.rgnNameComboBox.getItems().add(regionDto.getName());
        }
        List<TypeLocalityDto> typeLocalityDtoList = typeLocalityService.getTypeLocalityList();
        for (TypeLocalityDto localityDto : typeLocalityDtoList) {
            this.tnpNameComboBox.getItems().add(localityDto.getName());
        }
    }

    private void selectedComboBox(BnkSeekDto bnkSeek) {
        if (bnkSeek != null) {
            this.pznNameComboBox.getSelectionModel().select(bnkSeek.getPznName());
            this.uerNameComboBox.getSelectionModel().select(bnkSeek.getUerName());
            this.rgnNameComboBox.getSelectionModel().select(bnkSeek.getRgnName());
            this.tnpNameComboBox.getSelectionModel().select(bnkSeek.getTnpName());
        }
    }

    public BnkSeekDto getResult() {
        return this.bnkSeek;
    }

}