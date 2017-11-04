package main.java.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.dto.BnkSeekDto;
import main.java.util.DateUtil;


public class EditDialogController {
    @FXML
    public TextField realField;
    @FXML
    public TextField pznNameField;
    @FXML
    public TextField uerNameField;
    @FXML
    public TextField rgnNameField;
    @FXML
    public TextField indField;
    @FXML
    public TextField tnpNameField;
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

    private Stage dialogStage;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void btnOk() {
        if (isInputValid()) {

            //
//            save
            dialogStage.close();
        }
    }

    @FXML
    private void btnCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        return true;
    }

    public void setBnkSeek(BnkSeekDto bnkSeekDto) {
        if (bnkSeekDto!=null) {
            this.realField.setText(bnkSeekDto.getReal());
            this.pznNameField.setText(bnkSeekDto.getPznName());
            this.uerNameField.setText(bnkSeekDto.getUerName());
            this.rgnNameField.setText(bnkSeekDto.getRgnName());
            this.indField.setText(bnkSeekDto.getInd());
            this.tnpNameField.setText(bnkSeekDto.getTnpName());
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
            this.realField.setText("");
            this.pznNameField.setText("");
            this.uerNameField.setText("");
            this.rgnNameField.setText("");
            this.indField.setText("");
            this.tnpNameField.setText("");
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


}