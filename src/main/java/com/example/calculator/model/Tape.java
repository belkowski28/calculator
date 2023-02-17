package com.example.calculator.model;

public class Tape {

    private double thickness;
    private double density;

    private double regranulat;

    private double weight_ldpe;
    private double weight_slip;
    private double weight_nucleating;
    private double weight_regranulat;


    private String type;

    public Tape (double thickness, double density , double regranulat,String type){
        setThickness(thickness);
        setDensity(density);
        setRegranulat(regranulat);
        setType(type);
    }

    private double weight (){
        if (this.type.equals("EPE")){
            return ((this.thickness/1000f)*0.525*1)*this.density;
        }
        else {
            return ((this.thickness/1000f)*0.505*1)*this.density;
        }
    }

    private double stuff (){
        return ((1.0f-0.018f-this.regranulat));
    }

    public void raw_materials_weight(){
        setWeight_ldpe(stuff()*weight());
        setWeight_slip(weight()*0.01f);
        setWeight_nucleating(weight()*0.008f);
        setWeight_regranulat(weight()*this.regranulat);
    }

    public void setWeight_ldpe(double weight_ldpe) {
        this.weight_ldpe = weight_ldpe;
    }

    public void setWeight_slip(double weight_slip) {
        this.weight_slip = weight_slip;
    }

    public void setWeight_nucleating(double weight_nucleating) {
        this.weight_nucleating = weight_nucleating;
    }

    public void setWeight_regranulat(double weight_regranulat) {
        this.weight_regranulat = weight_regranulat;
    }
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setRegranulat(double regranulat) {
        this.regranulat = regranulat;
    }

    public void setType(String type) {
        this.type = type;
    }


    public double getWeight_ldpe() {
        return weight_ldpe;
    }

    public double getWeight_slip() {
        return weight_slip;
    }

    public double getWeight_nucleating() {
        return weight_nucleating;
    }

    public double getWeight_regranulat() {
        return weight_regranulat;
    }
}
