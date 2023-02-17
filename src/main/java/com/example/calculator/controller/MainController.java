package com.example.calculator.controller;

import com.example.calculator.model.Tape;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        DecimalFormat df = new DecimalFormat("#.#####");
        Tape tape = new Tape(2.0f,300,0.30f,"EPE");
        tape.raw_materials_weight();
        System.out.println(df.format(tape.getWeight_ldpe()));
        System.out.println(df.format(tape.getWeight_slip()));
        System.out.println(df.format(tape.getWeight_nucleating()));
        System.out.println(df.format(tape.getWeight_regranulat()));



    }
}