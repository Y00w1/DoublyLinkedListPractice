package com.example.historical;

import com.example.historical.models.Historic;
import com.example.historical.models.HistoricList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label displayText;

    @FXML
    private TextArea textArea;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button closeButton;

    private HistoricList historicList;
    private String savedText = "";

    public void onTextAreaKeyTyped(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String input = textArea.getText().trim();
            if (!input.isEmpty()) {
                Historic historic = new Historic(input);
                historicList.put(historic);
                textArea.clear();
            }
        }
    }

    public HelloController() {
        historicList = new HistoricList();
    }

    @FXML
    protected void onPreviousButtonClick() {
        historicList.undo();
        displayText.setText(this.savedText + " " + historicList.getToCurrentHistoricText());
    }

    @FXML
    protected void onNextButtonClick() {
        historicList.redo();
        displayText.setText(this.savedText + " " + historicList.getToCurrentHistoricText());
    }

    @FXML
    protected void onEnterButtonClick() {
        String input = textArea.getText().trim();
        if (!input.isEmpty()) {
            Historic historic = new Historic(input);
            historicList.put(historic);
            textArea.clear();
        }
        displayText.setText(this.savedText + " " + historicList.getToCurrentHistoricText());
    }

    @FXML
    protected void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void onSaveButtonClick() {
        this.savedText = this.savedText + " " + historicList.getToCurrentHistoricText();
        historicList.save();
        displayText.setText(this.savedText);
    }
}
