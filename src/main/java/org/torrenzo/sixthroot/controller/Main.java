package org.torrenzo.sixthroot.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @FXML
    private AnchorPane mainview;
    @FXML
    private Button btnShowFxmlLocation;
    @FXML
    private Label lblFxmlLocation;

    @FXML
    public void initialize() {
        this.btnShowFxmlLocation.setOnAction(e -> this.lblFxmlLocation.setText("somewhere over the rainbow: " + mainview.getId()));

    }

}
