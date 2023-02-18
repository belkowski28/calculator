package com.example.calculator.controller;

import com.example.calculator.model.CsvReader;
import com.example.calculator.model.Plate;
import com.example.calculator.model.Tape;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainController {

    @FXML
    private Label epe_kszt_h;
    @FXML
    private Label lam_kszt_h;
    @FXML
    private TextField gestosc_pianki;
    @FXML
    private TextField grubosc_uszczelki;
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
    private Label embossing;

    @FXML
    private TextField regranulat_pianki;

    @FXML
    private RadioButton radio_EPE;

    @FXML
    private RadioButton radio_Laminowana;

    public ArrayList <Plate> plates = null;

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

        ldpe.setText(df.format(tape.getWeight_ldpe()));
        poslizg.setText(df.format(tape.getWeight_slip()));
        nukleujacy.setText(df.format(tape.getWeight_nucleating()));
        regranulat.setText(df.format(tape.getWeight_regranulat()));
        embossing.setText(df.format(tape.getEmbossing_time()));
        }

    @FXML
    void liners() {
        CsvReader reader = new CsvReader("src/main/resources/płyta.csv");
        String szukana = grubosc_uszczelki.getText().replace(",", ".");
        System.out.println(szukana);
        plates = reader.getPlates();
        for (Plate plate : plates) {
            if (plate.getDiameter_min() <= Double.parseDouble(szukana) && Double.parseDouble(szukana) <= plate.getDiameter_min()) {
                System.out.println(plate.getDiameter_max() + " " + plate.getLaminated_kszt_h());
            }
        }
        }
}


