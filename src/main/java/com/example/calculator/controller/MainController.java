package com.example.calculator.controller;

import com.example.calculator.model.Tape;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    private TextField gestosc_pianki;

    @FXML
    private ToggleGroup grup;

    @FXML
    private TextField gruposc_pianki;

    @FXML
    private Label ldpe;

    @FXML
    private Label nukleujacy;

    @FXML
    private Label poslizg;

    @FXML
    private Label regranulat;

    @FXML
    private TextField regranulat_pianki;

    @FXML
    private RadioButton radio_EPE;

    @FXML
    private RadioButton radio_Laminowana;

    @FXML
    void calculate() {
        String rodzaj_pianki;
        if(radio_EPE.isSelected()){
            rodzaj_pianki="EPE";
        }
        else{
            rodzaj_pianki="Laminowana";
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        Tape tape = new Tape(Double.parseDouble(gruposc_pianki.getText().replace(",",".")),Double.parseDouble(gestosc_pianki.getText()),(Double.parseDouble(regranulat_pianki.getText())/100),rodzaj_pianki);
        tape.raw_materials_weight();

        ldpe.setText(df.format(tape.getWeight_ldpe()));
        poslizg.setText(df.format(tape.getWeight_slip()));
        nukleujacy.setText(df.format(tape.getWeight_nucleating()));
        regranulat.setText(df.format(tape.getWeight_regranulat()));
    }

}